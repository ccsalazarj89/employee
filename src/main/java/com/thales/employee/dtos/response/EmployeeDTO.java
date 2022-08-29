package com.thales.employee.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private int id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;
    private String profile_image;
    private int employee_annual_salary;
}
