package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ValidNumberOfDaysPerOvertimeHour {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private Integer validNumberOfDays;

        @OneToMany(mappedBy = "validNumberOfDaysPerOvertimeHour")
        private List<OvertimeHour> overtimeHours;
}
