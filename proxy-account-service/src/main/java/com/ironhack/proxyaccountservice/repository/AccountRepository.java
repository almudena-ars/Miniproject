package com.ironhack.proxyaccountservice.repository;

import com.ironhack.proxyaccountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT s.date FROM Account a JOIN a.sentTransactions s WHERE a.id=: id")
    List<LocalDate> findSentTransactionDates(@Param("id")Long id);

    @Query("SELECT r.date FROM Account a JOIN a.receivedTransactions r WHERE a.id=: id")
    List<LocalDate> findReceivedTransactionDates(@Param("id")Long id);


}
