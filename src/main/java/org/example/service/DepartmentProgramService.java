package org.example.service;

import org.example.dto.DepartmentProgramDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.exception.notFoundException.DepartmentProgramNotFoundException;
import org.example.exception.resorceExists.DepartmentProgramExistsException;
import org.example.mapper.DepartmentProgramMapper;
import org.example.model.DepartmentProgram;
import org.example.repository.DepartmentProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentProgramService {
    @Autowired
    private DepartmentProgramRepository repository;

    @Autowired
    private DepartmentProgramMapper mapper;

    public List<DepartmentProgramDto> getAll() {
        List<DepartmentProgram> departmentProgramList = repository.findAll();
        List<DepartmentProgramDto> result = departmentProgramList.stream()
                .map(departmentProgram -> mapper.modelToDto(departmentProgram))
                .collect(Collectors.toList());
        return result;
    }

    public DepartmentProgramDto getById(Long id) throws CopOvertimeGenericException {
        DepartmentProgram model = repository.findById(id).orElse(null);
        DepartmentProgramDto result;
        if (model != null) {
            result = mapper.modelToDto(model);
        } else throw new DepartmentProgramNotFoundException();
        return result;
    }


    public DepartmentProgramDto saveOrUpdate(DepartmentProgramDto dto) {
        DepartmentProgram model = mapper.dtoToModel(dto);
        model = repository.save(model);
        return mapper.modelToDto(model);
    }

    public DepartmentProgramDto save(DepartmentProgramDto dto) throws CopOvertimeGenericException {
        if (dto.getId() != null && repository.existsById(dto.getId())) throw new DepartmentProgramExistsException();
        return saveOrUpdate(dto);
    }

    public DepartmentProgramDto update(DepartmentProgramDto dto) throws CopOvertimeGenericException {
        if (dto.getId() > 0 && !repository.existsById(dto.getId())) throw new DepartmentProgramNotFoundException();
        return saveOrUpdate(dto);
    }

    public void delete(Long id) throws CopOvertimeGenericException {
        DepartmentProgramDto dto = getById(id);
        repository.delete(mapper.dtoToModel(dto));
    }
}
