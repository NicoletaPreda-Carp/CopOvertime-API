package org.example.service;

import org.example.dto.OvertimeHourDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.exception.notFoundException.OvertimeHourNotFoundException;
import org.example.exception.resorceExists.OvertimeHourExistsException;
import org.example.mapper.OvertimeHourMapper;
import org.example.model.OvertimeHour;
import org.example.repository.OvertimeHourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OvertimeHourService {
    @Autowired
    private OvertimeHourRepository repository;

    @Autowired
    private OvertimeHourMapper mapper;

    public List<OvertimeHourDto> getAll() {
        List<OvertimeHour> overtimeHourList = repository.findAll();
        List<OvertimeHourDto> result = overtimeHourList.stream()
                .map(overtimeHour -> mapper.modelToDto(overtimeHour))
                .collect(Collectors.toList());
        return result;
    }

    public OvertimeHourDto getById(Long id) throws CopOvertimeGenericException {
        OvertimeHour model = repository.findById(id).orElse(null);
        OvertimeHourDto result;
        if (model != null) {
            result = mapper.modelToDto(model);
        } else throw new OvertimeHourNotFoundException();
        return result;
    }


    public OvertimeHourDto saveOrUpdate(OvertimeHourDto dto) {
        OvertimeHour model = mapper.dtoToModel(dto);
        model = repository.save(model);
        return mapper.modelToDto(model);
    }

    public OvertimeHourDto save(OvertimeHourDto dto) throws CopOvertimeGenericException {
        if (dto.getId() != null && repository.existsById(dto.getId())) throw new OvertimeHourExistsException();
        return saveOrUpdate(dto);
    }

    public OvertimeHourDto update(OvertimeHourDto dto) throws CopOvertimeGenericException {
        if (dto.getId() > 0 && !repository.existsById(dto.getId())) throw new OvertimeHourNotFoundException();
        return saveOrUpdate(dto);
    }

    public void delete(Long id) throws CopOvertimeGenericException {
        OvertimeHourDto dto = getById(id);
        repository.delete(mapper.dtoToModel(dto));
    }
}
