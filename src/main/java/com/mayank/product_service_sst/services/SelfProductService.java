package com.mayank.product_service_sst.services;

import com.mayank.product_service_sst.exceptions.CategoryNotFoundException;
import com.mayank.product_service_sst.models.Product;
import com.mayank.product_service_sst.repositories.ProductRepository;
import com.mayank.product_service_sst.repositories.CategoryRepository;
import com.mayank.product_service_sst.exceptions.ProductNotFoundException;
import com.mayank.product_service_sst.models.Category;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(id, "Product not found");
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if (category.getId() == null) { // save the category
            product.setCategory(categoryRepository.save(category));
        }

        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

        if (optionalCategory.isEmpty()) {
            //The category that is passed in the input product in invalid.
            throw new CategoryNotFoundException("Invalid category id passed");
        }

        product1.setCategory(optionalCategory.get());
        return product1;
    }
}