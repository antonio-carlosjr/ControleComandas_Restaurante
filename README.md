# Sistema de Controle de Comandas para Restaurantes

Este projeto implementa um sistema básico para o gerenciamento de comandas em restaurantes. Ele permite o cadastro de comandas, realização de pedidos, fechamento de comandas e encerramento do dia, com persistência de dados em arquivos para consulta posterior. O mesmo foi desenvolvido durante as aulas de laboratório ministradas pelo professor Saulo Cabral do IFMG.

## Funcionalidades

1. **Cadastro de Comandas**:
   - Associa uma comanda a uma mesa e a um cliente.
   - Armazena o nome e telefone do cliente.

2. **Realização de Pedidos**:
   - Exibe o menu disponível.
   - Permite adicionar produtos da lista de menu à comanda de uma mesa específica.

3. **Fechamento de Comandas**:
   - Gera um arquivo de texto com o resumo dos pedidos e o valor total da comanda.

4. **Encerramento do Dia**:
   - Fecha todas as comandas abertas, gerando arquivos individuais para cada mesa.

5. **Menu Personalizável**:
   - Permite carregar produtos a partir de um arquivo CSV.

## Estrutura do Projeto

- **`Restaurante`**: Classe principal que gerencia comandas e produtos do restaurante.
- **`Comanda`**: Representa uma comanda, armazenando os pedidos, valor total e cliente responsável.
- **`Produto`**: Classe base para itens do menu (bebidas e porções).
- **`Bebida`**: Representa uma bebida, com propriedades como volume e se é alcoólica.
- **`Porcao`**: Representa uma porção, com informações sobre peso e quantidade de pessoas.
- **`Cliente`**: Armazena os dados do cliente (nome, telefone e endereço).
- **`ControleComandas`**: Classe com o método `main`, que fornece o menu de opções para interação com o sistema.

## Requisitos

- **Java 8 ou superior**
- Biblioteca padrão do Java para manipulação de arquivos e entrada de dados.

## Como Executar

1. Certifique-se de que o Java está instalado no seu sistema.
2. Compile os arquivos `.java` utilizando o comando:
   ```bash
   javac *.java
