package marketdesigners.subject.repository;

import marketdesigners.subject.domain.Car;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CarRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Car> findAll(){                //차량정보 전체 조회

        return em.createQuery("select c from Car c", Car.class)
                .getResultList();
    }

    @Transactional
    public Long save(Car car){          //차량정보 저장

        em.persist(car);

        return car.getId();
    }
}
