package org.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity (name = "employee_overtime_hours")
@Data
public class EmployeeOvertimeHour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "overtime_hour_id", foreignKey = @ForeignKey(name = "EMPLOYEE_OT_HOURS_OVERTIME_HOUR_FK"))
    private OvertimeHour overtimeHour;


    @ManyToOne
    @JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "EMPLOYEE_OT_HOURS_EMPLOYEE_FK"))
    private Employee employee;

}
