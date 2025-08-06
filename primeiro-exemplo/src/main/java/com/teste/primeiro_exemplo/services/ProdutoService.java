package com.teste.primeiro_exemplo.services;

//import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Metodo para Retorna uma lista de produtos.
     * 
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos() {
        return produtoRepository.obterTodos();
    }

    /**
     * Metodo para Retorna um produto encontrado pelo ID.
     * 
     * @param id produto sera localizado
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtoRepository.obterPorId(id);
    }

    /**
     * Metodo para Adicionar um produto na lista.
     * 
     * @param produto que sera adicionado
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto) {
        // Poderia ter alguma regra de negocio
        return produtoRepository.adicionar(produto);

    }

    /**
     * Metodo para Deletar um produto por Id.
     * 
     * @param id do produto que sera deletado
     */
    public void deletar(Integer id) {
        produtoRepository.deletar(id);
    }

    /**
     * Metodo para Atualizar um produto na lista.
     * 
     * @param produto que sera atualizado
     * @param id      do produto que sera atualizado
     * @return Retorna o produto que foi atualizado na lista.
     */
    public Produto atualizar(Integer id, Produto produto) {
        // Ter uma validação no ID
        produto.setId(id);

        return produtoRepository.atualizar(produto);

    }

}
