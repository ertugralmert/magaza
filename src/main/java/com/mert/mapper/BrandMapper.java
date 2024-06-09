package com.mert.mapper;

import com.mert.dto.request.BrandSaveRequestDto;
import com.mert.dto.response.BrandResponseDto;
import com.mert.entity.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface BrandMapper {
    BrandMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(BrandMapper.class);

    Brand fromBrandSaveRequestDto(BrandSaveRequestDto dto);
    BrandResponseDto toBrandResponseDto(Brand brand);
}
