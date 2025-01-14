
package controlecomandas;

public class Porcao extends Produto{
    private double peso;
    private int qPessoas;

    public Porcao(double peso, int qPessoas, 
            double valorUnit, String nome) {
        super(valorUnit, nome);
        this.peso = peso;
        this.qPessoas = qPessoas;
    }

    
    
    
    
}
