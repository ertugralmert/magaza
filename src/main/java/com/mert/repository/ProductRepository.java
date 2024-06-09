package com.mert.repository;

import com.mert.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p JOIN p.features pf WHERE pf.featureName = :featureName AND pf.category = :category")
    List<Product> findByFeature(@Param("featureName") String featureName, @Param("category") String category);
}
