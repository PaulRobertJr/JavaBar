package models;

public class Cliente extends Pessoa { // cliente com a extensão de pessoa
    private String email, dataNascimento, telefone;

    public Cliente(String nome, String cpf, int id, String email, String dataNascimento, String telefone) {
        super(nome, cpf, id);
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
