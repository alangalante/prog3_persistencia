package org.example.dao;

import jakarta.persistence.Query;
import org.example.entities.Cliente;

import java.util.List;

public class DaoCliente extends Dao<Cliente>{

    public DaoCliente(Class<Cliente> entity) {
        super(entity);
    }
    public DaoCliente() {
        super(Cliente.class);
    }
    public List<Cliente> findByName(String nome) {
        Query q = em.createQuery("select c from Cliente c where c.nome = '" + nome + "'");
        return q.getResultList();
    }
}
