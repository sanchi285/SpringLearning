package net.java.guides.departmentservice.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    @Schema(description = "ID of the department")
    private Long id;

    @Schema(description = "Name of the department")
    private String departmentName;

    @Schema(description = "Description of the department")
    private String getDepartmentDescription;

    @Schema(description = "Code of the department")
    private String departmentCode;
}