//package com.ironhack.proxyaccountservice.controller.impl;
//
//import com.ironhack.proxyaccountservice.controller.dto.BalanceDTO;
//import com.ironhack.proxyaccountservice.controller.dto.CheckingDTO;
//import com.ironhack.proxyaccountservice.model.Checking;
//import com.ironhack.proxyaccountservice.repository.CheckingRepository;
//import com.ironhack.proxyaccountservice.service.interfaces.CheckingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class CheckingControllerImpl {
//
//    @Autowired
//    private CheckingRepository checkingRepository;
//
//    @Autowired
//    private CheckingService checkingService;
//
//    @GetMapping("/checking/all")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Checking> getAllChecking(){
//        return checkingRepository.findAll();
//    }
//
//    @GetMapping("/checking/id/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Checking getCheckingById(@PathVariable(name = "id") Long id){
//        return checkingService.getCheckingById(id);
//    }
//
//
//    @PatchMapping("/checking/balance/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void updateCheckingBalance(@PathVariable(name = "id") Long id, @RequestBody BalanceDTO balanceDTO) {
//        checkingService.updateCheckingBalance(id, balanceDTO);
//    }
//
//    @PostMapping("/checking")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addChecking(@RequestBody CheckingDTO checkingDTO){
//        checkingService.addChecking(checkingDTO);
//    }
//
//
//}
//
