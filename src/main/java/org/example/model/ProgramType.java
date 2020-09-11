package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity(name ="program_types" )
@Data

public class ProgramType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalTime startsAt;

    private LocalTime endsAt;

    @OneToMany(mappedBy = "programType")
    private List<DepartmentProgram> departmentPrograms;

}
