package net.java.guides.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.java.guides.departmentservice.dto.DepartmentDto;
import net.java.guides.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;
    //build Save departmentRestApi
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{dept-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("dept-code") String departmentCode){
        DepartmentDto getdepartment = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(getdepartment,HttpStatus.OK);
    }

}
