package marketdesigners.subject.service;

import lombok.RequiredArgsConstructor;
import marketdesigners.subject.domain.Registration;
import marketdesigners.subject.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public List<Registration> findAll(){                //신청접수 정보 전체 조회

        return registrationRepository.findAll();
    }
}
