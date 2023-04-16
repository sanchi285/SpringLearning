package net.java.guides.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.java.guides.employeeservice.dto.EmployeeDto;
import net.java.guides.employeeservice.entity.Employee;
import net.java.guides.employeeservice.repository.EmployeeRepository;
import net.java.guides.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee savedEmplyee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );

        Employee savedEmployee  = employeeRepository.save(savedEmplyee);
        EmployeeDto employeeDto1 = new EmployeeDto(savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail()
                );
        return employeeDto1;
    }


    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
        return employeeDto;
    }
}
