package com.ironhack.proxyuserservice.model;

import com.ironhack.proxyuserservice.classes.ConversionClassUtil;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ThirdParty extends User{
    private String hashedKey;

    //hashed key
    //cuando haga el metodo meto las referencias


    public ThirdParty(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) throws NoSuchAlgorithmException, InvalidKeySpecException {

        this.hashedKey = ConversionClassUtil.convertSecretKeyToString(ConversionClassUtil.getKeyFromPassword(hashedKey, "1r0nh4ck"));
    }
}
