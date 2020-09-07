package org.example.mapper;

import org.example.dto.RankDto;
import org.example.model.Rank;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RankMapper {
    Rank dtoToModel (RankDto dto);
    RankDto modelToDto (Rank model);
}
