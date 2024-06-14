package controller;

import java.util.ArrayList;
import java.util.List;

import models.Cliente;
import models.Comanda;
import models.Fornecedor;
import models.Produto;

// classe controle para ter um gerenciamento do bar

public class ControllerBar {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Fornecedor> fornecedores = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private List<Comanda> comandas = new ArrayList<>();

    // metodos dos clientes

    public void alterarCliente(int index, Cliente cliente) {
        clientes.set(index, cliente);
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removeCliente(int index) {
        clientes.remove(index);
    }

    public List<Cliente> listaClientes() {
        return clientes;
    }

    // metodos dos fornecedores

    public void adicionarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public void alterarFornecedor(int id, Fornecedor fornecedor) {
        int index = buscarFornecedorPorId(id);
        if (index >= 0) {
            fornecedores.set(index, fornecedor);
        }
    }

    public void deletarFornecedor(int id) {
        int index = buscarFornecedorPorId(id);
        if (index >= 0) {
            fornecedores.remove(index);
        }
    }

    public List<Fornecedor> listarFornecedores() {
        return fornecedores;
    }

    public int buscarFornecedorPorId(int id) {
        for (int i = 0; 0 < fornecedores.size(); i++) {
            if (fornecedores.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    // metodos dos produtos

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void alterarProduto(int index, Produto produto) {
        produtos.set(index, produto);
    }

    public void deletarProduto(int index) {
        produtos.remove(index);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    // metodos das comandas

    public void adicionarComanda(Comanda comanda) {
        comandas.add(comanda);
    }

    public void alterarComanda(int index, Comanda comanda) {
        comandas.set(index, comanda);
    }

    public void deletarComanda(int index) {
        comandas.remove(index);
    }

    public List<Comanda> listarComandas() {
        return comandas;
    }

}
