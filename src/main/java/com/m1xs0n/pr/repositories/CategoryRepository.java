package com.m1xs0n.pr.repositories;

import com.m1xs0n.pr.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Додайте необхідні методи, якщо потрібно
}

