package com.ironhack.proxyuserservice.model;

import com.ironhack.proxyuserservice.classes.ConversionClassUtil;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ThirdParty extends User{
    private String name;
    private String hashedKey;

    //hashed key
    //cuando haga el metodo meto las referencias


    public ThirdParty(String name, String hashedKey) {
        this.name = name;
        this.hashedKey = hashedKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) throws NoSuchAlgorithmException, InvalidKeySpecException {

        this.hashedKey = ConversionClassUtil.convertSecretKeyToString(ConversionClassUtil.getKeyFromPassword(hashedKey, "1r0nh4ck"));
    }
}
