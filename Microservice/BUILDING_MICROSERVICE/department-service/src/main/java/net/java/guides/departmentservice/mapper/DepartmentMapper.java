package net.java.guides.departmentservice.mapper;

import net.java.guides.departmentservice.dto.DepartmentDto;
import net.java.guides.departmentservice.entity.Department;

public class DepartmentMapper {

    public  static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto =  new DepartmentDto(
                department.getId(),
                department.getGetDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getGetDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }
}
