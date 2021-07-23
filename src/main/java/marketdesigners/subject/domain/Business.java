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
    private String bizName;             //업체명

    private String representative;      //대표이사
    private String tel;                 //연락처

    @Column(name = "business_registration_date")
    private String bizRegDate;          //사업자등록일자

    @Column(name = "employee_num")
    private int employeeNum;            //직원수

    @Column(name = "car_num")
    private int carNum;                 //차량수

    private Status status;              //매칭가능여부
}