package com.ironhack.proxyaccountservice.model;



import com.ironhack.proxyaccountservice.classes.Money;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Checking extends Account {

    //When creating a new Checking account, if the primaryOwnerId is less than 24,
    // a StudentChecking account should be created otherwise a regular Checking Account
    // should be created
    @Transient
    private final BigDecimal fixedPenalty = new BigDecimal("40");
    @Transient
    private final BigDecimal fixedMinimumBalance = new BigDecimal("250");
    @Transient
    private final BigDecimal fixedMonthlyMaintenanceFee = new BigDecimal("12");



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checking_id")
    private Long id;
/*
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "balance_currency"))
    })
    private Money balance;*/
    private String secretKey;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "penalty_fee_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "penalty_fee_currency"))
    })
    @Column(name = "penalty_fee")
    private Money penaltyFee = new Money(fixedPenalty);
    private LocalDate creationDate;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency"))
    })
    @Column(name = "minimum_balance")
    private Money minimumBalance = new Money(fixedMinimumBalance);
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "monthly_maintenance_fee_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "monthly_maintenance_fee_currency"))
    })
    @Column(name = "monthly_maintenance_fee")
    private Money monthlyMaintenanceFee = new Money(fixedMonthlyMaintenanceFee);



    /*@ManyToOne
    @JoinColumn(name = "primary_owner_id")
    private Long primaryOwnerId;
    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    private Long secondaryOwnerId;

    @ManyToMany(mappedBy = "checkingTransfer")
    private Set<Transaction> transactions;*/

    /*@OneToMany(mappedBy = "checkingSender")
    List<Sender> senders;

    @OneToMany(mappedBy = "checkingReceiver")
    List<Receiver> receivers;*/

    public Checking() {
    }




    public Checking(Long id, Money balance, String secretKey, LocalDate creationDate/*, Status status, Long primaryOwnerId, Long secondaryOwnerId*/) {
        this.id = id;
        setBalance(balance);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        //this.status = status;
        //this.primaryOwnerId = primaryOwnerId;
        //this.secondaryOwnerId = secondaryOwnerId;
    }



    public BigDecimal getFixedPenalty() {
        return fixedPenalty;
    }

    public BigDecimal getFixedMinimumBalance() {
        return fixedMinimumBalance;
    }

    public BigDecimal getFixedMonthlyMaintenanceFee() {
        return fixedMonthlyMaintenanceFee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setBalance(Money balance) {
        if(balance.getAmount().compareTo(fixedMinimumBalance) == -1){
            Money newBalance = new Money (balance.decreaseAmount(penaltyFee));
            super.setBalance(newBalance);
        }else{
            super.setBalance(balance);
        }
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Money getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(Money penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }



    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Money getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(Money monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }


}

