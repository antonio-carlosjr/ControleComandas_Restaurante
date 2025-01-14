
package controlecomandas;

public class Bebida extends Produto{
    private double volume;
    private boolean alcoolica;

    public Bebida(double volume, boolean alcoolica, 
            double valorUnit, String nome) {
        super(valorUnit, nome);
        this.volume = volume;
        this.alcoolica = alcoolica;
    }
    
    
    
}
