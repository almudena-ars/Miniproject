package com.ironhack.proxyaccountservice.service.interfaces;

import com.ironhack.proxyaccountservice.controller.dto.BalanceDTO;
import com.ironhack.proxyaccountservice.controller.dto.CheckingDTO;
import com.ironhack.proxyaccountservice.model.Checking;

public interface CheckingService {
    Checking getCheckingById(Long id);

    void updateCheckingBalance(Long id, BalanceDTO balanceDTO);

    void addChecking(CheckingDTO checkingDTO);
}

