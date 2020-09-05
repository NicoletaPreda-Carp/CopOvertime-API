package org.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;
    private LocalDate startedAt;
    private LocalDate endedAt;
}
