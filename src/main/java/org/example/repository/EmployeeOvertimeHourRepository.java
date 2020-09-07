package org.example.repository;

import org.example.model.EmployeeOvertimeHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeOvertimeHourRepository extends JpaRepository<EmployeeOvertimeHour, Long> {
}
