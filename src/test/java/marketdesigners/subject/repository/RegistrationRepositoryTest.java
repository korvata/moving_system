package marketdesigners.subject.repository;

import marketdesigners.subject.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegistrationRepositoryTest {

    @Autowired
    RegistrationRepository registrationRepository = new RegistrationRepository();

    @Test
    void save() {

        //given
        User user = new User();
        Registration registration = Registration.createRegistration(user, "서울 송파구 방이동 어쩌구저쩌구", 5, "서울 금천구 가산동 블라블라", 10, "2020-02-21", Status.Y );

        //when
        Long saveRegId = registrationRepository.save(registration);

        //then
        assertThat(saveRegId).isEqualTo(registration.getId());
    }

    @Test
    void findAll() {
        //given
        User user1 = new User();
        User user2 = new User();

        Registration registration1 = Registration.createRegistration(user1, "서울 송파구 방이동 어쩌구저쩌구", 5, "서울 금천구 가산동 블라블라", 10, "2020-02-21", Status.Y );
        Registration registration2 = Registration.createRegistration(user2, "서울 동작구 상도동 어쩌구저쩌구", 2, "서울 강남구 서초동 블라블라", 5, "2020-11-25", Status.Y );


        Long bizNo1 = registrationRepository.save(registration1);
        Long bizNo2 = registrationRepository.save(registration2);

        //when
        List<Registration> result = registrationRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}