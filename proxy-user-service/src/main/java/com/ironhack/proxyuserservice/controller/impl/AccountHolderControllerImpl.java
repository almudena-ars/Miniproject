package com.ironhack.proxyuserservice.controller.impl;

import com.ironhack.proxyuserservice.controller.dto.AccountHolderDTO;
import com.ironhack.proxyuserservice.controller.interfaces.AccountHolderController;
import com.ironhack.proxyuserservice.model.AccountHolder;
import com.ironhack.proxyuserservice.model.Role;
import com.ironhack.proxyuserservice.model.User;
import com.ironhack.proxyuserservice.repository.AccountHolderRepository;
import com.ironhack.proxyuserservice.service.interfaces.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class AccountHolderControllerImpl implements AccountHolderController {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private AccountHolderService accountHolderService;

    @GetMapping("/accountholder/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> getAllAccountHolders(){
        return accountHolderService.findAll();
    }


    @GetMapping("/accountholder/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountHolder getAccountHolderById(@PathVariable(name = "id") Long id){
        return accountHolderService.getAccountHolderById(id);
    }

    @PostMapping("/accountholder")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAccountHolder(@RequestBody @Valid AccountHolderDTO accountHolderDTO) {
        accountHolderService.addAccountHolder(accountHolderDTO);
    }

    @GetMapping("/accountholder/roles/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Set<Role> getRoles(@PathVariable(name = "id") Long id){
        Optional<AccountHolder> optionalAccountHolder = accountHolderRepository.findById(id);
        if(optionalAccountHolder.isPresent()){
            return optionalAccountHolder.get().getRoles();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



}
