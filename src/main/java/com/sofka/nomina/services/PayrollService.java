package com.sofka.nomina.services;

import com.sofka.nomina.model.DTOS.EmployeeDTO;
import com.sofka.nomina.model.entities.EmployeeEntity;
import com.sofka.nomina.model.entities.PayrollEntity;
import com.sofka.nomina.model.factories.EmployeeFactory;
import com.sofka.nomina.model.persistence.Employee;
import com.sofka.nomina.repositories.EmployeeRepository;
import com.sofka.nomina.shared.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {
  private final EmployeeFactory factory;
  private final EmployeeRepository repository;
  private final EmployeeMapper mapper;

  public PayrollService(EmployeeFactory factory, EmployeeRepository repository, EmployeeMapper mapper) {
    this.factory = factory;
    this.repository = repository;
    this.mapper = mapper;
  }

  public Employee calculateTotalSalary(EmployeeDTO payload) {
    EmployeeEntity employeeEntity = factory.create(payload);
    employeeEntity.calculateSalary();

    Employee employee = new Employee(
            employeeEntity.getName(),
            employeeEntity.getEmail(),
            employeeEntity.getBasicSalary(),
            employeeEntity.getTotalSalary(),
            employeeEntity.getBonus(),
            employeeEntity.getEntryDate()
    );

    return repository.save(employee);
  }

  public PayrollEntity calculatePayroll(List<EmployeeDTO> payload) {
    List<EmployeeEntity> employeeEntities = payload.stream().map(factory::create).toList();

    float totalSalary = 0;
    float totalBonus = 0;

    for (EmployeeEntity employeeEntity : employeeEntities) {
      totalSalary += employeeEntity.calculateSalary();
      totalBonus += employeeEntity.getBonus();
    }

    return new PayrollEntity(employeeEntities, totalSalary, totalBonus);
  }
}
