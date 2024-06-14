import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("JavaBar");

        Scanner tecladinho = new Scanner(System.in);
        int opc;
        boolean sair = false;

        // Loop principal do menu
        do {
            System.out.print("----------------------------------------------------------------\n"
                    + "Selecione a opção desejada:\n"
                    + " 1. Clientes\n"
                    + " 2. Fornecedores\n"
                    + " 3. Produtos\n"
                    + " 4. Comandas\n"
                    + " 5. Relatórios\n"
                    + " 0. Sair\n"
                    + "Digite a opção:");
            opc = tecladinho.nextInt();
            tecladinho.nextLine(); // Consome a nova linha restante

            switch (opc) {
                case 1:
                    Cliente novoCliente = Cliente.cadastrarCliente(tecladinho);
                    System.out.println("Cliente cadastrado com sucesso:");
                    System.out.println(novoCliente);
                    break;
                case 2:
                    // incluir método de Fornecedores
                    break;
                case 3:
                    // incluir método de Produtos
                    break;
                case 4:
                    // incluir método de Comandas
                    break;
                case 5:
                    // incluir método de Relatórios
                    break;
                case 0:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (!sair); // O loop continua enquanto o usuário não escolher sair

        tecladinho.close(); // Fechar o Scanner
    }
}
