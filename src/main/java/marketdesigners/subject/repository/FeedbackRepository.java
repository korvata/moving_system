package marketdesigners.subject.repository;

import marketdesigners.subject.domain.Feedback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class FeedbackRepository {

    @PersistenceContext
    private EntityManager em;

    public Feedback findOne(Long id){          //피드백ID로 업체정보 조회

        return em.find(Feedback.class, id);
    }

    public List<Feedback> findAll(){                //피드백 전체 조회

        return em.createQuery("select f from feedback f", Feedback.class)
                .getResultList();
    }

    @Transactional
    public Long save(Feedback feedback){          //피드백 저장

        em.persist(feedback);

        return feedback.getId();
    }

}
