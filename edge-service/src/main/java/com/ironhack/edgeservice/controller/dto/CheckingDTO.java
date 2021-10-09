package com.ironhack.edgeservice.controller.dto;

import java.math.BigDecimal;
import java.util.Currency;

public class CheckingDTO {

    private BigDecimal balanceAmount;
    private Currency balanceCurrency;
    private String secretKey;
    private String status;
    private Long primaryOwner;
    private Long secondaryOwner;

    public CheckingDTO() {
    }

    public CheckingDTO(BigDecimal balanceAmount, Currency balanceCurrency, String secretKey, String status, Long primaryOwner, Long secondaryOwner) {
        this.balanceAmount = balanceAmount;
        this.balanceCurrency = balanceCurrency;
        this.secretKey = secretKey;
        this.status = status;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Currency getBalanceCurrency() {
        return balanceCurrency;
    }

    public void setBalanceCurrency(Currency balanceCurrency) {
        this.balanceCurrency = balanceCurrency;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(Long primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public Long getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(Long secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }
}
