import java.util.ArrayList;
import java.util.Scanner;

public class Comandas {
    private ArrayList<Comanda> listaDeComandas;

    public Comandas() {
        this.listaDeComandas = new ArrayList<>();
    }

    public void abrirComanda(Scanner tecladinho, Clientes clientes) {
        System.out.print("Digite o nome ou ID do cliente: ");
        String clienteInput = tecladinho.nextLine();
        Cliente cliente = clientes.buscarCliente(clienteInput);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Comanda comanda = new Comanda(cliente);
        listaDeComandas.add(comanda);

        System.out.println("Comanda aberta com sucesso para o cliente:");
        System.out.println(cliente);
    }

    public void adicionarProduto(Scanner tecladinho, Produtos produtos) {
        if (listaDeComandas.isEmpty()) {
            System.out.println("Nenhuma comanda aberta.");
            return;
        }

        Comanda comanda = listaDeComandas.get(listaDeComandas.size() - 1);

        System.out.print("Digite o nome ou código do produto: ");
        String produtoInput = tecladinho.nextLine();
        Produto produto = produtos.buscarProduto(produtoInput);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.print("Digite a quantidade do produto: ");
        int quantidade = tecladinho.nextInt();
        tecladinho.nextLine(); // Limpa o buffer do teclado

        comanda.adicionarProduto(produto, quantidade);

        System.out.println("Produto adicionado à comanda com sucesso.");
    }

    public void fecharComanda(Scanner tecladinho) {
        if (listaDeComandas.isEmpty()) {
            System.out.println("Nenhuma comanda aberta.");
            return;
        }

        Comanda comanda = listaDeComandas.remove(listaDeComandas.size() - 1);
        double total = comanda.calcularTotal();

        System.out.println("Comanda fechada com sucesso.");
        System.out.println("Cliente: " + comanda.getCliente());
        System.out.println("Total gasto: R$ " + total);
    }
}

class Comanda {
    private Cliente cliente;
    private ArrayList<ItemComanda> itens;

    public Comanda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        itens.add(new ItemComanda(produto, quantidade));
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemComanda item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }
}

class ItemComanda {
    private Produto produto;
    private int quantidade;

    public ItemComanda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
