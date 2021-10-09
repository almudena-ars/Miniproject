package com.ironhack.proxyuserservice.controller.dto;

public class AdminDTO {

    private String name;
    private String password;

    public AdminDTO() {
    }

    public AdminDTO(String userName, String password) {
        this.name = userName;
        this.password = password;
    }

    public AdminDTO(String userName) {
        this.name = userName;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
