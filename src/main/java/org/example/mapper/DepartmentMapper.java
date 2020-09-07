package org.example.mapper;

import org.example.dto.DepartmentDto;
import org.example.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department dtoToModel (DepartmentDto dto);
    DepartmentDto modelToDto (Department model);
}

