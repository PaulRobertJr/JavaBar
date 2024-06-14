import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("JavaBar");

        Scanner tecladinho = new Scanner(System.in);
        int opc;
        boolean sair = false;

        Fornecedores fornecedores = new Fornecedores();
        Produtos produtos = new Produtos();
        Clientes clientes = new Clientes();
        Comandas comandas = new Comandas();

        // Loop principal do menu
        do {
            System.out.print("----------------------------------------------------------------\n"
                    + "Selecione a opção desejada:\n"
                    + " 1. Clientes\n"
                    + " 2. Fornecedores\n"
                    + " 3. Produtos\n"
                    + " 4. Comandas\n"
                    + " 5. (vago para o card)\n"
                    + " 0. Sair\n"
                    + "Digite a opção:");
            opc = tecladinho.nextInt();
            tecladinho.nextLine(); // Limpa o buffer do teclado

            switch (opc) {
                case 1:
                    Cliente novoCliente = clientes.cadastrarCliente(tecladinho);
                    System.out.println("Cliente cadastrado com sucesso:");
                    System.out.println(novoCliente);
                    break;
                case 2:
                    gerenciarFornecedores(tecladinho, fornecedores);
                    break;
                case 3:
                    gerenciarProdutos(tecladinho, produtos);
                    break;
                case 4:
                    gerenciarComandas(tecladinho, comandas, clientes, produtos);
                    break;
                case 5:
                    // incluir método de vago para o card.
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

    // menu do gerenciamento de fornecedores
    public static void gerenciarFornecedores(Scanner tecladinho, Fornecedores fornecedores) {
        int op;

        do {
            System.out.print("----------------------------------------------------------------\n"
                    + "Menu Fornecedores:\n"
                    + " 1. Adicionar Fornecedor\n"
                    + " 2. Listar Fornecedores\n"
                    + " 3. Remover Fornecedor\n"
                    + " 0. Voltar\n"
                    + "Digite a opção:");
            op = tecladinho.nextInt();
            tecladinho.nextLine(); // Limpa o buffer do teclado

            switch (op) {
                case 1: // o cadastro
                    System.out.print("Digite o nome do fornecedor: ");
                    String nome = tecladinho.nextLine();
                    System.out.print("Digite o contato do fornecedor: ");
                    String contato = tecladinho.nextLine();
                    fornecedores.cadastrarFornecedor(nome, contato);
                    break;

                case 2: // a lista de fornecedores cadastrados
                    fornecedores.listarFornecedores();
                    break;

                case 3: // remocão de fornecedores
                    System.out.print("Digite o nome do fornecedor a ser removido: ");
                    String nomeRemover = tecladinho.nextLine();
                    fornecedores.removerFornecedor(nomeRemover);
                    break;

                case 0: // opção para voltar ao menu
                    System.out.println("Voltando ao menu principal...");
                    break;

                default: // mensagem de erro
                    System.out.println("Opção invalida");
                    break;
            }

        } while (op != 0);
    }

    // menu do gerenciamento de produtos
    public static void gerenciarProdutos(Scanner tecladinho, Produtos produtos) {
        int op;

        do {
            System.out.print("----------------------------------------------------------------\n"
                    + "Menu Produtos:\n"
                    + " 1. Cadastrar Produto\n"
                    + " 2. Listar Produtos\n"
                    + " 0. Voltar\n"
                    + "Digite a opção:");
            op = tecladinho.nextInt();
            tecladinho.nextLine(); // Limpa o buffer do teclado

            switch (op) {
                case 1:
                    produtos.cadastrarProduto(tecladinho);
                    break;

                case 2:
                    produtos.listarProdutos();
                    break;

                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (op != 0);
    }

    // menu do gerenciamento de comandas
    public static void gerenciarComandas(Scanner tecladinho, Comandas comandas, Clientes clientes, Produtos produtos) {
        int op;

        do {
            System.out.print("----------------------------------------------------------------\n"
                    + "Menu Comandas:\n"
                    + " 1. Abrir Comanda\n"
                    + " 2. Adicionar Produtos\n"
                    + " 3. Fechar Comanda\n"
                    + " 0. Voltar\n"
                    + "Digite a opção:");
            op = tecladinho.nextInt();
            tecladinho.nextLine(); // Limpa o buffer do teclado

            switch (op) {
                case 1:
                    comandas.abrirComanda(tecladinho, clientes);
                    break;

                case 2:
                    comandas.adicionarProduto(tecladinho, produtos);
                    break;

                case 3:
                    comandas.fecharComanda(tecladinho);
                    break;

                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (op != 0);
    }
}
