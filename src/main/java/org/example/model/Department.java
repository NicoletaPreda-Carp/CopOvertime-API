package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity (name ="departments")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<DepartmentEmployee> departmentEmployees;

    @OneToMany(mappedBy = "department")
    private List<DepartmentProgram> departmentPrograms;
    
}
