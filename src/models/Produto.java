package models;

public class Produto extends Item { // produto com a extensão de item
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        super(nome, preco);
        this.estoque = estoque;
    }

    @Override
    public double calcularPreco() {
        return this.preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}
