package marketdesigners.subject.repository;

import marketdesigners.subject.domain.Business;
import marketdesigners.subject.domain.Feedback;
import marketdesigners.subject.domain.Status;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BusinessRepositoryTest {

    @Autowired
    BusinessRepository businessRepository = new BusinessRepository();

    @Test
    void save() {

        //given
        List<Feedback> feedback1 = new ArrayList<>();
        Business business1 = Business.createBusiness("110-12-123456", "회사1", "02-1234-4567", "서울 송파구 방이동 어쩌구저쩌구", feedback1, "2020-02-21", 50, Status.Y );

        //when
        String saveBizNo = businessRepository.save(business1);

        //then
        assertThat(saveBizNo).isEqualTo(business1.getBizNo());
    }

    @Test
    void findAll() {
        //given
        List<Feedback> feedback1 = new ArrayList<>();
        List<Feedback> feedback2 = new ArrayList<>();
        Business business1 = Business.createBusiness("110-12-123456", "회사1", "02-1234-4567", "서울 송파구 방이동 어쩌구저쩌구", feedback1, "2020-02-21", 50, Status.Y );
        Business business2 = Business.createBusiness("110-34-456789", "회사2", "02-345-4511", "서울 금천구 가산동 블라블라", feedback2, "2021-07-25", 100, Status.Y );


        String bizNo1 = businessRepository.save(business1);
        String bizNo2 = businessRepository.save(business2);

        //when
        List<Business> result = businessRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}