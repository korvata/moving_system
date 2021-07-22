package marketdesigners.subject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Business {

    @Id
    @Column(name = "biz_no")
    private String bizNo;               //사업자번호

    @Column(name = "biz_name")
    private String bizName;

    private String representative;
    private String tel;

    @Column(name = "business_registration_date")
    private String bizRegDate;

    @Column(name = "employee_num")
    private int employeeNum;

    @Column(name = "car_num")
    private int carNum;

    private Status status;
}
