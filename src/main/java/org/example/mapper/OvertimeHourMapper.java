package org.example.mapper;

import org.example.dto.OvertimeHourDto;
import org.example.model.OvertimeHour;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OvertimeHourMapper {
    @Mappings({
            @Mapping(source = "legalDayOffId", target = "legalDayOff.id"),
            @Mapping(source = "validNumberOfDaysPerOvertimeHourId", target = "validNumberOfDaysPerOvertimeHour.id"),
    })
    OvertimeHour dtoToModel (OvertimeHourDto dto);

    @Mappings({
            @Mapping(source = "legalDayOff.id", target = "legalDayOffId"),
            @Mapping(source = "validNumberOfDaysPerOvertimeHour.id", target = "validNumberOfDaysPerOvertimeHourId"),
    })
    OvertimeHourDto modelToDto (OvertimeHour model);
}
