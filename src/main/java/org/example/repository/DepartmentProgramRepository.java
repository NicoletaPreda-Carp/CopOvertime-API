package org.example.repository;

import org.example.model.DepartmentProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentProgramRepository extends JpaRepository<DepartmentProgram, Long> {
}
