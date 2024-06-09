package com.mert.mapper;

import com.mert.dto.request.ProductFeatureSaveRequestDto;
import com.mert.dto.response.ProductFeatureResponseDto;
import com.mert.entity.ProductFeature;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ProductFeatureMapper {
    ProductFeatureMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ProductFeatureMapper.class);

    ProductFeature fromProductFeatureSaveRequestDto(ProductFeatureSaveRequestDto dto);
    ProductFeatureResponseDto toProductFeatureResponseDto(ProductFeature productFeature);
}
