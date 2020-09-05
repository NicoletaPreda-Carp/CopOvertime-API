package org.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class EmployeeOvertimeHour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //    private Long overtimeHourId;
//    private Long employeeId;

}
