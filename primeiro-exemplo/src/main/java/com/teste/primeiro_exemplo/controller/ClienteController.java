package com.teste.primeiro_exemplo.controller;
//package com.teste2.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.primeiro_exemplo.model.Cliente;
import com.teste.primeiro_exemplo.services.ClienteService;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    // Injeção de Dependência do ClienteService
    @Autowired
    private ClienteService clienteService;

    // Métodos CRUD para Cliente
    @GetMapping
    public List<Cliente> todosClientes() {
        return clienteService.todosClientes();
    }

    // Método para retornar um cliente específico por ID
    @GetMapping("/{id}")
    public Optional<Cliente> clientePorId(@PathVariable int id) {
        return clienteService.clientePorId(id);
    }

    // Métodos para Adicionar, Deletar e Atualizar Cliente

    // Método para Adicionar um novo cliente
    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return clienteService.adicionar(cliente);
    }

    // Método para Deletar um cliente por ID
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id) {
        clienteService.deletar(id);
        return "Cliente: " + id + " deletado com sucesso";
    }

    // Método para Atualizar um cliente existente
    // O ID é passado na URL e os dados atualizados no corpo da requisição
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        return clienteService.atualizar(id, cliente);
    }

    // ========================================================================================================

    // Método para retornar o nome do cliente
    @GetMapping("/nome/{id}")
    public String nomeCliente(@PathVariable int id) {
        Optional<Cliente> cliente = clienteService.clientePorId(id);
        return cliente.map(Cliente::getNome).orElse("Cliente não encontrado");
    }

    // Método para retornar o email do cliente
    @GetMapping("/email/{id}")
    public String emailCliente(@PathVariable int id) {
        Optional<Cliente> cliente = clienteService.clientePorId(id);
        return cliente.map(Cliente::getEmail).orElse("Cliente não encontrado");
    }

    // Método para retornar o telefone do cliente
    @GetMapping("/telefone/{id}")
    public String telefoneCliente(@PathVariable int id) {
        Optional<Cliente> cliente = clienteService.clientePorId(id);
        return cliente.map(Cliente::getTelefone).orElse("Cliente não encontrado");
    }

    // Método para retornar o ID do cliente
    @GetMapping("/id/{id}")
    public int idCliente(@PathVariable int id) {
        Optional<Cliente> cliente = clienteService.clientePorId(id);
        return cliente.map(Cliente::getId).orElse(-1); // Retorna -1 se o cliente não for encontrado
    }

    // ========================================================================================================

    // Método para retornar todos os detalhes do cliente
    @GetMapping("/detalhes/{id}")
    public Cliente detalhesCliente(@PathVariable int id) {
        Optional<Cliente> cliente = clienteService.clientePorId(id);
        return cliente.orElse(null); // Retorna null se o cliente não for encontrado
    }

    // Método para retornar o nome e email do cliente
    @GetMapping("/nome-email/{id}")
    public String nomeEmailCliente(@PathVariable int id) {
        Optional<Cliente> cliente = clienteService.clientePorId(id);
        return cliente.map(c -> "Nome: " + c.getNome() + ", Email: " + c.getEmail())
                .orElse("Cliente não encontrado");
    }

    // Método para retornar o nome e telefone do cliente
    @GetMapping("/nome-telefone/{id}")
    public String nomeTelefoneCliente(@PathVariable int id) {
        Optional<Cliente> cliente = clienteService.clientePorId(id);
        return cliente.map(c -> "Nome: " + c.getNome() + ", Telefone: " + c.getTelefone())
                .orElse("Cliente não encontrado");
    }

    // Método para retornar o email e telefone do cliente
    @GetMapping("/email-telefone/{id}")
    public String emailTelefoneCliente(@PathVariable int id) {
        Optional<Cliente> cliente = clienteService.clientePorId(id);
        return cliente.map(c -> "Email: " + c.getEmail() + ", Telefone: " + c.getTelefone())
                .orElse("Cliente não encontrado");
    }

    // Método para retornar o nome, email e telefone do cliente
    @GetMapping("/nome-email-telefone/{id}")
    public String nomeEmailTelefoneCliente(@PathVariable int id) {
        Optional<Cliente> cliente = clienteService.clientePorId(id);
        return cliente.map(c -> "Nome: " + c.getNome() + ", Email: " + c.getEmail() + ", Telefone: " + c.getTelefone())
                .orElse("Cliente não encontrado");
    }

}
