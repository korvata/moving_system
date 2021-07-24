package marketdesigners.subject.repository;

import marketdesigners.subject.domain.User;
import org.springframework.stereotype.Repository;

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

}
