package marketdesigners.subject.repository;

import marketdesigners.subject.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public List<User> findAll(){                //고객정보 전체 조회

        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Transactional
    public Long save(User user){            //고객 정보 저장

        em.persist(user);

        return user.getId();
    }

}
