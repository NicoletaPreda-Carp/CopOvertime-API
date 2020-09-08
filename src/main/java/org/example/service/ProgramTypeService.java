package org.example.service;

import org.example.dto.ProgramTypeDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.exception.notFoundException.ProgramTypeNotFoundException;
import org.example.exception.resorceExists.ProgramTypeExistsException;
import org.example.mapper.ProgramTypeMapper;
import org.example.model.ProgramType;
import org.example.repository.ProgramTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProgramTypeService {
    @Autowired
    private ProgramTypeRepository repository;

    @Autowired
    private ProgramTypeMapper mapper;

    public List<ProgramTypeDto> getAll() {
        List<ProgramType> programTypeList = repository.findAll();
        List<ProgramTypeDto> result = programTypeList.stream()
                .map(programType -> mapper.modelToDto(programType))
                .collect(Collectors.toList());
        return result;
    }

    public ProgramTypeDto getById(Long id) throws CopOvertimeGenericException {
        ProgramType model = repository.findById(id).orElse(null);
        ProgramTypeDto result;
        if (model != null) {
            result = mapper.modelToDto(model);
        } else throw new ProgramTypeNotFoundException();
        return result;
    }


    public ProgramTypeDto saveOrUpdate(ProgramTypeDto dto) {
        ProgramType model = mapper.dtoToModel(dto);
        model = repository.save(model);
        return mapper.modelToDto(model);
    }

    public ProgramTypeDto save(ProgramTypeDto dto) throws CopOvertimeGenericException {
        if (dto.getId() != null && repository.existsById(dto.getId())) throw new ProgramTypeExistsException();
        return saveOrUpdate(dto);
    }

    public ProgramTypeDto update(ProgramTypeDto dto) throws CopOvertimeGenericException {
        if (dto.getId() > 0 && !repository.existsById(dto.getId())) throw new ProgramTypeNotFoundException();
        return saveOrUpdate(dto);
    }

    public void delete(Long id) throws CopOvertimeGenericException {
        ProgramTypeDto dto = getById(id);
        repository.delete(mapper.dtoToModel(dto));
    }
}
