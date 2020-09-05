package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;

    @OneToMany(mappedBy = "employee")
    private List<DepartmentEmployee> departmentEmployees;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeOvertimeHour> employeeOvertimeHours;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeRank> employeeRanks;

}
