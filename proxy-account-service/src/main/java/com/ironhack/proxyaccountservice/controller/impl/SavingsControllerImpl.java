package com.ironhack.proxyaccountservice.controller.impl;

import com.ironhack.proxyaccountservice.controller.dto.BalanceDTO;
import com.ironhack.proxyaccountservice.controller.dto.SavingsDTO;
import com.ironhack.proxyaccountservice.model.Savings;
import com.ironhack.proxyaccountservice.repository.SavingsRepository;
import com.ironhack.proxyaccountservice.service.interfaces.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SavingsControllerImpl {

    @Autowired
    private SavingsService savingsService;

    @Autowired
    private SavingsRepository savingsRepository;

    @GetMapping("/savings/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Savings> getAllSavings(){
        return savingsRepository.findAll();
    }


    @GetMapping("/savings/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Savings getSavingsById(@PathVariable(name = "id") Long id){
        return savingsService.getSavingsById(id);
    }

    @GetMapping("/savingsdto/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SavingsDTO getSavingsDTOById(@PathVariable(name = "id") Long id){
        return savingsService.getSavingsDTOById(id);
    }


    @PostMapping("/savings")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSavings(@RequestBody SavingsDTO savingsDTO){
        savingsService.addSavings(savingsDTO);
    }

    @PatchMapping("/savings/balance/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateSavingsBalance(@PathVariable(name = "id") Long id, @RequestBody BalanceDTO balanceDTO) {
        savingsService.updateSavingsBalance(id, balanceDTO);
    }
}


