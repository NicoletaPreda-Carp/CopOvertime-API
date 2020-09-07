package org.example.mapper;

import org.example.dto.EmployeeRankDto;
import org.example.model.EmployeeRank;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EmployeeRankMapper {
    @Mappings({
            @Mapping(source = "employeeId", target = "employee.id"),
            @Mapping(source = "rankId", target = "rank.id"),
    })
    EmployeeRank dtoToModel (EmployeeRankDto dto);

    @Mappings({
            @Mapping(source = "employee.id", target = "employeeId"),
            @Mapping(source = "rank.id", target = "rankId"),
    })
    EmployeeRankDto modelToDto (EmployeeRank model);
}
