package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity (name = "valid_number_of_days_per_overtime_hours")
@Data
public class ValidNumberOfDaysPerOH {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private Integer validNumberOfDays;

        @OneToMany(mappedBy = "validNumberOfDaysPerOvertimeHour")
        private List<OvertimeHour> overtimeHours;
}
