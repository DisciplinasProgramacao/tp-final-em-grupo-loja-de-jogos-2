import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Set;
import loja.Cliente;
import loja.Compra;
import loja.Jogo;
import loja.Loja;

public class App {

    static String arqDados;

    /**
     * "Limpa" a tela (códigos de terminal VT-100)
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Menu para a Loja de Jogos
     * 
     * @param teclado Scanner de leitura
     * @return Opção do usuário (int)
     */
    public static int menu(Scanner teclado) {
        limparTela();
        System.out.println("XULAMBGAMES");
        System.out.println("==========================");
        System.out.println("Informe a opção desejada");
        System.out.println("1 - Cadastro de jogos");
        System.out.println("2 - Cadastro de clientes");
        System.out.println("3 - Cadastro de compras");
        System.out.println("0 - Sair");

        // ToDo
        // Revisar cadastros
        // Cadastrar compra
        // Opção de historico do cliente
        // Valor de uma compra
        // Valor mensal (total)
        // Valor médio
        // Jogos extremos

        int opcao = teclado.nextInt();
        teclado.nextLine();
        return opcao;
    }

    /**
     * Pausa para leitura de mensagens em console
     * 
     * @param teclado Scanner de leitura
     */
    static void pausa(Scanner teclado) {
        System.out.println("Enter para continuar.");
        teclado.nextLine();
    }

    /**
     * Gravação serializada do conjunto de clientes
     * 
     * @param clientes Conjunto de clientes a salvar
     * @throws IOException Em caso de erro na escrita ou abertura do arquivo
     *                     (propagação de exceção)
     */
    public static void gravarClientes(Set<Cliente> clientes) throws IOException {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(arqDados));
        for (Cliente cliente : clientes) {
            obj.writeObject(cliente);
        }
        obj.close();
    }

    /**
     * Gravação serializada do conjunto de compras
     * 
     * @param compras Conjunto de compras a salvar
     * @throws IOException Em caso de erro na escrita ou abertura do arquivo
     *                     (propagação de exceção)
     */
    public static void gravarCompras(Set<Compra> compras) throws IOException {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(arqDados));
        for (Compra compra : compras) {
            obj.writeObject(compra);
        }
        obj.close();
    }

    /**
     * Gravação serializada do conjunto de compras
     * 
     * @param compras Conjunto de compras a salvar
     * @throws IOException Em caso de erro na escrita ou abertura do arquivo
     *                     (propagação de exceção)
     */
    public static void gravarJogos(Set<Jogo> jogos) throws IOException {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(arqDados));
        for (Jogo jogo : jogos) {
            obj.writeObject(jogo);
        }
        obj.close();
    }

    public static void menuCadastraJogo() {
        Scanner teclado = new Scanner(System.in);

        int categoria = 0;
        String nome = "";
        String descricao = "";
        Double preco = 0.0;
        double modificador = 0;

        try {
            System.out.println("Qual a categoria do jogo a ser informado?");
            System.out.println("1 - Lançamento");
            System.out.println("2 - Premium");
            System.out.println("3 - Regular");
            System.out.println("4 - Promoção");
            categoria = teclado.nextInt();

            System.out.println("Digite o nome do jogo:");
            nome = teclado.nextLine();

            System.out.println("Digite a descrição do jogo:");
            descricao = teclado.nextLine();

            System.out.println("Digite o preço original do jogo:");
            preco = teclado.nextDouble();

            System.out.println("Digite o modificador de preço do jogo:");
            modificador = 0;

            switch (categoria) {
                case 3:
                    System.out.println("Categoria REGULAR");
                    System.out.println("Digite a porcentagem entre 70% e 100%:");
                    modificador = teclado.nextDouble();
                    break;
                case 4:
                    System.out.println("Categoria PROMOÇÃO");
                    System.out.println("Digite a porcentagem entre 30% e 50%:");
                    modificador = teclado.nextDouble();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        teclado.close();
        Loja.cadastrarJogo(categoria, nome, descricao, preco, modificador);
    }

    public static void menuCompraJogo() {
        Scanner teclado = new Scanner(System.in);
        int categoria = 0;
        String nome = "";
        String descricao = "";
        Double preco = 0.0;

        try {
            System.out.println("Deseja buscar o jogo por?");
            System.out.println("1 - Nome");
            System.out.println("2 - Descrição");
            System.out.println("3 - Preço");
            System.out.println("4 - Categoria");

            switch (categoria) {
                case 1:

                    System.out.println("Digite o nome do jogo desejado:");
                    nome = teclado.nextLine();
                    break;
                case 2:
                    System.out.println("Digite a descrição do jogo desejado:");
                    descricao = teclado.nextLine();

                    break;
                case 3:
                    System.out.println("Digite o preço do jogo desejado:");
                    preco = teclado.nextDouble();

                    break;
                case 4:
                    System.out.println("Digite a categoria de jogos desejada :");
                    categoria = teclado.nextInt();

                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        teclado.close();
        Loja.cadastrarJogo(categoria, nome, descricao, preco, categoria);
    }

    public static void menuCadastraCliente() {
        Scanner teclado = new Scanner(System.in);

        int categoria = 0;
        String nome = "";
        String usuario = "";
        String senha = "";
        String email = "";

        try {
            System.out.println("Qual a categoria do cliente a ser informado?");
            System.out.println("1 - Empolgado");
            System.out.println("2 - Fanático");
            System.out.println("3 - Cadastrado");
            categoria = teclado.nextInt();

            System.out.println("Digite o nome do Cliente:");
            nome = teclado.nextLine();

            System.out.println("Digite nome usuário do Cliente:");
            usuario = teclado.nextLine();

            System.out.println("Digite a senha do do Cliente:");
            senha = teclado.nextLine();

            switch (categoria) {
                case 1:
                    Loja.clienteEmpolgado(nome, categoria, usuario, senha);
                    break;
                case 2:
                    Loja.clienteFanatico(nome, categoria, usuario, senha);
                    break;
                case 3:
                    System.out.println("Informe qual será o e-mail do cliente");
                    email = teclado.nextLine();
                    Loja.clienteCadastrado(nome, categoria, usuario, senha, email);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        teclado.close();
    }

    public static void main(String[] args) throws Exception {
        int opcao = -1;
        Scanner teclado = new Scanner(System.in);
        // Jogo jogoCadastrado = null;
        // Cliente clienteCadastrado = null;
        // Compra compraCadastrada = null;

        do {
            opcao = menu(teclado);
            limparTela();
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    menuCadastraJogo();
                    break;
                case 2:
                    menuCadastraCliente();
                    break;
                case 3:
                    menuCompraJogo();

            }
            pausa(teclado);
        } while (opcao != 0);
        teclado.close();
    }

}