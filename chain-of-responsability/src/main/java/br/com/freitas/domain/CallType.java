package br.com.freitas.domain;

public enum CallType {
    INTERNAL("Internal"),
    LOCAL("Regional"),
    DDD("National"),
    DDI("International");

    private final String value;
    
    private CallType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
