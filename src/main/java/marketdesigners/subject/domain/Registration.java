package marketdesigners.subject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Registration {

    @Id @GeneratedValue
    @Column(name = "reg_id")
    private Long id;               //신청접수 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;              //고객 정보

    @Column(name = "start_address")
    private String startAddress;    //출발지 주소정보

    @Column(name = "start_floor")
    private int startFloor;         //출발지 층수

    @Column(name = "end_address")
    private String endAddress;      //도착지 주소정보

    @Column(name = "end_floor")
    private int endFloor;           //도착지 층수

    @Column(name = "moving_date")
    private LocalDateTime movingDate;   //이사일자

    @Column(name = "moving_status")
    private Status movingStatus;        //보관이사여부

    @Column(name = "use_agree_status")
    private Status useAgreeStatus;      //이용약관동의여부

    @Column(name = "third_agree_status")
    private Status thirdAgreeStatus;    //제3자 동의여부

    @Column(name = "market_agree_status")
    private Status marketAgreeStatus;   //마케팅 정보수신 동의여부

    /**
     * 생성 메서드
     */
    public Registration(User user, String startAddress, int startFloor, String endAddress, int endFloor, LocalDateTime movingDate, Status movingStatus, Status useAgreeStatus, Status thirdAgreeStatus, Status marketAgreeStatus) {
        this.user = user;
        this.startAddress = startAddress;
        this.startFloor = startFloor;
        this.endAddress = endAddress;
        this.endFloor = endFloor;
        this.movingDate = movingDate;
        this.movingStatus = movingStatus;
        this.useAgreeStatus = useAgreeStatus;
        this.thirdAgreeStatus = thirdAgreeStatus;
        this.marketAgreeStatus = marketAgreeStatus;
    }
}
