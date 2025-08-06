package com.teste.primeiro_exemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.teste.primeiro_exemplo.model.Produto;

@Repository
public class ProdutoRepository {

    // Simulando um banco de dados com uma lista
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoID = 0;

    /**
     * Metodo para Retorna uma lista de produtos.
     * 
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /**
     * Metodo para Retorna um produto encontrado pelo ID.
     * 
     * @param id produto sera localizado
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * Metodo para Adicionar um produto na lista.
     * 
     * @param produto que sera adicionado
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto) {
        ultimoID++;
        produto.setId(ultimoID);
        produtos.add(produto);
        return produto;
    }

    /**
     * Metodo para Deletar um produto por Id.
     * 
     * @param id do produto que sera deletado
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Metodo para Atualizar um produto na lista.
     * 
     * @param produto que sera atualizado
     * @return Retorna o produto que foi atualizado na lista.
     */
    public Produto atualizar(Produto produto) {
        // Eu tenho que remover o produto antigo da lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if (produtoEncontrado.isEmpty()) {
            throw new InputMismatchException("Produto não encontrado!!");
        }

        // Remover o produto dantigo da lista
        deletar(produto.getId());

        // Adicionar o produto atualizado na lista
        produtos.add(produto);

        return produto;
    }

}
