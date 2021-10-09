package com.ironhack.edgeservice.controller.dto;

import java.math.BigDecimal;
import java.util.Currency;

public class SavingsDTO {

    private BigDecimal balanceAmount;

    private Currency balanceCurrency;

    private String secretKey;

    private BigDecimal penaltyFeeAmount;
    private Currency penaltyFeeCurrency;
    private String status;
    private Long primaryOwner;
    private Long secondaryOwner;
    private BigDecimal interestRateAmount;
    private Currency interestRateCurrency;
    private BigDecimal minimumBalanceAmount;
    private Currency minimumBalanceCurrency;

    public SavingsDTO(BigDecimal balanceAmount, Currency balanceCurrency, String secretKey, BigDecimal penaltyFeeAmount, Currency penaltyFeeCurrency,  String status, Long primaryOwner, Long secondaryOwner, BigDecimal interestRateAmount, Currency interestRateCurrency, BigDecimal minimumBalanceAmount, Currency minimumBalanceCurrency) {
        this.balanceAmount = balanceAmount;
        this.balanceCurrency = balanceCurrency;
        this.secretKey = secretKey;
        this.penaltyFeeAmount = penaltyFeeAmount;
        this.penaltyFeeCurrency = penaltyFeeCurrency;
        this.status = status;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.interestRateAmount = interestRateAmount;
        this.interestRateCurrency = interestRateCurrency;
        this.minimumBalanceAmount = minimumBalanceAmount;
        this.minimumBalanceCurrency = minimumBalanceCurrency;
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

    public BigDecimal getPenaltyFeeAmount() {
        return penaltyFeeAmount;
    }

    public void setPenaltyFeeAmount(BigDecimal penaltyFeeAmount) {
        this.penaltyFeeAmount = penaltyFeeAmount;
    }

    public Currency getPenaltyFeeCurrency() {
        return penaltyFeeCurrency;
    }

    public void setPenaltyFeeCurrency(Currency penaltyFeeCurrency) {
        this.penaltyFeeCurrency = penaltyFeeCurrency;
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

    public BigDecimal getMinimumBalanceAmount() {
        return minimumBalanceAmount;
    }

    public void setMinimumBalanceAmount(BigDecimal minimumBalanceAmount) {
        this.minimumBalanceAmount = minimumBalanceAmount;
    }

    public Currency getMinimumBalanceCurrency() {
        return minimumBalanceCurrency;
    }

    public void setMinimumBalanceCurrency(Currency minimumBalanceCurrency) {
        this.minimumBalanceCurrency = minimumBalanceCurrency;
    }
}
