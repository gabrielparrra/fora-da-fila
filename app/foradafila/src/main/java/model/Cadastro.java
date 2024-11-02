package model;

import java.util.Date;

import static java.lang.Integer.parseInt;

public class Cadastro {


    private String Id;
    private String email;
    private String nome;
    private String cpf;
    private Date nascimento;
    private String password;
    private String tipo;

    public Cadastro( String Id,String email, String nome, String cpf, Date nascimento, String password, String tipo) {
        this.Id = Id;
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.password = password;
        this.tipo = tipo;
    }


    public String getEmail() {
        return email;
    }


    public String getNome() {
        return nome;
    }

    public String getNascimento() {
        return String.valueOf((java.sql.Date) nascimento);
    }


    public String getCpf() {
        return cpf;
    }


    public String getPassword() {
        return password;
    }


    public String getTipo() {
        return tipo;
    }

    public String getId() {
        return (Id);
    }
}
