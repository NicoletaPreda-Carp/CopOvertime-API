package org.example.mapper;

import org.example.dto.ValidNumberOfDaysPerOHDto;
import org.example.model.ValidNumberOfDaysPerOH;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ValidNumberOfDaysPerOHMapper {
    ValidNumberOfDaysPerOH dtoToModel (ValidNumberOfDaysPerOHDto dto);
    ValidNumberOfDaysPerOHDto modelToDto (ValidNumberOfDaysPerOH model);
}
