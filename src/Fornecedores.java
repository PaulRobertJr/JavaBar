import java.util.ArrayList;

public class Fornecedores {
    private ArrayList<Fornecedor> listaDeFornecedores;

    public Fornecedores() {
        this.listaDeFornecedores = new ArrayList<>();
    }

    public void cadastrarFornecedor(String nome, String contato) {
        Fornecedor fornecedor = new Fornecedor(nome, contato);
        listaDeFornecedores.add(fornecedor);
        System.out.println("Fornecedor cadastrado com sucesso.");
    }

    public void listarFornecedores() {
        if (listaDeFornecedores.isEmpty()) {
            System.out.println("Nenhum fornecedor cadastrado.");
        } else {
            System.out.println("Fornecedores cadastrados:");
            for (Fornecedor fornecedor : listaDeFornecedores) {
                System.out.println(fornecedor);
            }
        }
    }

    public void removerFornecedor(String nome) {
        Fornecedor fornecedorARemover = null;
        for (Fornecedor fornecedor : listaDeFornecedores) {
            if (fornecedor.getNome().equalsIgnoreCase(nome)) {
                fornecedorARemover = fornecedor;
                break;
            }
        }

        if (fornecedorARemover != null) {
            listaDeFornecedores.remove(fornecedorARemover);
            System.out.println("Fornecedor removido com sucesso.");
        } else {
            System.out.println("Fornecedor não encontrado.");
        }
    }
}

class Fornecedor {
    private String nome;
    private String contato;

    public Fornecedor(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Contato: " + contato;
    }
}
