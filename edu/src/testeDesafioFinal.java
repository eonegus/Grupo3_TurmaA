import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class testeDesafioFinal {
    public static void proximo() {
        //Função que faz o skip com o ENTER
        Scanner scanner = new Scanner(System.in);
        String next;
        next = scanner.nextLine();
        if (next.isEmpty()) {
        }
    }
    static int temp = 10;

    public static void digita(String mensagem, TimeUnit unit, long tempo_mensagem) throws InterruptedException {
        for (char caractere : mensagem.toCharArray()) {
            System.out.print(caractere);
            unit.sleep(tempo_mensagem);
        }
    }



    public static void desafioFinal() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //gera valores aleatorios para a questão
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        int c = random.nextInt(20 + 2);

        //informa os valores
        digita("Foram gerados 2 valores aleatórios:\nA:" + a + "\nB:" + b+"\n", TimeUnit.MILLISECONDS, temp);
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
                ? a + "x^2 - " + b + "x + " + c : b + "x^2 - " + a + "x + " + c;

        digita("Você formou a seguinte equação... \n" + equacaoGerada, TimeUnit.MILLISECONDS, temp);
        proximo();
        //Gera valores aleatorios para o criador
        int x = random.nextInt(20) + 1;
        int y = random.nextInt(20) + 1;
        int z = random.nextInt(20) + 1;

        //informa os valores que o criador pegou
        digita("\nCriador:\n'Bom, então essa será minha formação!...'\n", TimeUnit.MILLISECONDS, temp);
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
        } while (!respostaCorreta && tentativas < 3);;

    }
    //essa função faz com os sinais sejam colocador de forma correta
    private static String sinal(int valor) {
        return (valor >= 0) ? "+" : "-";
    }

    public static void main(String[] args) throws InterruptedException {
        desafioFinal();

    }
}
