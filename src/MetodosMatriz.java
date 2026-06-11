public class MetodosMatriz {

    // ═══════════════════════════════════════════════════════
    //  EXIBIÇÃO E MENU
    // ═══════════════════════════════════════════════════════

    // Formata e retorna a matriz 3x3 como texto para exibição no console
    public static String mostrarMatriz(int[][] m){
        return """
               | %2d    %2d    %2d |
               | %2d    %2d    %2d |
               | %2d    %2d    %2d |
               """.formatted(
                m[0][0], m[0][1], m[0][2],
                m[1][0], m[1][1], m[1][2],
                m[2][0], m[2][1], m[2][2]
        );
    }

    // Exibe uma matriz de qualquer tamanho (usada para matriz de ordem aleatória)
    public static void mostrarMatrizDinamica(int[][] m){
        for (int[] linha : m) {
            System.out.print("| ");
            for (int val : linha) System.out.printf("%3d ", val);
            System.out.println("|");
        }
    }

    // Retorna o menu principal com todas as opções disponíveis
    public static String menu(){
        return """
               
               ══════════════════ MENU ══════════════════
                --- OPERAÇÕES ---
                1.  Média das linhas
                2.  Soma das colunas
                3.  Maior elemento da matriz
                4.  Verificar matriz simétrica
                5.  Verificar matriz diagonal
                6.  Verificar matriz identidade
                7.  Trocar linhas e colunas
                8.  Números primos ordenados
                9.  Média da borda
                10. Impressão em espiral
                --- GERAR MATRIZES PARA TESTE ---
                11. Gerar matriz SIMÉTRICA aleatória
                12. Gerar matriz DIAGONAL aleatória
                13. Gerar matriz IDENTIDADE
                14. Gerar matriz de ORDEM ALEATÓRIA
                0.  Sair
               ══════════════════════════════════════════
               """;
    }

    // ═══════════════════════════════════════════════════════
    //  OPERAÇÕES (opções 1-10)
    // ═══════════════════════════════════════════════════════

    // Opção 1: calcula a média de cada linha e retorna em nova matriz (não altera a original)
    public static int[][] mediaLinhas(int[][] base) {
        int[][] resultado = new int[base.length][base[0].length];
        for (int i = 0; i < base.length; i++) {
            int soma = 0;
            for (int j = 0; j < base[0].length; j++) soma += base[i][j];
            for (int j = 0; j < base[0].length; j++) resultado[i][j] = soma / 3;
        }
        return resultado;
    }

    // Opção 2: retorna array com a soma de cada coluna
    public static int[] somaColunas(int[][] base){
        int[] somas = new int[3];
        for (int i = 0; i < base.length; i++)
            for (int j = 0; j < base[0].length; j++)
                somas[j] += base[i][j]; // j é o índice da coluna, então somas[j] acumula a coluna correta
        return somas;
    }

    // Opção 3: retorna [linha, coluna] do maior elemento (contando a partir de 1)
    public static int[] maiorElemento(int[][] base){
        int max = Integer.MIN_VALUE;
        int[] coord = new int[2];
        for (int i = 0; i < base.length; i++)
            for (int j = 0; j < base[0].length; j++)
                if (base[i][j] > max) { max = base[i][j]; coord[0] = i+1; coord[1] = j+1; }
        return coord;
    }

    // Opção 4: simétrica → M[i][j] == M[j][i] para toda posição
    public static boolean ehSimetrica(int[][] base){
        for (int i = 0; i < base.length; i++)
            for (int j = 0; j < base[0].length; j++)
                if (base[i][j] != base[j][i]) return false;
        return true;
    }

    // Opção 5: diagonal → todos os elementos FORA da diagonal principal (i != j) são zero
    public static boolean ehDiagonal(int[][] base){
        for (int i = 0; i < base.length; i++)
            for (int j = 0; j < base[0].length; j++)
                if (i != j && base[i][j] != 0) return false;
        return true;
    }

    // Opção 6: identidade → diagonal = 1, resto = 0
    public static boolean ehIdentidade(int[][] base){
        for (int i = 0; i < base.length; i++)
            for (int j = 0; j < base[0].length; j++) {
                if (i == j && base[i][j] != 1) return false;
                if (i != j && base[i][j] != 0) return false;
            }
        return true;
    }

    // Opção 7: troca linhaX↔linhaY e depois colunaA↔colunaB na mesma matriz
    public static int[][] trocarLinhasEColunas(int[][] base, int lx, int ly, int ca, int cb) {
        // Passo 1: troca as duas linhas elemento por elemento
        for (int j = 0; j < base[0].length; j++) {
            int temp = base[lx][j]; base[lx][j] = base[ly][j]; base[ly][j] = temp;
        }
        // Passo 2: troca as duas colunas elemento por elemento
        for (int i = 0; i < base.length; i++) {
            int temp = base[i][ca]; base[i][ca] = base[i][cb]; base[i][cb] = temp;
        }
        return base;
    }

    // Opção 8 (helper): verifica se n é primo testando divisores até √n
    private static boolean ehPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }

    // Opção 8: coleta primos da matriz e retorna ordenados (bubble sort)
    public static int[] primosOrdenados(int[][] base) {
        int qtd = 0;
        for (int[] l : base) for (int v : l) if (ehPrimo(v)) qtd++;

        int[] primos = new int[qtd];
        int idx = 0;
        for (int[] l : base) for (int v : l) if (ehPrimo(v)) primos[idx++] = v;

        // Bubble sort crescente
        for (int i = 0; i < primos.length - 1; i++)
            for (int j = 0; j < primos.length - 1 - i; j++)
                if (primos[j] > primos[j+1]) {
                    int t = primos[j]; primos[j] = primos[j+1]; primos[j+1] = t;
                }
        return primos;
    }

    // Opção 9: média dos elementos da borda (primeira/última linha e primeira/última coluna)
    // O loop visita cada posição uma única vez, então cantos nunca são somados duas vezes
    public static double mediaBorda(int[][] base) {
        int soma = 0, qtd = 0;
        for (int i = 0; i < base.length; i++)
            for (int j = 0; j < base[0].length; j++)
                if (i == 0 || i == base.length-1 || j == 0 || j == base[0].length-1) {
                    soma += base[i][j]; qtd++;
                }
        return (double) soma / qtd;
    }

    // Opção 10: imprime a matriz em espiral
    // Usa 4 limites (topo, fundo, esquerda, direita) que se fecham a cada volta
    public static void imprimirEspiral(int[][] base) {
        int topo = 0, fundo = base.length-1, esq = 0, dir = base[0].length-1;
        System.out.print("ESPIRAL: ");
        while (topo <= fundo && esq <= dir) {
            for (int j = esq; j <= dir; j++)        System.out.print(base[topo][j] + " "); topo++;
            for (int i = topo; i <= fundo; i++)      System.out.print(base[i][dir] + " ");  dir--;
            if (topo <= fundo) { for (int j = dir; j >= esq; j--)  System.out.print(base[fundo][j] + " "); fundo--; }
            if (esq <= dir)    { for (int i = fundo; i >= topo; i--) System.out.print(base[i][esq] + " ");  esq++; }
        }
        System.out.println();
    }

    // ═══════════════════════════════════════════════════════
    //  GERADORES DE MATRIZES PARA TESTE (opções 11-14)
    // ═══════════════════════════════════════════════════════

    // Opção 11: gera matriz simétrica aleatória
    // Estratégia: preenche a diagonal e o triângulo superior com valores aleatórios,
    // depois espelha cada posição [i][j] em [j][i] — garantindo M[i][j] == M[j][i]
    public static int[][] gerarSimetrica() {
        int[][] m = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = i; j < 3; j++) {      // j começa em i para cobrir diagonal + triângulo superior
                m[i][j] = (int)(Math.random() * 20) + 1;
                m[j][i] = m[i][j];             // espelha na posição transposta
            }
        return m;
    }

    // Opção 12: gera matriz diagonal aleatória
    // Estratégia: todos os elementos começam como zero; só a diagonal recebe valores aleatórios ≠ 0
    public static int[][] gerarDiagonal() {
        int[][] m = new int[3][3]; // Java já inicializa arrays com 0
        for (int i = 0; i < 3; i++)
            m[i][i] = (int)(Math.random() * 50) + 1; // diagonal recebe valor entre 1 e 50
        return m;
    }

    // Opção 13: retorna a matriz identidade fixa (diagonal = 1, resto = 0)
    public static int[][] gerarIdentidade() {
        int[][] m = new int[3][3];
        for (int i = 0; i < 3; i++) m[i][i] = 1;
        return m;
    }

    // Opção 14: gera uma matriz de dimensões aleatórias (1 a 5 linhas, 1 a 5 colunas)
    // e informa se é quadrada (linhas == colunas) — condição necessária para várias operações
    public static int[][] gerarMatrizAleatoria(int linhas, int colunas) {
        int[][] m = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++)
            for (int j = 0; j < colunas; j++)
                m[i][j] = (int)(Math.random() * 50) + 1;
        return m;
    }
}