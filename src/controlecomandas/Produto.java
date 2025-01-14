
package controlecomandas;

public class Produto {
    private double valorUnit;
    private int quantVend;
    private String nome;

    public Produto(double valorUnit, int quantVend, String nome) {
        this.valorUnit = valorUnit;
        this.quantVend = quantVend;
        this.nome = nome;
    }

    //uti. no momento do cadastro do MENU
    public Produto(double valorUnit, String nome) {
        this.valorUnit = valorUnit;
        this.nome = nome;
        this.quantVend = 0;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.valorUnit;
    }

    public double getValorUnit() {
        return valorUnit;
    }
    
    
    
    
}
