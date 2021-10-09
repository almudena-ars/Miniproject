package com.ironhack.proxyuserservice.controller.dto;

public class ThirdPartyDTO {

    private String userName;
    private String hashedKey;


    public ThirdPartyDTO() {
    }

    public ThirdPartyDTO(String userName) {
        this.userName = userName;
    }

    public ThirdPartyDTO(String userName, String hashedKey) {
        this.userName = userName;
        this.hashedKey = hashedKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }
}
