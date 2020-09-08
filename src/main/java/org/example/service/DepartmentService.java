package org.example.service;

import org.example.dto.DepartmentDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.exception.notFoundException.DepartmentNotFoundException;
import org.example.exception.resorceExists.DepartmentExistsException;
import org.example.mapper.DepartmentMapper;
import org.example.model.Department;
import org.example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private DepartmentMapper mapper;

    public List<DepartmentDto> getAll() {
        List<Department> departmentList = repository.findAll();
        List<DepartmentDto> result = departmentList.stream()
                .map(department -> mapper.modelToDto(department))
                .collect(Collectors.toList());
        return result;
    }

    public DepartmentDto getById(Long id) throws CopOvertimeGenericException {
        Department model = repository.findById(id).orElse(null);
        DepartmentDto result;
        if (model != null) {
            result = mapper.modelToDto(model);
        } else throw new DepartmentNotFoundException();
        return result;
    }


    public DepartmentDto saveOrUpdate(DepartmentDto dto) {
        Department model = mapper.dtoToModel(dto);
        model = repository.save(model);
        return mapper.modelToDto(model);
    }

        public DepartmentDto save(DepartmentDto dto) throws CopOvertimeGenericException {
        if (dto.getId() != null && repository.existsById(dto.getId())) throw new DepartmentExistsException();
        return saveOrUpdate(dto);
    }

    public DepartmentDto update(DepartmentDto dto) throws CopOvertimeGenericException {
        if (dto.getId() > 0 && !repository.existsById(dto.getId())) throw new DepartmentNotFoundException();
        return saveOrUpdate(dto);
    }

        public void delete(Long id) throws CopOvertimeGenericException {
            DepartmentDto dto = getById(id);
        repository.delete(mapper.dtoToModel(dto));
    }

}

