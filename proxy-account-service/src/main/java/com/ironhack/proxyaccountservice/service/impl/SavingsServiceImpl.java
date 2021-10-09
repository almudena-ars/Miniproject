package com.ironhack.proxyaccountservice.service.impl;

import com.ironhack.proxyaccountservice.classes.Money;
import com.ironhack.proxyaccountservice.controller.dto.BalanceDTO;
import com.ironhack.proxyaccountservice.controller.dto.SavingsDTO;
import com.ironhack.proxyaccountservice.enums.Status;
import com.ironhack.proxyaccountservice.model.Account;
import com.ironhack.proxyaccountservice.model.Savings;
import com.ironhack.proxyaccountservice.repository.AccountRepository;
import com.ironhack.proxyaccountservice.repository.SavingsRepository;
import com.ironhack.proxyaccountservice.service.interfaces.SavingsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Optional;


@Service
public class SavingsServiceImpl implements SavingsService {


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SavingsRepository savingsRepository;

    private final Logger logger = LoggerFactory.getLogger(SavingsServiceImpl.class);


    public Savings getSavingsById(Long id){
        Optional<Savings> optionalSavings = savingsRepository.findById(id);
        if(optionalSavings.isPresent()){
            return optionalSavings.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Savings account with id " + id + " not found");
        }
    }


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

    public SavingsDTO getSavingsDTOById(Long id){
        Optional<Savings> optionalSavings = savingsRepository.findById(id);
        if(optionalSavings.isPresent()){
            SavingsDTO savingsDTO = new SavingsDTO();
            savingsDTO.setBalanceAmount(optionalSavings.get().getBalance().getAmount());
            savingsDTO.setBalanceCurrency(optionalSavings.get().getBalance().getCurrency());
            savingsDTO.setSecretKey(optionalSavings.get().getSecretKey());
            savingsDTO.setBalanceAmount(optionalSavings.get().getPenaltyFee().getAmount());
            savingsDTO.setPenaltyFeeCurrency(optionalSavings.get().getPenaltyFee().getCurrency());
            savingsDTO.setStatus(optionalSavings.get().getStatus().toString());
            savingsDTO.setPrimaryOwner(optionalSavings.get().getPrimaryOwnerId());
            savingsDTO.setSecondaryOwner(optionalSavings.get().getSecondaryOwnerId());
            savingsDTO.setInterestRateAmount(optionalSavings.get().getInterestRate().getAmount());
            savingsDTO.setInterestRateCurrency(optionalSavings.get().getInterestRate().getCurrency());
            savingsDTO.setMinimumBalanceAmount(optionalSavings.get().getMinimumBalance().getAmount());
            savingsDTO.setMinimumBalanceCurrency(optionalSavings.get().getMinimumBalance().getCurrency());
            return savingsDTO;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Savings account with id " + id + " not found");
        }
    }
    public void updateSavingsBalance(Long id, BalanceDTO balanceDTO){
        Optional<Savings> optionalSavings = savingsRepository.findById(id);
        if(optionalSavings.isPresent()) {
            Savings savings = optionalSavings.get();
            Money balance = new Money(balanceDTO.getAmount(), balanceDTO.getCurrency());
            savings.setBalance(balance);
            logger.info("MoneyParam {}", balance.getAmount().toString());
            logger.info("Id {}", savings.getId().toString());
            logger.info("BalanceSavings {}", savings.getBalance().getAmount().toString());
            logger.info("Currency {}", savings.getBalance().getCurrency().toString());
            savingsRepository.save(savings);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Savings account with id " + id + " not found");        }
        }

    public void addSavings(SavingsDTO savingsDTO){



            Money balance = new Money(savingsDTO.getBalanceAmount(), savingsDTO.getBalanceCurrency());
            Money penaltyFee = new Money(savingsDTO.getPenaltyFeeAmount(), savingsDTO.getPenaltyFeeCurrency());
            Money interestRate = new Money(savingsDTO.getInterestRateAmount(), savingsDTO.getInterestRateCurrency());
            Money minimumBalance = new Money(savingsDTO.getMinimumBalanceAmount(), savingsDTO.getMinimumBalanceCurrency());

            LocalDate creationDate = LocalDate.now();

            Savings savings = new Savings();

            //savings.setBalance(balance);
            savings.setSecretKey(savingsDTO.getSecretKey());
            savings.setPenaltyFee(penaltyFee);
            savings.setCreationDate(creationDate);
            savings.setStatus(Status.valueOf(savingsDTO.getStatus()));
            savings.setPrimaryOwnerId(savingsDTO.getPrimaryOwner());
            if(savingsDTO.getSecondaryOwner() != null){
                    savings.setSecondaryOwnerId(savingsDTO.getSecondaryOwner());
            }else{

                savings.setSecondaryOwnerId(null);
                /*AccountHolder emptyAccountHolder = new AccountHolder();
                accountHolderRepository.save(emptyAccountHolder);
                savings.setSecondaryOwner(emptyAccountHolder);*/
           }

            savings.setInterestRate(interestRate);
            savings.setMinimumBalanceAndBalance(minimumBalance, balance);

            savingsRepository.save(savings);




    }

}
