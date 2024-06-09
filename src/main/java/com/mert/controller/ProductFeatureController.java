package com.mert.controller;

import com.mert.controller.base.BaseController;
import com.mert.dto.request.ProductFeatureSaveRequestDto;
import com.mert.dto.response.ProductFeatureResponseDto;
import com.mert.service.ProductFeatureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.mert.config.RestApis.*;

import java.util.List;

@RestController
@RequestMapping(PRODUCT_FEATURE)
@RequiredArgsConstructor
public class ProductFeatureController implements BaseController<ProductFeatureSaveRequestDto, ProductFeatureResponseDto, Long> {
    private final ProductFeatureService productFeatureService;

    @PostMapping(SAVE)
    @Override
    public ResponseEntity<ProductFeatureResponseDto> save(@Valid @RequestBody ProductFeatureSaveRequestDto dto) {
        ProductFeatureResponseDto createdProductFeature = productFeatureService.save(dto);
        return new ResponseEntity<>(createdProductFeature, HttpStatus.CREATED);
    }

    @PutMapping(UPDATE)
    @Override
    public ResponseEntity<ProductFeatureResponseDto> update(@PathVariable Long id, @Valid @RequestBody ProductFeatureSaveRequestDto dto) {
        ProductFeatureResponseDto updatedProductFeature = productFeatureService.update(id, dto);
        return ResponseEntity.ok(updatedProductFeature);
    }

    @GetMapping(GET_BY_ID)
    @Override
    public ResponseEntity<ProductFeatureResponseDto> findById(@PathVariable Long id) {
        ProductFeatureResponseDto productFeature = productFeatureService.findById(id);
        return ResponseEntity.ok(productFeature);
    }

    @GetMapping(GET_ALL)
    @Override
    public ResponseEntity<List<ProductFeatureResponseDto>> findAll() {
        List<ProductFeatureResponseDto> productFeatures = productFeatureService.findAll();
        return ResponseEntity.ok(productFeatures);
    }

    @DeleteMapping(DELETE)
    @Override
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productFeatureService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
