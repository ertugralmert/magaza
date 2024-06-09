package com.mert.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class ProductSaveRequestDto {
    private String name;
    private String description;
    private Double price;
    private String mainImageUrl;
    private List<String> otherImageUrls;
    private String brandName;  // Brand bilgisi
    private String modelName;  // Model bilgisi
}
