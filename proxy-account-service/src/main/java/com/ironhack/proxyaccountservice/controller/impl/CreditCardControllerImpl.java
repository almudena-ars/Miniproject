//package com.ironhack.proxyaccountservice.controller.impl;
//
//import com.ironhack.proxyaccountservice.controller.dto.BalanceDTO;
//import com.ironhack.proxyaccountservice.controller.dto.CreditCardDTO;
//import com.ironhack.proxyaccountservice.controller.interfaces.CreditCardController;
//import com.ironhack.proxyaccountservice.model.CreditCard;
//import com.ironhack.proxyaccountservice.repository.CreditCardRepository;
//import com.ironhack.proxyaccountservice.service.interfaces.CreditCardService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class CreditCardControllerImpl implements CreditCardController {
//
//    @Autowired
//    private CreditCardRepository creditCardRepository;
//
//    @Autowired
//    private CreditCardService creditCardService;
//
//    @GetMapping("/creditcard/all")
//    @ResponseStatus(HttpStatus.OK)
//    public List<CreditCard> getAllCreditCard(){
//        return creditCardRepository.findAll();
//    }
//
//    @GetMapping("/creditcard/id/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public CreditCard getCreditCardById(@PathVariable(name = "id") Long id){
//        return creditCardService.getCreditCardById(id);
//    }
//
//    @PostMapping("/creditcard")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addCreditCard(@RequestBody CreditCardDTO creditCardDTO){
//        creditCardService.addCreditCard(creditCardDTO);
//    }
//
//    @PatchMapping("/creditcard/balance/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void updateCreditCrdBalance(@PathVariable(name = "id") Long id, @RequestBody BalanceDTO balanceDTO) {
//        creditCardService.updateCreditCardBalance(id, balanceDTO);
//    }
//}
