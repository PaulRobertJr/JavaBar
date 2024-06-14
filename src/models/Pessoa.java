package models;

// Uma classe super que é a mesma coisa que a abstrata para usar de extensão para o pacote de modelos

public class Pessoa {
    protected int id;
    protected String nome, cpf;

    public Pessoa(String nome, String cpf, int id) {
        this.nome = nome;
        this.cpf = cpf;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
