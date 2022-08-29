package com.thales.employee.services;

import com.thales.employee.dtos.response.EmployeeDTO;


import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeDTO> findByAll();
    Optional<EmployeeDTO> findById(int id);

}
