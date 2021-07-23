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

    public Feedback findOne(Long id){          //사업자번호로 업체정보 조회

        return em.find(Feedback.class, id);
    }

    public List<Feedback> findAll(){                //업체정보 전체 조회

        return em.createQuery("select f from feedback f", Feedback.class)
                .getResultList();
    }

    @Transactional
    public Long save(Feedback feedback){          //업체정보 저장

        em.persist(feedback);

        return feedback.getId();
    }

}
