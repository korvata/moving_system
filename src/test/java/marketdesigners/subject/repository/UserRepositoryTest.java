package marketdesigners.subject.repository;


import marketdesigners.subject.domain.Feedback;
import marketdesigners.subject.domain.Registration;
import marketdesigners.subject.domain.Status;
import marketdesigners.subject.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository = new UserRepository();

    @Test
    void save() {

        //given
        List<Feedback> feedback1 = new ArrayList<>();
        List<Registration> registration1 = new ArrayList<>();
        User user = User.createUser("홍길동", "010-1234-7890", feedback1, registration1 );

        //when
        Long saveUserId = userRepository.save(user);

        //then
        assertThat(saveUserId).isEqualTo(user.getId());
    }

    @Test
    void findAll() {
        //given
        List<Feedback> feedback1 = new ArrayList<>();
        List<Registration> registration1 = new ArrayList<>();
        User user1 = User.createUser("홍길동", "010-1234-7890", feedback1, registration1 );

        List<Feedback> feedback2 = new ArrayList<>();
        List<Registration> registration2 = new ArrayList<>();
        User user2 = User.createUser("김철수", "010-1111-2222", feedback2, registration2 );


        Long bizNo1 = userRepository.save(user1);
        Long bizNo2 = userRepository.save(user2);

        //when
        List<User> result = userRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

}