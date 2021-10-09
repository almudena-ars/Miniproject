//package com.ironhack.proxyaccountservice.controller.impl;
//
//import com.ironhack.proxyaccountservice.controller.interfaces.StudentCheckingController;
//import com.ironhack.proxyaccountservice.model.StudentChecking;
//import com.ironhack.proxyaccountservice.repository.StudentCheckingRepository;
//import com.ironhack.proxyaccountservice.service.interfaces.StudentCheckingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class StudentCheckingControllerImpl implements StudentCheckingController {
//
//    @Autowired
//    private StudentCheckingRepository studentCheckingRepository;
//
//    @Autowired
//    private StudentCheckingService studentCheckingService;
//
//    @GetMapping("/studentchecking/all")
//    @ResponseStatus(HttpStatus.OK)
//    public List<StudentChecking> getAllStudentChecking(){
//        return studentCheckingRepository.findAll();
//    }
//
//    @GetMapping("/studentchecking/id/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public StudentChecking getStudentCheckingById(@PathVariable(name = "id") Long id){
//        return studentCheckingService.getStudentCheckingById(id);
//    }
//
//    /*@PostMapping("/studentchecking")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addStudentChecking(@RequestBody StudentCheckingDTO studentCheckingDTO){
//        studentCheckingService.addStudentChecking(studentCheckingDTO);
//    }
//
//    @PatchMapping("/studentchecking/balance/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void updateStudentCheckingBalance(@PathVariable(name = "id") Long id, @RequestBody BalanceDTO balanceDTO) {
//        studentCheckingService.updateStudentCheckingBalance(id, balanceDTO);
//    }*/
//}
//
