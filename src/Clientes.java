import java.util.ArrayList;
import java.util.Scanner;

public class Clientes {
    private ArrayList<Cliente> listaDeClientes;

    public Clientes() {
        this.listaDeClientes = new ArrayList<>();
    }

    public Cliente cadastrarCliente(Scanner tecladinho) {
        System.out.print("Digite o nome do cliente: ");
        String nome = tecladinho.nextLine();
        System.out.print("Digite o ID do cliente: ");
        String id = tecladinho.nextLine();

        Cliente cliente = new Cliente(nome, id);
        listaDeClientes.add(cliente);

        return cliente;
    }

    public Cliente buscarCliente(String clienteInput) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getNome().equalsIgnoreCase(clienteInput) || cliente.getId().equalsIgnoreCase(clienteInput)) {
                return cliente;
            }
        }
        return null;
    }
}

class Cliente {
    private String nome;
    private String id;

    public Cliente(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", ID: " + id;
    }
}
