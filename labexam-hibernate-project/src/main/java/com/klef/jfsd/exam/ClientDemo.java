package com.klef.jfsd.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(new Customer("John", "john@example.com", 30, "New York"));
            session.save(new Customer("Jane", "jane@example.com", 25, "Los Angeles"));
            transaction.commit();

            Criteria criteria = session.createCriteria(Customer.class);
            criteria.add(Restrictions.eq("location", "New York"));
            List<Customer> customers = criteria.list();
            System.out.println(customers);

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}