package net.java.guides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.java.guides.departmentservice.dto.DepartmentDto;
import net.java.guides.departmentservice.entity.Department;
import net.java.guides.departmentservice.repository.DepartmentRepository;
import net.java.guides.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert dto to entity
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getGetDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

        Department saveDepartment =   departmentRepository.save(department);

        DepartmentDto departmentDto1 = new DepartmentDto(
                saveDepartment.getId(),
                saveDepartment.getGetDepartmentName(),
                saveDepartment.getGetDepartmentName(),
                saveDepartment.getDepartmentCode()
        );

        return departmentDto1;
    }
}
