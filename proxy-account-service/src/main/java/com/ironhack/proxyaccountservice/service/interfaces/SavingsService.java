package com.ironhack.proxyaccountservice.service.interfaces;

import com.ironhack.proxyaccountservice.controller.dto.BalanceDTO;
import com.ironhack.proxyaccountservice.controller.dto.SavingsDTO;
import com.ironhack.proxyaccountservice.model.Savings;

public interface SavingsService {
    Savings getSavingsById(Long id);
    SavingsDTO getSavingsDTOById(Long id);

    void updateSavingsBalance(Long id, BalanceDTO balanceDTO);
    void addSavings(SavingsDTO savingsDTO);
}
