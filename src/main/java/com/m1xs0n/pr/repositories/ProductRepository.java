package com.m1xs0n.pr.repositories;

import com.m1xs0n.pr.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Specification<Product> spec, Pageable pageable);

    Page<Product> findAll(Pageable pageable);

    List<Product> findAllByCategoryId(Long categoryId);

    // Додайте необхідні методи, якщо потрібно
}
