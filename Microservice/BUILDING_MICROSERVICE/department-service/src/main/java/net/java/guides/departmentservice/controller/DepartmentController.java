package net.java.guides.departmentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.java.guides.departmentservice.dto.DepartmentDto;
import net.java.guides.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
@Tag(name = "Department API", description = "Endpoints for managing departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    @Operation(summary = "Create a new department", description = "Creates a new department with the provided details")
    @ApiResponse(responseCode = "201", description = "Department created successfully")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{dept-code}")
    @Operation(summary = "Get department by department code", description = "Retrieves the department with the specified department code")
    @ApiResponse(responseCode = "200", description = "Department found")
    @ApiResponse(responseCode = "404", description = "Department not found")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("dept-code") String departmentCode) {
        DepartmentDto department = departmentService.getDepartmentByCode(departmentCode);
        if (department != null) {
            return new ResponseEntity<>(department, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
