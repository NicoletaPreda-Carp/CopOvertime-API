package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentProgramDto {

    private Long id;
    private Long departmentId;
    private Long programTypeId;
}
