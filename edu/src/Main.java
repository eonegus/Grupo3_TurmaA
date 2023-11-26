import jdk.dynalink.NamedOperation;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static int temp_dialog =70, temp_narrativa = 150, temp_transicao = 25;
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

    public static void capitulo2(String nome) {
        int resposta1, resp2op3 = 0;
        Scanner menu = new Scanner(System.in);

        System.out.println("Seguindo o que o Edgar disse, Você segue em frente.\n " +
                "E acaba se deparando com uma sala misteriosa, iluminada por uma luz fraca. No centro da sala, havia uma escrita enigmática em uma pedra antiga: \n" +
                "'Edgar: Entenda jovem aventureiro, nesse lugar a matemática domina, e tudo envolve cálculo.'\n" +
                " 'Você pode optar sempre por não responder a pergunta, mas saiba que sempre estarei por perto para te ajudar, basta você falar “dica”");

        // DESAFIO 1
        System.out.println("Vamos ao primeiro desafio, por acaso você conhece sobre Polinómios?");
        System.out.println(" 1 - Sim.\n" +
                " 2 - Não.\n" +
                " 3 - Sim, porém não lembro.");

        int pergunta1 = menu.nextInt();

        switch (pergunta1) {
            case 1:
                System.out.println("Sim.");
                break;
            case 2:
                System.out.println("Não.");
                System.out.println("'Edgar: Bom, deixa eu te explicar um pouco, em um polinómio há três termos: \n" +
                        "A = termos que acompanham x²\n" +
                        "B = Termos que acompanham x;\n" +
                        "C = Algarismos que não acompanham um valor de X.'");
                break;

        }

        System.out.println("\n" +
                "Bom, então vamos lá.\n" +
                "Para avançar em sua busca, você deve decifrar o enigma do polinómio mágico.\n" +
                "Responda corretamente e o caminho se abrirá diante de você.\n" +
                "A escrita então se revelou a seguinte equação polinomial: ");
        // Desafio 1
        System.out.println("2x² + 4x + 3 + 4x² – 2x + 4");

        System.out.println("Caso a resposta esteja correta a parede em frente se abrirá dando passagem para que você possa seguir em frente.");
        System.out.println("\n" +
                "1)  6x² - 2x + 7\n" +
                "2)  6x² + 2x - 7\n" +
                "3)  6x² + 2x + 7");

        int desafio1 = menu.nextInt();

        switch (desafio1) {
            case 1:
                System.out.println("Resposta errada!");
                break;

            case 2:
                System.out.println("Resposta errada!");
                break;

            case 3:
                System.out.println("Resposta certa!");
                break;

            case 4:
                System.out.println("Dica: Primeiro some os termos independentes, depois combine os termos semelhantes.");
                break;

            default:
                System.out.println("Opção Inválida!");
                break;

        }

        System.out.println("\n" +
                "Quando essa porta se abre o jogador vê em sua frente um enorme salão dourado.\n" +
                " a impressão é de que ele tenha saído desse universo, e entrado em uma cidade medieval.\n" +
                " O salão é enorme e está em ruínas, aparentemente diversos saques e guerras aconteceram nesse local.\n" +
                "Ao final da sala uma enorme cadeira, na qual com certeza não foi projetada para um ser humano se sentar.");

        System.out.println("\n" +
                "Você pergunta:  \n" +
                "1 - Edgar, que lugar é esse?\n" +
                "2 - Uau, o que está rolando aqui?");

        int pergunta5 = menu.nextInt();

        switch (pergunta5) {
            case 1:
                System.out.println("\n" +
                        "1 - “Então jogador, como eu posso explicar… \n" +
                        "Esse é o lugar onde o mundo começou, ou seja, aqui é o lugar onde eu nasci.\n" +
                        "Quero dizer que, número, letras, palavras e tudo que você conhece começou aqui.\n" +
                        "Você pode conhecer como “cidade perdida” ou até “centro da terra”, mas o verdadeiro nome é “Monde”.");
                break;

            case 2:
                System.out.println("\n" +
                        "2 - An? Ah, você chegou ao salão principal. Bom aqui é o lugar onde seu desafio começa.\n" +
                        " Esse é o lugar onde o mundo começou, ou seja, aqui é o lugar onde eu nasci.\n" +
                        "Quero dizer que, número, letras, palavras e tudo que você conhece começou aqui.\n" +
                        "Você pode conhecer como “cidade perdida” ou até “centro da terra”, mas o verdadeiro nome é “Monde”.");
                break;

            default:
                System.out.println("\n" +
                        "Opção Invalida!");
                break;
        }

        System.out.println("\n" +
                "Olhe em volta jovem, tudo aqui é feito do mais puro ouro, há algo mais perfeito do que isso?");

        System.out.println("\n" +
                "1 - “Centro da terra? Monde? Dá pra explicar melhor?”\n" +
                "2 - “Ok, Edgar. Então aqui é o centro da criação?”\n");

        int pergunta6 = menu.nextInt();

        switch (pergunta6) {
            case 1, 2:
                System.out.println("\n" +
                        "Edgar apenas olha para você e segue em frente\n" +
                        "“Relaxa, você vai entender melhor”\n");
                break;

            default:
                System.out.println("\n" +
                        "Opção Invalida!");
        }
        System.out.println("\n" +
                "Um enorme som ecoa na sala, grandes muros se erguem e revelam diferentes valores.\n" +
                "'Edgar: “Bom aqui está o primeiro desafio então'");

        System.out.println("\n" +
                "'Edgar: “Bom aqui está o primeiro desafio então'”");

        // DESAFIO 2
        System.out.println("\n" +
                "Saindo do grande salão vc percebe que as parede estão diferentes. o que antes eram paredes rochosas, apertadas e escuras,\n" +
                " pouco a pouco tornam-se paredes feitas de uma rocha branca, que lembra muito mármore.");
        System.out.println("\n" +
                "O corredor começa a se tornar mais uniforme, não há mais tantos buracos no chão,\n" +
                " as paredes se mantêm com um toque delicado de mármore.\n" +
                "Caminhando mais e mais, com o que parece ser um corredor sem fim, logo a frente um feixe de luz se forma");

        System.out.println("\n" +
                "Qual ação devo tomar...\n" +
                "1 - Correr em direção a luz\n" +
                "2 - Continuar andando\n" +
                "3 - parar e analisar o local");

        int pergunta7 = menu.nextInt();

        switch (pergunta7) {
            case 1:
                System.out.println("\n" +
                        "Ao correr em direção a luz, acreditando ser a saída o jogador acaba tropeçando em um fio que abre um alçapão\n" +
                        " você começa a descer o que parece ser propositalmente um escorredor, ao chegar no final você se sente em uma espécie de colchão d´água.");
                break;
            case 2:
                System.out.println("\n" +
                        "Ao continuar andando em direção a luz, chegando perto desse feixe de luz você se descuida um pouco,\n" +
                        " e o que aparenta ser uma parte do piso é uma placa, ao pisar nessa placa o chão se abre e você começa a descer\n" +
                        " o que parece ser propositalmente um escorregador, ao chegar no final vc se sente em uma espécie de colchão d´água.");
                break;
            case 3:
                System.out.println("\n" +
                        "Analisando em volta você percebe uma espécie de chão falso, entende que se pisar ali algo irá acontecer.\n" +
                        " O feixe de luz aparenta vir de um buraco na parede que não leva a saída e sim a outro lugar");
                System.out.println("\n" +
                        "chegando nesse outro lugar, você terá duas opções:" +
                        "1- tentar contornar o chão falso\n" +
                        "2- Procurar outro jeito.");
                int respOp3 = menu.nextInt();

                switch (respOp3) {
                    case 1:
                        System.out.println("\n" +
                                "Você consegue contornar o chão falso e chegar até o buraco na parede, olhando o que vem através dele\n" +
                                " não consegue entender direito o que acontece ali, alguns vultos passam rapidamente e ofuscam seu entendimento.");
                        break;

                    case 2:
                        System.out.println("Olhando em volta novamente, apenas vê o caminho no qual vc veio e paredes de mármore sem nada diferente.");
                        break;

                    default:
                        System.out.println("Opção Invalida.");
                        break;
                }

                do {
                    System.out.println("\n" +
                            "Sem saber o que fazer, terá duas opções\n" +
                            "1- Entrar no chão falso\n" +
                            "2- Perguntar a Edgar o que fazer");
                    resp2op3 = menu.nextInt();

                    switch (resp2op3) {
                        case 1:
                            System.out.println("Ao pisar nessa placa o chão se abre e você começa a descer\n" +
                                    " o que parece ser propositalmente um escorregador, ao chegar no final vc se sente em uma espécie de colchão d´agua.");
                            break;

                        case 2:
                            System.out.println("Olá jovem, eu não sei exatamente se posso te dizer o que fazer, mas vamos, tenha coragem.");
                            break;

                        case 3:
                            System.out.println("Olhando em volta novamente, apenas vê o caminho no qual vc veio e paredes de mármore sem nada diferente.");
                            break;

                        default:
                            System.out.println("Opção Invalida.");
                    }
                } while (resp2op3 != 1);
        }
        capitulo3(nome);
    }


    public static void capitulo3(String nome) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(nome + " Olá");
        capitulo4(nome);
    }

    public static void capitulo4(String nome) {
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

    public static void Digita(String mensagem, TimeUnit unit, long tempo_mensagem) throws InterruptedException {
        for (char caractere : mensagem.toCharArray()) {
            System.out.print(caractere);
            unit.sleep(tempo_mensagem);
        }
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