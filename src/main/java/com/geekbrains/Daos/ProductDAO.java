package com.geekbrains.Daos;

import com.geekbrains.Entitys.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductDAO {
    private Session session;
    private final SessionFactory factory;

    public ProductDAO(Session session, SessionFactory factory) {
        this.session = session;
        this.factory = factory;
    }

    public List<Product> getAllProducts() {
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product").getResultList();
        session.getTransaction().commit();
        return products;
    }

    public Product findProductById(long id) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    public void deleteProductById(long id) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
    }

    public void saveOrUpdateProduct(Product product) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        Product productDuplicate = session.get(Product.class, product.getId());
        if (productDuplicate == null) {
            session.save(product);
        } else {
            productDuplicate.setTitle(product.getTitle());
            productDuplicate.setPrice(product.getPrice());
        }
        session.getTransaction().commit();
    }
}
