package com.ironhack.proxyuserservice.controller.impl;

import com.ironhack.proxyuserservice.controller.dto.ThirdPartyDTO;
import com.ironhack.proxyuserservice.controller.interfaces.ThirdPartyController;
import com.ironhack.proxyuserservice.model.ThirdParty;
import com.ironhack.proxyuserservice.service.interfaces.AdminService;
import com.ironhack.proxyuserservice.service.interfaces.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@RestController
public class ThirdPartyControllerImpl implements ThirdPartyController {

    @Autowired
    private ThirdPartyService thirdPartyService;


    @GetMapping("/thirdparty/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdParty> getAllThirdParties() {
        return thirdPartyService.findAll();
    }

    @GetMapping("/thirdparty/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ThirdParty getThirdPartyById(@PathVariable(name = "id")Long id) {
        return thirdPartyService.getThirdPartyById(id);
    }

    @PostMapping("/thirdparty")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty addAdmin(@RequestBody @Valid ThirdPartyDTO adminDTO) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return thirdPartyService.addThirdParty(adminDTO);
    }
}
