public class MetodosMatriz {

    // Metodo responsável por formatar e retornar a matriz como texto para exibição no console
    // Recebe a matriz e posiciona cada elemento no lugar certo usando .formatted()
    public static String mostrarMatriz(int[][] matriz){
        return """
               | %2d    %2d    %2d |
               | %2d    %2d    %2d |
               | %2d    %2d    %2d |
               """.formatted(
                matriz[0][0], matriz[0][1], matriz[0][2],  // linha 0
                matriz[1][0], matriz[1][1], matriz[1][2],  // linha 1
                matriz[2][0], matriz[2][1], matriz[2][2]   // linha 2
        );
    }

    // Metodo que retorna o menu de opções como texto para exibição no console
    public static String menu(){
        return """
               
               ~~~~~~~~~~~~~~~~~ MENU ~~~~~~~~~~~~~~~~~
                1. Media das linhas
                2. Soma das colunas
                3. Maior elemento da matriz
                4. Verificar matriz simetrica
                5. Verificar matriz diagonal
                6. Verificar matriz identidade
                0. Sair
               """;
    }

    // Metodo que calcula a media dos elementos de cada linha da matriz
    // Cria uma nova matriz para não alterar a original (arrays em Java são passados por referência)
    public static int[][] mediaLinhas(int[][] matrizBase) {
        int[][] matrizResultado = new int[matrizBase.length][matrizBase[0].length]; // nova matriz que vai receber os resultados
        int acumulador = 0; // guarda a soma dos elementos de cada linha

        for (int i = 0; i < matrizBase.length; i++) { // percorre cada linha

            // 1º loop: soma todos os elementos da linha atual
            for (int j = 0; j < matrizBase[0].length; j++) {
                acumulador += matrizBase[i][j];
            }

            // 2º loop: preenche todos os elementos da linha na nova matriz com a media calculada
            for (int j = 0; j < matrizBase[0].length; j++) {
                matrizResultado[i][j] = acumulador / 3;
            }

            acumulador = 0; // zera o acumulador antes de passar para a próxima linha
        }
        return matrizResultado;
    }

    // Metodo que calcula a soma dos elementos de cada coluna da matriz
    // Retorna um array onde cada posição representa a soma de uma coluna
    public static int[] somaColunas(int[][] matrizBase){
        int[] acumuladorColunas = new int[3]; // array com 3 posições: uma para cada coluna

        for (int i = 0; i < matrizBase.length; i++) {       // percorre as linhas
            for (int j = 0; j < matrizBase[0].length; j++) { // percorre as colunas
                if (j == 0){
                    acumuladorColunas[0] += matrizBase[i][j]; // acumula os valores da coluna 0
                }
                else if (j == 1){
                    acumuladorColunas[1] += matrizBase[i][j]; // acumula os valores da coluna 1
                }
                else{
                    acumuladorColunas[2] += matrizBase[i][j]; // acumula os valores da coluna 2
                }
            }
        }
        return acumuladorColunas;
    }

    // Metodo que encontra o maior elemento da matriz e retorna suas coordenadas (linha e coluna)
    public static int[] maiorElemento(int[][] matrizBase){
        int valorMaximo = -11111;    // começa com um valor muito baixo para garantir que qualquer elemento da matriz seja maior
        int[] coordenadas = new int[2]; // array para guardar [linha, coluna] do maior elemento

        // 1º loop: percorre toda a matriz para descobrir qual e o maior valor
        for (int i = 0; i < matrizBase.length; i++) {
            for (int j = 0; j < matrizBase[0].length; j++) {
                if (matrizBase[i][j] > valorMaximo){
                    valorMaximo = matrizBase[i][j]; // atualiza o maior valor encontrado ate agora
                    coordenadas[0] = i + 1; // +1 para exibir a posição contando a partir de 1 (não de 0)
                    coordenadas[1] = j + 1;
                }
            }
        }
        return coordenadas;
    }

    // Metodo que verifica se a matriz e simetrica
    // Uma matriz e simetrica quando M[i][j] == M[j][i] para toda posição
    // Ou seja, ela e igual à sua transposta
    public static boolean ehSimetrica(int[][] matrizBase){
        for (int i = 0; i < matrizBase.length; i++) {
            for (int j = 0; j < matrizBase[0].length; j++) {
                if (matrizBase[i][j] != matrizBase[j][i]){ // compara o elemento com seu espelho na transposta
                    return false; // se encontrar qualquer par diferente, já não e simetrica
                }
            }
        }
        return true; // chegou ate aqui sem encontrar diferença: e simetrica
    }

    // Metodo que verifica se a matriz e diagonal
    // Uma matriz e diagonal quando todos os elementos FORA da diagonal principal são zero
    // Os elementos da diagonal principal são aqueles onde linha == coluna (i == j)
    public static boolean ehDiagonal(int[][] matrizBase){
        for (int i = 0; i < matrizBase.length; i++) {
            for (int j = 0; j < matrizBase[0].length; j++) {
                if (i != j && matrizBase[i][j] != 0){ // se está fora da diagonal E não e zero: inválido
                    return false;
                }
            }
        }
        return true; // todos os elementos fora da diagonal são zero: e diagonal
    }

    // Metodo que verifica se a matriz e identidade
    // Uma matriz identidade tem duas regras:
    //   - Na diagonal principal (i == j): todos os valores devem ser 1
    //   - Fora da diagonal (i != j): todos os valores devem ser 0
    public static boolean ehIdentidade(int[][] matrizBase){
        for (int i = 0; i < matrizBase.length; i++) {
            for (int j = 0; j < matrizBase[0].length; j++) {
                if (i == j && matrizBase[i][j] != 1){ // está na diagonal mas o valor não e 1
                    return false;
                }
                if (i != j && matrizBase[i][j] != 0){ // está fora da diagonal mas o valor não e 0
                    return false;
                }
            }
        }
        return true; // passou pelas duas verificações: e identidade
    }

    public static int[][] trocarLinhasEColunas(int[][] matrizBase, int linhaX, int linhaY, int colunaA, int colunaB) {

        // PASSO 1: TROCAR AS LINHAS
        // Percorre coluna por coluna e troca os elementos entre linhaX e linhaY
        for (int j = 0; j < matrizBase[0].length; j++) {
            int temp = matrizBase[linhaX][j];        // guarda o valor da linhaX temporariamente
            matrizBase[linhaX][j] = matrizBase[linhaY][j]; // linhaX recebe o valor da linhaY
            matrizBase[linhaY][j] = temp;            // linhaY recebe o valor guardado (original da linhaX)
        }

        // PASSO 2: TROCAR AS COLUNAS
        // Percorre linha por linha e troca os elementos entre colunaA e colunaB
        for (int i = 0; i < matrizBase.length; i++) {
            int temp = matrizBase[i][colunaA];        // guarda o valor da colunaA temporariamente
            matrizBase[i][colunaA] = matrizBase[i][colunaB]; // colunaA recebe o valor da colunaB
            matrizBase[i][colunaB] = temp;            // colunaB recebe o valor guardado (original da colunaA)
        }

        return matrizBase;
    }
}