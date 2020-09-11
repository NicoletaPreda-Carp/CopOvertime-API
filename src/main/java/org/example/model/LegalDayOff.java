package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity (name = "legal_days_off")
@Data
public class LegalDayOff {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private LocalDate dayOff;

        @OneToMany(mappedBy = "legalDayOff")
        private List<OvertimeHour> overtimeHours;
}
