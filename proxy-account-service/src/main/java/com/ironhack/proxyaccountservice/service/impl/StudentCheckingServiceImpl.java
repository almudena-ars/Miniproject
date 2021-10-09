//package com.ironhack.proxyaccountservice.service.impl;
//
//import com.ironhack.proxyaccountservice.classes.Money;
//import com.ironhack.proxyaccountservice.controller.dto.BalanceDTO;
//import com.ironhack.proxyaccountservice.controller.dto.StudentCheckingDTO;
//import com.ironhack.proxyaccountservice.enums.Status;
//import com.ironhack.proxyaccountservice.model.Account;
//import com.ironhack.proxyaccountservice.model.AccountHolder;
//import com.ironhack.proxyaccountservice.model.StudentChecking;
//import com.ironhack.proxyaccountservice.repository.AccountHolderRepository;
//import com.ironhack.proxyaccountservice.repository.StudentCheckingRepository;
//import com.ironhack.proxyaccountservice.service.interfaces.StudentCheckingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class StudentCheckingServiceImpl implements StudentCheckingService {
//
//    @Autowired
//    private StudentCheckingRepository studentCheckingRepository;
//
//    @Autowired
//    private AccountHolderRepository accountHolderRepository;
//
//    public StudentChecking getStudentCheckingById(Long id) {
//        Optional<StudentChecking> optionalStudentChecking = studentCheckingRepository.findById(id);
//        if(optionalStudentChecking.isPresent()){
//            return optionalStudentChecking.get();
//        }else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "StudentChecking account with id " + id + " not found");
//        }
//    }
//
//    public void updateStudentCheckingBalance(Long id, BalanceDTO balanceDTO){
//        Optional<StudentChecking> optionalStudentChecking = studentCheckingRepository.findById(id);
//        if(optionalStudentChecking.isPresent()){
//            StudentChecking studentChecking = optionalStudentChecking.get();
//            Money balance = new Money(balanceDTO.getAmount(), balanceDTO.getCurrency());
//            studentChecking.setBalance(balance);
//            studentCheckingRepository.save(studentChecking);
//        }else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "StudentChecking account with id " + id + " not found");
//
//        }
//    }
//
//    public void addStudentChecking(StudentCheckingDTO studentCheckingDTO){
//        Optional<AccountHolder> optionalPrimaryOwner = accountHolderRepository.findById(studentCheckingDTO.getPrimaryOwner());
//        if(optionalPrimaryOwner.isPresent()){
//            Money balance = new Money(studentCheckingDTO.getBalanceAmount(), studentCheckingDTO.getBalanceCurrency());
//
//            LocalDate localDate = LocalDate.now();
//
//            StudentChecking studentChecking = new StudentChecking();
//            studentChecking.setBalance(balance);
//            studentChecking.setSecretKey(studentCheckingDTO.getSecretKey());
//            studentChecking.setCreationDate(localDate);
//            studentChecking.setStatus(Status.valueOf(studentCheckingDTO.getStatus()));
//            studentChecking.setPrimaryOwner(optionalPrimaryOwner.get());
//
//            List<Account> primaryOwners = new ArrayList<>();
//            primaryOwners.add(studentChecking);
//
//
//
//            Optional<AccountHolder> optionalSecondaryOwner = accountHolderRepository.findById(studentCheckingDTO.getSecondaryOwner());
//            if(optionalSecondaryOwner.isPresent()){
//                List<Account> secondaryOwners = new ArrayList<>();
//                secondaryOwners.add(studentChecking);
//                studentChecking.setSecondaryOwner(optionalSecondaryOwner.get());
//                AccountHolder secondaryAccountHolder = optionalSecondaryOwner.get();
//                secondaryAccountHolder.setSecondaryOwners(secondaryOwners);
//            }
//
//            /*if(studentCheckingDTO.getSecondaryOwner() != null){
//                Optional<AccountHolder> optionalSecondaryOwner = accountHolderRepository.findById(studentCheckingDTO.getSecondaryOwner());
//                optionalSecondaryOwner.ifPresent(studentChecking::setSecondaryOwner);
//
//                AccountHolder secondaryAccountHolder = optionalSecondaryOwner.get();
//                secondaryAccountHolder.addSecondaryStudentChecking(studentChecking);
//
//                accountHolderRepository.save(secondaryAccountHolder);
//            }else{
//                AccountHolder emptyAccountHolder = new AccountHolder();
//                accountHolderRepository.save(emptyAccountHolder);
//                studentChecking.setSecondaryOwner(emptyAccountHolder);
//            }*/
//
//            studentCheckingRepository.save(studentChecking);
//
//            AccountHolder primaryAccountHolder = optionalPrimaryOwner.get();
//            primaryAccountHolder.setPrimaryOwners(primaryOwners);
//
//            accountHolderRepository.save(primaryAccountHolder);
//
//        }else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Missing primary owner");
//        }
//    }
//}
