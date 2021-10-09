package com.ironhack.proxyaccountservice.service.interfaces;

import com.ironhack.proxyaccountservice.controller.dto.BalanceDTO;
import com.ironhack.proxyaccountservice.controller.dto.CreditCardDTO;
import com.ironhack.proxyaccountservice.model.CreditCard;

public interface CreditCardService {
    CreditCard getCreditCardById(Long id);
    void updateCreditCardBalance(Long id, BalanceDTO balanceDTO);
    void addCreditCard(CreditCardDTO creditCardDTO);
}
