package com.teste.primeiro_exemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.teste.primeiro_exemplo.model.Cliente;

@Repository
public class ClienteRepository {

    // Simulando um banco de dados com um array
    private List<Cliente> clientes = new ArrayList<>();
    private int ultimoId = 0;

    // Método para Retornar uma lista de clientes
    public List<Cliente> todosClientes() {
        return clientes;
    }

    // Método para Retornar um cliente específico por ID
    public Optional<Cliente> clientePorId(int id) {
        return clientes
                .stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst();

    }

    // Método para Adicionar um novo cliente
    public Cliente adicionar(Cliente cliente) {
        ultimoId++;
        cliente.setId(ultimoId);
        clientes.add(cliente);
        return cliente;

    }

    // Metodo para Deletar um cliente por ID
    public void Deletar(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    // Método para Atualizar um cliente existente
    public Cliente atualizar(Cliente cliente) {

        Optional<Cliente> clienteEncontrado = clientePorId(cliente.getId());

        // Removo o Cliente Antigo
        if (!clienteEncontrado.isPresent()) {
            throw new InputMismatchException("Cliente não encontrado");
        }

        // Remover o cliente antigo
        Deletar(cliente.getId());

        // Adicionar o cliente atualizado
        clientes.add(cliente);

        return cliente;

    }

}
