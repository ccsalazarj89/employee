package com.thales.employee.controllers;


import com.thales.employee.dtos.response.EmployeeDTO;
import com.thales.employee.services.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ApiOperation(
            value = "Get all employees dummy information",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @GetMapping
    public List<EmployeeDTO>  getAllEmployees(){

        return employeeService.findByAll();
    }


    @ApiOperation(
            value = "Get  employee dummy information by id",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @GetMapping(value="{id}")
    public EmployeeDTO  getEmployeeById(@PathVariable int id){

        return employeeService.findById(id).get();
    }


}
