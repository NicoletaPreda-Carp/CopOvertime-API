package org.example.mapper;

import org.example.dto.ProgramTypeDto;
import org.example.model.ProgramType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgramTypeMapper {
    ProgramType dtoToModel (ProgramTypeDto dto);
    ProgramTypeDto modelToDto (ProgramType model);
}
