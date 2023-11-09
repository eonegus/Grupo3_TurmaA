import jdk.dynalink.NamedOperation;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void proximo() {
        //Função que faz o skip com o ENTER
        Scanner scanner = new Scanner(System.in);
        String next;
        next = scanner.nextLine();
        if (next.isEmpty()) {
        }
    }

    public static void nome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual seu nome?");
    }

    public static void menu() {
        //Menu principal do jogo
        Scanner scanner = new Scanner(System.in);
        int op;
        //Laço pra que a escolha esteja conforme as opções
        do {
            //menu
            System.out.println();
            System.out.println("------------MENU ----------");
            System.out.println("-                         -");
            System.out.println("-      1 - Tutorial       -");
            System.out.println("-      2 -  Jogar         -");
            System.out.println("-      3 - Créditos       -");
            System.out.println("-      4 -  Sair          -");
            System.out.println("-                         -");
            System.out.println("---------------------------");

            System.out.println("Escolha uma opção:");
            op = scanner.nextInt();
            escolhaMenu(op);

        } while (op != 1 && op != 2 && op != 3 && op != 4);
    }

    public static void escolhaMenu(int op) {
        //Função que leva até as opções escolhidas
        switch (op) {
            case 1:
                System.out.println("Você escolheu: Tutorial");
                tutorial();
                break;
            case 2:
                System.out.println("Você escolheu: Jogar");
                jogar();
                break;
            case 3:
                System.out.println("Você escolheu: Créditos");
                creditos();
                break;
            case 4:
                System.out.println("Saindo...");
                System.out.println("Aperte ENTER para jogar...");
                proximo();
                menu();
                break;
        }
    }

    public static void tutorial() {
        //Tutorial do jogo
        int op;
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("-        Tutorial          -");
        System.out.println("----------------------------");
        System.out.println("\nOlá, investigador, para que você não se sinta perdido nessa aventura" +
                " vou lhe passar algumas dicas e um breve contexto da história.");
        System.out.println("Você é um pesquisador a procura de um tesouro perdido. Seu destino são " +
                " os túneis subterrâneos da frança.\n");
        System.out.println("----------------------------");
        System.out.println("-          DICAS           -");
        System.out.println("----------------------------");
        do {
            //Laço para que o jogador entenda como funciona a seleção de opções
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nDica 1: Para escolher suas ações digite o valor " +
                    "correspondente a uma das opções.\n");
            System.out.println("1 - Próxima dica\n2 - explicar novamente\n");
            System.out.print("Escolha: ");
            op = scanner.nextInt();
            if (op != 1 && op != 2) {
                System.out.println("Digite um valor válido!");
            }
        } while (op != 1);
        System.out.println("\nDica 2: Sempre que as reticências (...) aparecerem você deve pressionar ENTER" +
                " para continuar...");
        //fazer com que o jogador utilize e entenda a função
        proximo();
        System.out.println("Boa, já está entendendo!");
        System.out.println();
        System.out.println("Os desafios que você encontrará no caminho são sobre matematica, sendo " +
                " alguns deles questões de múltipla escolha,\nenquanto outros você deverá selecionar valores" +
                " sorteados aleatoriamente, e escrever o total.");
        System.out.println("Para selecionar a opção serão dados alternativas de 1 a 4...");
        //fazer com que o jogador utilize e entenda a função
        proximo();
        System.out.println("Para cada teste, você terá 2 tentativas para acertar.");
        System.out.println("Caso acerte, o jogo seguirá normalmente. Em caso de falha" +
                "será mostrado dado o aviso 'Você falhou!', junto a resposta do desafio...");
        //fazer com que o jogador utilize e entenda a função
        proximo();
        System.out.println("Muito bem, você terminou o tutorial, daqui pra frente é por sua conta!");
        System.out.println("Lembre-se, caso precise você sempre terá acesso ao tutorial pelo menu inicial.");
        System.out.println("Bem investigador, agora que você já sabe como as coisas funcionam por aqui, " +
                "venha conhecer um novo ambiente!");
        System.out.println("--------APERTE ENTER--------");
        //última demonstração da função
        proximo();
        menu();
    }

    public static void jogar() {
        Scanner scanner = new Scanner(System.in);
        //Inicia a apresentação do jogo
        System.out.println("Bem vindo a UNDER THE LIGHTS");
        System.out.println("Para começarmos, me diga, como devo chama-lo?:");
        //Deixa o usuario livre para escolher seu nome
        String nome = scanner.nextLine();
        System.out.println("Olá, " + nome + "!");
        //passa o nome para a função
        capitulo1(nome);
    }

    public static void capitulo1(String nome) {
        //a Função já está recebendo o nome pré estabelecido
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo " + nome);

        capitulo2(nome);
    }

    public static void capitulo2(String nome){
        Scanner scanner = new Scanner(System.in);
        

        capitulo3(nome);
    }

    public static void capitulo3(String nome){
        Scanner scanner = new Scanner(System.in);
        System.out.println(nome + " Olá");
        capitulo4(nome);
    }

    public static void capitulo4(String nome){
        Scanner scanner = new Scanner(System.in);
        System.out.println(nome + " Olá");
    }
    public static void escolhaDir() {
        Scanner scanner = new Scanner(System.in);

    }

    public static void escolhaEsq() {
        Scanner scanner = new Scanner(System.in);

    }

    public static void creditos() {
        //Créditos finais
        System.out.println();
        System.out.println("-------------CRÉDITOS-------------");
        System.out.println("-                                -");
        System.out.println("-      Alessandra Fernandes      -");
        System.out.println("-        Felipe Ferreira         -");
        System.out.println("-          João Victor           -");
        System.out.println("-         Vitor Gonçalves        -");
        System.out.println("-                                -");
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //começo do jogo para que o usuario decida começar
        System.out.println("Olá, bem vindo a 'UNDER THE LIGHTS'");
        System.out.println("Aperte ENTER para começar o jogo");
        proximo();
        menu();

    }
}