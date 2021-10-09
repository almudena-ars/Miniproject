package com.ironhack.proxyuserservice.repository;

import com.ironhack.proxyuserservice.model.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
    List<AccountHolder> findByUserName(String name);
}
