package net.java.guides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.java.guides.departmentservice.dto.DepartmentDto;
import net.java.guides.departmentservice.entity.Department;
import net.java.guides.departmentservice.mapper.DepartmentMapper;
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
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department saveDepartment =   departmentRepository.save(department);
        DepartmentDto departmentDto1 = DepartmentMapper.mapToDepartmentDto(saveDepartment);
        return departmentDto1;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
        return departmentDto;
    }
}
