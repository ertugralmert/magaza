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

    @Mapping(target = "brand", ignore = true) // Brand nesnesi DTO'dan doğrudan alınmaz, service katmanında set edilir
    @Mapping(target = "model", ignore = true) // Model nesnesi DTO'dan doğrudan alınmaz, service katmanında set edilir
    Product fromProductSaveRequestDto(ProductSaveRequestDto dto);

    @Mapping(target = "brandName", source = "brand.name")
    @Mapping(target = "modelName", source = "model.name")
    ProductResponseDto toProductResponseDto(Product product);
}
