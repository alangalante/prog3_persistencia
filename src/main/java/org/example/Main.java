package org.example;

import org.example.dao.Dao;
import org.example.entities.Cliente;
import org.example.entities.Telefone;

public class Main {
    public static void main(String[] args) {
/*        Cliente cliente = new Cliente();
        cliente.setEndereco("Rua A");
        cliente.setNome("Joao");
        cliente.setTelefone("123456789");

        new Dao<Cliente>().create(cliente);*/
        Telefone telefone = new Telefone();
        telefone.setDdd("22");
        telefone.setNumero("6666666");
        new Dao<Telefone>().create(telefone);
    }
}