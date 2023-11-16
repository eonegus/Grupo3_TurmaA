import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static int temp_dialog = 30, temp_narrativa = 30, temp_transicao = 80;
    public static void proximo() {
        //Função que faz o skip com o ENTER
        Scanner scanner = new Scanner(System.in);
        String next;
        next = scanner.nextLine();
        if (next.isEmpty()) {
        }
    }

    public static void nome() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Digita("Qual seu nome?",TimeUnit.MILLISECONDS);
    }

    public static void menu() throws InterruptedException {
        //Menu principal do jogo
        Scanner scanner = new Scanner(System.in);
        int op;
        //Laço pra que a escolha esteja conforme as opções
        do {
            //menu
            System.out.println();
            Digita("-------------MENU----------\n",TimeUnit.MILLISECONDS);
            System.out.print("-                         -\n");
            Digita("-      1 - Tutorial       -\n",TimeUnit.MILLISECONDS);
            Digita("-      2 -  Jogar         -\n",TimeUnit.MILLISECONDS);
            Digita("-      3 - Créditos       -\n",TimeUnit.MILLISECONDS);
            Digita("-      4 -  Sair          -\n",TimeUnit.MILLISECONDS);
            System.out.print("-                         -\n");
            Digita("---------------------------\n",TimeUnit.MILLISECONDS);

            Digita("Escolha uma opção:", TimeUnit.MILLISECONDS);
            op = scanner.nextInt();
            escolhaMenu(op);

        } while (op != 1 && op != 2 && op != 3 && op != 4);
    }


    public static void escolhaMenu(int op) throws InterruptedException {
        //Função que leva até as opções escolhidas
        switch (op) {
            case 1:
                Digita("Você escolheu: Tutorial\n",TimeUnit.MILLISECONDS);
                tutorial();
                break;
            case 2:
                Digita("Você escolheu: Jogar\n",TimeUnit.MILLISECONDS);
                jogar();
                break;
            case 3:
                Digita("Você escolheu: Créditos\n",TimeUnit.MILLISECONDS);
                creditos();
                break;
            case 4:
                Digita("Saindo...\n",TimeUnit.MILLISECONDS);
                Digita("Aperte ENTER para jogar...\n",TimeUnit.MILLISECONDS);
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
        Digita            ("-----------------------------\n",TimeUnit.MILLISECONDS);
        Digita("\nOlá, investigador, para que você não se sinta perdido nessa aventura\n" +
                "vou lhe passar algumas dicas e um breve contexto da história.\n",TimeUnit.MILLISECONDS);
        Digita("Você é um pesquisador a procura de um tesouro perdido. Seu destino são " +
                " os túneis subterrâneos da frança.\n",TimeUnit.MILLISECONDS);
        Digita("----------------------------\n",TimeUnit.MILLISECONDS);
        Digita("-          DICAS           -\n",TimeUnit.MILLISECONDS);
        Digita("----------------------------\n",TimeUnit.MILLISECONDS);
        do {
            //Laço para que o jogador entenda como funciona a seleção de opções
            Scanner scanner = new Scanner(System.in);
            Digita("\nDica 1: Para escolher suas ações digite o valor " +
                    "correspondente as opções dadas.\n",TimeUnit.MILLISECONDS);
            Digita("1 - Próxima dica\n2 - explicar novamente\n",TimeUnit.MILLISECONDS);
            System.out.print("Escolha: \n");
            op = scanner.nextInt();
            if (op != 1 && op != 2) {
                Digita("Digite um valor válido!\n",TimeUnit.MILLISECONDS);
            }
        } while (op != 1);
        Digita("\nDica 2: Sempre que as reticências (...) aparecerem você deve pressionar ENTER" +
                " para continuar...\n",TimeUnit.MILLISECONDS);
        //fazer com que o jogador utilize e entenda a função
        proximo();
        Digita("Boa, já está entendendo!\n",TimeUnit.MILLISECONDS);
        System.out.println();
        Digita("Os desafios que você encontrará no caminho são sobre matematica, sendo " +
                " alguns deles questões de múltipla escolha,\nenquanto outros você deverá selecionar valores" +
                " sorteados aleatoriamente, e escrever o total.\n",TimeUnit.MILLISECONDS);
        Digita("Para selecionar a opção serão dados alternativas de 1 a 4...\n",TimeUnit.MILLISECONDS);
        //fazer com que o jogador utilize e entenda a função
        proximo();
        Digita("Para cada teste, você terá 2 tentativas para acertar.\n",TimeUnit.MILLISECONDS);
        Digita("Caso acerte, o jogo seguirá normalmente. Em caso de falha\n" +
                "será mostrado o aviso 'Você falhou!', junto a resposta do desafio...\n",TimeUnit.MILLISECONDS);
        //fazer com que o jogador utilize e entenda a função
        proximo();
        Digita("Muito bem, você terminou o tutorial, daqui pra frente é por sua conta!\n",TimeUnit.MILLISECONDS);
        Digita("Lembre-se, caso precise você sempre terá acesso ao tutorial pelo menu inicial.\n",TimeUnit.MILLISECONDS);
        Digita("Então caro investigador, agora que você já sabe como as coisas funcionam por aqui, " +
                "venha conhecer um novo mundo!\n",TimeUnit.MILLISECONDS);
        Digita("--------APERTE ENTER--------\n",TimeUnit.MILLISECONDS);
        //última demonstração da função
        proximo();
        menu();
    }

    public static void jogar() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //Inicia a apresentação do jogo
        Digita("Bem vindo a UNDER THE LIGHTS\n",TimeUnit.MILLISECONDS);
        Digita("Para começarmos, me diga, como devo chama-lo?:\n",TimeUnit.MILLISECONDS);
        //Deixa o usuario livre para escolher seu nome
        String nome = scanner.nextLine();
        Digita("Olá, " + nome + "!\n",TimeUnit.MILLISECONDS);
        //passa o nome para a função
        capitulo1(nome);
    }

    public static void capitulo1(String nome) throws InterruptedException {
        //a Função já está recebendo o nome pré estabelecido
        Scanner scanner = new Scanner(System.in);
        Digita("Bem vindo \n" + nome,TimeUnit.MILLISECONDS);

        capitulo2(nome);
    }

    public static void capitulo2(String nome) {
        int resposta1, desafio1, escolhaDesafio2, resp2op3 = 0;

        Scanner menu = new Scanner(System.in);

        System.out.println("Seguindo o que o Edgar disse, Você segue em frente.\n " +
                "E acaba se deparando com uma sala misteriosa, iluminada por uma luz fraca. No centro da sala, havia uma escrita enigmática em uma pedra antiga: \n" +
                "'Edgar: Entenda jovem aventureiro, nesse lugar a matemática domina, e tudo envolve cálculo...'");
        proximo();

        System.out.println("Você pode optar sempre por não responder a pergunta, mas saiba que sempre estarei por perto para te ajudar, basta você falar dica");

        // DESAFIO 1
        System.out.println("Vamos ao primeiro desafio, por acaso você conhece sobre Polinómios?...");
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

        System.out.println("Bom, então vamos lá.\n" +
                "Para avançar em sua busca, você deve decifrar o enigma do polinómio mágico.\n" +
                "Responda corretamente e o caminho se abrirá diante de você...");
        proximo();
        System.out.println("A escrita então se revelou a seguinte equação polinomial: ");
        // Desafio 1
        System.out.println("2x² + 4x + 3 + 4x² – 2x + 4");

        do {
            System.out.println("Caso a resposta esteja correta a parede em frente se abrirá dando passagem para que você possa seguir em frente...");
            proximo();
            System.out.println("1)  6x² - 2x + 7\n" +
                    "2)  6x² + 2x - 7\n" +
                    "3)  6x² + 2x + 7\n" +
                    "4) Dica");

            desafio1 = menu.nextInt();

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
        } while (desafio1 != 3);

        System.out.println("\n" +
                "Quando essa porta se abre o jogador vê em sua frente um enorme salão dourado.\n" +
                " a impressão é de que ele tenha saído desse universo, e entrado em uma cidade medieval...");
        proximo();
        System.out.println("O salão é enorme e está em ruínas, aparentemente diversos saques e guerras aconteceram nesse local.\n" +
                "Ao final da sala uma enorme cadeira, na qual com certeza não foi projetada para um ser humano se sentar...");
        proximo();

        System.out.println("Você pergunta:  \n" +
                "1 - Edgar, que lugar é esse?\n" +
                "2 - Uau, o que está rolando aqui?");

        int pergunta2 = menu.nextInt();

        switch (pergunta2) {
            case 1:
                System.out.println("1 - “Então jogador, como eu posso explicar… ");
                proximo();
                System.out.println("Esse é o lugar onde o mundo começou, ou seja, aqui é o lugar onde eu nasci.\n" +
                        "Quero dizer que, número, letras, palavras e tudo que você conhece começou aqui...");
                proximo();
                System.out.println("Você pode conhecer como “cidade perdida” ou até “centro da terra”, mas o verdadeiro nome é “Monde”");
                break;

            case 2:
                System.out.println("2 - An? Ah, você chegou ao salão principal. Bom aqui é o lugar onde seu desafio começa.\n" +
                        " Esse é o lugar onde o mundo começou, ou seja, aqui é o lugar onde eu nasci.\n" +
                        "Quero dizer que, número, letras, palavras e tudo que você conhece começou aqui...");
                proximo();
                System.out.println("Você pode conhecer como “cidade perdida” ou até “centro da terra”, mas o verdadeiro nome é “Monde” ...");
                break;

            default:
                System.out.println("Opção Invalida!");
                break;
        }

        System.out.println("Olhe em volta jovem, tudo aqui é feito do mais puro ouro, há algo mais perfeito do que isso? ...");
        proximo();
        System.out.println("Você diz para Edgar: Que interessante, mas...");
        proximo();
        System.out.println("1 - “Centro da terra? Monde? Dá pra explicar melhor?”\n" +
                "2 - “Ok, Edgar. Então aqui é o centro da criação?”\n");

        int pergunta3 = menu.nextInt();

        switch (pergunta3) {
            case 1, 2:
                System.out.println("Edgar apenas olhe para você e segue em frente\n" +
                        "“Relaxa, você vai entender melhor”\n");
                break;

            default:
                System.out.println("Opção Invalida!");
        }
        System.out.println("Um enorme som ecoa na sala, grandes muros se erguem e revelam diferentes valores.\n" +
                "'Edgar: “Bom aqui está outro desafio para você...'");
        proximo();

        // DESAFIO 2
        System.out.println("Saindo do grande salão vc percebe que as paredes estão diferentes. o que antes eram paredes rochosas, apertadas e escuras,\n" +
                " pouco a pouco tornam-se paredes feitas de uma rocha branca, que lembra muito mármore...");
        proximo();
        System.out.println("O corredor começa a se tornar mais uniforme, não há mais tantos buracos no chão,\n" +
                " as paredes se mantêm com um toque delicado de mármore.\n" +
                "Caminhando mais e mais, com o que parece ser um corredor sem fim, logo a frente um feixe de luz se forma...");
        proximo();
        System.out.println("Qual ação devo tomar...");
        proximo();
        System.out.println("1 - Correr em direção a luz\n" +
                "2 - Continuar andando\n" +
                "3 - parar e analisar o local");

        int pergunta4 = menu.nextInt();

        switch (pergunta4) {
            case 1:
                System.out.println("Ao correr em direção a luz, acreditando ser a saída o jogador acaba tropeçando em um fio que abre um alçapão\n" +
                        " você começa a descer o que parece ser propositalmente um escorregador, ao chegar no final você se sente em uma espécie de colchão d´água.");
                break;
            case 2:
                System.out.println("Ao continuar andando em direção a luz, chegando perto desse feixe de luz você se descuida um pouco,\n" +
                        " e o que aparenta ser uma parte do piso é uma placa, ao pisar nessa placa o chão se abre e você começa a descer\n" +
                        " o que parece ser propositalmente um escorregador, ao chegar no final vc se sente em uma espécie de colchão d´água.");
                break;
            case 3:
                System.out.println("Analisando em volta você percebe uma espécie de chão falso, entende que se pisar ali algo irá acontecer.\n" +
                        " O feixe de luz aparenta vir de um buraco na parede que não leva a saída e sim a outro lugar");
                break;
            default:
                System.out.println("Resposta invalida.");
                break;
        }
        if (pergunta4 == 3) {
            System.out.println("chegando nesse outro lugar, você terá duas opções: ");
            System.out.println("1- tentar contornar o chão falso\n" +
                    "2- Procurar outro jeito.");

            int respOp3 = menu.nextInt();

            switch (respOp3) {
                case 1:
                    System.out.println("Você consegue contornar o chão falso e chegar até o buraco na parede, olhando o que vem através dele\n" +
                            " não consegue entender direito o que acontece ali, alguns vultos passam rapidamente e ofuscam seu entendimento.");
                    break;

                case 2:
                    System.out.println("Olhando em volta novamente, apenas vê o caminho no qual vc veio e paredes de mármore sem nada diferente.");
                    break;

                default:
                    System.out.println("Opção Invalida.");
                    break;
            }
        }

        do {
            System.out.println("Sem saber o que fazer, terá duas opções:");
            proximo();
            System.out.println("1- Entrar no chão falso\n" +
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

                default:
                    System.out.println("Opção Invalida.");
                    break;
            }
        } while (resp2op3 != 1);

        System.out.println("Enquanto está deitado no colchão d'água, uma mensagem misteriosa aparece em uma placa próxima:");
        System.out.println("Para avançar, resolva o seguinte polinômio: ...");
        proximo();
        System.out.println("4x³ - 2x² + 5x - 3");

        do {
            System.out.println("Caso a resposta esteja correta, a parede em frente se abrirá, dando passagem para que você possa seguir em frente...");
            proximo();
            System.out.println("1)  2x³ + 3x² - 2x - 1\n" +
                    "2)  4x³ - x² + 5x - 3\n" +
                    "3)  4x³ - 2x² + 5x + 3\n" +
                    "4) Dica");

            escolhaDesafio2 = menu.nextInt();

            switch (escolhaDesafio2) {
                case 1:
                    System.out.println("Infelizmente, a resposta está incorreta. O colchão d'água parece ficar mais agitado, mas nada acontece...");
                    proximo();
                    break;
                case 2:
                    System.out.println("Parabéns! Você resolveu o desafio. A parede se abre, revelando um novo caminho...");
                    proximo();
                    break;
                case 3:
                    System.out.println("Infelizmente, a resposta está incorreta. O colchão d'água parece ficar mais agitado, mas nada acontece...");
                    proximo();
                    break;
                case 4:
                    System.out.println("Considere agrupar termos e aplicar fatoração por grupos para simplificar o polinômio ");
                    break;
                default:
                    System.out.println("Opção invalida.");
                    break;
            }
        } while (escolhaDesafio2 != 2);


        System.out.println("Ao sair do colchão e atravessar o muro que se abriu em sua frente, seus olhos doem com o intenso brilho que é mostrado...\n" +
                " Diante dos seus olhos vc se depara com um “novo mundo”...");
        proximo();
        System.out.println("Seres místicos voam sobre sua cabeça, elfos brincam na cidade\n" +
                " e o que parece ser um enorme castelo está acentuado no meio disso tudo, emitindo uma intensa luz.");


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

    public static void creditos() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //Créditos finais
        System.out.println();
        System.out.println("-------------CRÉDITOS-------------");
        System.out.println("-                                -");
        System.out.println("-      Alessandra Fernandes      -");
        System.out.println("-        Felipe Ferreira         -");
        System.out.println("-          João Victor           -");
        System.out.println("-         Vitor Gonçalves        -");
        System.out.println("-                                -");
        System.out.println("----------------------------------\n");

        int op;
        do {
            System.out.println("Escolha uma opção!");
            Digita("1 - Menu\n2 - sair\n",TimeUnit.MILLISECONDS);
            System.out.print("");
            op = scanner.nextInt();
            if (op == 1 ){
                menu();
            }else if (op == 2){
                Digita("Saindo...\n",TimeUnit.MILLISECONDS);
            }else Digita("Valor invalido!\n",TimeUnit.MILLISECONDS);
        }while (op > 2);

    }

    public static void Digita(String s, TimeUnit timeUnit) throws InterruptedException {
        for (char caractere : s.toCharArray()) {
            System.out.print(caractere);
            timeUnit.sleep(temp_dialog);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //começo do jogo para que o usuario decida começar
        Digita("Olá, bem vindo a 'UNDER THE LIGHTS'\n",TimeUnit.MILLISECONDS);
        Digita("Aperte ENTER para começar o jogo\n",TimeUnit.MILLISECONDS);
        proximo();
        menu();

    }
}