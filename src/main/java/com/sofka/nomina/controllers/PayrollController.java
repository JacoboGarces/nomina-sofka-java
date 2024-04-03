package com.sofka.nomina.controllers;

import com.sofka.nomina.model.DTOS.EmployeeDTO;
import com.sofka.nomina.services.PayrollService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PayrollController {
  private final PayrollService payrollService;


  public PayrollController(PayrollService payrollService) {
    this.payrollService = payrollService;
  }

  @PostMapping("/CalculateEmployeeSalary")
  public ResponseEntity<?> calculateEmployeeSalary(@Valid @RequestBody EmployeeDTO payload, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
    }

    return ResponseEntity.status(HttpStatus.OK).body(payrollService.calculateTotalSalary(payload));
  }

  @PostMapping("/CalculatePayroll")
  public ResponseEntity<?> calculatePayroll(@Valid @RequestBody List<EmployeeDTO> payload, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
    }

    return ResponseEntity.status(HttpStatus.OK).body(payrollService.calculatePayroll(payload));
  }
}
