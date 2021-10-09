package com.ironhack.proxyuserservice.controller.interfaces;

import com.ironhack.proxyuserservice.controller.dto.AccountHolderDTO;
import com.ironhack.proxyuserservice.model.AccountHolder;
import com.ironhack.proxyuserservice.model.Role;
import com.ironhack.proxyuserservice.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

public interface AccountHolderController {

    List<AccountHolder> getAllAccountHolders();

    AccountHolder getAccountHolderById(Long id);

    void addAccountHolder(AccountHolderDTO accountHolderDTO);

    Set<Role> getRoles(Long id);
}
