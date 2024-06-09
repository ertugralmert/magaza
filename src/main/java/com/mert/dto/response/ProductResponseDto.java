package com.mert.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String mainImageUrl;
    private List<String> otherImageUrls;
    private Long brandId;
    private Long modelId;
}
