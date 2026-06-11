import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        Random rd = new Random();

        // Matriz de trabalho 3x3 — usada em todas as operações do menu
        int[][] matriz = new int[3][3];

        // Preenche a matriz com números aleatórios entre 1 e 50
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                matriz[i][j] = rd.nextInt(1, 51);

        int opcao = 1;

        System.out.println("MATRIZ INICIAL GERADA ALEATORIAMENTE:");
        System.out.println(MetodosMatriz.mostrarMatriz(matriz));

        // Loop principal — roda até o usuário digitar 0
        while(opcao != 0){

            // Loop de validação — só aceita entradas entre 0 e 14
            do {
                System.out.println(MetodosMatriz.menu());
                if (opcao < 0 || opcao > 14) System.out.println("\nESCOLHA UMA OPÇÃO VÁLIDA (0 a 14)\n");
                System.out.print("Sua opção >>>> ");
                opcao = input.nextInt();
            } while(opcao < 0 || opcao > 14);

            switch (opcao) {

                case 1 -> {
                    // Exibe a média de cada linha em uma nova matriz (original preservada)
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    System.out.println("OPÇÃO 1 - Média das linhas:");
                    System.out.println(MetodosMatriz.mostrarMatriz(MetodosMatriz.mediaLinhas(matriz)));
                }

                case 2 -> {
                    // Exibe a soma dos elementos de cada coluna
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    int[] somas = MetodosMatriz.somaColunas(matriz);
                    System.out.println("OPÇÃO 2 - Soma das colunas:");
                    System.out.printf("| COLUNA 1 | COLUNA 2 | COLUNA 3 |\n");
                    System.out.printf("|----------|----------|----------|\n");
                    System.out.printf("| %5d    | %5d    | %5d    |\n", somas[0], somas[1], somas[2]);
                }

                case 3 -> {
                    // Exibe as coordenadas do maior elemento (contando a partir de 1)
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    int[] coord = MetodosMatriz.maiorElemento(matriz);
                    System.out.println("OPÇÃO 3 - Maior elemento:");
                    System.out.printf("Linha: %d | Coluna: %d%n", coord[0], coord[1]);
                }

                case 4 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    System.out.println("OPÇÃO 4 - Simétrica:");
                    System.out.println(MetodosMatriz.ehSimetrica(matriz) ? "A matriz É simétrica." : "A matriz NÃO é simétrica.");
                }

                case 5 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    System.out.println("OPÇÃO 5 - Diagonal:");
                    System.out.println(MetodosMatriz.ehDiagonal(matriz) ? "A matriz É diagonal." : "A matriz NÃO é diagonal.");
                }

                case 6 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    System.out.println("OPÇÃO 6 - Identidade:");
                    System.out.println(MetodosMatriz.ehIdentidade(matriz) ? "A matriz É identidade." : "A matriz NÃO é identidade.");
                }

                case 7 -> {
                    // Pede as linhas e colunas a trocar (usuário digita índices de 0 a 2)
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    System.out.print("linhaX (0-2): ");  int lx = input.nextInt();
                    System.out.print("linhaY (0-2): ");  int ly = input.nextInt();
                    System.out.print("colunaA (0-2): "); int ca = input.nextInt();
                    System.out.print("colunaB (0-2): "); int cb = input.nextInt();
                    matriz = MetodosMatriz.trocarLinhasEColunas(matriz, lx, ly, ca, cb);
                    System.out.println("OPÇÃO 7 - Matriz após trocas:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                }

                case 8 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    int[] primos = MetodosMatriz.primosOrdenados(matriz);
                    System.out.println("OPÇÃO 8 - Primos ordenados:");
                    if (primos.length == 0) {
                        System.out.println("Nenhum primo encontrado.");
                    } else {
                        for (int p : primos) System.out.print(p + " ");
                        System.out.println();
                    }
                }

                case 9 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    System.out.printf("OPÇÃO 9 - Média da borda: %.2f%n", MetodosMatriz.mediaBorda(matriz));
                }

                case 10 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    System.out.println("OPÇÃO 10 - Espiral:");
                    MetodosMatriz.imprimirEspiral(matriz);
                }

                // ── GERADORES ──────────────────────────────────────────────

                case 11 -> {
                    // Gera matriz simétrica aleatória e a define como a matriz de trabalho
                    matriz = MetodosMatriz.gerarSimetrica();
                    System.out.println("OPÇÃO 11 - Nova matriz SIMÉTRICA gerada (use a opção 4 para confirmar):");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                }

                case 12 -> {
                    // Gera matriz diagonal aleatória e a define como a matriz de trabalho
                    matriz = MetodosMatriz.gerarDiagonal();
                    System.out.println("OPÇÃO 12 - Nova matriz DIAGONAL gerada (use a opção 5 para confirmar):");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                }

                case 13 -> {
                    // Carrega a matriz identidade fixa e a define como a matriz de trabalho
                    matriz = MetodosMatriz.gerarIdentidade();
                    System.out.println("OPÇÃO 13 - Matriz IDENTIDADE carregada (use a opção 6 para confirmar):");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                }

                case 14 -> {
                    // Gera uma matriz de dimensões aleatórias (1-5 x 1-5) e informa se é quadrada
                    int linhas = rd.nextInt(1, 6);
                    int colunas = rd.nextInt(1, 6);
                    int[][] matrizRandom = MetodosMatriz.gerarMatrizAleatoria(linhas, colunas);
                    System.out.printf("OPÇÃO 14 - Matriz %dx%d gerada:%n", linhas, colunas);
                    MetodosMatriz.mostrarMatrizDinamica(matrizRandom);
                    System.out.println();
                    if (linhas == colunas) {
                        System.out.println("É QUADRADA (linhas == colunas) → as operações do menu funcionam nela.");
                    } else {
                        System.out.println("NÃO é quadrada (linhas ≠ colunas) → operações como simétrica, diagonal e identidade exigem matrizes quadradas.");
                    }
                    // Nota: esta matriz não substitui a matriz de trabalho principal,
                    // pois pode ter dimensões diferentes de 3x3
                }
            }
        }

        System.out.println("Obrigado por usar o sistema! :))");
        input.close();
    }
}