package models;

public class Fornecedor {
    private String nome;
    private String contato;

    public Fornecedor(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Fornecedor [nome=" + nome + ", contato=" + contato + "]";
    }

}
