package org.example.mapper;

import org.example.dto.DepartmentProgramDto;
import org.example.model.DepartmentProgram;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DepartmentProgramMapper {
    @Mappings({
            @Mapping(source = "departmentId", target = "department.id"),
            @Mapping(source = "programTypeId", target = "programType.id"),
    })
    DepartmentProgram dtoToModel (DepartmentProgramDto dto);

    @Mappings({
            @Mapping(source = "department.id", target = "departmentId"),
            @Mapping(source = "programType.id", target = "programTypeId"),
    })
    DepartmentProgramDto modelToDto (DepartmentProgram model);
}
