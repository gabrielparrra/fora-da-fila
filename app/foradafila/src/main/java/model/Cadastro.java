package model;

public class Cadastro {

    private String email;
    private String nome;
    private String cpf;
    private String nascimento;
    private String password;
    private String tipo;

    public Cadastro(String email, String nome, String cpf, String nascimento, String password, String tipo){
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
        return nascimento;
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

}
