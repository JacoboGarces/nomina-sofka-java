package com.sofka.nomina.shared;

import com.sofka.nomina.model.entities.EmployeeEntity;
import com.sofka.nomina.model.persistence.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
  public Employee domainToEntity(EmployeeEntity employeeEntity) {
    return new Employee(
            employeeEntity.getName(),
            employeeEntity.getEmail(),
            employeeEntity.getBasicSalary(),
            employeeEntity.getTotalSalary(),
            employeeEntity.getBonus(),
            employeeEntity.getEntryDate()
    );
  }
}
