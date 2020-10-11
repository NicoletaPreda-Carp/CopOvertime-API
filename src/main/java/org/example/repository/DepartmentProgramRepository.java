package org.example.repository;

import org.example.model.DepartmentProgram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentProgramRepository extends JpaRepository<DepartmentProgram, Long> {
    List<DepartmentProgram> findByDepartment_Id(Long id);
}
