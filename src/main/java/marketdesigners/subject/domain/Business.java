package marketdesigners.subject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "Business")
public class Business {

    @Id
    @Column(name = "biz_no")
    private String bizNo;               //사업자번호

    @OneToMany(mappedBy = "business")
    private List<Feedback> feedbacks = new ArrayList<>();          //피드백 정보

    @Column(name = "biz_name")
    private String bizName;             //업체명

    private String representative;      //대표이사
    private String tel;                 //연락처
    private String address;             //주소

    @Column(name = "business_registration_date")
    private String bizRegDate;          //사업자등록일자

    @Column(name = "employee_num")
    private int employeeNum;            //직원수

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;                    //차량수

    private Status status;              //매칭가능여부


    /**
     * 연관관계 메서드
     */
    public void addFeedback(Feedback feedback){
        feedbacks.add(feedback);
        feedback.setBusiness(this);
    }

    /**
     * 생성 메서드
     */public static Business createBusiness(String bizNo, String bizName, String tel, String address, List<Feedback> feedbacks, String bizRegDate, int employeeNum, Status status){

        Business business = new Business();

        business.setBizNo(bizNo);
        business.setBizName(bizName);
        business.setTel(tel);
        business.setAddress(address);
        business.setBizRegDate(bizRegDate);
        business.setEmployeeNum(employeeNum);
        business.setStatus(status);

        for(Feedback feedback : feedbacks){
            business.addFeedback(feedback);
        }

        return business;

    }
}
