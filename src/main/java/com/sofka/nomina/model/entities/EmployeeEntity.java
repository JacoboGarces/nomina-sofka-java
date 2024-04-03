package com.sofka.nomina.model.entities;

import java.time.LocalDate;

public abstract class EmployeeEntity {
  protected String name;
  protected String email;
  protected float basicSalary;
  protected float totalSalary;
  protected float bonus;
  protected LocalDate entryDate;
  protected final int DAYS_TO_START_HOURS_WORKED = 1;

  public EmployeeEntity() {
  }

  public EmployeeEntity(String name, String email, float basicSalary, LocalDate entryDate) {
    this.name = name;
    this.email = email;
    this.basicSalary = basicSalary;
    this.entryDate = entryDate;
  }

  public abstract float calculateSalary();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public float getBasicSalary() {
    return basicSalary;
  }

  public void setBasicSalary(float basicSalary) {
    this.basicSalary = basicSalary;
  }

  public float getTotalSalary() {
    return totalSalary;
  }

  public void setTotalSalary(float totalSalary) {
    this.totalSalary = totalSalary;
  }

  public float getBonus() {
    return bonus;
  }

  public void setBonus(float bonus) {
    this.bonus = bonus;
  }

  public LocalDate getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(LocalDate entryDate) {
    this.entryDate = entryDate;
  }
}
