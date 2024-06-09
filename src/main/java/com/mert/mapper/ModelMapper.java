package com.mert.mapper;

import com.mert.dto.request.ModelSaveRequestDto;
import com.mert.dto.response.ModelResponseDto;
import com.mert.entity.Model;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    Model fromModelSaveRequestDto(ModelSaveRequestDto dto);
    ModelResponseDto toModelResponseDto(Model model);
}
