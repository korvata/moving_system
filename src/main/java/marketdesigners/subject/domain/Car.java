package marketdesigners.subject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Car {

    @Id
    @Column(name = "car_id")
    private Long id;                //차량 ID

    @Column(name = "five_ton")
    private int fiveTon;            //5톤 차량 수

    @Column(name = "half_five_ton")
    private int halfFiveTon;        //2.5톤 차량 수

    @Column(name = "one_ton")
    private int oneTon;             //1톤 차량 수

    private int etc;                //기타 차량 수
}
