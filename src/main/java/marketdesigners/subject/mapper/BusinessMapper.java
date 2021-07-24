package marketdesigners.subject.mapper;

import lombok.Getter;
import lombok.Setter;
import marketdesigners.subject.domain.Status;

@Getter @Setter
public class BusinessMapper {

    String name;
    String tel;
    String address;
    Status status;
}
