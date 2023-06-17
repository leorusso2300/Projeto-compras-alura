package br.com.alura.projetocompras.principal;

import br.com.alura.projetocompras.modelos.CartaoDeCredito;
import br.com.alura.projetocompras.modelos.Compra;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        CartaoDeCredito cartao = new CartaoDeCredito();
        Compra compra = new Compra();

        int contador = 1;
        boolean verifica = false;
        Map<String, Double> produtos = new HashMap<>();


        while (contador == 1) {
            if (!verifica) {
                System.out.println("Digite o limite do cartão: ");
                cartao.setLimiteCartao(reader.nextDouble());
            }

            System.out.println("Digite a descrição da compra: ");
            compra.setDescricaoCompra(reader.next());

            System.out.println("Digite o valor da compra: ");
            compra.setValorCompra(reader.nextDouble());

            if (compra.getValorCompra() <= cartao.getLimiteCartao()) {

                cartao.setLimiteCartao(cartao.getLimiteCartao() - compra.getValorCompra());
                produtos.put(compra.getDescricaoCompra(), compra.getValorCompra());
                System.out.println("Compra realizada!");

            } else {
                System.out.println("Saldo insuficiente!!");
                mostraLista(produtos, cartao.getLimiteCartao());
                break;
            }

            System.out.println("Digite 0 para sair ou 1 para continuar");
            contador = reader.nextInt();


            if (contador == 1) {
                verifica = true;
            } else {
                mostraLista(produtos, cartao.getLimiteCartao());
            }
        }
    }

    public static void mostraLista(Map produtos, double limiteCartao) {
        System.out.println(" ");
        System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
        System.out.println("COMPRAS REALIZADAS: ");
        System.out.println(" ");

        ArrayList list = new ArrayList<>(produtos.entrySet());
        list.sort(Map.Entry.comparingByValue());
        list.forEach(System.out::println);

        System.out.println(" ");
        System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
        System.out.println("Limite do cartão: " + limiteCartao);

    }
}

