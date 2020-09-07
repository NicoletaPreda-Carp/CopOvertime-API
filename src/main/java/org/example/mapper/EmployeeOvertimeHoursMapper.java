package org.example.mapper;

import org.example.dto.EmployeeOvertimeHourDto;
import org.example.model.EmployeeOvertimeHour;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EmployeeOvertimeHoursMapper {
    @Mappings({
            @Mapping(source = "overtimeHourId", target = "overtimeHour.id"),
            @Mapping(source = "employeeId", target = "employee.id"),
    })
    EmployeeOvertimeHour dtoToModel (EmployeeOvertimeHourDto dto);

    @Mappings({
            @Mapping(source = "overtimeHour.id", target = "overtimeHourId"),
            @Mapping(source = "employee.id", target = "employeeId"),
    })
    EmployeeOvertimeHourDto modelToDto (EmployeeOvertimeHour model);
}
