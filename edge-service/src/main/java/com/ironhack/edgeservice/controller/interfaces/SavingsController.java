package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.controller.dto.BalanceDTO;
import com.ironhack.edgeservice.controller.dto.SavingsDTO;

import java.util.List;

public interface SavingsController {

    List<SavingsDTO> getAllSavings();


    SavingsDTO getSavingsById(Long id);

    void addSavings(SavingsDTO savingsDTO);


    void updateSavingsBalance(Long id, BalanceDTO balanceDTO);
}
