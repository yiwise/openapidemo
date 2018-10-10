package com.yiwise.model;

import java.util.Map;

/**
 * @Author zqy
 * @Date 2018/10/10
 **/
public class CustomerPersonImportVO {
    private String name;
    private String phoneNumber;
    private Map<String, String> properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
