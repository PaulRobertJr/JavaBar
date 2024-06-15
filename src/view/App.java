package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControllerBar;
import models.Cliente;
import models.Comanda;
import models.Fornecedor;
import models.Produto;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("JavaBar");

        ControllerBar barControle = new ControllerBar();
        Scanner tecladinho = new Scanner(System.in);
        int opc;
        boolean sair = false;

        // Criando 3 clientes
        Cliente cliente1 = new Cliente("Alice Santos", "123.456.789-00", 1, "alice@santos.com", "01/01/1990",
                "1111-1111");
        Cliente cliente2 = new Cliente("Bob Marley", "234.567.890-11", 2, "bob@marley.com", "02/02/1985", "2222-2222");
        Cliente cliente3 = new Cliente("Charlie Bronw", "345.678.901-22", 3, "charlie@bronw.com", "03/03/1980",
                "3333-3333");

        barControle.addCliente(cliente1);
        barControle.addCliente(cliente2);
        barControle.addCliente(cliente3);

        // Criando 3 fornecedores
        Fornecedor fornecedor1 = new Fornecedor("Coca-Cola", "456.789.012-33", 1, "AMBEV", "4444-4444");
        Fornecedor fornecedor2 = new Fornecedor("Cheetos Salgadinhos", "567.890.123-44", 2, "Cheetos", "5555-5555");
        Fornecedor fornecedor3 = new Fornecedor("Maria Salgados", "678.901.234-55", 3, "Maria Slagdos", "6666-6666");

        barControle.adicionarFornecedor(fornecedor1);
        barControle.adicionarFornecedor(fornecedor2);
        barControle.adicionarFornecedor(fornecedor3);

        // Criando 6 produtos
        Produto produto1 = new Produto("Cerveja", 5.00, 100);
        Produto produto2 = new Produto("Refrigerante", 5.00, 200);
        Produto produto3 = new Produto("Água", 2.00, 300);
        Produto produto4 = new Produto("Whisky", 50.00, 50);
        Produto produto5 = new Produto("Vodka", 40.00, 60);
        Produto produto6 = new Produto("Vinho", 30.00, 70);

        barControle.adicionarProduto(produto1);
        barControle.adicionarProduto(produto2);
        barControle.adicionarProduto(produto3);
        barControle.adicionarProduto(produto4);
        barControle.adicionarProduto(produto5);
        barControle.adicionarProduto(produto6);

        // Loop principal do menu
        do {
            System.out.print("----------------------------------------------------------------\n"
                    + "Selecione a opção desejada:\n"
                    + " 1. Clientes.\n"
                    + " 2. Fornecedores.\n"
                    + " 3. Produtos.\n"
                    + " 4. Comandas.\n"
                    + " 5. Relatórios.\n"
                    + " 0. Sair.\n"
                    + "Digite a opção: \n");

            tecladinho.nextLine();
            try {
                opc = Integer.parseInt(tecladinho.nextLine());
                switch (opc) {
                    case 1:
                        gerenciarClientes(barControle, tecladinho);
                        break;
                    case 2:
                        gerenciarFornecedores(barControle, tecladinho);
                        break;
                    case 3:
                        gerenciarProdutos(barControle, tecladinho);
                        break;
                    case 4:
                        gerenciarComandas(barControle, tecladinho);
                        break;
                    case 5:
                        // incluir método de CARD.
                        break;
                    case 0:
                        sair = true;
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida, digite um numero de 0 a 5.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Digite um número.");
            }
        } while (!sair);
        tecladinho.close();
    }

    public static void gerenciarClientes(ControllerBar barControle, Scanner tecladinho) {
        int opc = -1;

        do {
            System.out.print("-------------------------------------------------\n"
                    + "Menu de Clientes:\n"
                    + " 1. Adicionar Cliente.\n"
                    + " 2. Alterar Cliente.\n"
                    + " 3. Deletar Cliente.\n"
                    + " 4. Listar Clientes.\n"
                    + " 0. Voltar.\n"
                    + "Digite a opção: \n");

            tecladinho.nextLine();
            try {
                opc = Integer.parseInt(tecladinho.nextLine());
                switch (opc) {
                    case 1:
                        System.out.println("Adicionar Cliente");

                        System.out.print("Nome: ");
                        String nome = tecladinho.nextLine();

                        System.out.print("CPF: ");
                        String cpf = tecladinho.nextLine();

                        System.out.print("Email: ");
                        String email = tecladinho.nextLine();

                        System.out.print("Data de Nascimento: ");
                        String dataNascimento = tecladinho.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = tecladinho.nextLine();

                        int id = barControle.listaClientes().size() + 1;
                        Cliente novoCliente = new Cliente(nome, cpf, id, email, dataNascimento, telefone);
                        barControle.addCliente(novoCliente);

                        System.out.println("Cliente adicionado com sucesso!");
                        break;

                    case 2:
                        if (barControle.listaClientes().isEmpty()) {
                            System.out.println("Nenhum cliente cadastrado.");
                        } else {
                            System.out.println("Alterar Cliente");
                            System.out.print("ID do Cliente: ");
                            int idAlterar = tecladinho.nextInt();
                            tecladinho.nextLine();

                            System.out.print("Nome: ");
                            nome = tecladinho.nextLine();

                            System.out.print("CPF: ");
                            cpf = tecladinho.nextLine();

                            System.out.print("Email: ");
                            email = tecladinho.nextLine();

                            System.out.print("Data de Nascimento: ");
                            dataNascimento = tecladinho.nextLine();

                            System.out.print("Telefone: ");
                            telefone = tecladinho.nextLine();

                            Cliente clienteAlterar = new Cliente(nome, cpf, idAlterar, email, dataNascimento, telefone);
                            barControle.alterarCliente(idAlterar - 1, clienteAlterar);

                            System.out.println("Cliente alterado com sucesso!");
                        }
                        break;

                    case 3:
                        if (barControle.listaClientes().isEmpty()) {
                            System.out.println("Nenhum cliente cadastrado.");
                        } else {
                            System.out.println("Deletar Cliente");
                            System.out.print("ID do Cliente: ");
                            int idDeletar = tecladinho.nextInt();
                            tecladinho.nextLine();

                            barControle.removeCliente(idDeletar - 1);
                            System.out.println("Cliente deletado com sucesso!");
                        }
                        break;

                    case 4:
                        if (barControle.listaClientes().isEmpty()) {
                            System.out.println("Nenhum cliente foi cadastrado.");
                        } else {
                            System.out.println("Lista de Clientes:");
                            for (Cliente c : barControle.listaClientes()) {
                                System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome() + ", CPF: "
                                        + c.getCpf() +
                                        ", Email: " + c.getEmail() + ", Data de Nascimento: " + c.getDataNascimento() +
                                        ", Telefone: " + c.getTelefone());
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Voltando ao Menu Principal...");
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Escolha inválida. Por favor, digite um numero de 0 a 4.");
                tecladinho.nextLine();
            }
        } while (opc != 0);

    }

    public static void gerenciarFornecedores(ControllerBar barControle, Scanner tecladinho) {
        int opc = -1;

        do {
            System.out.print("-------------------------------------------------\n"
                    + "Menu de Fornecedores:\n"
                    + " 1. Adicionar Fornecedor.\n"
                    + " 2. Alterar Fornecedor.\n"
                    + " 3. Deletar Fornecedor.\n"
                    + " 4. Listar Fornecedores.\n"
                    + " 0. Voltar.\n"
                    + "Digite a opção: \n");

            tecladinho.nextLine();
            try {
                opc = Integer.parseInt(tecladinho.nextLine());
                switch (opc) {
                    case 1:
                        System.out.println("Adicionar Fornecedor");

                        System.out.print("Nome: ");
                        String nome = tecladinho.nextLine();

                        System.out.print("CPF: ");
                        String cpf = tecladinho.nextLine();

                        System.out.print("Empresa: ");
                        String empresa = tecladinho.nextLine();

                        System.out.print("Contato: ");
                        String contato = tecladinho.nextLine();

                        int id = barControle.listarFornecedores().size() + 1;
                        Fornecedor novoFornecedor = new Fornecedor(nome, cpf, id, empresa, contato);
                        barControle.adicionarFornecedor(novoFornecedor);

                        System.out.println("Fornecedor adicionado com sucesso!");

                        break;

                    case 2:
                        if (barControle.listarFornecedores().isEmpty()) {
                            System.out.println("Nenhum fornecedor cadastrado.");
                        } else {
                            System.out.println("Alterar Fornecedor");
                            System.out.print("ID do Fornecedor: ");

                            int idAlterar = tecladinho.nextInt();
                            tecladinho.nextLine();

                            int index = barControle.buscarFornecedorPorId(idAlterar);

                            if (index >= 0) {
                                System.out.print("Nome: ");
                                nome = tecladinho.nextLine();

                                System.out.print("CPF: ");
                                cpf = tecladinho.nextLine();

                                System.out.print("Empresa: ");
                                empresa = tecladinho.nextLine();

                                System.out.print("Contato: ");
                                contato = tecladinho.nextLine();

                                Fornecedor fornecedorAlterar = new Fornecedor(nome, cpf, idAlterar, empresa, contato);
                                barControle.alterarFornecedor(idAlterar, fornecedorAlterar);

                                System.out.println("Fornecedor alterado com sucesso!");
                            } else {
                                System.out.println("ID de fornecedor inválido.");
                            }
                        }
                        break;

                    case 3:
                        if (barControle.listarFornecedores().isEmpty()) {
                            System.out.println("Nenhum fornecedor cadastrado.");
                        } else {
                            System.out.println("Deletar Fornecedor");
                            System.out.print("ID do Fornecedor: ");
                            int idDeletar = tecladinho.nextInt();
                            tecladinho.nextLine();

                            int index = barControle.buscarFornecedorPorId(idDeletar);

                            if (index >= 0) {
                                barControle.deletarFornecedor(idDeletar);
                                System.out.println("Fornecedor deletado com sucesso!");
                            } else {
                                System.out.println("ID de fornecedor inválido.");
                            }
                        }
                        break;

                    case 4:
                        if (barControle.listarFornecedores().isEmpty()) {
                            System.out.println("Nenhum fornecedor foi cadastrado.");
                        } else {
                            System.out.println("Lista de Fornecedores:");
                            for (Fornecedor f : barControle.listarFornecedores()) {
                                System.out
                                        .println("ID: " + f.getId() + ", Nome: " + f.getNome() + ", CPF: " + f.getCpf()
                                                + ", Empresa: " + f.getEmpresa() + ", Contato: " + f.getContato());
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Voltando ao Menu Principal...");
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Escolha inválida. Por favor, digite um numero de 0 a 4.");
                tecladinho.nextLine();
            }
        } while (opc != 0);
    }

    public static void gerenciarProdutos(ControllerBar barControle, Scanner tecladinho) {
        int opc = -1;

        do {
            try {
                opc = Integer.parseInt(tecladinho.nextLine());
                System.out.print("-------------------------------------------------\n"
                        + "Menu de Produtos:\n"
                        + " 1. Adicionar Produto.\n"
                        + " 2. Alterar Produto.\n"
                        + " 3. Deletar Produto.\n"
                        + " 4. Listar Produtos.\n"
                        + " 0. Voltar.\n"
                        + "Digite a opção: \n");

                opc = tecladinho.nextInt();
                tecladinho.nextLine();

                switch (opc) {
                    case 1:
                        System.out.println("Adicionar Produto");

                        System.out.print("Nome: ");
                        String nome = tecladinho.nextLine();

                        System.out.print("Preço: ");
                        double preco = tecladinho.nextDouble();
                        tecladinho.nextLine();

                        System.out.print("Estoque: ");
                        int estoque = tecladinho.nextInt();
                        tecladinho.nextLine();

                        Produto novoProduto = new Produto(nome, preco, estoque);
                        barControle.adicionarProduto(novoProduto);

                        System.out.println("Produto adicionado com sucesso!");
                        break;

                    case 2:
                        if (barControle.listarProdutos().isEmpty()) {
                            System.out.println("Nenhum produto cadastrado.");
                        } else {
                            System.out.println("Alterar Produto");
                            System.out.print("ID do Produto: ");

                            int idAlterar = tecladinho.nextInt();
                            tecladinho.nextLine();

                            if (idAlterar > 0 && idAlterar <= barControle.listarProdutos().size()) {
                                System.out.print("Nome: ");
                                nome = tecladinho.nextLine();

                                System.out.print("Preço: ");
                                preco = tecladinho.nextDouble();
                                tecladinho.nextLine();

                                System.out.print("Estoque: ");
                                estoque = tecladinho.nextInt();
                                tecladinho.nextLine();

                                Produto produtoAlterar = new Produto(nome, preco, estoque);
                                barControle.alterarProduto(idAlterar - 1, produtoAlterar);

                                System.out.println("Produto alterado com sucesso!");
                            } else {
                                System.out.println("ID de produto inválido.");
                            }
                        }
                        break;

                    case 3:
                        if (barControle.listarProdutos().isEmpty()) {
                            System.out.println("Nenhum produto cadastrado.");
                        } else {
                            System.out.println("Deletar Produto");
                            System.out.print("ID do Produto: ");
                            int idDeletar = tecladinho.nextInt();
                            tecladinho.nextLine();

                            if (idDeletar > 0 && idDeletar <= barControle.listarProdutos().size()) {
                                barControle.deletarProduto(idDeletar - 1);
                                System.out.println("Produto deletado com sucesso!");
                            } else {
                                System.out.println("ID de produto inválido.");
                            }
                        }
                        break;

                    case 4:
                        if (barControle.listarProdutos().isEmpty()) {
                            System.out.println("Nenhum produto foi cadastrado.");
                        } else {
                            System.out.println("Lista de Produtos:");
                            for (Produto p : barControle.listarProdutos()) {
                                System.out.println("ID: " + (barControle.listarProdutos().indexOf(p) + 1) + ", Nome: "
                                        + p.getNome() + ", Preço: " + p.getPreco()
                                        + ", Estoque: " + p.getEstoque());
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Voltando ao Menu Principal...");
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Escolha inválida. Por favor, digite um numero de 0 a 4.");
                tecladinho.nextLine();
            }
        } while (opc != 0);
    }

    public static void gerenciarComandas(ControllerBar barControle, Scanner tecladinho) {
        int opc = -1;

        do {
            System.out.print("-------------------------------------------------\n"
                    + "Menu de Comandas:\n"
                    + " 1. Abrir Comanda.\n"
                    + " 2. Adicionar Produto na Comanda.\n"
                    + " 3. Fechar Comanda.\n"
                    + " 4. Listar Comandas.\n"
                    + " 0. Voltar.\n"
                    + "Digite a opção: \n");

            try {
                opc = Integer.parseInt(tecladinho.nextLine());
                tecladinho.nextLine();

                switch (opc) {
                    case 1:
                        System.out.println("Abrir Comanda");

                        System.out.print("ID do Cliente: ");
                        int clienteId = tecladinho.nextInt();
                        tecladinho.nextLine();

                        if (clienteId > 0 && clienteId <= barControle.listaClientes().size()) {
                            Cliente cliente = barControle.listaClientes().get(clienteId - 1); // -1 para corrigir o
                                                                                              // índice
                            Comanda comanda = new Comanda(cliente, new ArrayList<>(), 0);
                            barControle.adicionarComanda(comanda);

                            System.out.println("Comanda aberta com sucesso!");
                        } else {
                            System.out.println("ID de cliente inválido.");
                        }
                        break;

                    case 2:
                        System.out.println("Adicionar Produto na Comanda");

                        System.out.print("ID da Comanda: ");
                        int comandaId = tecladinho.nextInt();
                        tecladinho.nextLine();

                        System.out.print("ID do Produto: ");
                        int produtoId = tecladinho.nextInt();
                        tecladinho.nextLine();

                        if (comandaId > 0 && comandaId <= barControle.listarComandas().size() &&
                                produtoId > 0 && produtoId <= barControle.listarProdutos().size()) {
                            Produto produto = barControle.listarProdutos().get(produtoId - 1); // -1 para corrigir o
                                                                                               // índice
                            Comanda comanda = barControle.listarComandas().get(comandaId - 1); // -1 para corrigir o
                                                                                               // índice
                            comanda.getProdutos().add(produto);
                            System.out.println("Produto adicionado na comanda com sucesso!");
                        } else {
                            System.out.println("ID de comanda ou produto inválido.");
                        }
                        break;

                    case 3:
                        System.out.println("Fechar Comanda");

                        System.out.print("ID da Comanda: ");
                        comandaId = tecladinho.nextInt();
                        tecladinho.nextLine(); // Consumir nova linha

                        if (comandaId > 0 && comandaId <= barControle.listarComandas().size()) {
                            Comanda comanda = barControle.listarComandas().get(comandaId - 1); // -1 para corrigir o
                                                                                               // índice
                            comanda.setTotal(comanda.getTotal()); // Calcular e setar o total
                            System.out.println("Comanda fechada com sucesso! Total: " + comanda.getTotal());
                        } else {
                            System.out.println("ID de comanda inválido.");
                        }
                        break;

                    case 4:
                        if (barControle.listarComandas().isEmpty()) {
                            System.out.println("Nenhuma comanda foi aberta.");
                        } else {
                            System.out.println("Lista de Comandas:");
                            for (Comanda c : barControle.listarComandas()) {
                                System.out
                                        .println("ID: " + (barControle.listarComandas().indexOf(c) + 1) + ", Cliente: "
                                                + c.getCliente().getNome() + ", Total: " + c.getTotal());
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Voltando ao Menu Principal...");
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Escolha inválida. Por favor, digite um numero de 0 a 4.");
                tecladinho.nextLine(); // Limpa o buffer do teclado
            }
        } while (opc != 0);
    }
}
