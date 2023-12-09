import jdk.dynalink.NamedOperation;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    static int temp = 10;
    static int acertos = 1; // Variavel global de acertos
    public static void proximo() {
        //Função que faz o skip com o ENTER
        Scanner scanner = new Scanner(System.in);
        String next;
        next = scanner.nextLine();
        if (next.isEmpty()) {
        }
    }

    public static void vinteUm() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);


        List<String> maoJogador = new ArrayList<>();
        List<String> maoComputador = new ArrayList<>();

        List<String> baralho = inicializarBaralho();
        Collections.shuffle(baralho);

        // Distribui as cartas para o jogador e o computador
        distribuirCarta(baralho, maoJogador);
        distribuirCarta(baralho, maoComputador);
        distribuirCarta(baralho, maoJogador);
        distribuirCarta(baralho, maoComputador);

        // Mostra as cartas iniciais
        digita("\nSistema: Cartas do aventureiro -> " + maoJogador, TimeUnit.MILLISECONDS, temp);
        digita("\nSistema: Mão total do aventureiro -> " + calcularPontuacao(maoJogador), TimeUnit.MILLISECONDS, temp);
        digita("\nSistema: Carta do Guardião -> " + maoComputador.get(0), TimeUnit.MILLISECONDS, temp);

        // Jogo principal
        while (true) {
            // Vez do jogador
            digita("\n\nSistema: Escolha uma ação: " +
                    "\n\n(1) Pedir carta " +
                    "\n(2) Parar", TimeUnit.MILLISECONDS, temp);
            digita("\nEscolha: ", TimeUnit.MILLISECONDS, temp);
            int escolha = scanner.nextInt();

            if (escolha == 1) {
                distribuirCarta(baralho, maoJogador);
                digita("\nSistema: Cartas do aventureiro -> " + maoJogador, TimeUnit.MILLISECONDS, temp);
                int pontuacaoJogador = calcularPontuacao(maoJogador);
                digita("\nSistema: Mão total do aventureiro -> : " + pontuacaoJogador, TimeUnit.MILLISECONDS, temp);

                if (pontuacaoJogador > 21) {
                    digita("\nEdgar: Vish...", TimeUnit.MILLISECONDS, temp);
                    digita("\nGuardião de Pedra: Você ultrapassou 21! Você perdeu!", TimeUnit.MILLISECONDS, temp);
                    digita("\nGuardião de Pedra: Quer jogar mais uma?\n", TimeUnit.MILLISECONDS, temp);
                    digita("\nSistema: O que deseja fazer?\n" +
                            "\n(1) Jogar mais uma\n" +
                            "(2) Encerrar jogatina\n", TimeUnit.MILLISECONDS, temp);
                    digita("Escolha: ", TimeUnit.MILLISECONDS, temp);
                    byte digEscolha;
                    do {
                        Scanner input = new Scanner(System.in);
                        digEscolha = input.nextByte();

                        if (digEscolha == 1) {
                            vinteUm();
                        } else if (digEscolha == 2) {
                            digita("\nGuardião de Pedra: Acho que já podemos parar por aqui.\n", TimeUnit.MILLISECONDS, temp);
                            break;
                        } else {
                            digita("\n\nSistema: Resposta inválida!.\n", TimeUnit.MILLISECONDS, temp);
                            break;
                        }
                    } while (digEscolha != 1 && digEscolha != 2);
                    break;
                }
            } else if (escolha == 2) {
                while (calcularPontuacao(maoComputador) < 17) {
                    distribuirCarta(baralho, maoComputador);
                }
                digita("\nSistema: Cartas do Guardião -> " + maoComputador, TimeUnit.MILLISECONDS, temp);
                System.out.println("\nSistema: Mão total do Guardião -> " + calcularPontuacao(maoComputador));

                // Determina o vencedor
                int pontuacaoJogador = calcularPontuacao(maoJogador);
                int pontuacaoComputador = calcularPontuacao(maoComputador);

                if (pontuacaoJogador > 21 || (pontuacaoComputador <= 21 && pontuacaoComputador >= pontuacaoJogador)) {
                    digita("\nEdgar: Ah, acho que-", TimeUnit.MILLISECONDS, temp);
                    digita("\nGuardião de Pedra: EU VENCI!!!", TimeUnit.MILLISECONDS, temp);
                    digita("\nGuardião de Pedra: Quer jogar mais uma?\n", TimeUnit.MILLISECONDS, temp);
                    digita("\nSistema: O que deseja fazer?\n" +
                            "\n(1) Jogar mais uma\n" +
                            "(2) Encerrar jogatina\n", TimeUnit.MILLISECONDS, temp);
                    digita("Escolha: ", TimeUnit.MILLISECONDS, temp);
                    byte digEscolha1;
                    do {
                        Scanner input = new Scanner(System.in);
                        digEscolha1 = input.nextByte();

                        if (digEscolha1 == 1) {
                            vinteUm();
                        } else if (digEscolha1 == 2) {
                            digita("\nGuardião de Pedra: Acho que já podemos parar por aqui.\n", TimeUnit.MILLISECONDS, temp);
                            break;
                        } else {
                            digita("\nSistema: Resposta inválida!.\n", TimeUnit.MILLISECONDS, temp);
                            break;
                        }
                    } while (digEscolha1 != 1 && digEscolha1 != 2);
                    break;
                } else {
                    digita("\nEdgar: Você venceu!!!", TimeUnit.MILLISECONDS, temp);
                    digita("\nGuardião de Pedra: Não fique se achando muito!", TimeUnit.MILLISECONDS, temp);
                    digita("\nQuer jogar mais uma?\n", TimeUnit.MILLISECONDS, temp);
                    digita("\nSistema: O que deseja fazer?\n" +
                            "\n(1) Jogar mais uma\n" +
                            "(2) Encerrar jogatina\n", TimeUnit.MILLISECONDS, temp);
                    digita("Escolha: ", TimeUnit.MILLISECONDS, temp);
                    byte digEscolha2;
                    do {
                        Scanner input = new Scanner(System.in);
                        digEscolha2 = input.nextByte();

                        if (digEscolha2 == 1) {
                            vinteUm();
                        } else if (digEscolha2 == 2) {
                            digita("\nGuardião de Pedra: Acho que já podemos parar por aqui.\n", TimeUnit.MILLISECONDS, temp);
                            break;
                        } else {
                            digita("\nSistema: Resposta inválida!.\n", TimeUnit.MILLISECONDS, temp);
                            break;
                        }
                    } while (digEscolha2 != 1 && digEscolha2 != 2);
                    break;
                }
            } else {
                digita("Sistema: Escolha inválida. Tente novamente.", TimeUnit.MILLISECONDS, temp);
            }
        }
    }

    private static List<String> inicializarBaralho() {
        List<String> baralho = new ArrayList<>();
        for (int i = 2; i <= 10; i++) {
            baralho.add(Integer.toString(i));
        }
        baralho.add("Valete");
        baralho.add("Dama");
        baralho.add("Rei");
        baralho.add("Ás");

        // Adiciona quatro conjuntos de cartas ao baralho
        List<String> baralhoCompleto = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            baralhoCompleto.addAll(baralho);
        }

        return baralhoCompleto;
    }

    private static void distribuirCarta(List<String> baralho, List<String> mao) {
        String carta = baralho.remove(0);
        mao.add(carta);
    }

    private static int calcularPontuacao(List<String> mao) {
        int pontuacao = 0;
        int ases = 0;

        for (String carta : mao) {
            if (carta.equals("Valete") || carta.equals("Dama") || carta.equals("Rei")) {
                pontuacao += 10;
            } else if (carta.equals("Ás")) {
                ases++;
            } else {
                pontuacao += Integer.parseInt(carta);
            }
        }

        for (int i = 0; i < ases; i++) {
            if (pontuacao + 11 <= 21) {
                pontuacao += 11;
            } else {
                pontuacao += 1;
            }
        }

        return pontuacao;
    }


    public static void nome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual seu nome?");
    }

    public static void menu() throws InterruptedException {
        //Menu principal do jogo
        Scanner scanner = new Scanner(System.in);
        int op;
        //Laço pra que a escolha esteja conforme as opções
        do {
            //menu
            System.out.println();
            digita("-------------MENU----------\n",TimeUnit.MILLISECONDS,temp);
            System.out.print("-                         -\n");
            digita("-      1 - Tutorial       -\n",TimeUnit.MILLISECONDS,temp);
            digita("-      2 -  Jogar         -\n",TimeUnit.MILLISECONDS,temp);
            digita("-      3 - Créditos       -\n",TimeUnit.MILLISECONDS,temp);
            digita("-      4 -  Sair          -\n",TimeUnit.MILLISECONDS,temp);
            System.out.print("-                         -\n");
            digita("---------------------------\n",TimeUnit.MILLISECONDS,temp);

            digita("Escolha uma opção: ", TimeUnit.MILLISECONDS,temp);
            op = scanner.nextInt();
            escolhaMenu(op);

        } while (op != 1 && op != 2 && op != 3 && op != 4);
    }


    public static void escolhaMenu(int op) throws InterruptedException {
        //Função que leva até as opções escolhidas
        switch (op) {
            case 1:
                digita("Você escolheu: Tutorial\n",TimeUnit.MILLISECONDS,temp);
                tutorial();
                break;
            case 2:
                digita("Você escolheu: Jogar\n",TimeUnit.MILLISECONDS,temp);
                jogar();
                break;
            case 3:
                digita("Você escolheu: Créditos\n",TimeUnit.MILLISECONDS,temp);
                creditos();
                break;
            case 4:
                digita("Saindo...\n",TimeUnit.MILLISECONDS,temp);
                digita("Aperte ENTER para jogar...\n",TimeUnit.MILLISECONDS,temp);
                proximo();
                menu();
                break;
        }
    }

    public static void tutorial() throws InterruptedException {
        //Tutorial do jogo
        int op;
        System.out.println();
        System.out.println("----------------------------\n");
        System.out.println("-        Tutorial          -\n");
        digita            ("-----------------------------\n",TimeUnit.MILLISECONDS,temp);
        digita("\nOlá, investigador, para que você não se sinta perdido nessa aventura\n" +
                "vou lhe passar algumas dicas e um breve contexto da história.\n",TimeUnit.MILLISECONDS,temp);
        digita("Você é um pesquisador a procura de um tesouro perdido. Seu destino são " +
                " os túneis subterrâneos da frança.\n",TimeUnit.MILLISECONDS,temp);
        digita("----------------------------\n",TimeUnit.MILLISECONDS,temp);
        digita("-          DICAS           -\n",TimeUnit.MILLISECONDS,temp);
        digita("----------------------------\n",TimeUnit.MILLISECONDS,temp);
        do {
            //Laço para que o jogador entenda como funciona a seleção de opções
            Scanner scanner = new Scanner(System.in);
            digita("\nDica 1: Para escolher suas ações digite o valor " +
                    "correspondente as opções dadas.\n",TimeUnit.MILLISECONDS,temp);
            digita("1 - Próxima dica\n2 - explicar novamente\n",TimeUnit.MILLISECONDS,temp);
            System.out.print("Escolha: \n");
            op = scanner.nextInt();
            if (op != 1 && op != 2) {
                digita("Digite um valor válido!\n",TimeUnit.MILLISECONDS,temp);
            }
        } while (op != 1);
        digita("\nDica 2: Sempre que as reticências (...) aparecerem você deve pressionar ENTER" +
                " para continuar...\n",TimeUnit.MILLISECONDS,temp);
        //fazer com que o jogador utilize e entenda a função
        proximo();
        digita("Boa, já está entendendo!\n",TimeUnit.MILLISECONDS,temp);
        System.out.println();
        digita("Os desafios que você encontrará no caminho são sobre matematica, sendo " +
                " alguns deles questões de múltipla escolha,\nenquanto outros você deverá selecionar valores" +
                " sorteados aleatoriamente, e escrever o total.\n",TimeUnit.MILLISECONDS,temp);
        digita("Para selecionar a opção serão dados alternativas de 1 a 4...\n",TimeUnit.MILLISECONDS,temp);
        //fazer com que o jogador utilize e entenda a função
        proximo();
        digita("Para cada teste, você terá 2 tentativas para acertar.\n",TimeUnit.MILLISECONDS,temp);
        digita("Caso acerte, o jogo seguirá normalmente. Em caso de falha\n" +
                "será mostrado o aviso 'Você falhou!', junto a resposta do desafio...\n",TimeUnit.MILLISECONDS,temp);
        //fazer com que o jogador utilize e entenda a função
        proximo();
        digita("Muito bem, você terminou o tutorial, daqui pra frente é por sua conta!\n",TimeUnit.MILLISECONDS,temp);
        digita("Lembre-se, caso precise você sempre terá acesso ao tutorial pelo menu inicial.\n",TimeUnit.MILLISECONDS,temp);
        digita("Então caro investigador, agora que você já sabe como as coisas funcionam por aqui, " +
                "venha conhecer um novo mundo!\n",TimeUnit.MILLISECONDS,temp);
        digita("--------APERTE ENTER--------\n",TimeUnit.MILLISECONDS,temp);
        //última demonstração da função
        proximo();
        menu();
    }


    public static void jogar() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //Inicia a apresentação do jogo
        System.out.println("Bem vindo a UNDER THE LIGHTS");
        System.out.println("Para começarmos, me diga, como devo chama-lo?:");
        //Deixa o usuario livre para escolher seu nome
        String nome = scanner.nextLine();
        //passa o nome para a função
        capitulo1(nome);
    }

    public static void capitulo1(String nome) throws InterruptedException {
        //a Função já está recebendo o nome pré estabelecido
        Scanner entrada = new Scanner(System.in);
        digita("Bem vindo \n" + nome,TimeUnit.MILLISECONDS, temp);
        byte escolha;
        byte escolha2;
        byte escolha3;


        digita("\nParis, França \nEsse é o local que você está! Seu destino? As catacumbas da cidade…\n",TimeUnit.MILLISECONDS, temp);
        digita("Diversas pessoas caminham pela cidade alegremente, de forma comum,\nporém duas pessoas em específico chamam sua atenção", TimeUnit.MILLISECONDS, temp);
        System.out.println("Eles aparentam ser pesquisadores, andando com grandes bolsas e ferramentas");
        System.out.println("Você chega perto e decide falar com eles");
        proximo();
        System.out.println("\n\nEscolha o que você deseja perguntar");
        digita("\n\n1- Olá, por acaso vocês poderiam me ajudar?", TimeUnit.MILLISECONDS, temp);
        digita("\n2- Ei. É… Eu gostaria de perguntar uma coisa.\n ", TimeUnit.MILLISECONDS, temp);
        escolha = entrada.nextByte();
        proximo();

        switch (escolha) {
            case 1:
                break;
            case 2:
                break;
            default:
                System.out.println("\nEscolha uma opção válida!\n\n");
                break;
        }
        proximo();

        System.out.println("\n\n -------- Apresentando os Personagens -------- \n\n");
        System.out.println("\n- Osmar, é um homem negro que possui\n cabelos encaracolados e grisalhos. Parece ter por volta de 50 anos. \n Sua característica mais chamativa certamente é sua altura,\n que parece chegar facilmente aos 1.9O. de altura\n Osmar tem um grande número de cicatrizes pelo corpo, \n parece já ter passado por muito na vida.\n");
        System.out.println("\nJunto dele tem uma mulher presente \n- Mika é uma  branca de cabelos cacheados e pretos,\n aparenta estar na casa dos 40 anos. E apesar de ser baixinha,\n Mika é uma mulher centrada e com muitas capacidades de exploração.\n Todos esses anos em que vivenciou suas aventuras, fizeram a \n ficar muito forte e atenta a todos os sinais de perigo ao seu redor.");
        System.out.println("\n\n-------- Fim das Apresentações --------\n\n");
        proximo();

        digita("\n\nOsmar olha para você e diz...", TimeUnit.MILLISECONDS, temp);
        digita("\nClaro que sim, aliás, sou Osmar e essa minha companheira, Mika.\nEla sorri de forma amigável.\n Me diga o que precisa?\n", TimeUnit.MILLISECONDS, temp);


        System.out.println("\n\nEsoclha uma das alternativas:\n");
        digita("\n\n1- Eu gostaria de ir até as catacumbas, sabe como chegar?", TimeUnit.MILLISECONDS, temp);
        digita("\n2- Quero conhecer os túneis, poderiam me mostrar a entrada?\n ", TimeUnit.MILLISECONDS, temp);

        do {
            escolha2 = entrada.nextByte();
            switch (escolha2) {
                case 1:
                    break;
                case 2:
                    break;
                default:

            }
        } while (escolha2 != 1 && escolha2 != 2);

        proximo();
        System.out.println("\nOsmar responde:\n");
        digita("\nClaro, te mostro o caminho, mas o resto é contigo. Se quiser, vamos agora\n", TimeUnit.MILLISECONDS, temp);
        System.out.println("\nVocê segue eles.");
        digita("\nSeguindo Mika e Osmar, eles te levam a uma antiga ferrovia da cidade, abrem uma porta e dizem:\n", TimeUnit.MILLISECONDS, temp);
        digita("\nMika e Osmar: “Bom. Só vamos até aqui. Boa sorte com o que você está procurando.\n", TimeUnit.MILLISECONDS, temp);
        System.out.println("\nE antes que você possa falar tchau, eles desaparecem atrás de você.\n");
        System.out.println("\nEnquanto você caminha sozinho no escuro apenas com uma lanterna\ne sua bolsa com algumas ferramentas básicas\nvocê escuta alguma voz lhe chamando..." +
                "\n");
        proximo();

        digita("\n(?)Olá " + nome + " , o que faz aqui?\n", TimeUnit.MILLISECONDS, temp);
        digita("\n 1- Olá?", TimeUnit.MILLISECONDS, temp);
        digita("\n 2- OI… quem é?", TimeUnit.MILLISECONDS, temp);
        digita("\n 3-Seguir em frente\n", TimeUnit.MILLISECONDS, temp);

        escolha3 = entrada.nextByte();
        switch (escolha3){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("\nEscolha uma opção válida!\n\n");
                break;
        }
        proximo();
        System.out.println("\n Você segue em frente, sua lanterna começa a piscar e sem perceber o\n chão abaixo se abre e você cai de uma altura de +/- 2 metros.\n");
        System.out.println("\nOlhando em volta você apenas vê paredes com algumas aranhas\ne baratas caminhando nela.");
        digita("\nNessa “sala” há dois túneis, um do seu lado direito e o outro do lado esquerdo", TimeUnit.MILLISECONDS, temp);
        digita("\n\nEscolha o túnel",TimeUnit.MILLISECONDS, temp);
        digita("\n 1- Túnel da Direita", TimeUnit.MILLISECONDS, temp);
        digita("\n 2- Túnel da Esquerda", TimeUnit.MILLISECONDS, temp);
        int op = entrada.nextInt();
        if(op == 1) {
            escolhaEsq(nome);
        }else if(op == 2){
            escolhaDir(nome);
        }
    }

    public static void capitulo2(String nome) throws InterruptedException {
        int resposta1, desafio1, escolhaDesafio2, resp2op3 = 0;

        Scanner menu = new Scanner(System.in);

        digita("Narrador: Seguindo o que o Edgar disse, Você continua em frente.\n " +
                "E acaba se deparando com uma sala misteriosa, iluminada por uma luz fraca. No centro da sala, havia uma escrita enigmática em uma pedra antiga: \n" +
                "Edgar: Entenda jovem aventureiro, nesse lugar a matemática domina, e tudo envolve cálculo...\n", TimeUnit.MILLISECONDS, temp);
        proximo();

        digita("Você pode optar sempre por não responder a pergunta, mas saiba que sempre estarei por perto para te ajudar, basta você falar dica\n", TimeUnit.MILLISECONDS, temp);

        // DESAFIO 1
        digita("Vamos ao primeiro desafio, por acaso você conhece sobre Polinómios?...", TimeUnit.MILLISECONDS, temp);
        digita(" 1 - Sim.\n" +
                " 2 - Não.\n" +
                " 3 - Sim, porém não lembro.\n", TimeUnit.MILLISECONDS, temp);

        int pergunta1 = menu.nextInt();

        switch (pergunta1) {
            case 1:
                digita("Sim.\n", TimeUnit.MILLISECONDS, temp);
                break;
            case 2:
                digita("Não.", TimeUnit.MILLISECONDS, temp);
                digita("Edgar: Bom, deixa eu te explicar um pouco, em um polinómio há três termos: \n" +
                        "A = termos que acompanham x²\n" +
                        "B = Termos que acompanham x;\n" +
                        "C = Algarismos que não acompanham um valor de X.\n", TimeUnit.MILLISECONDS, temp);
                break;
        }

        digita("Narrador: Bom, então vamos lá.\n" +
                "Para avançar em sua busca, você deve decifrar o enigma do polinómio mágico.\n" +
                "Responda corretamente e o caminho se abrirá diante de você...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("A escrita então se revelou a seguinte equação polinomial: \n", TimeUnit.MILLISECONDS, temp);
        // Desafio 1
        digita("2x² + 4x + 3 + 4x² – 2x + 4\n", TimeUnit.MILLISECONDS, temp);

        do {
            int tentativas = 0;

            digita("Caso a resposta esteja correta, a parede em frente se abrirá, dando passagem para que você possa seguir em frente...\n", TimeUnit.MILLISECONDS, temp);
            proximo();
            digita("1)  6x² - 2x + 7\n" +
                    "2)  6x² + 2x - 7\n" +
                    "3)  6x² + 2x + 7\n" +
                    "4) Dica\n", TimeUnit.MILLISECONDS, temp);

            desafio1 = menu.nextInt();
            tentativas++;

            switch (desafio1) {
                case 1:
                    digita("Resposta errada!\n", TimeUnit.MILLISECONDS, temp);
                    break;
                case 2:
                    digita("Resposta errada!\n", TimeUnit.MILLISECONDS, temp);
                    break;
                case 3:
                    digita("Resposta certa!\n", TimeUnit.MILLISECONDS, temp);
                    acertos++;
                    if (tentativas == 1) {
                        digita("Sistema: Parabéns! Você acertou na primeira tentativa e ganhou um ponto para dicas.\n", TimeUnit.MILLISECONDS, temp);
                    } else {
                        digita("Sistema: Você acertou após " + tentativas + " tentativas.\n", TimeUnit.MILLISECONDS, temp);
                        digita("Não foram debitados pontos para dicas.\n\n", TimeUnit.MILLISECONDS, temp);
                    }
                    break;
                case 4:
                    if (acertos > 0) {
                        digita("Dica: Primeiro some os termos independentes, depois combine os termos semelhantes.\n", TimeUnit.MILLISECONDS, temp);
                        acertos--;
                    } else {
                        digita("Você não possui pontos para dicas no momento.\n", TimeUnit.MILLISECONDS, temp);
                    }
                    break;
                default:
                    digita("Opção Inválida!\n", TimeUnit.MILLISECONDS, temp);
                    break;
            }
        } while (desafio1 != 3);


        digita("\n" +
                "Narrador: Quando essa porta se abre o jogador vê em sua frente um enorme salão dourado.\n" +
                " a impressão é de que ele tenha saído desse universo, e entrado em uma cidade medieval...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("O salão é enorme e está em ruínas, aparentemente diversos saques e guerras aconteceram nesse local.\n" +
                "Ao final da sala uma enorme cadeira, na qual com certeza não foi projetada para um ser humano se sentar...\n", TimeUnit.MILLISECONDS, temp);
        proximo();

        digita("Você pergunta:  \n" +
                "1 - Edgar, que lugar é esse?\n" +
                "2 - Uau, o que está rolando aqui?\n", TimeUnit.MILLISECONDS, temp);

        int pergunta2 = menu.nextInt();

        switch (pergunta2) {
            case 1:
                digita("1 - “Então " +nome+ ", como eu posso explicar…\n", TimeUnit.MILLISECONDS, temp);
                proximo();
                digita("Esse é o lugar onde o mundo começou, ou seja, aqui é o lugar onde eu nasci.\n" +
                        "Quero dizer que, número, letras, palavras e tudo que você conhece começou aqui...\n", TimeUnit.MILLISECONDS, temp);
                proximo();
                digita("Você pode conhecer como “cidade perdida” ou até “centro da terra”, mas o verdadeiro nome é “Monde”\n", TimeUnit.MILLISECONDS, temp);
                break;

            case 2:
                digita("2 - An? Ah, você chegou ao salão principal. Bom aqui é o lugar onde seu desafio começa.\n" +
                        " Esse é o lugar onde o mundo começou, ou seja, aqui é o lugar onde eu nasci.\n" +
                        "Quero dizer que, número, letras, palavras e tudo que você conhece começou aqui...\n", TimeUnit.MILLISECONDS, temp);
                proximo();
                digita("Você pode conhecer como “cidade perdida” ou até “centro da terra”, mas o verdadeiro nome é “Monde” ...\n", TimeUnit.MILLISECONDS, temp);
                proximo();
                break;

            default:
                digita("Opção Invalida!\n", TimeUnit.MILLISECONDS, temp);
                break;
        }

        digita("Edgar: Olhe em volta jovem, tudo aqui é feito do mais puro ouro, há algo mais perfeito do que isso? ...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("Você diz para Edgar: Que interessante, mas...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("1 - “Centro da terra? Monde? Dá pra explicar melhor?”\n" +
                "2 - “Ok, Edgar. Então aqui é o centro da criação?”\n", TimeUnit.MILLISECONDS, temp);

        int pergunta3 = menu.nextInt();

        switch (pergunta3) {
            case 1, 2:
                digita("Edgar apenas olhe para você e segue em frente\n" +
                        "“Relaxa, você vai entender melhor”\n", TimeUnit.MILLISECONDS, temp);
                break;

            default:
                digita("Opção Invalida!\n", TimeUnit.MILLISECONDS, temp);
        }
        digita("Um enorme som ecoa na sala, grandes muros se erguem e revelam diferentes valores.\n" +
                "Edgar: Bom aqui está outro desafio para você...\n", TimeUnit.MILLISECONDS, temp);
        proximo();

        // DESAFIO 2
        digita("Saindo do grande salão vc percebe que as paredes estão diferentes. o que antes eram paredes rochosas, apertadas e escuras,\n" +
                " pouco a pouco tornam-se paredes feitas de uma rocha branca, que lembra muito mármore...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("O corredor começa a se tornar mais uniforme, não há mais tantos buracos no chão,\n" +
                " as paredes se mantêm com um toque delicado de mármore.\n" +
                "Caminhando mais e mais, com o que parece ser um corredor sem fim, logo a frente um feixe de luz se forma...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("Qual ação devo tomar...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("1 - Correr em direção a luz\n" +
                "2 - Continuar andando\n" +
                "3 - parar e analisar o local\n", TimeUnit.MILLISECONDS, temp);

        int pergunta4 = menu.nextInt();

        switch (pergunta4) {
            case 1:
                digita("Ao correr em direção a luz, acreditando ser a saída o jogador acaba tropeçando em um fio que abre um alçapão\n" +
                        " você começa a descer o que parece ser propositalmente um escorregador, ao chegar no final você se sente em uma espécie de colchão d´água.\n", TimeUnit.MILLISECONDS, temp);
                break;
            case 2:
                digita("Ao continuar andando em direção a luz, chegando perto desse feixe de luz você se descuida um pouco,\n" +
                        " e o que aparenta ser uma parte do piso é uma placa, ao pisar nessa placa o chão se abre e você começa a descer\n" +
                        " o que parece ser propositalmente um escorregador, ao chegar no final vc se sente em uma espécie de colchão d´água.\n", TimeUnit.MILLISECONDS, temp);
                break;
            case 3:
                digita("Analisando em volta você percebe uma espécie de chão falso, entende que se pisar ali algo irá acontecer.\n" +
                        " O feixe de luz aparenta vir de um buraco na parede que não leva a saída e sim a outro lugar\n", TimeUnit.MILLISECONDS, temp);
                break;
            default:
                digita("Resposta invalida.", TimeUnit.MILLISECONDS, temp);
                break;
        }
        if (pergunta4 == 3) {
            digita("chegando nesse outro lugar, você terá duas opções: ", TimeUnit.MILLISECONDS, temp);
            digita("1- tentar contornar o chão falso\n" +
                    "2- Procurar outro jeito.\n", TimeUnit.MILLISECONDS, temp);

            int respOp3 = menu.nextInt();

            switch (respOp3) {
                case 1:
                    digita("Você consegue contornar o chão falso e chegar até o buraco na parede, olhando o que vem através dele\n" +
                            " não consegue entender direito o que acontece ali, alguns vultos passam rapidamente e ofuscam seu entendimento.\n", TimeUnit.MILLISECONDS, temp);
                    break;

                case 2:
                    digita("Olhando em volta novamente, apenas vê o caminho no qual vc veio e paredes de mármore sem nada diferente.\n", TimeUnit.MILLISECONDS, temp);
                    break;

                default:
                    digita("Opção Invalida.\n", TimeUnit.MILLISECONDS, temp);
                    break;
            }
        }

        do {
            digita("Sem saber o que fazer, terá duas opções: \n", TimeUnit.MILLISECONDS, temp);
            proximo();
            digita("1- Entrar no chão falso\n" +
                    "2- Perguntar a Edgar o que fazer\n", TimeUnit.MILLISECONDS, temp);
            resp2op3 = menu.nextInt();

            switch (resp2op3) {
                case 1:
                    digita("Ao pisar nessa placa o chão se abre e você começa a descer\n" +
                            " o que parece ser propositalmente um escorregador, ao chegar no final vc se sente em uma espécie de colchão d´agua.\n", TimeUnit.MILLISECONDS, temp);
                    break;

                case 2:
                    digita("Olá jovem, eu não sei exatamente se posso te dizer o que fazer, mas vamos, tenha coragem.\n", TimeUnit.MILLISECONDS, temp);
                    break;

                default:
                    digita("Opção Invalida.\n", TimeUnit.MILLISECONDS, temp);
                    break;
            }
        } while (resp2op3 != 1);

        digita("Narrador: Enquanto está deitado no colchão d'água, uma mensagem misteriosa aparece em uma placa próxima: \n", TimeUnit.MILLISECONDS, temp);
        digita("Para avançar, resolva o seguinte polinômio: ...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("4x³ - 2x² + 5x - 3\n", TimeUnit.MILLISECONDS, temp);

        do {
            int tentativas = 0;
            digita("Caso a resposta esteja correta, a parede em frente se abrirá, dando passagem para que você possa seguir em frente...\n", TimeUnit.MILLISECONDS, 50);
            proximo();
            digita("1)  2x³ + 3x² - 2x - 1\n" +
                    "2)  4x³ - x² + 5x - 3\n" +
                    "3)  4x³ - 2x² + 5x + 3\n" +
                    "4) Dica\n", TimeUnit.MILLISECONDS, 50);

            escolhaDesafio2 = menu.nextInt();
            tentativas++;

            switch (escolhaDesafio2) {
                case 1:
                    digita("Infelizmente, a resposta está incorreta. O colchão d'água parece ficar mais agitado, mas nada acontece...\n", TimeUnit.MILLISECONDS, temp);
                    proximo();
                    break;
                case 2:
                    digita("Parabéns! Você resolveu o desafio. A parede se abre, revelando um novo caminho...\n", TimeUnit.MILLISECONDS, temp);
                    proximo();
                    if (tentativas == 1) {
                        digita("Sistema: Você acertou na primeira tentativa! Excelente!\n", TimeUnit.MILLISECONDS, temp);
                        digita("Foram debitados pontos de dicas no seu score.", TimeUnit.MILLISECONDS, temp);
                    } else {
                        digita("Sistema: Você acertou após " + tentativas + " tentativas.\n", TimeUnit.MILLISECONDS, temp);
                        digita("Não foram debitados pontos para dicas.\n\n", TimeUnit.MILLISECONDS, temp);
                    }
                    break;
                case 3:
                    digita("Infelizmente, a resposta está incorreta. O colchão d'água parece ficar mais agitado, mas nada acontece...\n", TimeUnit.MILLISECONDS, temp);
                    proximo();
                    break;
                case 4:
                    if (acertos > 0) {
                        digita("Considere agrupar termos e aplicar fatoração por grupos para simplificar o polinômio\n", TimeUnit.MILLISECONDS, temp);
                        acertos--;
                    }
                    else digita("Sistema: Você não tem score de dicas o suficiente.", TimeUnit.MILLISECONDS, temp );
                    break;
                default:
                    digita("Opção inválida.\n", TimeUnit.MILLISECONDS, temp);
                    break;
            }
        } while (escolhaDesafio2 != 2);



        digita("Narrador: Ao sair do colchão e atravessar o muro que se abriu em sua frente, seus olhos doem com o intenso brilho que é mostrado...\n" +
                " Diante dos seus olhos vc se depara com um “novo mundo”...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("Seres místicos voam sobre sua cabeça, elfos brincam na cidade\n" +
                " e o que parece ser um enorme castelo está acentuado no meio disso tudo, emitindo uma intensa luz...\n", TimeUnit.MILLISECONDS, temp);
proximo();

        capitulo3(nome);

    }


    public static void capitulo3(String nome) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int resposta, resposta1, resposta2, resposta3;

        digita("Narrador: Na sua frente há uma enorme passarela que leva diretamente a esse castelo. " +
                "A passarela tem as cores do arco-íris.\n", TimeUnit.MILLISECONDS, temp);
        digita("Edgar sai na frente, percorrendo a passarela e analisando tudo em volta.\n",
                TimeUnit.MILLISECONDS, temp);
        do {
            digita("\nSistema: Qual ação você deseja tomar?\n\n", TimeUnit.MILLISECONDS, temp);
            digita("(1) 'Edgar, que lugar é esse?'\n" +
                    "(2) 'Onde estamos?'\n" +
                    "(3) Seguir Edgar.\n", TimeUnit.MILLISECONDS, temp);
            System.out.print("Escolha: ");
            resposta = input.nextByte();
            switch (resposta) {
                case 1:
                    digita("\nEdgar: Hã? Ah... sim... as vezes eu esqueço que você é de fora. Bom, aqui... ", TimeUnit.MILLISECONDS, temp);
                    proximo();
                    digita("é o começo de tudo? Acho que posso dizer assim.\n", TimeUnit.MILLISECONDS, temp);
                    break;
                case 2:
                    digita("\nEdgar: Ué, estamos no começo de tudo! Onde mais estaríamos?\n", TimeUnit.MILLISECONDS,
                            temp);
                    break;
                case 3:
                    break;
                default:
                    digita("\nSistema: Opção Invalida.\n", TimeUnit.MILLISECONDS, temp);
            }
        } while ((resposta != 1) && (resposta != 2) && (resposta != 3));

        if (resposta == 1 || resposta == 2) {
            do {
                digita("\nSistema: Qual ação você deseja tomar?\n", TimeUnit.MILLISECONDS, temp);
                digita("\n(1) 'Ok... e o que seria esse começo de tudo?'\n" +
                        "(2) Seguir Edgar.\n", TimeUnit.MILLISECONDS, temp);
                System.out.print("Escolha: ");
                resposta1 = input.nextByte();
                switch (resposta1) {
                    case 1:
                        digita("\nEdgar: Bom, o começo de tudo... é onde tudo começou..."
                                , TimeUnit.MILLISECONDS, temp);
                        proximo();
                        digita("o planeta, pessoas, animais, plantas... e até eu. Vamos, no castelo" +
                                " eu te explico tudo.\n", TimeUnit.MILLISECONDS, temp);
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("\nSistema: Opção Invalida.\n");
                        break;
                }

            } while (resposta1 != 1 && resposta1 != 2);
        }

        digita("\nNarrador: Seguindo Edgar em direção ao castelo, o jogador começa a perceber que o castelo é " +
                "totalmente dourado, tem um brilho intenso, como se fosse ouro.\n", TimeUnit.MILLISECONDS, temp);
        digita("O castelo tem um enorme portão, e ao lado há uma tabuleta de madeira com uma faca.\n",
                TimeUnit.MILLISECONDS,
                temp);
        digita("\nEdgar: Eita, não esperava por isso. Bom então aqui é o início do segundo desafio. Vejamos...\n",
                TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("Narrador: Edgar sopra sobre a tabuleta com uma espécie de pó, que pouco a pouco forma o desafio.\n",
                TimeUnit.MILLISECONDS,
                temp);
        digita("\nEscrita da tabuleta: Para por aqui continuar, um enigma matemático terá de acertar...\n",
                TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("x^2 - 6x + k\n\n", TimeUnit.MILLISECONDS, temp);
        digita("Nessa equação, a chave achará, desvende-a e acesso ao grande castelo o concederá.\n",
                TimeUnit.MILLISECONDS, temp);

        do {
            digita("\nSistema: O que deseja fazer?\n", TimeUnit.MILLISECONDS, 50);
            digita("\n(1) Talhar a resposta na tabuleta.\n" +
                    "(2) Pedir ajuda a Edgar\n", TimeUnit.MILLISECONDS, 50);
            System.out.print("Escolha: ");
            resposta2 = input.nextInt();

            switch (resposta2) {
                case 1:
                    int respDesafio2;
                    int tentativas = 0;

                    do {
                        tentativas++;
                        digita("\nInsira a resposta do desafio: ", TimeUnit.MILLISECONDS, temp);
                        respDesafio2 = input.nextInt();

                        if (respDesafio2 == 9) {
                            if (tentativas == 1) {
                                digita("\nSistema: Parabéns! Você acertou na primeira tentativa e ganhou um ponto para dicas.\n",
                                        TimeUnit.MILLISECONDS, temp);
                                acertos++;
                            } else {
                                digita("\nSistema: Você acertou após " + tentativas + " tentativas.\n",
                                        TimeUnit.MILLISECONDS, temp);
                                digita("Não foram debitados pontos para dicas.\n", TimeUnit.MILLISECONDS, temp );
                            }
                        } else {
                            digita("\nNarrador: Nada acontece, a porta não se mexe nem mesmo um centímetro.\n"
                                    + "\nEdgar: Acho que não é essa a resposta...\n", TimeUnit.MILLISECONDS, temp);
                        }
                    } while (respDesafio2 != 9);

                    break;
                case 2:
                    if (acertos > 0) {
                        digita("\nEdgar: Utilize a fórmula de Bhaskara, acho que dessa forma podemos descobrir qual \n" +
                                        "número colocar no lugar de k para que 'b^2 - 4ac' seja um quadrado perfeito.\n"
                                , TimeUnit.MILLISECONDS, temp);
                        acertos--;
                        break;
                    } else {
                        digita("\nEdgar: Acho que não consigo te ajudar dessa vez carinha.\n"
                                , TimeUnit.MILLISECONDS, temp);
                    }
                    break;
                default:
                    System.out.println("\nSistema: Opção Invalida.");
            }
        } while (resposta2 != 1);

        digita("\nNarrador: Após talhar a resposta correta na tabuleta a porta finalmente se abre.\n"
                , TimeUnit.MILLISECONDS, temp);
        digita("\nEdgar: É isso! Vamos entrar, você tem que ver tudo por aqui!\n", TimeUnit.MILLISECONDS, temp);
        digita("\nNarrador: Ao entrar no castelo há um enorme hall, com enormes pinturas que iam de " +
                "sistemas numéricos antigos \naté calculadoras e computadores atuais\n", TimeUnit.MILLISECONDS, temp);
        digita("\nEdgar: Há, sim.. Bom, como eu disse aqui é o começo de tudo e isso aqui é o que temos " +
                "mais orgulho...", TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("O nosso criador, fez com que todos os povos tenham conhecimentos, porém demorou \num pouco para " +
                        "chegarmos onde estamos, porém tem um que acertamos \nem cheio e diversas pessoas ainda usam, é esse aqui:\n"
                , TimeUnit.MILLISECONDS, temp);
        digita("\nNarrador: Edgar mostra uma foto de um objeto com diversas bolas ao redor que ao " +
                "mexer elas podemos chegar a um determinado valor.\n", TimeUnit.MILLISECONDS, temp);
        digita("\nEdgar: Você conhece esse aqui?\n", TimeUnit.MILLISECONDS, temp);
        do {
            digita("\nSistema: O que deseja fazer?\n", TimeUnit.MILLISECONDS, temp);
            digita("\n(1) 'SIM, é um ábaco né?'\n" +
                    "(2) 'Olha! Parece um instrumento musical.'\n" +
                    "(3) 'Um... Brinquedo para crianças?'\n", TimeUnit.MILLISECONDS, temp);
            System.out.print("\nEscolha: ");
            resposta3 = input.nextByte();
            switch (resposta3) {
                case 1:
                    digita("\nEdgar: Isso mesmo! Você é inteligente.\n", TimeUnit.MILLISECONDS, temp);
                    break;
                case 2:
                case 3:
                    digita("\nNah... ", TimeUnit.MILLISECONDS, temp);
                    proximo();
                    digita("na verdade é um ábaco, mas sem problemas!\n", TimeUnit.MILLISECONDS, temp);
                    break;
                default:
                    digita("\nSistema: Opção Invalida.\n", TimeUnit.MILLISECONDS, temp);
            }
        } while (resposta3 != 1 && resposta3 != 2 && resposta3 != 3);
        digita("\nNarrador: Seguindo em frente no enorme castelo dá se ver diversos elfos com livros conversando " +
                "uns com os outros.\n", TimeUnit.MILLISECONDS, temp);
        digita("Uma enorme porta está em frente de vocês agora, uma enorme porta para o que aparenta ser para " +
                "um ser enorme passar.\n", TimeUnit.MILLISECONDS, temp);
        digita("\nEdgar: Olha só, vamos entrar na sala do criador. Por favor, mantenha o respeito " +
                "com ele.\n", TimeUnit.MILLISECONDS, temp);
        digita("Só temos que falar com o guardião antes. Aliás, você sabe jogar cartas?\n"
                , TimeUnit.MILLISECONDS, temp);
        digita("\n!!! BOOOOOM !!!\n", TimeUnit.MILLISECONDS, temp);
        digita("\nNarrador: Antes que você possa responder a porta a frente de voces se abre com um intensa " +
                "força,\nrevelando um grande ser, seu rosto é revestido com pedras, " +
                "diversos amuletos estão em seu braço,\ncom números e operações escritas, " +
                "Em seu cinturão há um enorme baralho feito de um tipo de mármore.\n", TimeUnit.MILLISECONDS, temp);
        digita("\nGuardião de Pedra: Edgar, o que você está fazendo aqui? Eu já falei," +
                " não traga humanos para cá!\n", TimeUnit.MILLISECONDS, temp);
        digita("\nEdgar: Calma aí Pedroso, esse aqui é diferente. Ele está querendo voltar, " +
                "entrou aqui por engano.\n", TimeUnit.MILLISECONDS, temp);
        digita("\nGuardião de Pedra: Bom, você sabe as regras. Para voltar tem que me ganhar, " +
                "no meu jogo.\n", TimeUnit.MILLISECONDS, temp);
        digita("\nEdgar: Ok, eu vou explicar como funciona.\n\n", TimeUnit.MILLISECONDS, temp);

        // Explicação das regras do 21
        digita("======== Regras do Jogo ========", TimeUnit.MILLISECONDS, temp);
        digita("\n\nO objetivo do jogo é ter uma mão de cartas com um valor total mais próximo de 21\ndo que" +
                " a mão do dealer (a casa), sem ultrapassar 21.\n", TimeUnit.MILLISECONDS, temp);
        digita("As cartas de 2 a 10 valem seu valor normal.\n", TimeUnit.MILLISECONDS, temp);
        digita("As cartas de face (valete, rainha e rei) valem 10 pontos cada.\n", TimeUnit.MILLISECONDS, temp);
        digita("As cartas de Ás podem valer 1 ou 11 pontos, dependendo da situação. " +
                "O jogador decide o valor do Ás.\n", TimeUnit.MILLISECONDS, temp);
        digita("\nGuardião de Pedra: Ok, agora que sabe as regras...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("Vamos começar o jogo!\n", TimeUnit.MILLISECONDS, temp);
        vinteUm();

        digita("\nGuardião de Pedra: É pequenino, foi divertido.\n", TimeUnit.MILLISECONDS, temp);
        digita("Como agradecimento pela jogatina, vou levá-los ao Criador.\n", TimeUnit.MILLISECONDS, temp);
        digita("\nNerrador: O guardião leva vocês até uma sala ao lado, um enorme trono está de costas para a porta, monitores " +
                "enormes estão ao redor da sala, \n", TimeUnit.MILLISECONDS, temp);
        digita("todos com diversas contas acontecendo, elfos fiscalizam e fazem anotações sobre tudo " +
                "que está sendo passado.\n", TimeUnit.MILLISECONDS, temp);
        digita("\nGuardião de Pedra: Criador, com licença. Temos um diferente.\n", TimeUnit.MILLISECONDS, temp);
        digita("\nNarrador: Dois elfos vão em direção a cadeira e começam a virá-la lentamente. Ao virar totalmente a cadeira é visto que... \n", TimeUnit.MILLISECONDS, temp);


        capitulo4(nome);
    }

    public static void capitulo4(String nome) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        //Primeiro momento do capitulo 4
        digita("    O criador se revela um ser imponente, misterioso e tanto quanto majestoso\n",TimeUnit.MILLISECONDS, temp);
        digita("ele usa um sobretudo preto e uma espécie de máscara que revela apenas seus olhos que brilham em dourado...",TimeUnit.MILLISECONDS, temp);
        proximo();
        System.out.println("");
        digita("Criador: Pedroso, Edgar... Me expliquem agora o motivo desse ser estar na minha sala!...",TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("Edgar: C-criador... até onde sei seu nome é " + nome + ", não sei exatamente como conseguiu entrar aqui, mas apenas quer voltar\n" +
                "para o povo lá de cima. Passamos por vários desafios para chegar até aqui, até ganhou do Pedroso...",TimeUnit.MILLISECONDS, temp);
        System.out.println("");
        proximo();
        digita("O criador olha para o gigante de pedra que faz um sinal de confirmação com a cabeça.",TimeUnit.MILLISECONDS, temp);
        //Sout utilizado para espaçãr os elementos
        System.out.println("");
        System.out.println("");
        digita("Criador: Muito bem, " + nome + ", já que você chegou até aqui, vou te explicar melhor o que está acontecendo.\n",TimeUnit.MILLISECONDS, temp);
        digita("Você está no coração do monde, o ínicio de tudo.\n",TimeUnit.MILLISECONDS, temp);
        digita("Eu sou responsável por criar, moldar e cuidar de todo o conhecimento, formulás de cálculos e todas as estruturas que envolver o universo...\n",TimeUnit.MILLISECONDS, temp);
        proximo();

        int a1;
        // primeira escolha do capitulo 4
        do {
            digita("1 - 'Ok, eu já sei, tudo é perfeito, bonito e completo. Quais são as formas de sair daqui?'\n", TimeUnit.MILLISECONDS, temp);
            digita("2 - 'Entendi, criador, apenas gostaria de saber mais, como você é? Tipo, como o Edgar existe, o motivo de eu estar aqui...\n", TimeUnit.MILLISECONDS, temp);

            System.out.print("R: ");
            a1 = scanner.nextInt();
            //não deixa digitar um valor diferente do pedido
            if (a1 != 1 && a1 != 2) {
                System.out.println("\nValor inválido.\n");
            }
        } while (a1 != 1 && a1 != 2);

        switch (a1) {
            case 1 -> {
                System.out.println("");
                digita("Criador: Bom, para que você saia, obviamente terá que passar por mais um desafio, nesse caso, será especialmente" +
                        " feito por mim!...\n", TimeUnit.MILLISECONDS, temp);
                proximo();
                break;
            }
            case 2 -> {
                System.out.println("");
                digita("Criador: Calma jovem, com tantas perguntas você vai acabar dividindo por zero...\n", TimeUnit.MILLISECONDS, temp);
                System.out.println("[Pedroso e Edgar riem]");
                digita("Criador: Vamos, o que você deseja saber?\n", TimeUnit.MILLISECONDS, temp);
                break;
            }
        }
        if (a1 == 1) {
            digita("'Claro, qual é o desafio?'\n", TimeUnit.MILLISECONDS, temp);
            System.out.println("");
            a1(nome);
        } else if (a1 == 2) {
            digita("\n'Quero saber um pouco mais sobre aqui'\n", TimeUnit.MILLISECONDS, temp);
        }
        digita("Criador: Bom, como você já sabe aqui é o monde, onde tudo foi criado",TimeUnit.MILLISECONDS, temp);
        System.out.println("");
        digita("Em um piscar de olhos o criador muda sua forma, assumindo uma aparência indentica a sua...",TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("\nCriador: Viu? " + nome + " eu posso ser você, Edgar ou até o Pedroso.\n" +
                " Eu nasci aqui e toda minha vida se resumiu em deixar tudo em perfeita ordem...",TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("- Não esqueça " + nome + " para tudo há diversas opções, desde que você entrou aqui seu único desejo é encontrar um tesouro e depois sair,\n",TimeUnit.MILLISECONDS, temp);
        digita("mas você já considerou ficar por aqui e quem sabe achar seu querido tesouro?...",TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("- Vai do seu coração e coragem.\n" +
                " Agora, vamos jogar!...\n",TimeUnit.MILLISECONDS, temp);
        proximo();

        int resp2;
        //segunda escolha do jogo
        do {
            digita("1-'Claro, vamos",TimeUnit.MILLISECONDS, temp);
            resp2 = scanner.nextInt();

            if (resp2 != 1 ){
                System.out.println("Valor inválido.");
            }
        }while (resp2 != 1);
        desafioFinal(nome);
    }

    public static void a1(String nome) throws InterruptedException {
        //começa a explicação do desafio
        Scanner scanner = new Scanner(System.in);
        int resp;
        do {
            digita("Criador: O desafio consiste no seguinte. Vou te passar 2 valores aleatorios, você deve escolher um desses valores" +
                    " depois disso será minha vez...", TimeUnit.MILLISECONDS, temp);
            proximo();
            digita("Dessa forma vamos gerar um lindo polinomio, responda corretamente e você saíra!...\n", TimeUnit.MILLISECONDS, temp);
            proximo();
            digita("Você entendeu?", TimeUnit.MILLISECONDS, temp);
            System.out.println("");
            digita("1- Sim\n2- Não\n", TimeUnit.MILLISECONDS, temp);
            resp = scanner.nextInt();

            if (resp != 1 && resp != 2) {
                System.out.println("Valor inválido!");
            }
        } while (resp != 1);
        desafioFinal(nome);
    }

    //inicia o desafio final
    public static void desafioFinal(String nome) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //gera valores aleatorios para a questão
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        int c = random.nextInt(20 + 2);

        //informa os valores
        digita("Foram gerados 2 valores aleatórios:\nA:" + a + "\nB:" + b+"\n",TimeUnit.MILLISECONDS, temp);
        digita("x^2 - x + C \n",TimeUnit.MILLISECONDS, temp);

        String opcaoEscolhida;


        //loop para que o desafio funcione e a escolha seja correta
        do {
            digita("\nEscolha qual valor será x^2: (A ou B)\n", TimeUnit.MILLISECONDS, temp);
            opcaoEscolhida = scanner.nextLine();

            if (!opcaoEscolhida.equalsIgnoreCase("a") && !opcaoEscolhida.equalsIgnoreCase("b")) {
                digita("Esta opção não é válida!\n", TimeUnit.MILLISECONDS, temp);
            }
        } while (!opcaoEscolhida.equalsIgnoreCase("a") && !opcaoEscolhida.equalsIgnoreCase("b"));

        //facilita a escolha utilizando o sistema com "?"
        String equacaoGerada = (opcaoEscolhida.equalsIgnoreCase("a"))
                ? a + "x^2 - " + b + "x + " + c
                : b + "x^2 - " + a + "x + " + c;

        digita("Você formou a seguinte equação... \n" + equacaoGerada, TimeUnit.MILLISECONDS, temp);
        proximo();
        //Gera valores aleatorios para o criador
        int x = random.nextInt(20) + 1;
        int y = random.nextInt(20) + 1;
        int z = random.nextInt(20) + 1;

        //informa os valores que o criador pegou
        digita("\nCriador: Bom, então essa será minha formação!...\n", TimeUnit.MILLISECONDS, temp);
        digita("-" + x + "x^2 + " + y + "x + " + z+"\n", TimeUnit.MILLISECONDS, temp);
        proximo();

        // mostra a forma final da questão se for escolhido a letra A
        if (opcaoEscolhida.equalsIgnoreCase("a")) {
            digita("\n" +
                    "Em sua frente os números flutam e formam seu último desafio!\n" +
                    a + "x^2 - " + b + "x + " + c + " - " + x + "x^2 + " + y + "x + " + z + "...\n", TimeUnit.MILLISECONDS, temp);
            proximo();
        }
        // mostra a forma final da questão se for escolhido a letra B
        if (opcaoEscolhida.equalsIgnoreCase("b")) {
            digita("\n" +
                    "Em sua frente se forma a seguinte equação!\n" +
                    b + "x^2 - " + a + "x + " + c + " - " + x + "x^2 + " + y + "x + " + z + "...\n", TimeUnit.MILLISECONDS, temp);
            proximo();
        }
        //Conta final de acordo com letra escolhida
        String resposta = (opcaoEscolhida.equalsIgnoreCase("a"))
                ? ((a - x)) + "x^2 " + sinal(-b + y) + " " + Math.abs(-b + y) + "x " + sinal(c + z) + " " + Math.abs(c + z)
                : ((b - x)) + "x^2 " + sinal(-a + y) + " " + Math.abs(-a + y) + "x " + sinal(c + z) + " " + Math.abs(c + z);


        ArrayList<String> opcoesErradas = new ArrayList<>();
        //contas erradas para fornercer a opção
        if (opcaoEscolhida.equalsIgnoreCase("a")) {
            opcoesErradas.add((a - x) + "x^2 " + sinal(b + y) + " " + Math.abs(b + y) + "x " + sinal(c - z) + " " + (c + z));
            opcoesErradas.add((a - x) + "x^2 " + sinal(b - y) + " " + Math.abs(b - y) + "x " + sinal(c + z) + " " + (c + z));
        } else {
            opcoesErradas.add((b - x) + "x^2 " + sinal(a + y) + " " + Math.abs(a + y) + "x " + sinal(c + z) + " " + (c + z));
            opcoesErradas.add((b - x) + "x^2 " + sinal(a - y) + " " + Math.abs(a - y) + "x " + sinal(c - z) + " " + (c + z));
        }

        Collections.shuffle(opcoesErradas);

        int tentativas = 0;
        boolean respostaCorreta = false;
        //faz com o que jogador escolha a opção de acordo com as opções dadas
        do {
            tentativas++;
            digita("\nEscolha uma opção. Tentativa " + tentativas + ":\n", TimeUnit.MILLISECONDS, temp);
            digita("A: " + opcoesErradas.get(0)+"\n",TimeUnit.MILLISECONDS, temp);
            digita("B: " + opcoesErradas.get(1)+"\n",TimeUnit.MILLISECONDS, temp);
            digita("C: " + resposta+"\n",TimeUnit.MILLISECONDS, temp);

            String resp = scanner.nextLine();

            if (resp.equalsIgnoreCase("c")) {
                digita("Resposta correta!\n",TimeUnit.MILLISECONDS, temp);
                respostaCorreta = true;
            } else {
                System.out.println("Resposta errada. Tente novamente.");
            }
        } while (!respostaCorreta && tentativas < 3);
        passou(nome);

    }
    //essa função faz com os sinais sejam colocador de forma correta
    private static String sinal(int valor) {
        return (valor >= 0) ? "+" : "-";
    }

    public static void passou(String nome) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        digita("Ao finalizar o desafio com êxito o criador te olha de forma orgulhosa",TimeUnit.MILLISECONDS, temp);
        System.out.println("");
        digita("Criador: Você foi bem "+ nome+ ". Demonstrou compreensão e habilidade...\n",TimeUnit.MILLISECONDS, temp);
        digita("Como eu disse, há sempre a opção de ficar por aqui e a opção de ir.\n",TimeUnit.MILLISECONDS, temp);

        int op;

        do {
            digita("1 - 'O que muda se eu ficar ou não?'\n",TimeUnit.MILLISECONDS, temp);
            op = scanner.nextInt();

            if (op != 1){
                System.out.println("Valor inválido");
            }
        }while (op != 1);

        digita("Bom, ficando aqui você terá acesso a conhecimentos diversos, porém se você sair tudo que você viu será completamente apagado\n",TimeUnit.MILLISECONDS, temp);
        digita("claro, o que você aprendeu será mantido, pois o conhecimento não se pode apagar!...\n",TimeUnit.MILLISECONDS, temp);
        digita("Me diga, o que deseja?\n",TimeUnit.MILLISECONDS, temp);

        int op2;
        do{
            digita("1- 'Eu quero ficar!\n",TimeUnit.MILLISECONDS, temp);
            digita("2- 'Obrigado por tudo, mas eu prefiro voltar ao meu mundo\n",TimeUnit.MILLISECONDS, temp);
            op2 = scanner.nextInt();


            if (op2 != 1 && op2 != 2){
                System.out.println("Valor inválido");
            }

            if (op2 == 1){
                ficar(nome);
            }else if (op2 == 2){
                sair(nome);
            }

        }while (op2 != 1 && op2 != 2);

    }

    public static void ficar(String nome) throws InterruptedException {
        digita("Ao escolher ficar os olhos do criador se tornam mais intensos, em um tom de felicidade",TimeUnit.MILLISECONDS, temp);
        System.out.println("");
        digita("Criador: Ótima escolha, venha me dê sua mão...\n",TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("Ao tocar a mão do criador você sente seu corpo leve, seus olhos se fecham e sua mente divaga em um cenário aconchegante e feliz\n",TimeUnit.MILLISECONDS, temp);
        digita("Você sente que agora tudo está resolvido, você encontrou o tesouro que procurava...\n",TimeUnit.MILLISECONDS, temp);
        proximo();
        digita(nome + " você acorda de repente em uma cama leve e macia, um chalé de madeira. Ao lado da cama está Edgar\n",TimeUnit.MILLISECONDS, temp);
        digita("Edgar: Você ficou, que legal. Bem vindo, essa é sua nova casa...\n",TimeUnit.MILLISECONDS, temp);
        proximo();
        fim();
    }


    public static void sair(String nome) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        digita("Criador: Claro eu entendo\n",TimeUnit.MILLISECONDS, temp);
        digita("Com um gesto de mão, o criador cria uma portal de luz em sua frente...\n",TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("Criador: Continue sua jornada " + nome+ ". Não esqueça, o conhecimento é o tesouro que você procura\n",TimeUnit.MILLISECONDS, temp);
        System.out.println("");
        digita("Ao atravessar a passagem você se vê na entrada das catacumbas, ali estão Mika e Osmar\n",TimeUnit.MILLISECONDS, temp);
        digita("Mika: Ei, "+nome+", encontrou o que queria?...",TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("Você sente uma intensa dor de cabeça e um leve flash de memoria 'Conhecimento é o tesouro que você procura\n",TimeUnit.MILLISECONDS, temp);

        int op;
        do {
            digita("1- 'Sim, com certeza encontrei!\n",TimeUnit.MILLISECONDS, temp);
            digita("2 - 'Sim! Conhecimento, era isso desde o começo\n",TimeUnit.MILLISECONDS, temp);
            op = scanner.nextInt();

            if (op != 1 && op != 2){
                System.out.println("Valor inválido");
            }
        }while (op != 1 && op != 2);

        digita("Mika e Osmar se entreolham, seus olhos dão um livre brilho em dourado\n",TimeUnit.MILLISECONDS, temp);
        digita("Osmar: Que legal, fico feliz que tenha aprendido, com certeza Edgar sentirá saudades...",TimeUnit.MILLISECONDS, temp);
        proximo();
        fim();


    }

    public static void fim() throws InterruptedException {
        digita("Obrigado por jogar, esperamos que tenha gostado",TimeUnit.MILLISECONDS, temp);
    }

    public static void escolhaDir(String nome) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        byte escolha4;
        byte dica;
        byte op2;

        digita("\n\nSeguindo o túnel da direita você vê que as paredes começam a mudar\n pouco a pouco, diversos símbolos vão aparecendo\n", TimeUnit.MILLISECONDS, temp);
        digita("\nMais a frente você se depara com uma enorme sala, cheia de vasos e\n esculturas de diferentes tamanhos e formas.\nAlguns vasos específicos contém grandes números desenhados neles (1; 8; 1.)", TimeUnit.MILLISECONDS, temp);
        digita("\nDo outro lado da sala há um portão com uma espécie de porteiro com\n senha pedindo três números. Ao lado desse porteiro há um papel com \numa frase escrita", TimeUnit.MILLISECONDS, temp);
        digita("\nPara passar pense em um valor menor que 120 e maior que 110\n", TimeUnit.MILLISECONDS, temp);


        String respostaCorreta = "118";
        String respostaUsuario;
        do {
            System.out.print("Digite a sua resposta: ");
            respostaUsuario = scanner.nextLine();

            if (respostaUsuario.equals(respostaCorreta)) {
                System.out.println("Ótimo! Você conseguiu!!");
            } else {
                System.out.println("Resposta errada. Tente novamente.");
            }
        } while (!respostaUsuario.equals(respostaCorreta));

        digita("\nAo entrar nessa nova sala, novamente uma voz ecoa...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("\n(?): Aparentemente você já entendeu como funcionam as coisas por aqui,\nacho que já está na hora de nos conhecermos.\n", TimeUnit.MILLISECONDS, temp);
        digita("O pequeno ser olha para o jogador e fala:", TimeUnit.MILLISECONDS, temp);
        digita("\nOlá," + nome + "meu nome é Edgar, sou o elfo responsável por esse lugar\ndevo dizer que você veio para em um lugar bem diferente…" + "PORÉM como eu sou um ajudante, irei te auxiliar com os desafios para sair daqui!...”\n", TimeUnit.MILLISECONDS, temp);
        proximo();

        System.out.println("Escolha uma das opções:");
        digita("\n1- Perdão… o que você é?\n", TimeUnit.MILLISECONDS, temp);
        digita("\n2- Tá.. Ajudar com o que exatamente?", TimeUnit.MILLISECONDS, temp);
        digita("\n3- Elfo? Isso não existe", TimeUnit.MILLISECONDS, temp);

        escolha4 = scanner.nextByte();
        //respostas do edgar:
        switch (escolha4){
            case 1:
                digita("1: Orás, sou Edgar um elfo ajudante. Como você entrou aqui eu serei o responsável para que você saia, em segurança.\n", TimeUnit.MILLISECONDS, temp);
                break;
            case 2:
                digita("2: Bom, já que você invadiu aqui eu sou responsável por garantir que você saia, em segurança.\n", TimeUnit.MILLISECONDS, temp);
                break;
            case 3:
                digita("3: Ei… Isso ofendeu. Eu sou o Elfo ajudante e responsável por garantir que você saia, em segurança.\n", TimeUnit.MILLISECONDS, temp);
                break;
            default:
                System.out.println("\nEscolha uma opção válida!\n\n");
                break;
        }

        escolha4 = scanner.nextByte();
        //respostas do edgar:
        switch (escolha4){
            case 1:
                digita("Orás, sou Edgar um elfo ajudante. Como você entrou aqui eu serei o responsável para que você saia, em segurança.\n", TimeUnit.MILLISECONDS, temp);
                break;
            case 2:
                digita("Bom, já que você invadiu aqui eu sou responsável por garantir que você saia, em segurança.\n", TimeUnit.MILLISECONDS, temp);
                break;
            case 3:
                digita("Ei… Isso ofendeu. Eu sou o Elfo ajudante e responsável por garantir que você saia, em segurança.\n", TimeUnit.MILLISECONDS, temp);
                break;
            default:
                System.out.println("\nEscolha uma opção válida!\n\n");
                break;
        }

        System.out.println("Escolha uma das opções abaixo: ");
        digita("1- E como eu saio daqui?\n", TimeUnit.MILLISECONDS, temp);
        digita("2- Entendi Edgar. Você sabe me informar sobre um tesouro escondido por aqui?", TimeUnit.MILLISECONDS, temp);
        digita("3- Em segurança? O que isso significa?", TimeUnit.MILLISECONDS, temp);
        op2= scanner.nextByte();

        do {
            switch (op2){
                case 1:
                    digita("Edgar: Primeiramente, você precisa saber algumas contas de matemática,\nvou te explicar o que você deve fazer ao encontrar a resposta.\n", TimeUnit.MILLISECONDS, temp);
                    digita("Sempre que você já souber a resposta de algo você deve apertar 9 e “falar” a resposta da questão.\n", TimeUnit.MILLISECONDS, temp);
                    break;
                case 2:
                    digita("Ah tá, você é só mais um a procura de conhecimento. Deixa eu te contar que conhecimento não se acha através de tesouros. Ao longo do túnel você vai entender.\n", TimeUnit.MILLISECONDS, temp);
                    break;
                case 3:
                    digita("Significa que você está vivo agora, mas eu não prometo que no final não estará.\n", TimeUnit.MILLISECONDS, temp);
                    break;
            }
        }while(op2 != 1 && op2 != 2 && op2 !=3);

        System.out.println("Aperte 1 para dica");
        dica = scanner.nextByte();
        switch (dica){
            case 1:
                digita("dica: Pense que, se 1 + 1 é igual a 2, logo X + X é igual a 2X.\n", TimeUnit.MILLISECONDS, temp);
                break;
            default:
                System.out.println("Escolha inválida! Escolha o número certo.");
        }
        digita("Entendeu? Vamos a primeira pergunta: ", TimeUnit.MILLISECONDS, temp);

        respostaCorreta = "2x";
        do {
            digita("Quanto é X + X? ", TimeUnit.MILLISECONDS, temp);
            respostaUsuario = scanner.next();

            if (respostaUsuario.equals(respostaCorreta)) {
                digita("Parabéns! Sua resposta está correta.", TimeUnit.MILLISECONDS, temp);
            } else {
                digita("Ops! Sua resposta está incorreta. Tente novamente.", TimeUnit.MILLISECONDS, temp);
            }
        } while (!respostaUsuario.equals(respostaCorreta));

        // Fecha o scanner para evitar vazamentos de recursos
        scanner.close();

        digita("Após seguir seu caminho Edgar te leva para outra sala...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        capitulo2(nome);

    }

    public static void escolhaEsq(String nome) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        byte escolha4;
        byte dica;
        byte op2;
        digita("Seguindo o túnel da esquerda o jogador vê alguns números romanos escritos\nCCXXX", TimeUnit.MILLISECONDS, temp);
        digita("Mesmo sem entender, você continua seguindo em frente.\n", TimeUnit.MILLISECONDS, temp);
        digita("Logo" + nome + "se depara com uma sala com diversos desenhos\nna parede, desenhos de pessoas caçando com um estranho pacote de", TimeUnit.MILLISECONDS, temp);
        digita("\npedras em seu bolso, eventualmente você vê uma enorme porta de\nferro com algo estranho que não deveria estar ali", TimeUnit.MILLISECONDS, temp);
        digita("aparentemente um sistema para colocar a senha.\n", TimeUnit.MILLISECONDS, temp);
        digita("\nCom um certo receio, mas confiando no número romano que havia visto, você decide colocá-los no sistema\n", TimeUnit.MILLISECONDS, temp);

        System.out.println("Aperte 1 para dica");
        dica = scanner.nextByte();
        switch (dica){
            case 1:
                digita("dica: Pense que, se C é igual a 100 e X é igual a 10, logo C+C+X+X+X é igual a 230.\n", TimeUnit.MILLISECONDS, temp);
                break;
            default:
                break;
        }
        digita("Digite aqui o número: ", TimeUnit.MILLISECONDS, temp);
        String respostaUsuario = scanner.nextLine();

        //Resposta correta que usuário deverá responder
        String respostaCorreta = "230";

        if (respostaUsuario.equals(respostaCorreta)) {
            System.out.println("Ótimo! Você conseguiu!!");
        } else {
            System.out.println("Resposta errada. Tente novamente");
        }

        digita("\nCom alívio" + nome + "ele avança, determinado a enfrentar o próxmo desafio em sua jornada.\n", TimeUnit.MILLISECONDS, temp);
        digita("\nApós digitar a senha" + nome + "se vê em uma outra sala.\n", TimeUnit.MILLISECONDS, temp);
        digita("\nAo entrar nessa nova sala, novamente uma voz ecoa...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        digita("\n(?): Aparentemente você já entendeu como funcionam as coisas por aqui,\nacho que já está na hora de nos conhecermos.\n", TimeUnit.MILLISECONDS, temp);
        digita("O pequeno ser olha para o jogador e fala:", TimeUnit.MILLISECONDS, temp);
        digita("\nOlá," + nome + "meu nome é Edgar, sou o elfo responsável por esse lugar\ndevo dizer que você veio para em um lugar bem diferente…" + "PORÉM como eu sou um ajudante, irei te auxiliar com os desafios para sair daqui!”\n", TimeUnit.MILLISECONDS, temp);

        digita("Escolha uma das opções:", TimeUnit.MILLISECONDS, temp);
        digita("\n1- Perdão… o que você é?\n", TimeUnit.MILLISECONDS, temp);
        digita("\n2- Tá.. Ajudar com o que exatamente?", TimeUnit.MILLISECONDS, temp);
        digita("\n3- Elfo? Isso não existe", TimeUnit.MILLISECONDS, temp);

        escolha4 = scanner.nextByte();
        //respostas do edgar:
        switch (escolha4){
            case 1:
                digita("Edgar: Orás, sou Edgar um elfo ajudante. Como você entrou aqui eu serei o responsável para que você saia, em segurança.\n", TimeUnit.MILLISECONDS, temp);
                break;
            case 2:
                digita("Edgar: Bom, já que você invadiu aqui eu sou responsável por garantir que você saia, em segurança.\n", TimeUnit.MILLISECONDS, temp);
                break;
            case 3:
                digita("Edgar: Ei… Isso ofendeu. Eu sou o Elfo ajudante e responsável por garantir que você saia, em segurança.\n", TimeUnit.MILLISECONDS, temp);
                break;
            default:
                System.out.println("\nEscolha uma opção válida!\n\n");
                break;
        }

        digita("Escolha uma das opções abaixo: ", TimeUnit.MILLISECONDS, temp);
        digita("1- E como eu saio daqui?\n", TimeUnit.MILLISECONDS, temp);
        digita("2- Entendi Edgar. Você sabe me informar sobre um tesouro escondido por aqui?", TimeUnit.MILLISECONDS, temp);
        digita("3- Em segurança? O que isso significa?", TimeUnit.MILLISECONDS, temp);
        op2= scanner.nextByte();

        do {

            switch (op2){
                case 1:
                    digita("Edgar: Primeiramente, você precisa saber algumas contas de matemática,\nvou te explicar o que você deve fazer ao encontrar a resposta.\n", TimeUnit.MILLISECONDS, temp);
                    digita("Sempre que você já souber a resposta de algo você deve apertar 9 e “falar” a resposta da questão.\n", TimeUnit.MILLISECONDS, temp);
                    break;
                case 2:
                    digita("Edgar: Ah tá, você é só mais um a procura de conhecimento. Deixa eu te contar que conhecimento não se acha através de tesouros. Ao longo do túnel você vai entender.\n", TimeUnit.MILLISECONDS, temp);
                    break;
                case 3:
                    digita("Significa que você está vivo agora, mas eu não prometo que no final não estará.\n", TimeUnit.MILLISECONDS, temp);
                    break;
            }
        }while(op2 != 1 && op2 != 2 && op2 !=3);

        System.out.println("Aperte 1 para dica");
        dica = scanner.nextByte();
        switch (dica){
            case 1:
                digita("dica: Pense que, se 1 + 1 é igual a 2, logo X + X é igual a 2X.\n", TimeUnit.MILLISECONDS, temp);
                break;
            default:
                digita("Escolha inválida! Escolha o número certo.", TimeUnit.MILLISECONDS, temp);
        }
        System.out.println("Entendeu? Vamos a primeira pergunta: ");
        respostaCorreta = "2x";

        // Verifica se a resposta do usuário está correta
        do {
            System.out.print("Quanto é X + X? ");
            respostaUsuario = scanner.next();

            if (respostaUsuario.equals(respostaCorreta)) {
                System.out.println("Parabéns! Sua resposta está correta.");
            } else {
                System.out.println("Ops! Sua resposta está incorreta. Tente novamente.");
            }
        } while (!respostaUsuario.equals(respostaCorreta));

        // Fecha o scanner para evitar vazamentos de recursos
        scanner.close();

        digita("Após seguir seu caminho Edgar te leva para outra sala...\n", TimeUnit.MILLISECONDS, temp);
        proximo();
        capitulo2(nome);
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

    public static void digita(String mensagem, TimeUnit unit, long tempo_mensagem) throws InterruptedException {
        for (char caractere : mensagem.toCharArray()) {
            System.out.print(caractere);
            unit.sleep(tempo_mensagem);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //começo do jogo para que o usuario decida começar
        System.out.println("Olá, bem vindo a 'UNDER THE LIGHTS'");
        System.out.println("Aperte ENTER para começar o jogo");
        proximo();
        menu();

    }
}