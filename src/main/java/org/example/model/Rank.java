package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity (name = "ranks")
@Data
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;
    private LocalDate startedAt;
    private LocalDate endedAt;

    @OneToMany(mappedBy = "rank")
    private List<EmployeeRank> employeeRanks;

}
