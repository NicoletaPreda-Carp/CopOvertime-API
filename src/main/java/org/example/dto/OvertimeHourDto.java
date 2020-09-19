package org.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OvertimeHourDto {
    private Long id;


    private LocalDate performedAt;
    private LocalTime startedAt;
    private LocalTime endedAt;
    private Integer numberOfHours;
    private LocalDate expiresAt;
    private Boolean isWeekend;
    private Boolean enabled;
    private Long legalDaysOffId;
    private Long validNumberOfDaysId;
}
