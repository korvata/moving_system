package marketdesigners.subject.repository;

import marketdesigners.subject.domain.Feedback;
import marketdesigners.subject.domain.Satisfaction;
import marketdesigners.subject.domain.Status;
import marketdesigners.subject.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FeedbackRepositoryTest {

    @Autowired
    FeedbackRepository feedbackRepository = new FeedbackRepository();

    @Test
    void save() {

        //given
        User user = new User();
        Feedback feedback = Feedback.createFeedback(user, Status.Y, Satisfaction.SCORE5, Satisfaction.SCORE3, Satisfaction.SCORE4, Status.Y, 1000, "2020-12-10", "친절하고 좋았습니다.");

        //when
        Long saveFeedbackId = feedbackRepository.save(feedback);

        //then
        assertThat(saveFeedbackId).isEqualTo(feedback.getId());
    }

    @Test
    void findAll() {

        //given
        User user1 = new User();
        User user2 = new User();
        Feedback feedback1 = Feedback.createFeedback(user1, Status.Y, Satisfaction.SCORE5, Satisfaction.SCORE2, Satisfaction.SCORE5, Status.Y, 1000, "2020-12-10", "친절하고 좋았습니다.");
        Feedback feedback2 = Feedback.createFeedback(user2, Status.Y, Satisfaction.SCORE3, Satisfaction.SCORE2, Satisfaction.SCORE2, Status.N, 5000, "2021-01-10", "별로에요.");

        Long feedbackId1 = feedbackRepository.save(feedback1);
        Long feedbackId2 = feedbackRepository.save(feedback2);

        //when
        List<Feedback> result = feedbackRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);

    }


}