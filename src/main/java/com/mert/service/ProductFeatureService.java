package com.mert.service;

import com.mert.dto.request.ProductFeatureSaveRequestDto;
import com.mert.dto.response.ProductFeatureResponseDto;
import com.mert.service.base.BaseService;

public interface ProductFeatureService extends BaseService<ProductFeatureSaveRequestDto, ProductFeatureResponseDto, Long> {
}
