package com.ironhack.proxyuserservice.service.impl;

import com.ironhack.proxyuserservice.controller.dto.ThirdPartyDTO;
import com.ironhack.proxyuserservice.model.Admin;
import com.ironhack.proxyuserservice.model.Role;
import com.ironhack.proxyuserservice.model.ThirdParty;
import com.ironhack.proxyuserservice.repository.AdminRepository;
import com.ironhack.proxyuserservice.repository.RoleRepository;
import com.ironhack.proxyuserservice.repository.ThirdPartyRepository;
import com.ironhack.proxyuserservice.service.interfaces.ThirdPartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ThirdPartyServiceImpl implements ThirdPartyService {

    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    @Autowired
    RoleRepository roleRepository;

    private final Logger logger = LoggerFactory.getLogger(ThirdPartyServiceImpl.class);

    public List<ThirdParty> findAll() {
        List<ThirdParty> thirdParties = thirdPartyRepository.findAll();
        if (thirdParties.size() > 0) {
            logger.info(thirdParties.toString());
            return thirdParties;
        }
        else{
            logger.error("There aren't third parties yet");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There aren't third parties yet");
        }
    }

    public ThirdParty getThirdPartyById(Long id) {
        Optional<ThirdParty> optionalThirdParty = thirdPartyRepository.findById(id);
        if(optionalThirdParty.isPresent()){
            logger.info(optionalThirdParty.get().toString());
            return optionalThirdParty.get();
        }else{
            logger.error("ThirdParty with id " + id + " not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ThirdParty with id " + id + " not found");
        }

    }

    public ThirdParty addThirdParty(ThirdPartyDTO adminDTO) throws NoSuchAlgorithmException, InvalidKeySpecException {
        ThirdParty thirdParty = new ThirdParty();

        Set<Role> roleSet = new HashSet<>();
        Role role = new Role("THIRD PARTY");
        role.setUser(thirdParty);
        roleSet.add(role);
        logger.info(adminDTO.getUserName());
        logger.info(adminDTO.getHashedKey());

        thirdParty.setUsername(adminDTO.getUserName());
        thirdParty.setPassword("-");
        thirdParty.setHashedKey(adminDTO.getHashedKey());
        thirdParty.setRoles(roleSet);

        logger.info(thirdParty.toString());
        thirdPartyRepository.save(thirdParty);

        roleRepository.save(role);

        return thirdParty;

    }
}
