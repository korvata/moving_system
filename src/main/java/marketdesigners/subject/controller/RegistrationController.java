package marketdesigners.subject.controller;

import lombok.RequiredArgsConstructor;
import marketdesigners.subject.domain.Registration;
import marketdesigners.subject.service.RegistrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping("/registrations")
    public List<Registration> findAll(){

        return registrationService.findAll();
    }
}
