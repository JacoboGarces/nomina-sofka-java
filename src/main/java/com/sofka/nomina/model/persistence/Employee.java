package com.sofka.nomina.model.persistence;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private float basicSalary;
  private float totalSalary;
  private float bonus;
  private LocalDate entryDate;

  public Employee(String name, String email, float basicSalary, float totalSalary, float bonus, LocalDate entryDate) {
    this.name = name;
    this.email = email;
    this.basicSalary = basicSalary;
    this.totalSalary = totalSalary;
    this.bonus = bonus;
    this.entryDate = entryDate;
  }

  public Employee(Long id, String name, String email, float basicSalary, float totalSalary, float bonus, LocalDate entryDate) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.basicSalary = basicSalary;
    this.totalSalary = totalSalary;
    this.bonus = bonus;
    this.entryDate = entryDate;
  }

  public Employee() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return Float.compare(basicSalary, employee.basicSalary) == 0 && Float.compare(totalSalary, employee.totalSalary) == 0 && Float.compare(bonus, employee.bonus) == 0 && Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(email, employee.email) && Objects.equals(entryDate, employee.entryDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, basicSalary, totalSalary, bonus, entryDate);
  }
}
