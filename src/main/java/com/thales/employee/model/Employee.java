package com.thales.employee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int id;
    private String employeeName;
    private double employeeSalary;
    private int employeeAge;
    private String profileImage;

}
