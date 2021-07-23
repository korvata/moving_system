package marketdesigners.subject.domain;

import lombok.Getter;

@Getter
public enum CarNum {

    ONE("1톤"),
    HALFFIVE("2.5톤"),
    FIVE("5톤"),
    ETC("기타");

    private String value;

    CarNum(String value){
        this.value = value;
    }

    public static CarNum fromCode(String dbData) {

        if(dbData.equals("1톤")) return ONE;
        else if(dbData.equals("2.5톤")) return HALFFIVE;
        else if(dbData.equals("5톤")) return FIVE;
        else if(dbData.equals("기타")) return ETC;

        throw new UnsupportedOperationException( dbData + " is not supported!" );
    }
}
