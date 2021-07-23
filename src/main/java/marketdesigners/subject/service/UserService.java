package marketdesigners.subject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marketdesigners.subject.domain.User;
import marketdesigners.subject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> userList(){                       //고객 전체 조회

        return userRepository.findAll();
    }
}
