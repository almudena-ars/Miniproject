package com.ironhack.proxyuserservice.service.interfaces;

import com.ironhack.proxyuserservice.controller.dto.AccountHolderDTO;
import com.ironhack.proxyuserservice.controller.dto.AdminDTO;
import com.ironhack.proxyuserservice.controller.dto.UserDTO;
import com.ironhack.proxyuserservice.model.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> findAll();

    Admin getAdminById(Long id);

    void addAdmin(AccountHolderDTO adminDTO);
}
