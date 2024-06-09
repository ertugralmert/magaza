package com.mert.repository;

import com.mert.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long> {
    Optional<Model> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
}
