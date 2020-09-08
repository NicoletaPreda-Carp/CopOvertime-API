package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

    @OneToMany(mappedBy = "overtimeHour")
    private List<EmployeeOvertimeHour> employeeOvertimeHours;


    @ManyToOne
    @JoinColumn(name = "legal_day_off_id", foreignKey = @ForeignKey(name = "LEGAL_DOFF_OVERTIMEHOURS_FK"))
    private LegalDayOff legalDayOff;


    @ManyToOne
    @JoinColumn(name = "valid_number_of_days_id", foreignKey = @ForeignKey(name = "VNODPOTH_OVERTIMEHOURS_FK"))
    private ValidNumberOfDaysPerOH validNumberOfDaysPerOvertimeHour;
}
