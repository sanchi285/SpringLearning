package net.java.guides.employeeservice.mapper;

import net.java.guides.employeeservice.dto.EmployeeDto;
import net.java.guides.employeeservice.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto maptoEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        return employeeDto;
    }

    public  static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee =  new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
                return  employee;
    }


}
