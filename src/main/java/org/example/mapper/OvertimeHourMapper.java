package org.example.mapper;

import org.example.dto.OvertimeHourDto;
import org.example.model.OvertimeHour;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OvertimeHourMapper {
    @Mappings({
            @Mapping(source = "legalDaysOffId", target = "legalDayOff.id"),
            @Mapping(source = "validNumberOfDaysId", target = "validNumberOfDaysPerOvertimeHour.id"),
    })
    OvertimeHour dtoToModel (OvertimeHourDto dto);

    @Mappings({
            @Mapping(source = "legalDayOff.id", target = "legalDaysOffId"),
            @Mapping(source = "validNumberOfDaysPerOvertimeHour.id", target = "validNumberOfDaysId"),
    })
    OvertimeHourDto modelToDto (OvertimeHour model);
}
