package com.ironhack.proxyuserservice.service.interfaces;

import com.ironhack.proxyuserservice.controller.dto.AccountHolderDTO;
import com.ironhack.proxyuserservice.model.AccountHolder;
import com.ironhack.proxyuserservice.model.User;

import java.util.List;

public interface AccountHolderService {
    AccountHolder getAccountHolderById(Long id);

    void addAccountHolder(AccountHolderDTO accountHolderDTO);

    List<AccountHolder> findAll();
}
