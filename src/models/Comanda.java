package models;

import java.util.*;

public class Comanda {
    private Cliente cliente; // cliente resgitrado
    private List<Produto> produtos; // produto que consumiu
    private double total; // o total a ser pago

    public Comanda(Cliente cliente, List<Produto> produtos, double total) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.total = total;
    }

   

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
