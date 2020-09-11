package org.example.service;

import org.example.dto.EmployeeDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.exception.notFoundException.EmployeeNotFoundException;
import org.example.exception.resorceExists.EmployeeExistsException;
import org.example.mapper.EmployeeMapper;
import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeMapper mapper;

    public List<EmployeeDto> getAll() {
        List<Employee> employeeList = repository.findAll();
        List<EmployeeDto> result = employeeList.stream()
                .map(employee -> mapper.modelToDto(employee))
                .collect(Collectors.toList());
        return result;
    }

    public EmployeeDto getById(Long id) throws CopOvertimeGenericException {
        Employee model = repository.findById(id).orElse(null);
        EmployeeDto result;
        if (model != null) {
            result = mapper.modelToDto(model);
        } else throw new EmployeeNotFoundException();
        return result;
    }


    public EmployeeDto saveOrUpdate(EmployeeDto dto) {
        Employee model = mapper.dtoToModel(dto);
        model = repository.save(model);
        return mapper.modelToDto(model);
    }

    public EmployeeDto save(EmployeeDto dto) throws CopOvertimeGenericException {
        if (dto.getId() != null && repository.existsById(dto.getId())) throw new EmployeeExistsException();
        return saveOrUpdate(dto);
    }

    public EmployeeDto update(EmployeeDto dto) throws CopOvertimeGenericException {
        if (dto.getId() > 0 && !repository.existsById(dto.getId())) throw new EmployeeNotFoundException();
        return saveOrUpdate(dto);
    }

    public void delete(Long id) throws CopOvertimeGenericException {
        EmployeeDto dto = getById(id);
        repository.delete(mapper.dtoToModel(dto));
    }
}
