package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRankDto {

    private Long id;
    private Long employeeId;
    private Long rankId;
    private LocalDate startedAt;
    private LocalDate endedAt;

}
