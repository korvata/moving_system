package marketdesigners.subject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;                    //고객 ID

    private String tel;                 //연락처

    @Column(name="reg_date")
    private LocalDateTime regDate;      //등록일자

    @OneToMany
    @JoinColumn(name="feedback_id")
    private Feedback feedback;          //피드백 정보

    @OneToMany
    @JoinColumn(name="reg_id")
    private Registration registration;  //신청접수 정보
}
