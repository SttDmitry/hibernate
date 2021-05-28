package com.geekbrains.Daos;

import com.geekbrains.Entitys.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    List<Product> findAll();

    @Query(value ="select id, title, price from products where price IN (SELECT MAX(price) FROM products)", nativeQuery = true)
    List<Product> findProductWithMaxPrice();

    @Query(value ="select id, title, price from products where price IN (SELECT MIN(price) FROM products)", nativeQuery = true)
    List<Product> findProductWithMinPrice();
}
