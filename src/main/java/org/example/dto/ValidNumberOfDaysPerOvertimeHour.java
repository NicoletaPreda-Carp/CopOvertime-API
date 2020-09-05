package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidNumberOfDaysPerOvertimeHour {

    private Long id;
    private Integer validNumberOfDays;
}
