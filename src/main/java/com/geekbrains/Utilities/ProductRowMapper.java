package com.geekbrains.Utilities;

import com.geekbrains.Entitys.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRowMapper implements RowMapper<List<Product>> {
    @Override
    public List<Product> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (resultSet.next())
        {
            products.add(new Product(resultSet.getLong("id"), resultSet.getString("title"), resultSet.getInt("cost")));
        }
        return products;
    }
}
