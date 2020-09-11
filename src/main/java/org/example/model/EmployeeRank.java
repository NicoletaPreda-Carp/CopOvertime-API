package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "employee_ranks")
@Data
public class EmployeeRank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "EMPLOYEE_RANK_EMPLOYEES_FK"))
    private Employee employee;



    @ManyToOne
    @JoinColumn(name = "rank_id", foreignKey = @ForeignKey(name = "EMPLOYEE_RANK_RANKS_FK"))
    private Rank rank;

    private LocalDate startedAt;
    private LocalDate endedAt;

}
