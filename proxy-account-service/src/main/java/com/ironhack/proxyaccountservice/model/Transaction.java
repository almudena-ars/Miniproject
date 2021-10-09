package com.ironhack.proxyaccountservice.model;

import com.ironhack.proxyaccountservice.classes.Money;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "currency_quantity")),
            @AttributeOverride(name = "amount", column = @Column(name = "amount_quantity"))
    })
    //@Column(name = "interest_rate")
    private Money quantity;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "sendingAccount")
    private Account sendingAccount;

    @ManyToOne
    @JoinColumn(name = "receivingAccount")
    private Account receivingAccount;

    /*@ManyToOne
    @JoinColumn(name = "Long_id")
    private Long  Long;*/

    /*@ManyToOne
    @JoinColumn(name = "sendingLong")
    private Long  sendingLong;

    @ManyToOne
    @JoinColumn(name = "receivingLong")
    private Long  receivingLong;*/

    /*@OneToOne(mappedBy = "sentTransaction")
    private Sender sender;

    @OneToOne(mappedBy = "receivedTransaction")
    private Receiver receiver;*/

    //First one to add is the sender, second one is the receiver
    /*@ManyToMany
    @JoinTable(
            name = "transaction_Long",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "Long_id"))
    private Set<Long> Longs;

    @ManyToMany
    @JoinTable(
            name = "transaction_checking",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "checking_id"))
    private Set<Checking> checkingTransfer;

    @ManyToMany
    @JoinTable(
            name = "transaction_savings",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "savings_id"))
    private Set<Savings> savingsTransfer;

    @ManyToMany
    @JoinTable(
            name = "transaction_student_checking",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "student_checking_id"))
    private Set<StudentChecking> studentCheckingTransfer;

    @ManyToMany
    @JoinTable(
            name = "transaction_credit_card",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "credit_card_id"))
    private Set<CreditCard> creditCardTransfer;*/

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Money getQuantity() {
        return quantity;
    }

    public void setQuantity(Money quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Account getSendingAccount() {
        return sendingAccount;
    }

    public void setSendingAccount(Account sendingAccount) {
        this.sendingAccount = sendingAccount;
    }

    public Account getReceivingAccount() {
        return receivingAccount;
    }

    public void setReceivingAccount(Account receivingAccount) {
        this.receivingAccount = receivingAccount;
    }
}
