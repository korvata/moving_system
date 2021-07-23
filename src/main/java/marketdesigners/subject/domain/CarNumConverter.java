package marketdesigners.subject.domain;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Slf4j
@Converter
public class CarNumConverter implements AttributeConverter<CarNum, String> {

    @Override
    public String convertToDatabaseColumn(CarNum attribute) {
        return attribute.getValue();
    }

    @Override
    public CarNum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        try {
            return CarNum.fromCode(dbData);
        } catch (IllegalArgumentException e) {
            log.error("failure to convert cause unexpected code [{}]", dbData, e);
            throw e;
        }
    }
}
