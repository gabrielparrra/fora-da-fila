package model;

public class Cadastro {

    private int id;
    private String email;
    private String nome;
    private String cpf;
    private String password;
    private String tipo;

    public Cadastro(int id, String email, String nome, String cpf, String password, String tipo) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.password = password;
        this.tipo = tipo;
    }

    // Getters e Setters
    public int getId() {
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

    public String getPassword() {
        return password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
