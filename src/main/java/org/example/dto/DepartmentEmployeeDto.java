package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEmployeeDto {

    private Long id;
    private Long departmentId;
    private Long employeeId;
}
