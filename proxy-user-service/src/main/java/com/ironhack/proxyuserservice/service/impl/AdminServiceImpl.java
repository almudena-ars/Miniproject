package com.ironhack.proxyuserservice.service.impl;

import com.ironhack.proxyuserservice.controller.dto.AccountHolderDTO;
import com.ironhack.proxyuserservice.controller.dto.AdminDTO;
import com.ironhack.proxyuserservice.controller.dto.UserDTO;
import com.ironhack.proxyuserservice.model.AccountHolder;
import com.ironhack.proxyuserservice.model.Admin;
import com.ironhack.proxyuserservice.model.Role;
import com.ironhack.proxyuserservice.repository.AdminRepository;
import com.ironhack.proxyuserservice.repository.RoleRepository;
import com.ironhack.proxyuserservice.service.interfaces.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    RoleRepository roleRepository;

    private final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);


    public List<Admin> findAll() {
        List<Admin> admins = adminRepository.findAll();
        if (admins.size() > 0) {
            logger.info(admins.toString());
            return admins;
        }
        else{
            logger.error("There aren't admins yet");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There aren't admins yet");
        }
    }

    public Admin getAdminById(Long id) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        if(optionalAdmin.isPresent()){
            logger.info(optionalAdmin.get().toString());
            return optionalAdmin.get();
        }else{
            logger.error("Admin with id " + id + " not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin with id " + id + " not found");
        }
    }

    public void addAdmin(AccountHolderDTO adminDTO) {
        Admin admin = new Admin();

        Set<Role> roleSet = new HashSet<>();
        Role role = new Role("ADMIN");
        role.setUser(admin);
        roleSet.add(role);
        logger.info(adminDTO.getUsername());
        logger.info(adminDTO.getPassword());

        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(adminDTO.getPassword());
        admin.setRoles(roleSet);

        logger.info(admin.toString());
        adminRepository.save(admin);

        roleRepository.save(role);
    }

}
