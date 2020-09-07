package org.example.mapper;

import org.example.dto.LegalDayOffDto;
import org.example.model.LegalDayOff;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LegalDayOffMapper {
    LegalDayOff dtoToModel (LegalDayOffDto dto);
    LegalDayOffDto modelToDto (LegalDayOff model);
}
