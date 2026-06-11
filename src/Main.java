import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

//        DECLARAR INPUT
        Scanner input = new Scanner(System.in);

//        DECLARAR RANDOM
        Random rd = new Random();

//        DECLARAR MATRIZ 3X3
        int[][] matriz = new int[3][3];

//        PREENCHER COM NUMEROS ALEATORIOS ENTRE 1 E 50
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = rd.nextInt(1, 51);
            }
        }

//        COMEÇA EM 1 PRA ENTRAR NO LOOP SEM PEDIR OPCAO ANTES DE MOSTRAR A MATRIZ
        int opcao = 1;

//        MOSTRAR MATRIZ INICIAL
        System.out.println("MATRIZ DEFINIDA:");
        System.out.println(MetodosMatriz.mostrarMatriz(matriz));

//        LOOP PRINCIPAL - roda ate o usuario escolher 0
        while(opcao != 0){

//            LOOP DE VALIDACAO - so aceita valores entre 0 e 14
            do{
                System.out.println(MetodosMatriz.menu());
                if (opcao < 0 || opcao > 14){
                    System.out.println("\nESCOLHA UMA OPÇÃO VÁLIDA\n");
                }
                System.out.print("Sua opção >>>> ");
                opcao = input.nextInt();
            } while(opcao < 0 || opcao > 14);

            switch (opcao) {
                case 1 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    int[][] matrizMedia = MetodosMatriz.mediaLinhas(matriz);
                    System.out.println("\nOPÇÃO 1 - Média das linhas:\n");
                    System.out.println(MetodosMatriz.mostrarMatriz(matrizMedia));
                }
                case 2 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    int[] resultadoSomaColunas = MetodosMatriz.somaColunas(matriz);
                    System.out.println("\nOPÇÃO 2 - Soma das colunas:\n");
                    System.out.printf("| COLUNA 1 | COLUNA 2 | COLUNA 3 |\n");
                    System.out.printf("|----------|----------|----------|\n");
                    System.out.printf("| %5d    | %5d    | %5d    |\n", resultadoSomaColunas[0], resultadoSomaColunas[1], resultadoSomaColunas[2]);
                }
                case 3 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    int[] coordenadas = MetodosMatriz.maiorElemento(matriz);
                    System.out.println("\nOPÇÃO 3 - Maior elemento da matriz:\n");
                    System.out.printf("Linha: %d\n", coordenadas[0]);
                    System.out.printf("Coluna: %d\n", coordenadas[1]);
                }
                case 4 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    boolean ehSimetrica = MetodosMatriz.ehSimetrica(matriz);
                    System.out.println("\nOPÇÃO 4 - Verificar matriz simétrica:\n");
                    System.out.println(ehSimetrica ? "A matriz É simétrica." : "A matriz NÃO é simétrica.");
                }
                case 5 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    boolean ehDiagonal = MetodosMatriz.ehDiagonal(matriz);
                    System.out.println("\nOPÇÃO 5 - Verificar matriz diagonal:\n");
                    System.out.println(ehDiagonal ? "A matriz É diagonal." : "A matriz NÃO é diagonal.");
                }
                case 6 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    boolean ehIdentidade = MetodosMatriz.ehIdentidade(matriz);
                    System.out.println("\nOPÇÃO 6 - Verificar matriz identidade:\n");
                    System.out.println(ehIdentidade ? "A matriz É identidade." : "A matriz NÃO é identidade.");
                }
                case 7 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    System.out.print("Digite linhaX (0 a 2): ");
                    int linhaX = input.nextInt();
                    System.out.print("Digite linhaY (0 a 2): ");
                    int linhaY = input.nextInt();
                    System.out.print("Digite colunaA (0 a 2): ");
                    int colunaA = input.nextInt();
                    System.out.print("Digite colunaB (0 a 2): ");
                    int colunaB = input.nextInt();
                    matriz = MetodosMatriz.trocarLinhasEColunas(matriz, linhaX, linhaY, colunaA, colunaB);
                    System.out.println("\nOPÇÃO 7 - Matriz após as trocas:\n");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                }
                case 8 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    int[] primos = MetodosMatriz.primosOrdenados(matriz);
                    System.out.println("\nOPÇÃO 8 - Números primos ordenados:\n");
                    if (primos.length == 0) {
                        System.out.println("Nenhum número primo encontrado na matriz.");
                    } else {
                        System.out.print("Primos encontrados: ");
                        for (int primo : primos) System.out.print(primo + " ");
                        System.out.println();
                    }
                }
                case 9 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    double media = MetodosMatriz.mediaBorda(matriz);
                    System.out.println("\nOPÇÃO 9 - Média da borda:\n");
                    System.out.printf("Média dos elementos da borda: %.2f%n", media);
                }
                case 10 -> {
                    System.out.println("\nMATRIZ ORIGINAL:");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                    System.out.println("\nOPÇÃO 10 - Impressão em espiral:\n");
                    MetodosMatriz.imprimirEspiral(matriz);
                }
                case 11 -> {
//                    substitui a matriz de trabalho por uma simetrica aleatoria
                    matriz = MetodosMatriz.gerarSimetrica();
                    System.out.println("\nOPÇÃO 11 - Nova matriz SIMÉTRICA gerada (use a opção 4 para confirmar):\n");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                }
                case 12 -> {
//                    substitui a matriz de trabalho por uma diagonal aleatoria
                    matriz = MetodosMatriz.gerarDiagonal();
                    System.out.println("\nOPÇÃO 12 - Nova matriz DIAGONAL gerada (use a opção 5 para confirmar):\n");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                }
                case 13 -> {
//                    substitui a matriz de trabalho pela identidade
                    matriz = MetodosMatriz.gerarIdentidade();
                    System.out.println("\nOPÇÃO 13 - Matriz IDENTIDADE carregada (use a opção 6 para confirmar):\n");
                    System.out.println(MetodosMatriz.mostrarMatriz(matriz));
                }
                case 14 -> {
//                    gera uma matriz de tamanho aleatorio e fala se e quadrada ou nao
//                    nao substitui a matriz de trabalho pois pode ter dimensoes diferentes de 3x3
                    int linhas = rd.nextInt(1, 6);
                    int colunas = rd.nextInt(1, 6);
                    int[][] matrizAleatoria = MetodosMatriz.gerarMatrizAleatoria(linhas, colunas);
                    System.out.printf("\nOPÇÃO 14 - Matriz %dx%d gerada:%n%n", linhas, colunas);
                    MetodosMatriz.mostrarMatrizDinamica(matrizAleatoria);
                    System.out.println();
                    if (linhas == colunas) {
                        System.out.println("A matriz E QUADRADA (linhas == colunas)");
                    } else {
                        System.out.println("A matriz NAO e quadrada (linhas != colunas) -> operacoes como simetrica, diagonal e identidade so funcionam em matrizes quadradas");
                    }
                }
            }
        }

        System.out.println("Obrigado por usar o sistema! :))");
    }
}