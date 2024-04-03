package com.sofka.nomina.model.entities;

import java.util.List;

public class PayrollEntity {
  private List<EmployeeEntity> employeeEntities;
  private float total;
  private float totalBonus;

  public PayrollEntity() {
  }

  public PayrollEntity(List<EmployeeEntity> employeeEntities, float total, float totalBonus) {
    this.employeeEntities = employeeEntities;
    this.total = total;
    this.totalBonus = totalBonus;
  }

  public List<EmployeeEntity> getEmployees() {
    return employeeEntities;
  }

  public void setEmployees(List<EmployeeEntity> employeeEntities) {
    this.employeeEntities = employeeEntities;
  }

  public float getTotal() {
    return total;
  }

  public void setTotal(float total) {
    this.total = total;
  }

  public float getTotalBonus() {
    return totalBonus;
  }

  public void setTotalBonus(float totalBonus) {
    this.totalBonus = totalBonus;
  }
}
