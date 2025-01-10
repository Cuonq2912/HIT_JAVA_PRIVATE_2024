package com.mycompany.swingmaven.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static EntityManagerFactory entityManagerFactory;
    public static EntityManager getEntityManager() {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("application-unit");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entityManagerFactory.createEntityManager();
    }
}
