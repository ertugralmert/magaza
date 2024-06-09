package com.mert.service.base;

import com.mert.dto.request.ProductSaveRequestDto;
import com.mert.dto.response.ProductResponseDto;
import com.mert.entity.Brand;
import com.mert.entity.Model;
import com.mert.entity.Product;
import com.mert.exception.ErrorType;
import com.mert.exception.ProductManagementException;
import com.mert.mapper.ProductMapper;
import com.mert.repository.BrandRepository;
import com.mert.repository.ModelRepository;
import com.mert.repository.ProductRepository;
import com.mert.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mert.exception.ErrorType.BAD_REQUEST_ERROR;
import static com.mert.exception.ErrorType.DATA_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDto save(ProductSaveRequestDto dto) {
        if (productRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new ProductManagementException(ErrorType.CONFLICT_ERROR);
        }

        Brand brand = brandRepository.findByNameIgnoreCase(dto.getBrandName())
                .orElseThrow(() -> new ProductManagementException(BAD_REQUEST_ERROR));
        Model model = modelRepository.findByNameIgnoreCase(dto.getModelName())
                .orElseThrow(() -> new ProductManagementException(BAD_REQUEST_ERROR));

        Product product = productMapper.fromProductSaveRequestDto(dto);
        product.setBrand(brand);
        product.setModel(model);

        return productMapper.toProductResponseDto(productRepository.save(product));
    }

    @Override
    public ProductResponseDto update(Long id, ProductSaveRequestDto dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductManagementException(DATA_NOT_FOUND));

        Brand brand = brandRepository.findByNameIgnoreCase(dto.getBrandName())
                .orElseThrow(() -> new ProductManagementException(BAD_REQUEST_ERROR));
        Model model = modelRepository.findByNameIgnoreCase(dto.getModelName())
                .orElseThrow(() -> new ProductManagementException(BAD_REQUEST_ERROR));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setMainImageUrl(dto.getMainImageUrl());
        product.setOtherImageUrls(dto.getOtherImageUrls());
        product.setBrand(brand);
        product.setModel(model);

        return productMapper.toProductResponseDto(productRepository.save(product));
    }

    @Override
    public ProductResponseDto findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductManagementException(DATA_NOT_FOUND));
        return productMapper.toProductResponseDto(product);
    }

    @Override
    public List<ProductResponseDto> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new ProductManagementException(DATA_NOT_FOUND));
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponseDto> findByFeature(String featureName, String category) {
        return productRepository.findByFeature(featureName, category).stream()
                .map(productMapper::toProductResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDto> findByCategory(String category) {
        return productRepository.findByCategory(category).stream()
                .map(productMapper::toProductResponseDto)
                .collect(Collectors.toList());
    }
}
