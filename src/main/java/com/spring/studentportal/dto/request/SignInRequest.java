package com.spring.studentportal.dto.request;

public class SignInRequest {
    private String varsityId;
    private String password;

    public String getVarsityId() {
        return varsityId;
    }

    public void setVarsityId(String varsityId) {
        this.varsityId = varsityId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
