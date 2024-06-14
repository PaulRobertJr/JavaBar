import java.util.ArrayList;
import java.util.Scanner;

public class Produtos {
    private ArrayList<Produto> listaDeProdutos;

    public Produtos() {
        this.listaDeProdutos = new ArrayList<>();
    }

    public void cadastrarProduto(Scanner tecladinho) {
        System.out.print("Digite o nome do produto: ");
        String nome = tecladinho.nextLine();
        System.out.print("Digite o preço de venda do produto: ");
        double preco = tecladinho.nextDouble();
        tecladinho.nextLine(); // Limpa o buffer do teclado
        System.out.print("Digite a categoria do produto: ");
        String categoria = tecladinho.nextLine();

        Produto produto = new Produto(nome, preco, categoria);
        listaDeProdutos.add(produto);

        System.out.println("Produto cadastrado com sucesso:");
        System.out.println(produto);
    }

    public void listarProdutos() {
        if (listaDeProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Produtos cadastrados:");
            for (Produto produto : listaDeProdutos) {
                System.out.println(produto);
            }
        }
    }

    public Produto buscarProduto(String produtoInput) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getNome().equalsIgnoreCase(produtoInput)) {
                return produto;
            }
        }
        return null;
    }
}

class Produto {
    private String nome;
    private double preco;
    private String categoria;

    public Produto(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Preço: " + preco + ", Categoria: " + categoria;
    }
}
