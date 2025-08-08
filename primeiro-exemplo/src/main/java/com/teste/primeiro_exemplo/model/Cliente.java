package com.teste.primeiro_exemplo.model;

public class Cliente {

    // #region Attributes
    private int id;
    private String nome;
    private String email;
    private String telefone;
    // #endregion

    // #region Constructors
    // Construtor padrão

    public Cliente() {
    }

    // Construtor com parâmetros
    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // construtor completo, útil pra testes
    public Cliente(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // #endregion

    // #region Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // #endregion

}
