package org.example.service;

import org.example.dto.LegalDayOffDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.exception.notFoundException.LegalDayOffNotFoundException;
import org.example.exception.resorceExists.LegalDayOffExistsException;
import org.example.mapper.LegalDayOffMapper;
import org.example.model.LegalDayOff;
import org.example.repository.LegalDayOffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LegalDayOffService {
    @Autowired
    private LegalDayOffRepository repository;

    @Autowired
    private LegalDayOffMapper mapper;

    public List<LegalDayOffDto> getAll() {
        List<LegalDayOff> legalDayOffList = repository.findAll();
        List<LegalDayOffDto> result = legalDayOffList.stream()
                .map(legalDayOff -> mapper.modelToDto(legalDayOff))
                .collect(Collectors.toList());
        return result;
    }

    public LegalDayOffDto getById(Long id) throws CopOvertimeGenericException {
        LegalDayOff model = repository.findById(id).orElse(null);
        LegalDayOffDto result;
        if (model != null) {
            result = mapper.modelToDto(model);
        } else throw new LegalDayOffNotFoundException();
        return result;
    }


    public LegalDayOffDto saveOrUpdate(LegalDayOffDto dto) {
        LegalDayOff model = mapper.dtoToModel(dto);
        model = repository.save(model);
        return mapper.modelToDto(model);
    }

    public LegalDayOffDto save(LegalDayOffDto dto) throws CopOvertimeGenericException {
        if (dto.getId() != null && repository.existsById(dto.getId())) throw new LegalDayOffExistsException();
        return saveOrUpdate(dto);
    }

    public LegalDayOffDto update(LegalDayOffDto dto) throws CopOvertimeGenericException {
        if (dto.getId() > 0 && !repository.existsById(dto.getId())) throw new LegalDayOffNotFoundException();
        return saveOrUpdate(dto);
    }

    public void delete(Long id) throws CopOvertimeGenericException {
        LegalDayOffDto dto = getById(id);
        repository.delete(mapper.dtoToModel(dto));
    }
}
