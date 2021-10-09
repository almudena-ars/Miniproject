package com.ironhack.proxyuserservice.controller.interfaces;

import com.ironhack.proxyuserservice.controller.dto.AccountHolderDTO;
import com.ironhack.proxyuserservice.controller.dto.AdminDTO;
import com.ironhack.proxyuserservice.controller.dto.UserDTO;
import com.ironhack.proxyuserservice.model.Admin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface AdminController {

    List<Admin> getAllAdmins();

    Admin getAdminById(Long id);

    void addAdmin(AccountHolderDTO adminDTO);
}
