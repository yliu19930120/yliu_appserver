package com.yliu.enums;

public enum ActionType {

    PECTORALES("胸部","PECTORALES"),
    DORSAL("背部","DORSAL"),
    LEG("腿部","LEG"),
    SHOULDERS("肩部","SHOULDERS"),
    ARM("手臂","ARM"),
    ABDOMINAL("腹部","ABDOMINAL"),
    STAMINA("体能","STAMINA"),
    CORE("核心肌群","CORE"),
    OTHERS("其他","OTHERS"),
    ;

    private String name;
    private String code;

    ActionType(String name, String code) {
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

    public static String getCodeByName(String name){
        String code = OTHERS.getCode();
        if(name==null){
            return code;
        }
        for (ActionType actionType:values()){
            if(name.equals(actionType.getName())){
                return actionType.getCode();
            }
        }
        return code;
    }
}
