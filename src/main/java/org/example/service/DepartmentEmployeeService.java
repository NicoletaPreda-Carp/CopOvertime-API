package org.example.service;

import org.example.dto.DepartmentEmployeeDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.exception.notFoundException.DepartmentEmployeeNotFoundException;
import org.example.exception.resorceExists.DepartmentEmployeeExistsException;
import org.example.mapper.DepartmentEmployeeMapper;
import org.example.model.DepartmentEmployee;
import org.example.repository.DepartmentEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentEmployeeService {
    @Autowired
    private DepartmentEmployeeRepository repository;

    @Autowired
    private DepartmentEmployeeMapper mapper;

    public List<DepartmentEmployeeDto> getAll() {
        List<DepartmentEmployee> departmentEmployeeList = repository.findAll();
        List<DepartmentEmployeeDto> result = departmentEmployeeList.stream()
                .map(department -> mapper.modelToDto(department))
                .collect(Collectors.toList());
        return result;
    }

    public DepartmentEmployeeDto getById(Long id) throws CopOvertimeGenericException {
        DepartmentEmployee model = repository.findById(id).orElse(null);
        DepartmentEmployeeDto result;
        if (model != null) {
            result = mapper.modelToDto(model);
        } else throw new DepartmentEmployeeNotFoundException();
        return result;
    }


    public DepartmentEmployeeDto saveOrUpdate(DepartmentEmployeeDto dto) {
        DepartmentEmployee model = mapper.dtoToModel(dto);
        model = repository.save(model);
        return mapper.modelToDto(model);
    }

    public DepartmentEmployeeDto save(DepartmentEmployeeDto dto) throws CopOvertimeGenericException {
        if (dto.getId() != null && repository.existsById(dto.getId())) throw new DepartmentEmployeeExistsException();
        return saveOrUpdate(dto);
    }

    public DepartmentEmployeeDto update(DepartmentEmployeeDto dto) throws CopOvertimeGenericException {
        if (dto.getId() > 0 && !repository.existsById(dto.getId())) throw new DepartmentEmployeeNotFoundException();
        return saveOrUpdate(dto);
    }

    public void delete(Long id) throws CopOvertimeGenericException {
        DepartmentEmployeeDto dto = getById(id);
        repository.delete(mapper.dtoToModel(dto));
    }
}
