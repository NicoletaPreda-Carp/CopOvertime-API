package org.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "department_employees")
@Data
public class DepartmentEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "DEPARTMET_EMPLOYEE_DEPARTMENTS_FK"))
    private Department department;



    @ManyToOne
    @JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "DEPARTMENT_EMPLOYEE_EMPLOYEES_FK"))
    private Employee employee;

}
