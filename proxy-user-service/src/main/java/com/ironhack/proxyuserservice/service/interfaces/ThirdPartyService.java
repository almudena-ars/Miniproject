package com.ironhack.proxyuserservice.service.interfaces;

import com.ironhack.proxyuserservice.controller.dto.ThirdPartyDTO;
import com.ironhack.proxyuserservice.model.ThirdParty;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface ThirdPartyService {


    List<ThirdParty> findAll();

    ThirdParty getThirdPartyById(Long id);

    ThirdParty addThirdParty(ThirdPartyDTO adminDTO) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
