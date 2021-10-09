package com.ironhack.proxyaccountservice.model;

import com.ironhack.proxyaccountservice.classes.Money;
import com.ironhack.proxyaccountservice.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Savings extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "savings_id")
    private Long id;

    @Transient
    private final BigDecimal fixedPenalty = new BigDecimal("40");

   /* @Embedded
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
            @AttributeOverride(name = "currency", column = @Column(name = "currency_interest_rate")),
            @AttributeOverride(name = "amount", column = @Column(name = "amount_interest_rate"))
    })
    @Column(name = "interest_rate")
    private Money interestRate;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency"))
    })
    @Column(name = "minimum_balance")
    private Money minimumBalance;

   /* @ManyToOne
    @JoinColumn(name = "primary_owner_id")
    private Long primaryOwnerId;
    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    private Long secondaryOwnerId;

    @ManyToMany(mappedBy = "savingsTransfer")
    private Set<Transaction> transactions;*/

    public Savings() {
    }

    public Savings(Long id, Money balance, Status status, Long primaryOwnerId, Long secondaryOwnerId, List<Transaction> sentTransactions, List<Transaction> receivedTransactions, String secretKey, Money penaltyFee, LocalDate creationDate, Money interestRate, Money minimumBalance) {
        super(id, balance, status, primaryOwnerId, secondaryOwnerId, sentTransactions, receivedTransactions);
        this.secretKey = secretKey;
        this.penaltyFee = penaltyFee;
        this.creationDate = creationDate;
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    public Savings(Money balance, String secretKey, Money penaltyFee, LocalDate creationDate, Money interestRate, Money minimumBalance, Long primaryOwnerId, Long secondaryOwnerId) {

        setBalance(balance);
        this.secretKey = secretKey;
        this.penaltyFee = penaltyFee;
        this.creationDate = creationDate;
        //this.status = status;
        setInterestRate(interestRate);
        setMinimumBalance(minimumBalance);
    }



    public Savings(Money balance, String secretKey, Money penaltyFee, LocalDate creationDate,  Money interestRate, Money minimumBalance, Long primaryOwnerId) {
        setInterestRate(interestRate);
        setMinimumBalanceAndBalance(minimumBalance, balance);
        this.secretKey = secretKey;
        this.penaltyFee = penaltyFee;
        this.creationDate = creationDate;
        //this.status = status;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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




    public Money getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Money interestRate) {
        BigDecimal maximum = new BigDecimal("0.5");
        BigDecimal minimum = new BigDecimal("0");
        BigDecimal defaultValue = new BigDecimal("0.025");
        Money defaultInterestRate = new Money(defaultValue, interestRate.getCurrency());

        //-1, 0, or 1 as this BigDecimal is numerically less than, equal to, or greater than val.

        if(interestRate.getAmount().compareTo(maximum) == -1 && interestRate.getAmount().compareTo(minimum) >= 1){
            this.interestRate = interestRate;
        }else{
            this.interestRate = defaultInterestRate;
        }

    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        BigDecimal maximum = new BigDecimal("1000");
        BigDecimal minimum = new BigDecimal("100");
        BigDecimal defaultValue = new BigDecimal("1000");
        Money defaultMinimumBalance = new Money(defaultValue);

        //-1, 0, or 1 as this BigDecimal is numerically less than, equal to, or greater than val.

        if(minimumBalance.getAmount().compareTo(maximum) == -1 && minimumBalance.getAmount().compareTo(minimum) >= 1){
            this.minimumBalance = minimumBalance;
        }else{
            this.minimumBalance = defaultMinimumBalance;
        }
    }

    public void setMinimumBalanceAndBalance(Money minimumBalance, Money balance){
        BigDecimal maximum = new BigDecimal("1000");
        BigDecimal minimum = new BigDecimal("100");
        BigDecimal defaultValue = new BigDecimal("1000");
        Money defaultMinimumBalance = new Money(defaultValue);

        //-1, 0, or 1 as this BigDecimal is numerically less than, equal to, or greater than val.

        if(minimumBalance.getAmount().compareTo(maximum) == -1 && minimumBalance.getAmount().compareTo(minimum) >= 1){
            this.minimumBalance = minimumBalance;
        }else{
            this.minimumBalance = defaultMinimumBalance;
        }

        if(balance.getAmount().compareTo(this.minimumBalance.getAmount()) == -1){
            Money newBalance = new Money (balance.decreaseAmount(penaltyFee));
            super.setBalance(newBalance);
        }else{
            super.setBalance(balance);
        }
    }


}
