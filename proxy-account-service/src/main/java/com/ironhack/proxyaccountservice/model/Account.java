package com.ironhack.proxyaccountservice.model;

import com.ironhack.proxyaccountservice.classes.Money;
import com.ironhack.proxyaccountservice.enums.Status;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "balance_currency"))
    })
    private Money balance;

    @Enumerated(EnumType.STRING)
    private Status status;


    private Long primaryOwnerId;


    private Long secondaryOwnerId;

    @OneToMany(mappedBy = "sendingAccount")
    private List<Transaction> sentTransactions;

    @OneToMany(mappedBy = "receivingAccount")
    private List<Transaction> receivedTransactions;



    public Account() {
    }

    public Account(Long id, Money balance, Status status, Long primaryOwnerId, Long secondaryOwnerId, List<Transaction> sentTransactions, List<Transaction> receivedTransactions) {
        this.id = id;
        this.balance = balance;
        this.status = Status.ACTIVE;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.sentTransactions = sentTransactions;
        this.receivedTransactions = receivedTransactions;
    }

    public Account(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Long getprimaryOwnerId() {
        return primaryOwnerId;
    }

    public void setprimaryOwnerId(Long primaryOwnerId) {
        this.primaryOwnerId = primaryOwnerId;
    }

    public Long getsecondaryOwnerId() {
        return secondaryOwnerId;
    }

    public void setsecondaryOwnerId(Long secondaryOwnerId) {
        this.secondaryOwnerId = secondaryOwnerId;
    }

    public List<Transaction> getSentTransactions() {
        return sentTransactions;
    }

    public void setSentTransactions(List<Transaction> sentTransactions) {
        this.sentTransactions = sentTransactions;
    }

    public List<Transaction> getReceivedTransactions() {
        return receivedTransactions;
    }

    public void setReceivedTransactions(List<Transaction> receivedTransactions) {
        this.receivedTransactions = receivedTransactions;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}