package org.example.service;

import org.example.dto.EmployeeOvertimeHourDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.exception.notFoundException.EmployeeOvertimeHourNotFoundException;
import org.example.exception.resorceExists.EmployeeOvertimeHourExistsException;
import org.example.mapper.EmployeeOvertimeHourMapper;
import org.example.model.EmployeeOvertimeHour;
import org.example.repository.EmployeeOvertimeHourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeOvertimeHourService {
    @Autowired
    private EmployeeOvertimeHourRepository repository;

    @Autowired
    private EmployeeOvertimeHourMapper mapper;

    public List<EmployeeOvertimeHourDto> getAll() {
        List<EmployeeOvertimeHour> employeeOvertimeHourList = repository.findAll();
        List<EmployeeOvertimeHourDto> result = employeeOvertimeHourList.stream()
                .map(employeeOvertimeHour -> mapper.modelToDto(employeeOvertimeHour))
                .collect(Collectors.toList());
        return result;
    }

    public EmployeeOvertimeHourDto getById(Long id) throws CopOvertimeGenericException {
        EmployeeOvertimeHour model = repository.findById(id).orElse(null);
        EmployeeOvertimeHourDto result;
        if (model != null) {
            result = mapper.modelToDto(model);
        } else throw new EmployeeOvertimeHourNotFoundException();
        return result;
    }


    public EmployeeOvertimeHourDto saveOrUpdate(EmployeeOvertimeHourDto dto) {
        EmployeeOvertimeHour model = mapper.dtoToModel(dto);
        model = repository.save(model);
        return mapper.modelToDto(model);
    }

    public EmployeeOvertimeHourDto save(EmployeeOvertimeHourDto dto) throws CopOvertimeGenericException {
        if (dto.getId() != null && repository.existsById(dto.getId())) throw new EmployeeOvertimeHourExistsException();
        return saveOrUpdate(dto);
    }

    public EmployeeOvertimeHourDto update(EmployeeOvertimeHourDto dto) throws CopOvertimeGenericException {
        if (dto.getId() > 0 && !repository.existsById(dto.getId())) throw new EmployeeOvertimeHourNotFoundException();
        return saveOrUpdate(dto);
    }

    public void delete(Long id) throws CopOvertimeGenericException {
        EmployeeOvertimeHourDto dto = getById(id);
        repository.delete(mapper.dtoToModel(dto));
    }
}
