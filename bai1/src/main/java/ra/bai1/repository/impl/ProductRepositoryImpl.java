package konta.bai1.repository.impl;

import konta.bai1.model.entity.Product;
import konta.bai1.repository.ProductRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    //hibernate
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.openSession();
        try {
            List list = session.createQuery("from Product").list();
            return list;
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean save(Product product) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public Product findById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Product.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Product product) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }
}
