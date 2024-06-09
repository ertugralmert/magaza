package com.mert.service.base;

import com.mert.dto.request.ProductFeatureSaveRequestDto;
import com.mert.dto.response.ProductFeatureResponseDto;
import com.mert.entity.ProductFeature;
import com.mert.mapper.ProductFeatureMapper;
import com.mert.repository.ProductFeatureRepository;
import com.mert.service.ProductFeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductFeatureServiceImpl implements ProductFeatureService {
    private final ProductFeatureRepository productFeatureRepository;
    private final ProductFeatureMapper productFeatureMapper;

    @Override
    public ProductFeatureResponseDto save(ProductFeatureSaveRequestDto dto) {
        ProductFeature productFeature = productFeatureMapper.fromProductFeatureSaveRequestDto(dto);
        return productFeatureMapper.toProductFeatureResponseDto(productFeatureRepository.save(productFeature));
    }

    @Override
    public ProductFeatureResponseDto update(Long id, ProductFeatureSaveRequestDto dto) {
        ProductFeature productFeature = productFeatureRepository.findById(id).orElseThrow();
        productFeature.setCategory(dto.getCategory());
        productFeature.setFeatureName(dto.getFeatureName());
        productFeature.setDescription(dto.getDescription());
        return productFeatureMapper.toProductFeatureResponseDto(productFeatureRepository.save(productFeature));
    }

    @Override
    public ProductFeatureResponseDto findById(Long id) {
        return productFeatureMapper.toProductFeatureResponseDto(productFeatureRepository.findById(id).orElseThrow());
    }

    @Override
    public List<ProductFeatureResponseDto> findAll() {
        return productFeatureRepository.findAll().stream().map(productFeatureMapper::toProductFeatureResponseDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        productFeatureRepository.deleteById(id);
    }
}
