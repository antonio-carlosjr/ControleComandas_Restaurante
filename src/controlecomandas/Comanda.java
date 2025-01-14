package controlecomandas;

import controlecomandas.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;

public class Comanda {

    private LocalDate data;
    private int numMesa;
    private double valorTotal;
    private Cliente respComanda;
    

    //Preciso de uma lista de produtos
    //Produto produtosCons[] = new Produto[1000];
    private ArrayList<Produto> produtos = new ArrayList<>();

    public Comanda(int numMesa, Cliente respComanda) {
        this.numMesa = numMesa;
        this.respComanda = respComanda;
        this.valorTotal = 0.0;
        this.data = LocalDate.now();
    }

    public void anotaPedido(Produto novoPedido) {
        this.produtos.add(novoPedido);
        this.valorTotal += novoPedido.getValorUnit();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Cliente getRespComanda() {
        return respComanda;
    }

    int cont = 0;
    String listaImprimePedios = "";

    public String imprimePedidos() {
        while (produtos.size() > cont) {
            Produto iterador = produtos.get(cont);
            cont++;
            listaImprimePedios = listaImprimePedios + iterador +"\n";
        }
        return listaImprimePedios;
    }
}
