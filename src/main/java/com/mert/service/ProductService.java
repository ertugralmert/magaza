package com.mert.service;

import com.mert.dto.request.ProductSaveRequestDto;
import com.mert.dto.response.ProductResponseDto;
import com.mert.service.base.BaseService;

import java.util.List;

public interface ProductService extends BaseService<ProductSaveRequestDto, ProductResponseDto, Long> {
    List<ProductResponseDto> findByFeature(String featureName, String category);
}
