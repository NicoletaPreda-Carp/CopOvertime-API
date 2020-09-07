package org.example.repository;

import org.example.model.LegalDayOff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalDayOffRepository extends JpaRepository<LegalDayOff, Long> {
}
