package com.m1xs0n.pr.services;

import com.m1xs0n.pr.entities.Product;
import com.m1xs0n.pr.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByCategoryId(Long categoryId) {
        return null;
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

    public Page<Product> getFilteredProducts(Specification<Product> spec, Pageable pageable) {
        return productRepository.findAll(spec, pageable);
    }

    public Page<Product> getSortedProductsByCategory(Specification<Product> categoryId, Pageable pageable) {
        Specification<Product> spec = Specification.where((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("category").get("id"), categoryId));
        return productRepository.findAll(spec, pageable);
    }

    // Додайте інші методи, якщо потрібно
}
