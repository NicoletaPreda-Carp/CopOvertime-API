package org.example.service;

import org.example.dto.ValidNumberOfDaysPerOHDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.exception.notFoundException.ValidNumberOfDaysPerOHNotFoundException;
import org.example.exception.resorceExists.ValidNumberOfDaysPerOHExistsException;
import org.example.mapper.ValidNumberOfDaysPerOHMapper;
import org.example.model.ValidNumberOfDaysPerOH;
import org.example.repository.ValidNumberOfDaysPerOHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ValidNumberOfDaysPerOHService {
    @Autowired
    private ValidNumberOfDaysPerOHRepository repository;

    @Autowired
    private ValidNumberOfDaysPerOHMapper mapper;

    public List<ValidNumberOfDaysPerOHDto> getAll() {
        List<ValidNumberOfDaysPerOH> validNumberOfDaysPerOHList = repository.findAll();
        List<ValidNumberOfDaysPerOHDto> result = validNumberOfDaysPerOHList.stream()
                .map(validNumberOfDaysPerOH -> mapper.modelToDto(validNumberOfDaysPerOH))
                .collect(Collectors.toList());
        return result;
    }

    public ValidNumberOfDaysPerOHDto getById(Long id) throws CopOvertimeGenericException {
        ValidNumberOfDaysPerOH model = repository.findById(id).orElse(null);
        ValidNumberOfDaysPerOHDto result;
        if (model != null) {
            result = mapper.modelToDto(model);
        } else throw new ValidNumberOfDaysPerOHNotFoundException();
        return result;
    }


    public ValidNumberOfDaysPerOHDto saveOrUpdate(ValidNumberOfDaysPerOHDto dto) {
        ValidNumberOfDaysPerOH model = mapper.dtoToModel(dto);
        model = repository.save(model);
        return mapper.modelToDto(model);
    }

    public ValidNumberOfDaysPerOHDto save(ValidNumberOfDaysPerOHDto dto) throws CopOvertimeGenericException {
        if (dto.getId() != null && repository.existsById(dto.getId())) throw new ValidNumberOfDaysPerOHExistsException();
        return saveOrUpdate(dto);
    }

    public ValidNumberOfDaysPerOHDto update(ValidNumberOfDaysPerOHDto dto) throws CopOvertimeGenericException {
        if (dto.getId() > 0 && !repository.existsById(dto.getId())) throw new ValidNumberOfDaysPerOHNotFoundException();
        return saveOrUpdate(dto);
    }

    public void delete(Long id) throws CopOvertimeGenericException {
        ValidNumberOfDaysPerOHDto dto = getById(id);
        repository.delete(mapper.dtoToModel(dto));
    }
}
