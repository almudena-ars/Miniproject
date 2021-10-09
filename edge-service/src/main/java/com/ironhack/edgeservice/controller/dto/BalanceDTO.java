package com.ironhack.edgeservice.controller.dto;

import java.math.BigDecimal;
import java.util.Currency;

public class BalanceDTO {
    private BigDecimal amount;
    private Currency currency;
    //private String roundingMode;


    public BalanceDTO() {
    }

    public BalanceDTO(BigDecimal amount, Currency currency, String roundingMode) {
        this.amount = amount;
        this.currency = currency;
        //this.roundingMode = roundingMode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /*public String getRoundingMode() {
        return roundingMode;
    }

    public void setRoundingMode(String roundingMode) {
        this.roundingMode = roundingMode;
    }*/
}
