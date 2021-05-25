package com.geekbrains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        Session session;
        session = factory.getCurrentSession();
        ProductDAO productDAO = new ProductDAO(session, factory);

        Product product = new Product();
        product.setId(3);
        product.setPrice(15);
        product.setTitle("mellon2");
        productDAO.saveOrUpdateProduct(product);

        System.out.println(productDAO.findProductById(4));

        System.out.println(productDAO.getAllProducts());

        productDAO.deleteProductById(4);
    }
}
