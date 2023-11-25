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
        Digita("Bem vindo(a) \n",TimeUnit.MILLISECONDS);
        byte escolha;
        byte escolha2;
        byte escolha3;

        //inicio da nossa história
        Digita("\nParis, França \nEsse é o local que você está! Seu destino? As catacumbas da cidade…\n", TimeUnit.MILLISECONDS);
        System.out.println("Diversas pessoas caminham pela cidade alegremente, de forma comum,\nporém duas pessoas em específico chamam sua atenção");
        System.out.println("Eles aparentam ser pesquisadores, andando com grandes bolsas e ferramentas");
        Digita("Você chega perto e decide falar com eles...", TimeUnit.MILLISECONDS);
        proximo();
        System.out.println("\n\nEscolha o que você deseja perguntar");
        System.out.println("\n\n1- Olá, por acaso vocês poderiam me ajudar?" );
        System.out.println("\n2- Ei. É… Eu gostaria de perguntar uma coisa.\n ");
        escolha = scanner.nextByte();
        proximo();


        do {
            switch (escolha) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\nEscolha uma opção válida!\n\n");
            }
        }while(escolha != 1 && escolha != 2);

        System.out.println("\n\n -------- Apresentando os Personagens -------- \n");
        System.out.println("\n- Osmar, é um homem negro que possui\n cabelos encaracolados e grisalhos. Parece ter por volta de 50 anos. \n Sua característica mais chamativa certamente é sua altura,\n que parece chegar facilmente aos 1.9O. de altura\n Osmar tem um grande número de cicatrizes pelo corpo, \n parece já ter passado por muito na vida.\n");
        System.out.println("\nJunto dele tem uma mulher presente \n- Mika é uma  branca de cabelos cacheados e pretos,\n aparenta estar na casa dos 40 anos. E apesar de ser baixinha,\n Mika é uma mulher centrada e com muitas capacidades de exploração.\n Todos esses anos em que vivenciou suas aventuras, fizeram a \n ficar muito forte e atenta a todos os sinais de perigo ao seu redor.");
        System.out.println("\n\n-------- Fim das Apresentações --------");
        proximo();

        System.out.println("\nOsmar olha para você e diz...");
        System.out.println("\nClaro que sim, aliás, sou Osmar e essa minha companheira, Mika.\nEla sorri de forma amigável.\n Me diga o que precisa?\n");


        System.out.println("\n\nEsoclha uma das alternativas:");
        System.out.println("\n\n1- Eu gostaria de ir até as catacumbas,sabe como chegar?");
        System.out.println("\n2- Quero conhecer os túneis, poderiam me mostrar a entrada?\n ");

        do {
            escolha2 = scanner.nextByte();
            switch (escolha2) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Escolha uma opção válida!");

            }
        } while (escolha2 != 1 && escolha2 != 2);

        proximo();
        System.out.println("\nOsmar responde:\n");
        System.out.println("\nClaro, te mostro o caminho, mas o resto é contigo. Se quiser, vamos agora\nVocê segue eles.");
        System.out.println("\nSeguindo Mika e Osmar, eles te levam a uma antiga ferrovia da cidade, abrem uma porta e dizem:\n");
        System.out.println("\nMika e Osmar: “Bom. Só vamos até aqui. Boa sorte com o que você está procurando.\n");
        System.out.println("\nE antes que você possa falar tchau, eles desaparecem atrás de você.\n");
        System.out.println("\nEnquanto você caminha sozinho no escuro apenas com uma lanterna\ne sua bolsa com algumas ferramentas básicas\nvocê escuta alguma voz lhe chamando..." +
                "\n");
        proximo();

        System.out.println("\n(?)Olá " + nome + " , o que faz aqui?\n");
        System.out.println("\n 1- Olá?");
        System.out.println("\n 2- OI… quem é?");
        System.out.println("\n 3-Seguir em frente\n");

        escolha3 = scanner.nextByte();
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
        System.out.println("\nVocê segue em frente, sua lanterna começa a piscar e sem perceber o\n chão abaixo se abre e você cai de uma altura de +/- 2 metros.\n");
        System.out.println("\nOlhando em volta você apenas vê paredes com algumas aranhas\ne baratas caminhando nela.");

        System.out.println("\nNessa “sala” há dois túnei" +
                "s, um do seu lado direito e o outro do lado esquerdo");

        System.out.println("Escolha um dos túneis:\n 1- Direita 2- Esquerda");

        int op = scanner.nextInt();
        do {
            if(op == 1) {
                escolhaDir(nome);
            } else if (op == 2) {
                escolhaEsq(nome);
            }
        }while (op >2);
            System.out.println("Escolha um valor válido");

        proximo();
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

    public static void escolhaDir(String nome) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        byte escolha4;

        System.out.println("\n\nSeguindo o túnel da direita você vê que as paredes começam a mudar\n pouco a pouco, diversos símbolos vão aparecendo\n");
        System.out.println("\nMais a frente você se depara com uma enorme sala, cheia de vasos e\n esculturas de diferentes tamanhos e formas.\nAlguns vasos específicos contém grandes números desenhados neles (1; 8; 1.)");
        System.out.println("\nDo outro lado da sala há um portão com uma espécie de porteiro com\n senha pedindo três números. Ao lado desse porteiro há um papel com \numa frase escrita\n ");
        System.out.println("\nPara passar pense em um valor menor que 120 e maior que 110\n");

        System.out.print("Digite a sua resposta: ");
        String respostaUsuario = scanner.nextLine();

        //Resposta correta
        String respostaCorreta = "118";

        if (respostaUsuario.equals(respostaCorreta)) {
            System.out.println("Ótimo! Você conseguiu!!");
        } else {
            System.out.println("Resposta errada.");
        }

        System.out.println("\nAo entrar nessa nova sala, novamente uma voz ecoa\n");
        System.out.println("\n(?): Aparentemente você já entendeu como funcionam as coisas por aqui,\nacho que já está na hora de nos conhecermos.\n");
        System.out.println("O pequeno ser olha para o jogador e fala:");
        System.out.println("\nOlá," + nome + "meu nome é Edgar, sou o elfo responsável por esse lugar\ndevo dizer que você veio para em um lugar bem diferente…" + "PORÉM como eu sou um ajudante, irei te auxiliar com os desafios para sair daqui!”\n");

        System.out.println("Escolha uma das opções:");
        System.out.println("\n1- Perdão… o que você é?\n");
        System.out.println("\n2- Tá.. Ajudar com o que exatamente?");
        System.out.println("\n3- Elfo? Isso não existe");

        escolha4 = scanner.nextByte();
        //respostas do edgar:
        switch (escolha4){
            case 1:
                System.out.println("1: Orás, sou Edgar um elfo ajudante. Como você entrou aqui eu serei o responsável para que você saia, em segurança.\n");
                break;
            case 2:
                System.out.println("2: Bom, já que você invadiu aqui eu sou responsável por garantir que você saia, em segurança.\n");
                break;
            case 3:
                System.out.println("3: Ei… Isso ofendeu. Eu sou o Elfo ajudante e responsável por garantir que você saia, em segurança.\n");
                break;
            default:
                System.out.println("\nEscolha uma opção válida!\n\n");
                break;
        }
        capitulo2(nome);
    }

    public static void escolhaEsq(String nome) {
        Scanner scanner = new Scanner(System.in);
        byte escolha4;
        byte dica;
        byte op2;
        System.out.println("Seguindo o túnel da esquerda o jogador vê alguns números romanos escritos\nCXVVII");
        System.out.println("Porém sem entender, você continua seguindo em frente.\n");
        System.out.println("Mais pra frente, o jogador se depara com uma sala com diversos desenhos\nna parede, desenhos de pessoas caçando com um estranho pacote de");
        System.out.println("\npedras em seu bolso, eventualmente o jogador vê uma enorme porta de ");
        System.out.println("\nferro com algo estranho que não deveria estar ali, um sistema para colocar a senha.\n");
        System.out.println("\nCom um certo receio, mas confiando no número romano que havia visto ");
        System.out.println("\nanteriormente (CXVVII = 118), o jogador, tenso e esperançoso, digita os ");
        System.out.println("\nnúmeros romanos na porta, que começa a se abrir lentamente.");


        System.out.println("\nCom alívio ele avança, determinado a enfrentar o próxmo desafio em sua jornada.\n");
        System.out.println("\nApós digitar a senha o jogador se vê em uma outra sala.\n");
        System.out.println("\nAo entrar nessa nova sala, novamente uma voz ecoa\n");
        System.out.println("\n(?): Aparentemente você já entendeu como funcionam as coisas por aqui,\nacho que já está na hora de nos conhecermos.\n");
        System.out.println("O pequeno ser olha para o jogador e fala:");
        System.out.println("\nOlá," + nome + "meu nome é Edgar, sou o elfo responsável por esse lugar\ndevo dizer que você veio para em um lugar bem diferente…" + "PORÉM como eu sou um ajudante, irei te auxiliar com os desafios para sair daqui!”\n");

        System.out.println("Escolha uma das opções:");
        System.out.println("\n1- Perdão… o que você é?\n");
        System.out.println("\n2- Tá.. Ajudar com o que exatamente?");
        System.out.println("\n3- Elfo? Isso não existe");

        escolha4 = scanner.nextByte();
        //respostas do edgar:
        switch (escolha4){
            case 1:
                System.out.println("Orás, sou Edgar um elfo ajudante. Como você entrou aqui eu serei o responsável para que você saia, em segurança.\n");
                break;
            case 2:
                System.out.println("Bom, já que você invadiu aqui eu sou responsável por garantir que você saia, em segurança.\n");
                break;
            case 3:
                System.out.println("Ei… Isso ofendeu. Eu sou o Elfo ajudante e responsável por garantir que você saia, em segurança.\n");
                break;
            default:
                System.out.println("\nEscolha uma opção válida!\n\n");
                break;
        }


        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1- E como eu saio daqui?\n");
        System.out.println("2- Entendi Edgar. Você sabe me informar sobre um tesouro escondido por aqui?");
        System.out.println("3- Em segurança? O que isso significa?");
        op2= scanner.nextByte();

        do {

            switch (op2){
                case 1:
                    System.out.println("Edgar: Primeiramente, você precisa saber algumas contas de matemática,\nvou te explicar o que você deve fazer ao encontrar a resposta.\n");
                    System.out.println("Sempre que você já souber a resposta de algo você deve apertar 9 e “falar” a resposta da questão.\n");
                    break;
                case 2:
                    System.out.println("Ah tá, você é só mais um a procura de conhecimento. Deixa eu te contar que conhecimento não se acha através de tesouros. Ao longo do túnel você vai entender.\n");
                    break;
                case 3:
                    System.out.println("Significa que você está vivo agora, mas eu não prometo que no final não estará.\n");
                    break;
            }
        }while(op2 != 1 && op2 != 2 && op2 !=3);

        System.out.println("Aperte 1 para dica");
        dica = scanner.nextByte();
        switch (dica){
            case 1:
                System.out.println("dica: Pense que, se 1 + 1 é igual a 2, logo X + X é igual a 2X.\n");
                break;
            default:
                System.out.println("Escolha inválida! Escolha o número certo.");
        }
        System.out.println("Entendeu? Vamos a primeira pergunta: ");
        System.out.print("Quanto é X + X? ");
        String respostaUsuario = scanner.next();

        String respostaCorreta = "2x";
        // Verifica se a resposta do usuário está correta
        if (respostaUsuario.equals(respostaCorreta)) {
            System.out.println("Parabéns! Sua resposta está correta.");
        } else {
            System.out.println("Ops! Sua resposta está incorreta. A resposta correta é: " + respostaCorreta);
        }

        // Fecha o scanner para evitar vazamentos de recursos
        scanner.close();

        System.out.println("Após seguir seu caminho Edgar te leva para outra sala...\n");
        proximo();
        capitulo2(nome);
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