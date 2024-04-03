package com.sofka.nomina.repositories;

import com.sofka.nomina.model.persistence.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
