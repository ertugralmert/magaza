package com.mert.mapper;

import com.mert.dto.request.BrandSaveRequestDto;
import com.mert.dto.response.BrandResponseDto;
import com.mert.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    Brand fromBrandSaveRequestDto(BrandSaveRequestDto dto);
    BrandResponseDto toBrandResponseDto(Brand brand);
}
