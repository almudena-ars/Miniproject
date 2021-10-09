package com.ironhack.proxyuserservice.controller.interfaces;

import com.ironhack.proxyuserservice.controller.dto.AccountHolderDTO;
import com.ironhack.proxyuserservice.controller.dto.ThirdPartyDTO;
import com.ironhack.proxyuserservice.model.Admin;
import com.ironhack.proxyuserservice.model.ThirdParty;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface ThirdPartyController {

    List<ThirdParty> getAllThirdParties();

    ThirdParty getThirdPartyById(Long id);

    ThirdParty addAdmin(ThirdPartyDTO adminDTO) throws NoSuchAlgorithmException, InvalidKeySpecException;

}
