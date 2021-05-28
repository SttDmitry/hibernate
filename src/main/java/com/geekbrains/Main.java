package com.geekbrains;

import com.geekbrains.Daos.JdbcTemplateProductDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Product.class)
//                .buildSessionFactory();
//        Session session;
//        session = factory.getCurrentSession();
//        ProductDAO productDAO = new ProductDAO(session, factory);
//
//        Product product = new Product();
//        product.setId(3L);
//        product.setPrice(15);
//        product.setTitle("mellon2");
//        productDAO.saveOrUpdateProduct(product);
//
//        System.out.println(productDAO.findProductById(4));
//
//        System.out.println(productDAO.getAllProducts());
//
//        productDAO.deleteProductById(4);

        SpringApplication.run(Main.class, args);

    }
}
