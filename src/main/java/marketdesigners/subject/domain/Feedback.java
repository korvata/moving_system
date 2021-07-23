package marketdesigners.subject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Feedback {

    @Id
    @GeneratedValue
    @Column(name = "feedback_id")
    private Long id;               //피드백 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;              //고객 정보

    @Column(name = "info_agree")
    private Status infoAgree;      //이용약관동의여부

    @Convert(converter = SatisfactionConverter.class)
    @Column(name = "pro_satisfaction")
    private Satisfaction proSatisfaction;    //전문성 만족도

    @Convert(converter = SatisfactionConverter.class)
    @Column(name = "price_satisfaction")
    private Satisfaction priceSatisfaction;    //가격 만족도

    @Convert(converter = SatisfactionConverter.class)
    @Column(name = "manner_satisfaction")
    private Satisfaction mannerSatisfaction;    //친절 만족도

    private Status revisit;                     //재방문 의사

    @Column(name = "contract_price")
    private int price;                          //계약가격

    @Column(name = "moving_date")
    private LocalDateTime movingDate;           //이사일

    @Column(name = "feedback_date")
    private LocalDateTime feedbackDate;         //피드백 작성일

    @Column(name = "contents")
    private String contents;                     //피드백 내용
}
