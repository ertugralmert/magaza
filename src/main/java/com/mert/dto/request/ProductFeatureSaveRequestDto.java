package com.mert.dto.request;

import lombok.Data;

@Data
public class ProductFeatureSaveRequestDto {
    private String category;
    private String featureName;
    private String description;
    private Long productId; // Bu alan eklendi
}
