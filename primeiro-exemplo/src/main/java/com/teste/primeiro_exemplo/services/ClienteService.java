package com.teste.primeiro_exemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiro_exemplo.model.Cliente;
import com.teste.primeiro_exemplo.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para Retornar uma lista de clientes
    public List<Cliente> todosClientes() {
        return clienteRepository.todosClientes();
    }

    // Método para Retornar um cliente específico por ID
    public Optional<Cliente> clientePorId(int id) {
        return clienteRepository.clientePorId(id);
    }

    // Método para Adicionar um novo cliente
    public Cliente adicionar(Cliente cliente) {
        return clienteRepository.adicionar(cliente);
    }

    // Método para Deletar um cliente por ID
    public void deletar(int id) {
        clienteRepository.Deletar(id);
    }

    // Método para Atualizar um cliente existente
    public Cliente atualizar(int id, Cliente cliente) {

        cliente.setId(id);
        return clienteRepository.atualizar(cliente);
    }

}
