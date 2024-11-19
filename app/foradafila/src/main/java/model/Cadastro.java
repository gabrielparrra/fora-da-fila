package model;

import java.util.Date;

public class Cadastro {

    private String id;
    private String email;
    private String nome;
    private String cpf;
    private Date nascimento; // Mudança para o tipo Date
    private String password;
    private String tipo;

    public Cadastro(String id, String email, String nome, String cpf, Date nascimento, String password, String tipo) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.password = password;
        this.tipo = tipo;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public String getPassword() {
        return password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
