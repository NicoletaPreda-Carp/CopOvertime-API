package org.example.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramTypeDto {

    private Long id;
    private String name;
    private LocalTime startsAt;
    private LocalTime endsAt;

}
