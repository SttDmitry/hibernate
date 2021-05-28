package com.geekbrains.Services;

import com.geekbrains.Daos.ProductRepository;
import com.geekbrains.Entitys.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProductsWithMaxPrice(){
        return productRepository.findProductWithMaxPrice();
    }

    public List<Product> findProductsWithMinPrice() {
        return productRepository.findProductWithMinPrice();
    }

    public List<Product> getProductsWithMinAndMaxPrice(){
        List<Product> products = new ArrayList<>();
        products.addAll(findProductsWithMaxPrice());
        products.addAll(findProductsWithMinPrice());
        return products;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public ProductsService() {
    }
}
