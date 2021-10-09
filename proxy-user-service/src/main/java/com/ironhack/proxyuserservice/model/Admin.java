package com.ironhack.proxyuserservice.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name ="id")
public class Admin extends User{

    public Admin() {
    }

}
