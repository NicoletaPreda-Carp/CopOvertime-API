package org.example.mapper;

import org.example.dto.DepartmentEmployeeDto;
import org.example.model.DepartmentEmployee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DepartmentEmployeeMapper {

    @Mappings({
            @Mapping(source = "departmentId", target = "department.id"),
            @Mapping(source = "employeeId", target = "employee.id"),
    })
    DepartmentEmployee dtoToModel (DepartmentEmployeeDto dto);

    @Mappings({
            @Mapping(source = "department.id", target = "departmentId"),
            @Mapping(source = "employee.id", target = "employeeId"),
    })
    DepartmentEmployeeDto modelToDto (DepartmentEmployee model);
}
