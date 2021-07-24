package marketdesigners.subject.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private List<Feedback> feedbacks = new ArrayList<>();          //피드백 정보

    @OneToMany
    private List<Registration> registrations = new ArrayList<>();  //신청접수 정보

    @Column(name = "use_agree_status")
    private Status useAgreeStatus;      //이용약관동의여부

    @Column(name = "third_agree_status")
    private Status thirdAgreeStatus;    //제3자 동의여부

    @Column(name = "market_agree_status")
    private Status marketAgreeStatus;   //마케팅 정보수신 동의여부

    /**
     * 생성 메서드
     *//*
    public User(String name, String tel, LocalDateTime regDate, List<Feedback> feedbacks, List<Registration> registrations, Status useAgreeStatus, Status thirdAgreeStatus, Status marketAgreeStatus) {
        this.name = name;
        this.tel = tel;
        this.regDate = regDate;
        this.feedbacks = feedbacks;
        this.registrations = registrations;
        this.useAgreeStatus = useAgreeStatus;
        this.thirdAgreeStatus = thirdAgreeStatus;
        this.marketAgreeStatus = marketAgreeStatus;
    }*/
}
