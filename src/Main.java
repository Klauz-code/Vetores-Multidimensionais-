import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        // Declara o scanner para capturar o input do usuário pelo teclado
        Scanner input = new Scanner(System.in);

        // Declara o gerador de números aleatórios
        Random rd = new Random();

        // Declara a matriz 3x3 que será usada em todas as operações
        int[][] matriz = new int[3][3];

        // Preenche a matriz com números aleatórios entre 1 e 50
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = rd.nextInt(1, 51);
            }
        }

        // Variável que guarda a opção escolhida pelo usuário (começa em 1 para entrar no loop)
        int opcao = 1;

        // Exibe a matriz gerada aleatoriamente antes de mostrar o menu
        System.out.println("MATRIZ DEFINIDA:");
        System.out.println(MetodosMatriz.mostrarMatriz(matriz));

        // Loop principal: continua rodando até o usuário escolher a opção 0 (Sair)
        while(opcao != 0){

            // Loop de validação: fica pedindo uma opção até receber um valor entre 0 e 6
            do{
                System.out.println(MetodosMatriz.menu());
                if (opcao < 0 || opcao > 6){
                    System.out.println("\nESCOLHA UMA OPÇÃO VÁLIDA\n");
                }
                System.out.print("Sua opção >>>> ");
                opcao = input.nextInt();
            } while(opcao < 0 || opcao > 6);

            // Executa a operação correspondente à opção escolhida
            switch (opcao) {

                // Opção 1: calcula e exibe a média dos elementos de cada linha
                case 1 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    int[][] matrizMedia = MetodosMatriz.mediaLinhas(matriz);
                    System.out.println("\n\nOPÇÃO 1 - Média das linhas:\n");
                    System.out.println(MetodosMatriz.mostrarMatriz(matrizMedia));
                }

                // Opção 2: calcula e exibe a soma dos elementos de cada coluna
                case 2 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    int[] resultadoSomaColunas = MetodosMatriz.somaColunas(matriz);
                    System.out.println("\n\nOPÇÃO 2 - Soma das colunas:\n");
                    System.out.printf("| COLUNA 1 | COLUNA 2 | COLUNA 3 |\n");
                    System.out.printf("|----------|----------|----------|\n");
                    System.out.printf("| %5d    | %5d    | %5d    |\n",
                            resultadoSomaColunas[0], resultadoSomaColunas[1], resultadoSomaColunas[2]);
                }

                // Opção 3: encontra e exibe as coordenadas do maior elemento da matriz
                case 3 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    System.out.println("\n\nOPÇÃO 3 - Maior elemento da matriz:\n");
                    int[] coordenadas = MetodosMatriz.maiorElemento(matriz);
                    System.out.printf("COORDENADAS DO ELEMENTO DE VALOR MÁXIMO:\n");
                    System.out.printf("Linha: %d\n", coordenadas[0]);
                    System.out.printf("Coluna: %d\n", coordenadas[1]);
                }

                // Opção 4: verifica se a matriz é simétrica (igual à sua transposta)
                case 4 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    System.out.println("\n\nOPÇÃO 4 - Verificar matriz simétrica:\n");
                    boolean ehSimetrica = MetodosMatriz.ehSimetrica(matriz);
                    System.out.println(ehSimetrica ? "A matriz É simétrica." : "A matriz NÃO é simétrica.");
                }

                // Opção 5: verifica se a matriz é diagonal (fora da diagonal principal tudo é zero)
                case 5 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    System.out.println("\n\nOPÇÃO 5 - Verificar matriz diagonal:\n");
                    boolean ehDiagonal = MetodosMatriz.ehDiagonal(matriz);
                    System.out.println(ehDiagonal ? "A matriz É diagonal." : "A matriz NÃO é diagonal.");
                }

                // Opção 6: verifica se a matriz é identidade (diagonal = 1, resto = 0)
                case 6 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    System.out.println("\n\nOPÇÃO 6 - Verificar matriz identidade:\n");
                    boolean ehIdentidade = MetodosMatriz.ehIdentidade(matriz);
                    System.out.println(ehIdentidade ? "A matriz É identidade." : "A matriz NÃO é identidade.");
                }
            }
        }

        // Mensagem de encerramento exibida quando o usuário escolhe a opção 0
        System.out.println("Obrigado por usar o sistema! :))");
    }
}