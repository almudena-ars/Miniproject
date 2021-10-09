//package com.ironhack.proxyaccountservice.service.impl;
//
//import com.ironhack.proxyaccountservice.classes.Money;
//import com.ironhack.proxyaccountservice.controller.dto.BalanceDTO;
//import com.ironhack.proxyaccountservice.controller.dto.CreditCardDTO;
//import com.ironhack.proxyaccountservice.enums.Status;
//import com.ironhack.proxyaccountservice.model.AccountHolder;
//import com.ironhack.proxyaccountservice.model.CreditCard;
//import com.ironhack.proxyaccountservice.repository.AccountHolderRepository;
//import com.ironhack.proxyaccountservice.repository.CreditCardRepository;
//import com.ironhack.proxyaccountservice.service.interfaces.CreditCardService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.Optional;
//
//@Service
//public class CreditCardServiceImpl implements CreditCardService {
//
//    @Autowired
//    private CreditCardRepository creditCardRepository;
//
//    @Autowired
//    private AccountHolderRepository accountHolderRepository;
//
//    public CreditCard getCreditCardById(Long id) {
//        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
//        if(optionalCreditCard.isPresent()){
//            return optionalCreditCard.get();
//        }else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CreditCard account with id " + id + " not found");
//        }
//    }
//
//    public void updateCreditCardBalance(Long id, BalanceDTO balanceDTO){
//        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
//        if(optionalCreditCard.isPresent()){
//            CreditCard creditCard = optionalCreditCard.get();
//            Money balance = new Money(balanceDTO.getAmount(), balanceDTO.getCurrency());
//            creditCard.setBalance(balance);
//            creditCardRepository.save(creditCard);
//        }else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CreditCard account with id " + id + " not found");
//        }
//    }
//
//
//    public void addCreditCard(CreditCardDTO creditCardDTO){
//        Optional<AccountHolder> optionalPrimaryOwner = accountHolderRepository.findById(creditCardDTO.getPrimaryOwner());
//        if(optionalPrimaryOwner.isPresent()){
//            Money balance = new Money(creditCardDTO.getBalanceAmount(), creditCardDTO.getBalanceCurrency());
//            Money creditLimit = new Money(creditCardDTO.getCreditLimitAmount(), creditCardDTO.getCreditLimitCurrency());
//            Money interestRate = new Money(creditCardDTO.getCreditLimitAmount(), creditCardDTO.getCreditLimitCurrency());
//
//            CreditCard creditCard = new CreditCard();
//
//            creditCard.setBalance(balance);
//            creditCard.setCreditLimit(creditLimit);
//            creditCard.setInterestRate(interestRate);
//            creditCard.setStatus(Status.valueOf(creditCardDTO.getStatus()));
//            creditCard.setPrimaryOwner(optionalPrimaryOwner.get());
//
//            Optional<AccountHolder> optionalSecondaryOwner = accountHolderRepository.findById(creditCardDTO.getSecondaryOwner());
//            if(optionalSecondaryOwner.isPresent()){
//                creditCard.setSecondaryOwner(optionalSecondaryOwner.get());
//            }
//
//            /*
//
//            if(creditCardDTO.getSecondaryOwner() == null){
//                Optional<AccountHolder> nullSecondaryOwner = accountHolderRepository.findById(0L);
//                creditCard.setSecondaryOwner(nullSecondaryOwner.get());
//            }else if(optionalSecondaryOwner.isPresent()){
//                creditCard.setSecondaryOwner(optionalSecondaryOwner.get());
//            }else{
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Secondary with id " + creditCardDTO.getSecondaryOwner() + " not found");
//            }*/
//
//            creditCardRepository.save(creditCard);
//
//            /*if(creditCardDTO.getSecondaryOwner() != null){
//                Optional<AccountHolder> optionalSecondaryOwner = accountHolderRepository.findById(creditCardDTO.getSecondaryOwner());
//                if(optionalSecondaryOwner.isPresent()){
//                    creditCard.setSecondaryOwner(optionalSecondaryOwner.get());
//                }
//            }else{
//                AccountHolder emptyAccountHolder = new AccountHolder();
//                accountHolderRepository.save(emptyAccountHolder);
//                creditCard.setSecondaryOwner(emptyAccountHolder);
//            }*/
//
//        }else{
//            throw new ResponseStatusException(HttpStatus.MULTI_STATUS, "Missing primary owner");
//        }
//    }
//
//
//}
