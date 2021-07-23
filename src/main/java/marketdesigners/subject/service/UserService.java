package marketdesigners.subject.service;

import lombok.RequiredArgsConstructor;
import marketdesigners.subject.domain.User;
import marketdesigners.subject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll(){                       //고객 전체 조회

        return userRepository.findAll();
    }
}
