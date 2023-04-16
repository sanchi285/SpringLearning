package net.java.guides.employeeservice.service;

import net.java.guides.employeeservice.dto.EmployeeDto;
import net.java.guides.employeeservice.repository.EmployeeRepository;

public interface EmployeeService {
    EmployeeDto saveEmployee (EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
}
