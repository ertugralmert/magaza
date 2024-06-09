package com.mert.controller;

import com.mert.controller.base.BaseController;
import com.mert.dto.request.BrandSaveRequestDto;
import com.mert.dto.response.BrandResponseDto;
import com.mert.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mert.config.RestApis.*;


import java.util.List;

@RestController
@RequestMapping(BRAND)
@RequiredArgsConstructor
public class BrandController implements BaseController<BrandSaveRequestDto, BrandResponseDto, Long> {
    private final BrandService brandService;

    @PostMapping(SAVE)
    @Override
    public ResponseEntity<BrandResponseDto> save(@Valid @RequestBody BrandSaveRequestDto dto) {
        BrandResponseDto createdBrand = brandService.save(dto);
        return new ResponseEntity<>(createdBrand, HttpStatus.CREATED);
    }

    @PutMapping(UPDATE)
    @Override
    public ResponseEntity<BrandResponseDto> update(@PathVariable Long id, @Valid @RequestBody BrandSaveRequestDto dto) {
        BrandResponseDto updatedBrand = brandService.update(id, dto);
        return ResponseEntity.ok(updatedBrand);
    }

    @GetMapping(GET_BY_ID)
    @Override
    public ResponseEntity<BrandResponseDto> findById(@PathVariable Long id) {
        BrandResponseDto brand = brandService.findById(id);
        return ResponseEntity.ok(brand);
    }

    @GetMapping(GET_ALL)
    @Override
    public ResponseEntity<List<BrandResponseDto>> findAll() {
        List<BrandResponseDto> brands = brandService.findAll();
        return ResponseEntity.ok(brands);
    }

    @DeleteMapping(DELETE)
    @Override
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        brandService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
