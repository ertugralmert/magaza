package com.mert.dto.response;

import lombok.Data;

@Data
public class ProductFeatureResponseDto {
    private Long id;
    private String category;
    private String featureName;
    private String description;
}
