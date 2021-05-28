package com.geekbrains.Daos;


import com.geekbrains.Entitys.Product;
import com.geekbrains.Utilities.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component("JdbcTemplate")
public class JdbcTemplateProductDao implements NewProductDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateProductDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> listOfProducts() {
        return jdbcTemplate.queryForObject("SELECT id, title, cost FROM products;", new ProductRowMapper());
    }
}
