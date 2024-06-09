package com.mert.controller;

import com.mert.controller.base.BaseController;
import com.mert.dto.request.ProductSaveRequestDto;
import com.mert.dto.response.ProductResponseDto;
import com.mert.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mert.config.RestApis.*;

@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController implements BaseController<ProductSaveRequestDto, ProductResponseDto, Long> {
    private final ProductService productService;

    @PostMapping(SAVE)
    @Override
    public ResponseEntity<ProductResponseDto> save(@Valid @RequestBody ProductSaveRequestDto dto) {
        ProductResponseDto createdProduct = productService.save(dto);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping(UPDATE)
    @Override
    public ResponseEntity<ProductResponseDto> update(@PathVariable Long id, @Valid @RequestBody ProductSaveRequestDto dto) {
        ProductResponseDto updatedProduct = productService.update(id, dto);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping(GET_BY_ID)
    @Override
    public ResponseEntity<ProductResponseDto> findById(@PathVariable Long id) {
        ProductResponseDto product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping(GET_ALL)
    @Override
    public ResponseEntity<List<ProductResponseDto>> findAll() {
        List<ProductResponseDto> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping(DELETE)
    @Override
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(FILTER)
    public ResponseEntity<List<ProductResponseDto>> findByFeature(@RequestParam String featureName, @RequestParam String category) {
        List<ProductResponseDto> products = productService.findByFeature(featureName, category);
        return ResponseEntity.ok(products);
    }
}
