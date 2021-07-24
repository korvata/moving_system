package marketdesigners.subject.repository;

import marketdesigners.subject.domain.Business;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class BusinessRepository {

    @PersistenceContext
    private EntityManager em;

    public Business findOne(String bizNo){          //사업자번호로 업체정보 조회

        return em.find(Business.class, bizNo);
    }

    public List<Business> findAll(){                //업체정보 전체 조회

        return em.createQuery("select b from Business b", Business.class)
                .getResultList();
    }

    @Transactional
    public String save(Business business){          //업체정보 저장

        em.persist(business);

        return business.getBizNo();
    }

}
