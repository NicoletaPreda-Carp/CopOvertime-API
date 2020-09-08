package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidNumberOfDaysPerOHDto {

    private Long id;
    private Integer validNumberOfDays;

}
