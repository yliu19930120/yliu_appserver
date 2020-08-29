package com.yliu.enums;

public enum Constant {
    TRUE("是","0"),
    FALSE("否","1"),
    ;

    private String name;
    private String code;

    Constant(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
