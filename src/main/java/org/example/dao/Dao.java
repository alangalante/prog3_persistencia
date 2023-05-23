package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dao<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> entity;

    static {
        emf = Persistence.createEntityManagerFactory("jpa_exemplo");
    }
    public Dao() {
        em = emf.createEntityManager();
    }
    public Dao<E> create(E entity) {
        abrir();
        em.persist(entity);
        fechar();
        return this;
    }

    public Dao<E> abrir() {
        em.getTransaction().begin();
        return this;
    }

    public Dao<E> fechar() {
        em.getTransaction().commit();
        return this;
    }

}
