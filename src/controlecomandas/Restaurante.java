package controlecomandas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Restaurante {

    private String nome;

    private Comanda[] comandas = new Comanda[10];

    private ArrayList<Produto> menu = new ArrayList<>();

    public Restaurante(String nome) {
        this.nome = nome;

        //carregaProdutos();
        carregarProdutosMenu();
    }

    /*private void carregaProdutos(){
        this.menu.add(new Porcao(350.0, 1, 12.0, "Tropeiro"));
        this.menu.add(new Porcao(500.0, 3, 15.0, "Fritas"));
        this.menu.add(new Porcao(500.0, 2, 36.0, "Filé"));
        this.menu.add(new Bebida(380.0,true, 10.0,"Bebida da massa"));
        this.menu.add(new Bebida(500.0,false, 12.0,"Suco de Laranja"));
    }*/
    public void realCadastraComanda() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o nome do cliente:");
        String nomeCli = entrada.nextLine();

        System.out.println("Informe o núm de tel. do cliente:");
        String telCli = entrada.nextLine();

        Cliente novoCli = new Cliente(nomeCli, telCli);

        //aqui seria necessário validar o intervalo do num da mesa [1..10]
        System.out.println("Informe o número da mesa do cliente:");
        int numMesa = entrada.nextInt();

        Comanda novaComanda = new Comanda(numMesa, novoCli);

        comandas[numMesa] = novaComanda;

    }

    public boolean realizarPedido() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("informe o núm da mesa:");
        int numMesa = entrada.nextInt();

        //será que existe alguem ocupand. a mesa
        if (numMesa < 0 || numMesa > 9 || comandas[numMesa] == null) {
            return false;
        } else {
            //imprimir o MENU
            for (int i = 0; i < this.menu.size(); i++) {
                System.out.println((i + 1) + " - " + this.menu.get(i));
            }

            System.out.println("Informe o produto do pedido:");
            int numProduto = entrada.nextInt();
            numProduto--;

            this.comandas[numMesa].anotaPedido(this.menu.get(numProduto));

            return true;
        }

    }

    public void fecharComanda() {
        Scanner entrada = new Scanner(System.in);

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm");
        String dataHoraFormatada = agora.format(formatador);

        try {
            System.out.println("Informe o número da mesa a ser fechada: ");
            int numMesa = entrada.nextInt();

            String nomeArquivo = "mesa" + numMesa + "_" + dataHoraFormatada + ".txt";

            String textoLinha = null;

            File arquivo = new File("C:\\Users\\Carlos\\Downloads\\" + nomeArquivo);

            try {
                FileWriter marcaEscrita = new FileWriter(arquivo);

                BufferedWriter bufEscrita = new BufferedWriter(marcaEscrita);

                //realizar a escrita dos dados
                bufEscrita.write(this.comandas[numMesa].getRespComanda().toString() + "\n");

                bufEscrita.write(this.comandas[numMesa].imprimePedidos());

                bufEscrita.write("Total: R$" + this.comandas[numMesa].getValorTotal());

                bufEscrita.flush();
                bufEscrita.close();

            } catch (IOException ex) {
                System.err.println("Arquivo corrompido");
            }

            //comandas
            System.out.println("Produtos cons. ");
            this.comandas[numMesa].imprimePedidos();

            System.out.println("Valor Total: "
                    + this.comandas[numMesa].getValorTotal());

            this.comandas[numMesa] = null;
        } catch (NullPointerException erro) {
            System.out.println("A comanda não existe ou o núm. da mesa está inco.");
        } catch (InputMismatchException erro1) {
            System.out.println("Erro na entrada de dados");
            erro1.printStackTrace();
        } catch (Exception e) {
            //todos os erros restantes

        }
    }

    public void encerrarDia() {
        for (int cont = 0; cont < 10; cont++) {
            if (this.comandas[cont] != null){
            Scanner entrada = new Scanner(System.in);

                LocalDateTime agora = LocalDateTime.now();
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm");
                String dataHoraFormatada = agora.format(formatador);

                try {
                    String nomeArquivo = "mesa" + cont + "_" + dataHoraFormatada + ".txt";

                    String textoLinha = null;

                    File arquivo = new File("C:\\Users\\Carlos\\Downloads\\" + nomeArquivo);

                    try {
                        FileWriter marcaEscrita = new FileWriter(arquivo);

                        BufferedWriter bufEscrita = new BufferedWriter(marcaEscrita);

                        //realizar a escrita dos dados
                        bufEscrita.write(this.comandas[cont].getRespComanda().toString() + "\n");

                        bufEscrita.write(this.comandas[cont].imprimePedidos());

                        bufEscrita.write("Total: R$" + this.comandas[cont].getValorTotal());

                        bufEscrita.flush();
                        bufEscrita.close();

                    } catch (IOException ex) {
                        System.err.println("Arquivo corrompido");
                    }

                    //comandas
                    System.out.println("Produtos cons. ");
                    this.comandas[cont].imprimePedidos();

                    System.out.println("Valor Total: "
                            + this.comandas[cont].getValorTotal());

                    this.comandas[cont] = null;
                } catch (NullPointerException erro) {
                    System.out.println("A comanda não existe ou o núm. da mesa está inco.");
                } catch (InputMismatchException erro1) {
                    System.out.println("Erro na entrada de dados");
                    erro1.printStackTrace();
                } catch (Exception e) {
                    //todos os erros restantes

                }
            }
        }
    }

    private void carregarProdutosMenu() {

        //1° encontrar o arquivo
        File arquivo = new File("C:\\Users\\Carlos\\Downloads\\refeicoes_e_bebidas.csv");

        //2° marcar como leitura
        if (arquivo.exists() && arquivo.canRead() && arquivo.isFile()) {
            try {
                //"marca" o arquivo ref, como leitura
                FileReader marcarLeitura = new FileReader(arquivo);

                BufferedReader bufLeitura = new BufferedReader(marcarLeitura);

                //1° linha cabeçalho
                String linha = bufLeitura.readLine();

                while (linha != null) {
                    linha = bufLeitura.readLine();

                    //verificar se não esgotamos TODAS as linhas do arq.
                    if (linha != null) {
                        String pedacosLinha[] = linha.split(";");

                        //transformar em Produto
                        Produto novoProd = new Produto(
                                Double.parseDouble(pedacosLinha[1]),
                                pedacosLinha[0]);

                        //produto do arquivo disp. para comerc.
                        this.menu.add(novoProd);
                    }
                }
            } catch (FileNotFoundException erro) {
                System.out.println("Caminho do arquivo incorreto");
            } catch (IOException erroLeitura) {
                System.out.println("Erro na leitura dos dados");
            }
        }

        //3° ler linhas do arquivo
    }

}
