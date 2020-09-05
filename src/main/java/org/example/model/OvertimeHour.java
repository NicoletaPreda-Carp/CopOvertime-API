package org.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class OvertimeHour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate performedAt;
    private LocalTime startedAt;
    private LocalTime endedAt;
    private Integer numberOfHours;
    private LocalDate expiresAt;
    private Boolean isWeekend;
    private Boolean enabled;

//    private Long legalDayOffId;
//    private Long validNumberOfDays;
}
