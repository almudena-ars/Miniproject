package com.ironhack.proxyuserservice.controller.dto;

public class AccountHolderDTO {
    private String username;
    private String password;
    private String birthDate;
    private String primaryCity;
    private String primaryStreet;
    private String primaryPostalCode;
    private String mailingCity;
    private String mailingStreet;
    private String mailingPostalCode;

    public AccountHolderDTO() {
    }

    public AccountHolderDTO(String username, String password, String birthDate, String primaryCity, String primaryStreet, String primaryPostalCode, String mailingCity,
                            String mailingStreet, String mailingPostalCode) {
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.primaryCity = primaryCity;
        this.primaryStreet = primaryStreet;
        this.primaryPostalCode = primaryPostalCode;
        this.mailingCity = mailingCity;
        this.mailingStreet = mailingStreet;
        this.mailingPostalCode = mailingPostalCode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPrimaryCity() {
        return primaryCity;
    }

    public void setPrimaryCity(String primaryCity) {
        this.primaryCity = primaryCity;
    }

    public String getPrimaryStreet() {
        return primaryStreet;
    }

    public void setPrimaryStreet(String primaryStreet) {
        this.primaryStreet = primaryStreet;
    }

    public String getPrimaryPostalCode() {
        return primaryPostalCode;
    }

    public void setPrimaryPostalCode(String primaryPostalCode) {
        this.primaryPostalCode = primaryPostalCode;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }

    public String getMailingPostalCode() {
        return mailingPostalCode;
    }

    public void setMailingPostalCode(String mailingPostalCode) {
        this.mailingPostalCode = mailingPostalCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
