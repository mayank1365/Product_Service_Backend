package com.mayank.product_service_sst;

import com.mayank.product_service_sst.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceSstApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceSstApplication.class, args);
		Product product = new Product();
	}

}
