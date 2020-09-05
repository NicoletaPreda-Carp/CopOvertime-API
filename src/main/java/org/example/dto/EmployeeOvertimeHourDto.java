package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeOvertimeHourDto {
    private Long id;

    private Long overtimeHourId;
    private Long employeeId;

}
