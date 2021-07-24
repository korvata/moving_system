package marketdesigners.subject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "business")
public class Business {

    @Id
    @Column(name = "biz_no")
    private String bizNo;               //사업자번호

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks = new ArrayList<>();          //피드백 정보

    @Column(name = "biz_name")
    private String bizName;             //업체명

    private String representative;      //대표이사
    private String tel;                 //연락처

    @Column(name = "business_registration_date")
    private String bizRegDate;          //사업자등록일자

    @Column(name = "employee_num")
    private int employeeNum;            //직원수

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Car car;                    //차량수

    private Status status;              //매칭가능여부


    /**
     * 생성 메서드
     *//*
    public static Business createBusiness(String bizNo, List<Feedback> feedbacks, String bizName, String representative, String tel, String bizRegDate, int employeeNum, Car car, Status status) {



        this.bizNo = bizNo;
        this.feedbacks = feedbacks;
        this.bizName = bizName;
        this.representative = representative;
        this.tel = tel;
        this.bizRegDate = bizRegDate;
        this.employeeNum = employeeNum;
        this.car = car;
        this.status = status;
    }*/
}
