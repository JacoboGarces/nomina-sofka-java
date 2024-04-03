package com.sofka.nomina.model.factories;

import com.sofka.nomina.model.DTOS.EmployeeDTO;
import com.sofka.nomina.model.EmployeeType;
import com.sofka.nomina.model.entities.EmployeeEntity;
import com.sofka.nomina.model.entities.ExternalEntity;
import com.sofka.nomina.model.entities.InternalEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeFactory {
  public EmployeeEntity create(EmployeeDTO payload) {
    Map<EmployeeType, EmployeeEntity> employeeChildren = new HashMap<>();
    employeeChildren.put(EmployeeType.EXTERNAL, new ExternalEntity(payload.getName(), payload.getEmail(), payload.getBasicSalary(), payload.getEntryDate()));
    employeeChildren.put(EmployeeType.INTERNAL, new InternalEntity(payload.getName(), payload.getEmail(), payload.getBasicSalary(), payload.getEntryDate()));
    EmployeeEntity employeeEntity = employeeChildren.get(payload.getType());

    if (employeeEntity == null) {
      throw new IllegalArgumentException("Forbidden type.");
    }

    return employeeEntity;
  }
}
