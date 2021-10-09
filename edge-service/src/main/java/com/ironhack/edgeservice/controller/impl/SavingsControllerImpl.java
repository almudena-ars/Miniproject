package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.client.ProxyAccountService;
import com.ironhack.edgeservice.controller.interfaces.SavingsController;
import com.ironhack.edgeservice.controller.dto.BalanceDTO;
import com.ironhack.edgeservice.controller.dto.SavingsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
public class SavingsControllerImpl implements SavingsController {

    @Autowired
    private ProxyAccountService proxyAccountService;

    @GetMapping("/savings/all")
    @ResponseStatus(HttpStatus.OK)
    public List<SavingsDTO> getAllSavings(){
        return proxyAccountService.getAllSavings();
    }

    @GetMapping("/savings/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SavingsDTO getSavingsById(@PathVariable(name = "id") Long id){
        return proxyAccountService.getSavingsById(id);
    }


    @PostMapping("/savings")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSavings(@RequestBody SavingsDTO savingsDTO){
        proxyAccountService.addSavings(savingsDTO);
    }

    @PatchMapping("/savings/balance/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateSavingsBalance(@PathVariable(name = "id") Long id, @RequestBody BalanceDTO balanceDTO) {
        proxyAccountService.updateSavingsBalance(id, balanceDTO);
    }
}
