package org.example.repository;

import org.example.model.OvertimeHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OvertimeHourRepository extends JpaRepository <OvertimeHour, Long> {
}
