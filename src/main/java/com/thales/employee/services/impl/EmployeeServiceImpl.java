package com.thales.employee.services.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.thales.employee.clients.EmployeeClient;
import com.thales.employee.dtos.response.EmployeeDTO;
import com.thales.employee.model.Employee;
import com.thales.employee.services.EmployeeService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static com.thales.employee.commons.APIEndPoints.DUMMY_RESTAPI_EXAMPLE;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeClient employeeClient;

    @Override
    public List<EmployeeDTO> findByAll() {

        List<Map> result =  employeeClient.getAllEmployees();

        List<EmployeeDTO> employeeDTOList =  result.stream()
                .map(employee-> EmployeeDTO.builder()
                        .id((Integer) employee.get("id"))
                        .employee_name((String) employee.get("employee_name"))
                        .employee_age((Integer) employee.get("employee_age"))
                        .employee_salary((Integer) employee.get("employee_salary"))
                        .employee_annual_salary(this.getAnnualSalary((Integer) employee.get("employee_salary")))
                        .profile_image((String) employee.get("profile_image"))
                        .build())
                .collect(Collectors.toList());

        return employeeDTOList;
    }

    @Override
    public Optional<EmployeeDTO> findById(int id) {

        Map<?,?> result = employeeClient.getEmployeeById(id);

        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .id((Integer) result.get("id"))
                .employee_name((String) result.get("employee_name"))
                .employee_age((Integer) result.get("employee_age"))
                .employee_salary((Integer) result.get("employee_salary"))
                .employee_annual_salary(this.getAnnualSalary((Integer) result.get("employee_salary")))
                .profile_image((String) result.get("profile_image"))
                .build();

        return Optional.of(employeeDTO);

    }

    private int getAnnualSalary(int employee_salary){

        return employee_salary * 12;
    }



}
