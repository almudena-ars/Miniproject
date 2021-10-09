package com.ironhack.proxyaccountservice.repository;

import com.ironhack.proxyaccountservice.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t.date FROM Transaction t JOIN t.sendingAccount s WHERE s.id=:id")
    List<LocalDate> findSentTransactionDates(@Param("id")Long id);

    @Query("SELECT t.date FROM Transaction t JOIN t.receivingAccount s WHERE s.id=:id")
    List<LocalDate> findReceivedTransactionDates(@Param("id")Long id);

   //@Query("SELECT t.date FROM Transaction t JOIN t.sendingAccount s WHERE s.id=:id BETWEEN :start AND :end")
    //List<LocalDate> findSentDates(@Param("id")Long id, @Param("start") LocalDate date1, @Param("end") LocalDate date2);

    //@Query("SELECT t.date FROM Transaction t JOIN t.receivingAccount s WHERE s.id=:id")
    //List<LocalDate> findByDateBetweenReceive(@Param("id")Long id, LocalDate startDate, LocalDate finalDate);
}
