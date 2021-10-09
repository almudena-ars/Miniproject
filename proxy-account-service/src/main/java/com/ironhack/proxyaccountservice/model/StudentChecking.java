package com.ironhack.proxyaccountservice.model;

import com.ironhack.proxyaccountservice.classes.Money;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class StudentChecking extends Account {

    @Transient
    private final BigDecimal fixedPenalty = new BigDecimal("40");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_checking_id")
    private Long id;

    /*@Embedded
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

    /*@ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "primary_owner_id")
    private Long primaryOwnerId;


    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "secondary_owner_id")
    private Long secondaryOwnerId;

    @ManyToMany(mappedBy = "studentCheckingTransfer")
    private Set<Transaction> transactions;*/

    public StudentChecking() {
    }

    public StudentChecking(Long id,  String secretKey, Money penaltyFee, LocalDate creationDate) {
        this.id = id;
        //this.balance = balance;
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


}
