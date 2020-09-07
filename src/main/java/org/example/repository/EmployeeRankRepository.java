package org.example.repository;

import org.example.model.EmployeeRank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRankRepository extends JpaRepository<EmployeeRank, Long> {
}
