package com.example.entjava2me3.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class HibernateUtil {

    private static EntityManager entityManager;

    private final EntityManagerFactory entityManagerFactory;

    private static final HibernateUtil hibernateUtil = new HibernateUtil();

    private HibernateUtil() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jollibee-pos");
    }

    public static HibernateUtil getInstance() {
        return hibernateUtil;
    }

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
}
