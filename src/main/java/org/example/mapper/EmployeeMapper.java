package org.example.mapper;

import org.example.dto.EmployeeDto;
import org.example.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee dtoToModel (EmployeeDto dto);
    EmployeeDto modelToDto (Employee model);
}
