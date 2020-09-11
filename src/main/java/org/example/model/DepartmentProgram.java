package org.example.model;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "department_programs")
@Data
public class DepartmentProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "DEPARTMET_EMPLOYEE_DEPARTMENTS_FK"))
    private Department department;


    @ManyToOne
    @JoinColumn(name = "program_type_id", foreignKey = @ForeignKey(name = "DEPARTMENT_PROGRAM_PROGRAM_TYPES_FK"))
    private ProgramType programType;

}
