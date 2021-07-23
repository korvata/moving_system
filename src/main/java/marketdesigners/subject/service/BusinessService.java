package marketdesigners.subject.service;

import lombok.RequiredArgsConstructor;
import marketdesigners.subject.domain.Business;
import marketdesigners.subject.repository.BusinessRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BusinessService {

    private final BusinessRepository businessRepository;

    public List<Business> findAll(){                //업체 정보 전체 조회

        return businessRepository.findAll();
    }
}
