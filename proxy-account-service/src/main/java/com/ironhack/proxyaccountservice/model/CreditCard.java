package com.ironhack.proxyaccountservice.model;

import com.ironhack.proxyaccountservice.classes.Money;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Account{

    @Transient
    private final BigDecimal fixedPenalty = new BigDecimal("40");


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_card_id")
    private Long id;
    /*@Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "amount"))
    })
    //@Column(name = "balance")
    private Money balance;*/

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "currency_credit_limit")),
            @AttributeOverride(name = "amount", column = @Column(name = "amount_credit_limit"))
    })
    //@Column(name = "credit_limit")
    private Money creditLimit;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "currency_penalty_fee")),
            @AttributeOverride(name = "amount", column = @Column(name = "amount_penalty_fee"))
    })
    //@Column(name = "penalty_fee")
    private Money penaltyFee = new Money(fixedPenalty);
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "currency_interest_rate")),
            @AttributeOverride(name = "amount", column = @Column(name = "amount_interest_rate"))
    })
    //@Column(name = "interest_rate")
    private Money interestRate;

    /*@ManyToMany(mappedBy = "creditCardTransfer")
    private Set<Transaction> transactions;*/


    public CreditCard() {
    }



    public CreditCard(Long id, Money balance, Long primaryOwnerIdId, Long secondaryOwnerIdId, Money creditLimit, Money penaltyFee, Money interestRate) {
        this.id = id;
        //this.balance = balance;
        setCreditLimit(creditLimit);
        this.penaltyFee = penaltyFee;
        setInterestRate(interestRate);
    }

    public CreditCard(Long id, Money balance,   Money creditLimit, Money penaltyFee, Money interestRate) {
        this.id = id;
        //this.balance = balance;
        setCreditLimit(creditLimit);
        this.penaltyFee = penaltyFee;
        setInterestRate(interestRate);
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public Money getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Money creditLimit) {

        BigDecimal maximum = new BigDecimal("100000");
        BigDecimal minimum = new BigDecimal("100");
        BigDecimal defaultValue = new BigDecimal("100");
        Money defaultCreditLimit = new Money(defaultValue);

        //-1, 0, or 1 as this BigDecimal is numerically less than, equal to, or greater than val.

        if(creditLimit.getAmount().compareTo(maximum) == -1 && creditLimit.getAmount().compareTo(minimum) >= 1){
            this.creditLimit = creditLimit;
        }else{
            this.creditLimit = defaultCreditLimit;
        }
    }

    public Money getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(Money penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public Money getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Money interestRate) {

        BigDecimal maximum = new BigDecimal("0.2");
        BigDecimal minimum = new BigDecimal("0.1");
        BigDecimal defaultValue = new BigDecimal("0.2");
        Money defaultInterestRate = new Money(defaultValue);

        //-1, 0, or 1 as this BigDecimal is numerically less than, equal to, or greater than val.

        if(interestRate.getAmount().compareTo(maximum) == -1 && interestRate.getAmount().compareTo(minimum) >= 1){
            this.interestRate = interestRate;
        }else{
            this.interestRate = defaultInterestRate;
        }
    }


}
