package marketdesigners.subject.repository;

import marketdesigners.subject.domain.Registration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RegistrationRepository {

    @PersistenceContext
    private EntityManager em;

    public Registration findOne(Long id){          //접수번호로 접수정보 조회

        return em.find(Registration.class, id);
    }

    public List<Registration> findAll(){                //접수정보 전체 조회

        return em.createQuery("select r from registration r", Registration.class)
                .getResultList();
    }

    @Transactional
    public Long save(Registration registration){          //접수정보 저장

        em.persist(registration);

        return registration.getId();
    }
}
