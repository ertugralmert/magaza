package com.mert.mapper;

import com.mert.dto.request.ProductSaveRequestDto;
import com.mert.dto.response.ProductResponseDto;
import com.mert.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "brandId", ignore = true)
    @Mapping(target = "modelId", ignore = true)
    Product fromProductSaveRequestDto(ProductSaveRequestDto dto);

    ProductResponseDto toProductResponseDto(Product product);
}
