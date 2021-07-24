package marketdesigners.subject.service;

import lombok.RequiredArgsConstructor;
import marketdesigners.subject.domain.User;
import marketdesigners.subject.mapper.UserMapper;
import marketdesigners.subject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserMapper> findAllUserMapper(){                       //고객 전체 조회

        List<UserMapper> userMapperList = new ArrayList<>();

        List<User> users = findAll();

        for(User user : users){
            UserMapper userMapper = new UserMapper();
            String name = user.getName();
            String tel = user.getTel();
            String newTel = tel.substring(0, tel.length()-3) + "**"+ tel.substring(tel.length()-2 + 1);

            userMapper.setName(name);
            userMapper.setTel(newTel);

            userMapperList.add(userMapper);
        }

        return userMapperList;
    }

    public List<User> findAll(){

        return userRepository.findAll();
    }

    public int userCount(){                             //전체 고객 정보 수

        return findAll().size();
    }
}
