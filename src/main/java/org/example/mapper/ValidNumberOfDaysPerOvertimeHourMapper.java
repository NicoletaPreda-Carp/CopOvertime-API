package org.example.mapper;

import org.example.dto.ValidNumberOfDaysPerOvertimeHourDto;
import org.example.model.ValidNumberOfDaysPerOvertimeHour;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ValidNumberOfDaysPerOvertimeHourMapper {
    ValidNumberOfDaysPerOvertimeHour dtoToModel (ValidNumberOfDaysPerOvertimeHourDto dto);
    ValidNumberOfDaysPerOvertimeHourDto modelToDto (ValidNumberOfDaysPerOvertimeHour model);
}
