package marketdesigners.subject.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Satisfaction {

    SCORE5("매우만족"),
    SCORE4("만족"),
    SCORE3("보통"),
    SCORE2("불만족"),
    SCORE1("매우불만족");

    private String value;

    Satisfaction(String value){
        this.value = value;
    }

    public static Satisfaction fromCode(String dbData) {

        if(dbData.equals("매우만족")) return SCORE5;
        else if(dbData.equals("만족")) return SCORE4;
        else if(dbData.equals("보통")) return SCORE3;
        else if(dbData.equals("불만족")) return SCORE2;
        else if(dbData.equals("매우불만족")) return SCORE1;

        throw new UnsupportedOperationException( dbData + " is not supported!" );
    }
}
