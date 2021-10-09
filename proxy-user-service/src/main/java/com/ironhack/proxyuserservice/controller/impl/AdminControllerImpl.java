package com.ironhack.proxyuserservice.controller.impl;

import com.ironhack.proxyuserservice.controller.dto.AccountHolderDTO;
import com.ironhack.proxyuserservice.controller.dto.AdminDTO;
import com.ironhack.proxyuserservice.controller.dto.UserDTO;
import com.ironhack.proxyuserservice.controller.interfaces.AdminController;
import com.ironhack.proxyuserservice.model.Admin;
import com.ironhack.proxyuserservice.repository.AdminRepository;
import com.ironhack.proxyuserservice.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminControllerImpl implements AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping("/admin/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAllAdmins(){
        return adminService.findAll();
    }

    @GetMapping("/admin/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Admin getAdminById(@PathVariable(name = "id") Long id){
        return adminService.getAdminById(id);
    }

    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAdmin(@RequestBody @Valid AccountHolderDTO adminDTO) {
        adminService.addAdmin(adminDTO);
    }


}
