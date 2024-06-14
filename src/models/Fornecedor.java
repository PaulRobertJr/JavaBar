package models;

public class Fornecedor extends Pessoa { // fornecedor com a extensão de pessoa
    private String empresa, contato;

    public Fornecedor(String nome, String cpf, int id, String empresa, String contato) {
        super(nome, cpf, id);
        this.empresa = empresa;
        this.contato = contato;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

}
