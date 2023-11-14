package com.example.entjava2me3.dao;

import com.example.entjava2me3.connection.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.*;
import com.example.entjava2me3.models.Order;

import java.util.List;

public class OrderDao {
    private final EntityManager entityManager;

    public OrderDao() {
        entityManager = HibernateUtil.getInstance().getEntityManager();
    }

    public List<Order> getAllOrders(boolean isPending) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
        Root<Order> root = criteriaQuery.from(Order.class);

        CriteriaQuery<Order> select = criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("isPending"), isPending));

        return entityManager.createQuery(select).getResultList();
    }

    public Order serveOrder(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Order order = entityManager.find(Order.class, id);
        order.setPending(false);
        transaction.commit();
        return order;
    }

    public Order getOrder(int id) {
        return entityManager.find(Order.class, id);
    }

    public Order addOrder(String name, String item, int quantity, double price) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Order order = new Order(name, item, quantity, price);
        entityManager.persist(order);
        transaction.commit();
        return order;
    }
}
