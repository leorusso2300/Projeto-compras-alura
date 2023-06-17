package br.com.alura.projetocompras.modelos;

public class Compra implements Comparable<Compra> {

    private String descricaoCompra;
    private double valorCompra;

    public String getDescricaoCompra() {
        return descricaoCompra;
    }

    public void setDescricaoCompra(String descricaoCompra) {
        this.descricaoCompra = descricaoCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Override
    public int compareTo(Compra outroValor) {
        return Double.valueOf(this.valorCompra).compareTo(Double.valueOf(outroValor.valorCompra));
    }
}
