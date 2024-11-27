package model;

public class Evento {
    private int id;
    private String evento;
    private String data;
    private String local;
    private String assento;
    private String valor;

    // Construtor completo
    public Evento(int id, String evento, String data, String local, String assento, String valor) {
        this.id = id;
        this.evento = evento;
        this.data = data;
        this.local = local;
        this.assento = assento;
        this.valor = valor;
    }

    // Construtor sem ID (para criação)
    public Evento(String evento, String data, String local, String assento, String valor) {
        this.evento = evento;
        this.data = data;
        this.local = local;
        this.assento = assento;
        this.valor = valor;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
