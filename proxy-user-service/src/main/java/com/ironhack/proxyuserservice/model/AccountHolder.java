package com.ironhack.proxyuserservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.proxyuserservice.classes.Address;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class AccountHolder extends User{


    private String name;
    @Column(name = "date_of_birth")
    private LocalDate birthDate;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "primary_city")),
            @AttributeOverride(name = "street", column = @Column(name = "primary_street")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "primary_postal_code"))
    })
    @Column(name = "primaryAddress")
    private Address primaryAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "mailing_city")),
            @AttributeOverride(name = "street", column = @Column(name = "mailing_street")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "mailing_postal_code"))
    })
    @Column(name = "mailing_address")
    private Address mailingAddress;


    /*@JsonIgnore
    @OneToMany(mappedBy = "primaryOwner")
    private List<Checking> primaryChecking;

    @JsonIgnore
    @OneToMany(mappedBy = "secondaryOwner")
    private List<Checking> secondaryChecking;

    @JsonIgnore
    @OneToMany(mappedBy = "primaryOwner")
    private List<CreditCard> primaryCreditCard;

    @JsonIgnore
    @OneToMany(mappedBy = "secondaryOwner")
    private List<CreditCard> secondaryCreditCard;

    @JsonIgnore
    @OneToMany(mappedBy = "primaryOwner")
    private List<Savings> primarySavings;

    @JsonIgnore
    @OneToMany(mappedBy = "secondaryOwner")
    private List<Savings> secondarySavings;

    @JsonIgnore
    @OneToMany(mappedBy = "primaryOwner")
    private List<StudentChecking> primaryStudentChecking;

    @JsonIgnore
    @OneToMany(mappedBy = "secondaryOwner")
    private List<StudentChecking> secondaryStudentChecking;*/

    //@JsonIgnore
    /*@OneToMany(mappedBy = "accountHolderSender")
    private List<Sender> sent;

    @OneToMany(mappedBy = "accountHolderReceiver")
    private List<Receiver> received;*/




    /*@ManyToMany(mappedBy = "accountholders")
    private List<Transaction> transactions;*/

    /*@OneToMany(mappedBy = "receiver")
    private List<Transaction> receivedTransactions;*/

    /*@OneToMany(mappedBy = "accountHolder")
    private List<Transaction> transactions;*/

    /*@OneToMany(mappedBy = "sendingAccountHolder")
    private List<Transaction> sentTransactions;

    @OneToMany(mappedBy = "receivingAccountHolder")
    private List<Transaction> receivedTransactions;*/



    public AccountHolder() {
    }

    public AccountHolder(String username, String password, Set<Role> roles) {
        super(username, password, roles);
    }


    public AccountHolder(String name, LocalDate birthDate, Address primaryAddress, Address mailingAddress) {
        this.name = name;
        this.birthDate = birthDate;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }


    /*public List<Transaction> getSentTransactions() {
        return sentTransactions;
    }

    public void setSentTransactions(List<Transaction> sentTransactions) {
        this.sentTransactions = sentTransactions;
    }*/

    /*public List<Transaction> getReceivedTransactions() {
        return receivedTransactions;
    }

    public void setReceivedTransactions(List<Transaction> receivedTransactions) {
        this.receivedTransactions = receivedTransactions;
    }*/
}
