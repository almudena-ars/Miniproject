//package com.ironhack.proxyaccountservice.controller.impl;
//
//import com.ironhack.proxyaccountservice.model.Transaction;
//import com.ironhack.proxyaccountservice.repository.TransactionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class TransactionImpl {
//
//    @Autowired
//    private TransactionRepository transactionRepository;
//
//    @GetMapping("/transaction/all")
//    @ResponseStatus(HttpStatus.FOUND)
//    public List<Transaction> getAllTransaction(){
//        return transactionRepository.findAll();
//    }
//}
