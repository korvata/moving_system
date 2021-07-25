# 1. DB 버전
8.0.25 MySQL

# 2. 셋팅법
## DDL
create table business (
       biz_no varchar(255) not null,
        address varchar(255),
        biz_name varchar(255),
        business_registration_date varchar(255),
        employee_num integer,
        representative varchar(255),
        status integer,
        tel varchar(255),
        car_id bigint,
        primary key (biz_no)
    )
    
    create table car (
       car_id bigint not null,
        etc integer not null,
        five_ton integer,
        half_five_ton integer,
        one_ton integer,
        primary key (car_id)
    )
    
    create table feedback (
       feedback_id bigint not null,
        contents varchar(255),
        feedback_date datetime(6),
        info_agree integer,
        manner_satisfaction varchar(255),
        moving_date varchar(255),
        contract_price integer,
        price_satisfaction varchar(255),
        pro_satisfaction varchar(255),
        revisit integer,
        business_id varchar(255),
        user_id bigint,
        primary key (feedback_id)
    )
	
    create table hibernate_sequence (
       next_val bigint
    )
	
    insert into hibernate_sequence values ( 1 )
    
    create table registration (
       reg_id bigint not null,
        end_address varchar(255),
        end_floor integer,
        moving_date varchar(255),
        moving_status integer,
        start_address varchar(255),
        start_floor integer,
        user_id bigint,
        primary key (reg_id)
    )
    
    create table user (
       user_id bigint not null,
        market_agree_status integer,
        name varchar(255),
        reg_date datetime(6),
        tel varchar(255),
        third_agree_status integer,
        use_agree_status integer,
        primary key (user_id)
    )
    
    alter table business 
       add constraint car_id 
       foreign key (car_id) 
       references car (car_id)

    
    alter table feedback 
       add constraint business_id 
       foreign key (business_id) 
       references business (biz_no)

    
    alter table feedback 
       add constraint user_id 
       foreign key (user_id) 
       references user (user_id)

    
    alter table registration 
       add constraint user_id 
       foreign key (user_id) 
       references user (user_id)
       
## DB접속 정보
ID : root
PW : qwer1234!

## 데이터 입력
insert into marketdesigners.user values(1, 1, "홍길동", "2020-12-21", "010-1234-5678", 1, 1);
insert into marketdesigners.user values(2, 0, "김철수", "2020-12-21", "010-1111-2222", 1, 1);
insert into marketdesigners.user values(3, 1, "박유리", "2020-12-21", "010-3464-3453", 1, 1);
insert into marketdesigners.user values(4, 1, "이순신", "2020-12-21", "010-3434-8989", 1, 1);

insert into marketdesigners.car values(1, 0, 1, 5, 6);
insert into marketdesigners.car values(2, 1, 0, 3, 2);
insert into marketdesigners.car values(3, 4, 1, 5, 3);
insert into marketdesigners.car values(4, 6, 2, 5, 1);

insert into marketdesigners.business values("123", "서울 송파구 방이동 어쩌구저쩌구", "회사1", "2021-06-21", 20, "대표1", 1, "010-1122-3344", 1);
insert into marketdesigners.business values("234", "경기도 안산시 와동 123123", "회사2", "2020-12-12", 25, "대표2", 0, "010-6644-3344", 2);
insert into marketdesigners.business values("345", "서울 동작구 상도동 블라블라", "회사3", "2019-07-01", 60, "대표3", 1, "010-1233-2321", 3);
insert into marketdesigners.business values("456", "서울 강남구 서초동 aaa-bb", "회사4", "2021-07-25", 100, "대표4", 0, "010-4564-2315", 4);


insert into marketdesigners.registration values(1, "서울 송파구 방이동 어쩌구저쩌구", 3, "2020-11-12", 1, "서울 송파구 와동 어쩌구저쩌구", 23, 1);
insert into marketdesigners.registration values(2, "대전 유성구 유성동 797-1213", 3, "2015-12-13", 1, "서울 송파구 와동 어쩌구저쩌구", 23, 2);
insert into marketdesigners.registration values(3, "경기도 시흥시 장곡동 123-454", 3, "2020-06-21", 1, "서울 송파구 와동 어쩌구저쩌구", 23, 3);
insert into marketdesigners.registration values(4, "서울 강남구 서초동 블라블라", 3, "2021-09-11", 1, "서울 송파구 와동 어쩌구저쩌구", 23, 4);

# 3. 테스트 및 Run

# 4. 사용한 패키지
