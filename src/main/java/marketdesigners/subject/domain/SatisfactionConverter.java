package marketdesigners.subject.domain;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Slf4j
@Converter
public class SatisfactionConverter implements AttributeConverter<Satisfaction, String> {

    @Override
    public String convertToDatabaseColumn(Satisfaction attribute) {
        return attribute.getValue();
    }

    @Override
    public Satisfaction convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        try {
            return Satisfaction.fromCode(dbData);
        } catch (IllegalArgumentException e) {
            log.error("failure to convert cause unexpected code [{}]", dbData, e);
            throw e;
        }
    }
}
