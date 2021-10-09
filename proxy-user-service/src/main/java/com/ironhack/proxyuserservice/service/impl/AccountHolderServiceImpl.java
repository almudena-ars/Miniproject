package com.ironhack.proxyuserservice.service.impl;

import com.ironhack.proxyuserservice.classes.Address;
import com.ironhack.proxyuserservice.controller.dto.AccountHolderDTO;
import com.ironhack.proxyuserservice.model.AccountHolder;
import com.ironhack.proxyuserservice.model.Role;
import com.ironhack.proxyuserservice.model.User;
import com.ironhack.proxyuserservice.repository.AccountHolderRepository;
import com.ironhack.proxyuserservice.repository.RoleRepository;
import com.ironhack.proxyuserservice.service.interfaces.AccountHolderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private RoleRepository roleRepository;

    private final Logger logger = LoggerFactory.getLogger(AccountHolderServiceImpl.class);

    public List<AccountHolder> findAll() {
        List<AccountHolder> accountHolders = accountHolderRepository.findAll();
        if (accountHolders.size() > 0) {
            logger.info(accountHolders.toString());
            return accountHolders;
        }
        else{
            logger.error("There aren't account holders yet");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There aren't account holders yet");
        }
    }

    public AccountHolder getAccountHolderById(Long id) {
        Optional<AccountHolder> optionalAccountHolder = accountHolderRepository.findById(id);
        if(optionalAccountHolder.isPresent()){
            logger.info(optionalAccountHolder.get().toString());
            return optionalAccountHolder.get();
        }else{
            logger.error("AccountHolder with account with id " + id + " not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AccountHolder with account with id " + id + " not found");
        }
    }

    public AccountHolder addAccountHolder(AccountHolderDTO accountHolderDTO) {

        Address primaryAddress = new Address();
        primaryAddress.setCity(accountHolderDTO.getPrimaryCity());
        primaryAddress.setStreet(accountHolderDTO.getPrimaryStreet());
        primaryAddress.setPostalCode(accountHolderDTO.getPrimaryPostalCode());

        Address mailingAddress = new Address();
        mailingAddress.setStreet(accountHolderDTO.getMailingStreet());
        mailingAddress.setCity(accountHolderDTO.getMailingCity());
        mailingAddress.setPostalCode(accountHolderDTO.getMailingPostalCode());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //convert String to LocalDate
        LocalDate birthDate = LocalDate.parse(accountHolderDTO.getBirthDate(), formatter);

        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setBirthDate(birthDate);
        accountHolder.setPrimaryAddress(primaryAddress);
        accountHolder.setMailingAddress(mailingAddress);

        Set<Role> roleSet = new HashSet<>();
        Role role = new Role("ACCOUNTHOLDER");
        role.setUser(accountHolder);
        roleSet.add(role);

        accountHolder.setUsername(accountHolderDTO.getUsername());
        accountHolder.setPassword(accountHolderDTO.getPassword());
        accountHolder.setRoles(roleSet);

        logger.info("Saved: " + accountHolder.toString());
        roleRepository.save(role);

        accountHolderRepository.save(accountHolder);

        return accountHolder;



    }

}
