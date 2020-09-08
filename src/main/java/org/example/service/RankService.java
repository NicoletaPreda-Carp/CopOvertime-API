package org.example.service;

import org.example.dto.RankDto;
import org.example.exception.CopOvertimeGenericException;
import org.example.exception.notFoundException.RankNotFoundException;
import org.example.exception.resorceExists.RankExistsException;
import org.example.mapper.RankMapper;
import org.example.model.Rank;
import org.example.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RankService {
    @Autowired
    private RankRepository repository;

    @Autowired
    private RankMapper mapper;

    public List<RankDto> getAll() {
        List<Rank> rankList = repository.findAll();
        List<RankDto> result = rankList.stream()
                .map(rank -> mapper.modelToDto(rank))
                .collect(Collectors.toList());
        return result;
    }

    public RankDto getById(Long id) throws CopOvertimeGenericException {
        Rank model = repository.findById(id).orElse(null);
        RankDto result;
        if (model != null) {
            result = mapper.modelToDto(model);
        } else throw new RankNotFoundException();
        return result;
    }


    public RankDto saveOrUpdate(RankDto dto) {
        Rank model = mapper.dtoToModel(dto);
        model = repository.save(model);
        return mapper.modelToDto(model);
    }

    public RankDto save(RankDto dto) throws CopOvertimeGenericException {
        if (dto.getId() != null && repository.existsById(dto.getId())) throw new RankExistsException();
        return saveOrUpdate(dto);
    }

    public RankDto update(RankDto dto) throws CopOvertimeGenericException {
        if (dto.getId() > 0 && !repository.existsById(dto.getId())) throw new RankNotFoundException();
        return saveOrUpdate(dto);
    }

    public void delete(Long id) throws CopOvertimeGenericException {
        RankDto dto = getById(id);
        repository.delete(mapper.dtoToModel(dto));
    }
}
