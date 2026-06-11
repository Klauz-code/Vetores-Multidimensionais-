public class MetodosMatriz {

//    EXIBIÇÃO E MENU

    //    formata a matriz 3x3 como texto pra exibir no console
    public static String mostrarMatriz(int[][] matriz){
        return """
               | %2d    %2d    %2d |
               | %2d    %2d    %2d |
               | %2d    %2d    %2d |
               """.formatted(
                matriz[0][0], matriz[0][1], matriz[0][2],
                matriz[1][0], matriz[1][1], matriz[1][2],
                matriz[2][0], matriz[2][1], matriz[2][2]
        );
    }

    //    mesma coisa mas pra matrizes de qualquer tamanho (usada na opção 14)
    public static void mostrarMatrizDinamica(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%3d ", matriz[i][j]);
            }
            System.out.println("|");
        }
    }

    public static String menu(){
        return """
               
               ~~~~~~~~~~~~~~~~~ MENU ~~~~~~~~~~~~~~~~~
                --- OPERAÇÕES ---
                1.  Media das linhas
                2.  Soma das colunas
                3.  Maior elemento da matriz
                4.  Verificar matriz simetrica
                5.  Verificar matriz diagonal
                6.  Verificar matriz identidade
                7.  Trocar linhas e colunas
                8.  Numeros primos ordenados
                9.  Media da borda
                10. Impressao em espiral
                --- GERAR MATRIZES PARA TESTE ---
                11. Gerar matriz SIMETRICA
                12. Gerar matriz DIAGONAL
                13. Gerar matriz IDENTIDADE
                14. Gerar matriz de ordem ALEATORIA
                0.  Sair
               """;
    }

//    OPERAÇÕES

    //    calcula a media de cada linha e salva numa matriz nova
//    uso uma matriz nova pra nao alterar a original (array é passado por referencia em java)
    public static int[][] mediaLinhas(int[][] matrizBase) {
        int[][] matrizResultado = new int[matrizBase.length][matrizBase[0].length];
        int acumulador = 0;

        for (int i = 0; i < matrizBase.length; i++) {

//            primeiro somo tudo da linha
            for (int j = 0; j < matrizBase[0].length; j++) {
                acumulador += matrizBase[i][j];
            }

//            depois preencho a linha inteira com a media
            for (int j = 0; j < matrizBase[0].length; j++) {
                matrizResultado[i][j] = acumulador / 3;
            }

            acumulador = 0; // zera antes de passar pra proxima linha
        }
        return matrizResultado;
    }

    //    soma os elementos de cada coluna e retorna num array de 3 posicoes
    public static int[] somaColunas(int[][] matrizBase){
        int[] acumuladorColunas = new int[3];

        for (int i = 0; i < matrizBase.length; i++) {
            for (int j = 0; j < matrizBase[0].length; j++) {
                if (j == 0){
                    acumuladorColunas[0] += matrizBase[i][j];
                }
                else if (j == 1){
                    acumuladorColunas[1] += matrizBase[i][j];
                }
                else{
                    acumuladorColunas[2] += matrizBase[i][j];
                }
            }
        }
        return acumuladorColunas;
    }

    //    percorre a matriz inteira guardando sempre a posicao do maior valor encontrado
//    o +1 nas coordenadas é pra exibir contando a partir de 1, nao de 0
    public static int[] maiorElemento(int[][] matrizBase){
        int valorMaximo = -11111;
        int[] coordenadas = new int[2];

        for (int i = 0; i < matrizBase.length; i++) {
            for (int j = 0; j < matrizBase[0].length; j++) {
                if (matrizBase[i][j] > valorMaximo){
                    valorMaximo = matrizBase[i][j];
                    coordenadas[0] = i + 1;
                    coordenadas[1] = j + 1;
                }
            }
        }
        return coordenadas;
    }

    //    matriz simetrica = M[i][j] == M[j][i] pra toda posicao
//    se achar qualquer par diferente, ja retorna false
    public static boolean ehSimetrica(int[][] matrizBase){
        for (int i = 0; i < matrizBase.length; i++) {
            for (int j = 0; j < matrizBase[0].length; j++) {
                if (matrizBase[i][j] != matrizBase[j][i]){
                    return false;
                }
            }
        }
        return true;
    }

    //    matriz diagonal = tudo fora da diagonal principal (i != j) tem que ser zero
    public static boolean ehDiagonal(int[][] matrizBase){
        for (int i = 0; i < matrizBase.length; i++) {
            for (int j = 0; j < matrizBase[0].length; j++) {
                if (i != j && matrizBase[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    //    matriz identidade = diagonal vale 1, todo o resto vale 0
    public static boolean ehIdentidade(int[][] matrizBase){
        for (int i = 0; i < matrizBase.length; i++) {
            for (int j = 0; j < matrizBase[0].length; j++) {
                if (i == j && matrizBase[i][j] != 1){
                    return false;
                }
                if (i != j && matrizBase[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    //    troca linhaX com linhaY, depois troca colunaA com colunaB
//    uso uma variavel temp pra nao perder o valor original durante a troca
    public static int[][] trocarLinhasEColunas(int[][] matrizBase, int linhaX, int linhaY, int colunaA, int colunaB) {

//        passo 1: troca as linhas
        for (int j = 0; j < matrizBase[0].length; j++) {
            int temp = matrizBase[linhaX][j];
            matrizBase[linhaX][j] = matrizBase[linhaY][j];
            matrizBase[linhaY][j] = temp;
        }

//        passo 2: troca as colunas
        for (int i = 0; i < matrizBase.length; i++) {
            int temp = matrizBase[i][colunaA];
            matrizBase[i][colunaA] = matrizBase[i][colunaB];
            matrizBase[i][colunaB] = temp;
        }

        return matrizBase;
    }

    //    so precisa testar divisores ate a raiz quadrada de n
//    se dividir exato por qualquer numero, nao e primo
    private static boolean ehPrimo(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //    primeiro conto quantos primos tem pra criar o array do tamanho certo
//    depois preencho o array e ordeno com bubble sort
    public static int[] primosOrdenados(int[][] matrizBase) {
        int quantidade = 0;

        for (int i = 0; i < matrizBase.length; i++) {
            for (int j = 0; j < matrizBase[0].length; j++) {
                if (ehPrimo(matrizBase[i][j])) {
                    quantidade++;
                }
            }
        }

        int[] primos = new int[quantidade];
        int indice = 0;

        for (int i = 0; i < matrizBase.length; i++) {
            for (int j = 0; j < matrizBase[0].length; j++) {
                if (ehPrimo(matrizBase[i][j])) {
                    primos[indice] = matrizBase[i][j];
                    indice++;
                }
            }
        }

//        bubble sort crescente
        for (int i = 0; i < primos.length - 1; i++) {
            for (int j = 0; j < primos.length - 1 - i; j++) {
                if (primos[j] > primos[j + 1]) {
                    int temp = primos[j];
                    primos[j] = primos[j + 1];
                    primos[j + 1] = temp;
                }
            }
        }
        return primos;
    }

    //    borda = primeira linha, ultima linha, primeira coluna, ultima coluna
//    cada posicao e visitada uma so vez entao os cantos nao sao somados duas vezes
    public static double mediaBorda(int[][] matrizBase) {
        int soma = 0;
        int quantidade = 0;

        for (int i = 0; i < matrizBase.length; i++) {
            for (int j = 0; j < matrizBase[0].length; j++) {
                boolean ehBorda = i == 0 || i == matrizBase.length - 1
                        || j == 0 || j == matrizBase[0].length - 1;
                if (ehBorda) {
                    soma += matrizBase[i][j];
                    quantidade++;
                }
            }
        }
        return (double) soma / quantidade;
    }

    //    uso 4 limites (topo, fundo, esquerda, direita) que vao fechando a cada volta
//    cada passo percorre um lado da borda atual e depois encolhe aquele limite
    public static void imprimirEspiral(int[][] matrizBase) {
        int topoLinha   = 0;
        int fundoLinha  = matrizBase.length - 1;
        int esquerdaCol = 0;
        int direitaCol  = matrizBase[0].length - 1;

        System.out.print("ESPIRAL: ");

        while (topoLinha <= fundoLinha && esquerdaCol <= direitaCol) {

//            esquerda pra direita na linha do topo
            for (int j = esquerdaCol; j <= direitaCol; j++) {
                System.out.print(matrizBase[topoLinha][j] + " ");
            }
            topoLinha++;

//            cima pra baixo na coluna da direita
            for (int i = topoLinha; i <= fundoLinha; i++) {
                System.out.print(matrizBase[i][direitaCol] + " ");
            }
            direitaCol--;

//            direita pra esquerda na linha do fundo
            if (topoLinha <= fundoLinha) {
                for (int j = direitaCol; j >= esquerdaCol; j--) {
                    System.out.print(matrizBase[fundoLinha][j] + " ");
                }
                fundoLinha--;
            }

//            baixo pra cima na coluna da esquerda
            if (esquerdaCol <= direitaCol) {
                for (int i = fundoLinha; i >= topoLinha; i--) {
                    System.out.print(matrizBase[i][esquerdaCol] + " ");
                }
                esquerdaCol++;
            }
        }
        System.out.println();
    }

//    GERADORES

    //    preencho a diagonal e o triangulo superior com valores aleatorios
//    e espelho cada [i][j] em [j][i] pra garantir a simetria
    public static int[][] gerarSimetrica() {
        int[][] matrizResultado = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = i; j < 3; j++) { // j começa em i pra cobrir diagonal + triangulo superior
                matrizResultado[i][j] = (int)(Math.random() * 20) + 1;
                matrizResultado[j][i] = matrizResultado[i][j];
            }
        }
        return matrizResultado;
    }

    //    java ja inicializa arrays com 0, entao so preciso preencher a diagonal
    public static int[][] gerarDiagonal() {
        int[][] matrizResultado = new int[3][3];

        for (int i = 0; i < 3; i++) {
            matrizResultado[i][i] = (int)(Math.random() * 20) + 1;
        }
        return matrizResultado;
    }

    //    mesma logica da diagonal, so que a diagonal vale 1 fixo
    public static int[][] gerarIdentidade() {
        int[][] matrizResultado = new int[3][3];

        for (int i = 0; i < 3; i++) {
            matrizResultado[i][i] = 1;
        }
        return matrizResultado;
    }

    //    gera uma matriz de qualquer tamanho entre 1x1 e 5x5 com valores aleatorios
    public static int[][] gerarMatrizAleatoria(int linhas, int colunas) {
        int[][] matrizResultado = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matrizResultado[i][j] = (int)(Math.random() * 50) + 1;
            }
        }
        return matrizResultado;
    }
}