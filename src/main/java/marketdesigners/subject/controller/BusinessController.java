package marketdesigners.subject.controller;

import lombok.RequiredArgsConstructor;
import marketdesigners.subject.mapper.BusinessMapper;
import marketdesigners.subject.service.BusinessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BusinessController {

    private final BusinessService businessService;

    @GetMapping("/business")
    public List<BusinessMapper> findAll(){

        return businessService.findAllBusinessMapper();
    }
}
