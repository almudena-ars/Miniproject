package com.ironhack.proxyaccountservice.service.interfaces;

import com.ironhack.proxyaccountservice.controller.dto.BalanceDTO;
import com.ironhack.proxyaccountservice.controller.dto.StudentCheckingDTO;
import com.ironhack.proxyaccountservice.model.StudentChecking;

public interface StudentCheckingService {
    StudentChecking getStudentCheckingById(Long id);
    void addStudentChecking(StudentCheckingDTO studentCheckingDTO);
    void updateStudentCheckingBalance(Long id, BalanceDTO balanceDTO);
}
