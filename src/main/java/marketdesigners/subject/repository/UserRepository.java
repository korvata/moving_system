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

    public User findOne(Long id){          //고객번호로 고객정보 조회

        return em.find(User.class, id);
    }

    public List<User> findAll(){                //고객정보 전체 조회

        return em.createQuery("select u from user u", User.class)
                .getResultList();
    }

    @Transactional
    public Long save(User user){          //고객정보 저장

        em.persist(user);

        return user.getId();
    }
}
