package com.sofka.nomina.services;

import com.sofka.nomina.model.DTOS.EmployeeDTO;
import com.sofka.nomina.model.EmployeeType;
import com.sofka.nomina.model.entities.EmployeeEntity;
import com.sofka.nomina.model.entities.ExternalEntity;
import com.sofka.nomina.model.factories.EmployeeFactory;
import com.sofka.nomina.model.persistence.Employee;
import com.sofka.nomina.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PayrollServiceTest {
  @Mock
  private EmployeeRepository repository;

  @Mock
  private EmployeeFactory factory;

  @InjectMocks
  private PayrollService service;

  @Test
  void calculateTotalSalarySuccess() {
    Employee employee = new Employee(
            1L,
            "Ana García",
            "ana.garcia@example.com",
            3000,
            104500,
            100000,
            LocalDate.of(2021, 8, 20)
    );

    EmployeeDTO employeeDTO = new EmployeeDTO(
            "Ana García",
            "ana.garcia@example.com",
            EmployeeType.EXTERNAL,
            3000,
            LocalDate.of(2021, 8, 20)
    );

    EmployeeEntity employeeEntity = new ExternalEntity(
            "Ana García",
            "ana.garcia@example.com",
            3000,
            LocalDate.of(2021, 8, 20)
    );

    when(factory.create(any(EmployeeDTO.class))).thenReturn(employeeEntity);

    when(repository.save(any(Employee.class))).thenReturn(employee);

    Employee result = service.calculateTotalSalary(employeeDTO);

    Assertions.assertEquals(result, employee);
    verify(repository, times(1)).save(any(Employee.class));
    verify(factory, times(1)).create(employeeDTO);
  }
}