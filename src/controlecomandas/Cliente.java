package controlecomandas;

//cliente do rest.
public class Cliente {

    private String nome;
    private String telefone;
    private String endereco;

    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public Cliente(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    


    @Override
    public String toString() {
        return nome;
    }
}


