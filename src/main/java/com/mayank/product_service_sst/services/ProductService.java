package com.mayank.product_service_sst.services;

import com.mayank.product_service_sst.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);
}
