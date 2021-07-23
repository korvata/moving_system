package marketdesigners.subject.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private String name;                //고객 이름

    private String tel;                 //연락처

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="reg_date")
    private LocalDateTime regDate;      //등록일자

    @OneToMany
    @JoinColumn(name="feedback_id")
    private Feedback feedback;          //피드백 정보

    @OneToMany
    @JoinColumn(name="reg_id")
    private Registration registration;  //신청접수 정보

    @Column(name = "use_agree_status")
    private Status useAgreeStatus;      //이용약관동의여부

    @Column(name = "third_agree_status")
    private Status thirdAgreeStatus;    //제3자 동의여부

    @Column(name = "market_agree_status")
    private Status marketAgreeStatus;   //마케팅 정보수신 동의여부

    /**
     * 생성 메서드
     */
    public User(String name, String tel, LocalDateTime regDate, Feedback feedback, Registration registration, Status useAgreeStatus, Status thirdAgreeStatus, Status marketAgreeStatus) {
        this.name = name;
        this.tel = tel;
        this.regDate = regDate;
        this.feedback = feedback;
        this.registration = registration;
        this.useAgreeStatus = useAgreeStatus;
        this.thirdAgreeStatus = thirdAgreeStatus;
        this.marketAgreeStatus = marketAgreeStatus;
    }
}
