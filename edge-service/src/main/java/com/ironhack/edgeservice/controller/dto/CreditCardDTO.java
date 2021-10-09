package com.ironhack.edgeservice.controller.dto;

import java.math.BigDecimal;
import java.util.Currency;

public class CreditCardDTO {

    private BigDecimal balanceAmount;
    private Currency balanceCurrency;
    private BigDecimal creditLimitAmount;
    private Currency creditLimitCurrency;
    private String status;
    private BigDecimal interestRateAmount;
    private Currency interestRateCurrency;
    private Long primaryOwner;
    private Long secondaryOwner;


    public CreditCardDTO() {
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

    public BigDecimal getCreditLimitAmount() {
        return creditLimitAmount;
    }

    public void setCreditLimitAmount(BigDecimal creditLimitAmount) {
        this.creditLimitAmount = creditLimitAmount;
    }

    public Currency getCreditLimitCurrency() {
        return creditLimitCurrency;
    }

    public void setCreditLimitCurrency(Currency creditLimitCurrency) {
        this.creditLimitCurrency = creditLimitCurrency;
    }

    public BigDecimal getInterestRateAmount() {
        return interestRateAmount;
    }

    public void setInterestRateAmount(BigDecimal interestRateAmount) {
        this.interestRateAmount = interestRateAmount;
    }

    public Currency getInterestRateCurrency() {
        return interestRateCurrency;
    }

    public void setInterestRateCurrency(Currency interestRateCurrency) {
        this.interestRateCurrency = interestRateCurrency;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
