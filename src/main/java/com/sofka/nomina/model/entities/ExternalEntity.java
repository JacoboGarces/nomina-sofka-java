package com.sofka.nomina.model.entities;

import java.time.LocalDate;

public class ExternalEntity extends EmployeeEntity {
  public ExternalEntity() {
  }

  public ExternalEntity(String name, String email, float basicSalary, LocalDate entryDate) {
    super(name, email, basicSalary, entryDate);
  }

  @Override
  public float calculateSalary() {
    final float INCREMENT_PERCENTAGE = 50;
    final float HOURS_WORKED = 8;
    totalSalary = basicSalary * (1 + INCREMENT_PERCENTAGE / 100);
    LocalDate today = LocalDate.now();
    float totalDays = today.toEpochDay() - entryDate.toEpochDay() - DAYS_TO_START_HOURS_WORKED;
    float totalHours = totalDays * HOURS_WORKED;

    if (totalHours < 8760) {
      bonus = 100000;
    } else {
      bonus = 1200000;
    }

    totalSalary += bonus;
    return totalSalary;
  }
}
