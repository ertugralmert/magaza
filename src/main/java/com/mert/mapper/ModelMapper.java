package com.mert.mapper;

import com.mert.dto.request.ModelSaveRequestDto;
import com.mert.dto.response.ModelResponseDto;
import com.mert.entity.Model;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ModelMapper {

    ModelMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ModelMapper.class);

    Model fromModelSaveRequestDto(ModelSaveRequestDto dto);
    ModelResponseDto toModelResponseDto(Model model);
}
