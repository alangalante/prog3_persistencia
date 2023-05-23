package org.example;

import org.example.dao.Dao;
import org.example.dao.DaoCliente;
import org.example.entities.Cliente;
import org.example.entities.Funcionario;
import org.example.entities.Setor;
import org.example.entities.Telefone;

import java.util.List;

public class Main {
    public static void main(String[] args) {
            criarFuncionario();
    }

    public static void deletarCliente() {
        Dao<Cliente> daoCliente = new Dao<>(Cliente.class);
        daoCliente.delete(1);


    }

    public static void alterarCliente() {
        Dao<Cliente> daoCliente = new Dao<>(Cliente.class);
        Cliente c = daoCliente.findById(2);
        c.setNome("Nome Alterado");
        daoCliente.update(c);

    }
    public static void criarCliente() {
        Dao<Cliente> daoCliente = new Dao<>(Cliente.class);

        for (int i=0;i<10;i++) {
            Cliente cliente = new Cliente();
            cliente.setNome(String.format("Nome %d", i));
            cliente.setEndereco(String.format("Rua %d", i));
            cliente.setCpf(String.valueOf(i));

            for (int j=0;j<i;j++) {
                cliente.addTelefone(new Telefone("22", String.format("%d%d%d%d",j,j,j,j)));
            }
            daoCliente.create(cliente);

        }


    }
    public static void criarFuncionario() {
        Dao<Funcionario> daoFuncionario = new Dao<>(Funcionario.class);

        for (int i=0;i<10;i++) {
            Funcionario func = new Funcionario();
            func.setNome(String.format("Nome %d", i));
            func.setMatricula(String.valueOf(i));

            for (int j=0;j<i;j++) {
                func.addSetor(new Setor(String.format("%d%d%d%d",j,j,j,j)));
            }
            daoFuncionario.create(func);

        }


    }

    public static void imprimirClientes() {
        Dao<Cliente> daoCliente = new Dao<>(Cliente.class);
        List<Cliente> clientes = daoCliente.findAll();

        for (Cliente c: clientes) {
            System.out.println(c);
        }
    }

    public static void buscarPorNome() {
        DaoCliente daoCliente = new DaoCliente();
        List<Cliente> clientes = daoCliente.findByName("Nome Alterado");

        for (Cliente c: clientes) {
            System.out.println(c);
        }
    }
}