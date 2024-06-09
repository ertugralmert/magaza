package com.mert.service.base;

import com.mert.dto.request.BrandSaveRequestDto;
import com.mert.dto.response.BrandResponseDto;
import com.mert.entity.Brand;
import com.mert.mapper.BrandMapper;
import com.mert.repository.BrandRepository;
import com.mert.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public BrandResponseDto save(BrandSaveRequestDto dto) {
        Brand brand = brandMapper.fromBrandSaveRequestDto(dto);
        return brandMapper.toBrandResponseDto(brandRepository.save(brand));
    }

    @Override
    public BrandResponseDto update(Long id, BrandSaveRequestDto dto) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        brand.setName(dto.getName());
        return brandMapper.toBrandResponseDto(brandRepository.save(brand));
    }

    @Override
    public BrandResponseDto findById(Long id) {
        return brandMapper.toBrandResponseDto(brandRepository.findById(id).orElseThrow());
    }

    @Override
    public List<BrandResponseDto> findAll() {
        return brandRepository.findAll().stream().map(brandMapper::toBrandResponseDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }
}
