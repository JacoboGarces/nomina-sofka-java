package com.sofka.nomina.model.DTOS;

import com.sofka.nomina.model.EmployeeType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EmployeeDTO {
  @NotNull
  @NotBlank
  private String name;
  @NotNull
  @NotBlank
  @Email
  private String email;
  @NotNull
  private EmployeeType type;
  @NotNull
  @DecimalMin(value = "0", inclusive = false)
  private float basicSalary;
  @NotNull
  private LocalDate entryDate;

  public EmployeeDTO() {
  }

  public EmployeeDTO(String name, String email, EmployeeType type, float basicSalary, LocalDate entryDate) {
    this.name = name;
    this.email = email;
    this.type = type;
    this.basicSalary = basicSalary;
    this.entryDate = entryDate;
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

  public LocalDate getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(LocalDate entryDate) {
    this.entryDate = entryDate;
  }

  public EmployeeType getType() {
    return type;
  }

  public void setType(EmployeeType type) {
    this.type = type;
  }
}
