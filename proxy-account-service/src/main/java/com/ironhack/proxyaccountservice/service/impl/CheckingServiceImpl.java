//package com.ironhack.proxyaccountservice.service.impl;
//
//import com.ironhack.proxyaccountservice.classes.Money;
//import com.ironhack.proxyaccountservice.controller.dto.BalanceDTO;
//import com.ironhack.proxyaccountservice.controller.dto.CheckingDTO;
//import com.ironhack.proxyaccountservice.controller.dto.StudentCheckingDTO;
//import com.ironhack.proxyaccountservice.enums.Status;
//import com.ironhack.proxyaccountservice.model.AccountHolder;
//import com.ironhack.proxyaccountservice.model.Checking;
//import com.ironhack.proxyaccountservice.repository.AccountHolderRepository;
//import com.ironhack.proxyaccountservice.repository.CheckingRepository;
//import com.ironhack.proxyaccountservice.service.interfaces.CheckingService;
//import com.ironhack.proxyaccountservice.service.interfaces.StudentCheckingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.time.LocalDate;
//import java.time.Period;
//import java.util.Optional;
//
//@Service
//public class CheckingServiceImpl implements CheckingService {
///*
//    @Autowired
//    private AccountHolderRepository accountHolderRepository;
//
//    @Autowired
//    private CheckingRepository checkingRepository;
//
//    @Autowired
//    private StudentCheckingService studentCheckingService;
//
//
//
//    public Checking getCheckingById(Long id) {
//        Optional<Checking> optionalChecking = checkingRepository.findById(id);
//        if(optionalChecking.isPresent()){
//            return optionalChecking.get();
//        }else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Checking account with id " + id + " not found");
//        }
//    }
//
//
//    public void updateCheckingBalance(Long id, BalanceDTO balanceDTO){
//        Optional<Checking> optionalChecking = checkingRepository.findById(id);
//        if(optionalChecking.isPresent()){
//            Checking checking = optionalChecking.get();
//            Money balance = new Money(balanceDTO.getAmount(), balanceDTO.getCurrency());
//            checking.setBalance(balance);
//            checkingRepository.save(checking);
//        }else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Checking account with id " + id + " not found");
//        }
//    }
//
//    public void addChecking(CheckingDTO checkingDTO){
//        Optional<AccountHolder> optionalPrimaryOwner = accountHolderRepository.findById(checkingDTO.getPrimaryOwner());
//        if(optionalPrimaryOwner.isPresent()){
//
//            LocalDate localDate = LocalDate.now();
//
//            Period diff = Period.between(optionalPrimaryOwner.get().getBirthDate(),localDate);
//
//            if(diff.getYears() >= 24){
//                Money balance = new Money(checkingDTO.getBalanceAmount(), checkingDTO.getBalanceCurrency());
//                LocalDate creationDate = LocalDate.now();
//
//                Checking checking = new Checking();
//                checking.setBalance(balance);
//                checking.setSecretKey(checkingDTO.getSecretKey());
//                checking.setCreationDate(creationDate);
//                checking.setStatus(Status.valueOf(checkingDTO.getStatus()));
//                checking.setPrimaryOwner(optionalPrimaryOwner.get());
//
//                if(checkingDTO.getSecondaryOwner() != null){
//                    Optional<AccountHolder> optionalSecondaryOwner = accountHolderRepository.findById(checkingDTO.getSecondaryOwner());
//                    optionalSecondaryOwner.ifPresent(checking::setSecondaryOwner);
//                }else{
//                    AccountHolder emptyAccountHolder = new AccountHolder();
//                    accountHolderRepository.save(emptyAccountHolder);
//                    checking.setSecondaryOwner(emptyAccountHolder);
//                }
//
//                checkingRepository.save(checking);
//            }else{
//
//                StudentCheckingDTO studentCheckingDTO = new StudentCheckingDTO();
//
//                studentCheckingDTO.setBalanceAmount(checkingDTO.getBalanceAmount());
//                studentCheckingDTO.setBalanceCurrency(checkingDTO.getBalanceCurrency());
//                studentCheckingDTO.setSecretKey(checkingDTO.getSecretKey());
//                studentCheckingDTO.setStatus(checkingDTO.getStatus());
//                studentCheckingDTO.setPrimaryOwner(checkingDTO.getPrimaryOwner());
//                studentCheckingDTO.setSecondaryOwner(checkingDTO.getSecondaryOwner());
//                studentCheckingService.addStudentChecking(studentCheckingDTO);
//            }
//
//        }else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Missing primary owner");
//
//        }
//    }
//*/
//
//
//
//}
