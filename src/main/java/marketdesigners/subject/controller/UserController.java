package marketdesigners.subject.controller;

import lombok.RequiredArgsConstructor;
import marketdesigners.subject.mapper.UserMapper;
import marketdesigners.subject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public List<UserMapper> findAll(){

        return userService.findAllUserMapper();
    }
}
