package marketdesigners.subject.service;

import lombok.RequiredArgsConstructor;
import marketdesigners.subject.domain.Business;
import marketdesigners.subject.domain.Status;
import marketdesigners.subject.domain.User;
import marketdesigners.subject.mapper.BusinessMapper;
import marketdesigners.subject.mapper.UserMapper;
import marketdesigners.subject.repository.BusinessRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BusinessService {

    private final BusinessRepository businessRepository;

    public List<BusinessMapper> findAllBusinessMapper(){                       //고객 전체 조회

        List<BusinessMapper> businessMapperList = new ArrayList<>();

        List<Business> businesses = findAll();

        for(Business business : businesses){
            BusinessMapper businessMapper = new BusinessMapper();
            String name = business.getBizName();
            String tel = business.getTel();
            String address = business.getAddress();
            Status status = business.getStatus();

            String newTel = tel.substring(0, tel.length()-3) + "**"+ tel.substring(tel.length()-2 + 1);
            String newAddress = address.substring(0, address.indexOf("동 ")+1);

            businessMapper.setName(name);
            businessMapper.setTel(newTel);
            businessMapper.setAddress(newAddress);
            businessMapper.setStatus(status);

            businessMapperList.add(businessMapper);
        }

        return businessMapperList;
    }

    public List<Business> findAll(){                //업체 정보 전체 조회

        return businessRepository.findAll();
    }
}
