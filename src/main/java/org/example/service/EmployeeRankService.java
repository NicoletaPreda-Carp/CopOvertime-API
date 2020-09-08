package org.example.service;

import org.example.dto.EmployeeRankDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.exception.notFoundException.EmployeeRankNotFoundException;
import org.example.exception.resorceExists.EmployeeRankExistsException;
import org.example.mapper.EmployeeRankMapper;
import org.example.model.EmployeeRank;
import org.example.repository.EmployeeRankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeRankService {
    @Autowired
    private EmployeeRankRepository repository;

    @Autowired
    private EmployeeRankMapper mapper;

    public List<EmployeeRankDto> getAll() {
        List<EmployeeRank> employeeRankList = repository.findAll();
        List<EmployeeRankDto> result = employeeRankList.stream()
                .map(employeeRank -> mapper.modelToDto(employeeRank))
                .collect(Collectors.toList());
        return result;
    }

    public EmployeeRankDto getById(Long id) throws CopOvertimeGenericException {
        EmployeeRank model = repository.findById(id).orElse(null);
        EmployeeRankDto result;
        if (model != null) {
            result = mapper.modelToDto(model);
        } else throw new EmployeeRankNotFoundException();
        return result;
    }


    public EmployeeRankDto saveOrUpdate(EmployeeRankDto dto) {
        EmployeeRank model = mapper.dtoToModel(dto);
        model = repository.save(model);
        return mapper.modelToDto(model);
    }

    public EmployeeRankDto save(EmployeeRankDto dto) throws CopOvertimeGenericException {
        if (dto.getId() != null && repository.existsById(dto.getId())) throw new EmployeeRankExistsException();
        return saveOrUpdate(dto);
    }

    public EmployeeRankDto update(EmployeeRankDto dto) throws CopOvertimeGenericException {
        if (dto.getId() > 0 && !repository.existsById(dto.getId())) throw new EmployeeRankNotFoundException();
        return saveOrUpdate(dto);
    }

    public void delete(Long id) throws CopOvertimeGenericException {
        EmployeeRankDto dto = getById(id);
        repository.delete(mapper.dtoToModel(dto));
    }
}
