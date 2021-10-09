package com.ironhack.edgeservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.ironhack.edgeservice.controller.dto.*;

import java.util.List;

@FeignClient("proxy-account-service")
public interface ProxyAccountService {
    @GetMapping("/savings/all")
    @ResponseStatus(HttpStatus.OK)
    List<SavingsDTO> getAllSavings();

    @GetMapping("/savingsdto/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    SavingsDTO getSavingsById(@PathVariable(name = "id") Long id);


    @PostMapping("/savings")
    @ResponseStatus(HttpStatus.CREATED)
    void addSavings(@RequestBody SavingsDTO savingsDTO);

    @PatchMapping("/savings/balance/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateSavingsBalance(@PathVariable(name = "id") Long id, @RequestBody BalanceDTO balanceDTO);
}
