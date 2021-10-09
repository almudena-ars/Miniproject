package com.ironhack.edgeservice.controller.dto;

import java.math.BigDecimal;
import java.util.Currency;

public class TransferDTO {

    //private String receiverName;
    private Long receiverAccountId;
    private Long senderAccountId;
    private BigDecimal amount;
    private Currency currency;

    public TransferDTO() {
    }

    public Long getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(Long receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }



    public Long getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(Long senderAccountId) {
        this.senderAccountId = senderAccountId;
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
}
