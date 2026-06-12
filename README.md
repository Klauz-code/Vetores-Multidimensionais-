# 🔢 Operações com Matrizes

Projeto desenvolvido em Java que gera uma matriz 3x3 com valores aleatórios e oferece um menu interativo para realizar diversas operações matemáticas sobre ela.

---

## 📋 Funcionalidades

### Operações
| Opção | Operação | Descrição |
|-------|----------|-----------|
| 1 | Média das linhas | Calcula a média dos elementos de cada linha e exibe uma nova matriz com os resultados |
| 2 | Soma das colunas | Soma todos os elementos de cada coluna e exibe os totais |
| 3 | Maior elemento | Encontra o maior valor da matriz e exibe suas coordenadas |
| 4 | Matriz simétrica | Verifica se a matriz é igual à sua transposta (M[i][j] == M[j][i]) |
| 5 | Matriz diagonal | Verifica se todos os elementos fora da diagonal principal são zero |
| 6 | Matriz identidade | Verifica se a diagonal principal é 1 e o restante é 0 |
| 7 | Trocar linhas e colunas | Troca linhaX com linhaY e colunaA com colunaB na mesma matriz |
| 8 | Números primos | Coleta todos os primos da matriz e retorna ordenados de forma crescente |
| 9 | Média da borda | Calcula a média dos elementos da primeira/última linha e primeira/última coluna |
| 10 | Impressão em espiral | Imprime os elementos da matriz seguindo um formato espiral |
| 0 | Sair | Encerra o programa |

### Geradores de matrizes para teste
| Opção | Gerador | Descrição |
|-------|---------|-----------|
| 11 | Matriz simétrica | Gera uma matriz simétrica aleatória e substitui a matriz de trabalho |
| 12 | Matriz diagonal | Gera uma matriz diagonal aleatória e substitui a matriz de trabalho |
| 13 | Matriz identidade | Carrega a matriz identidade fixa e substitui a matriz de trabalho |
| 14 | Matriz de ordem aleatória | Gera uma matriz de dimensões aleatórias (1-5 x 1-5) e informa se é quadrada |

> As opções 11, 12 e 13 substituem a matriz de trabalho, então dá pra usar logo em seguida as opções 4, 5 e 6 pra confirmar o resultado sem depender da sorte da matriz aleatória inicial.

---

## 🗂️ Estrutura do Projeto

```
📦 projeto
 ┣ 📄 Main.java            — Ponto de entrada, loop do menu e chamadas dos métodos
 ┗ 📄 MetodosMatriz.java   — Todos os métodos de operação sobre a matriz
```

---

## ▶️ Como executar

**Pré-requisito:** ter o [JDK](https://www.oracle.com/java/technologies/downloads/) instalado (versão 14 ou superior).

**1. Clone o repositório**
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

**2. Compile os arquivos**
```bash
javac Main.java MetodosMatriz.java
```

**3. Execute o programa**
```bash
java Main
```

---

## 💡 Exemplo de uso

```
MATRIZ DEFINIDA:
|  7    23    41 |
| 15    38    12 |
| 44     6    29 |

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

Sua opção >>>> 11

OPÇÃO 11 - Nova matriz SIMÉTRICA gerada (use a opção 4 para confirmar):

|  3    7    2 |
|  7    5    9 |
|  2    9    1 |

Sua opção >>>> 4

MATRIZ ORIGINAL:
|  3    7    2 |
|  7    5    9 |
|  2    9    1 |

OPÇÃO 4 - Verificar matriz simétrica:

A matriz É simétrica.
```

---

## 🔍 Detalhes técnicos

- A matriz é gerada automaticamente com números aleatórios entre **1 e 50** usando a classe `Random`
- O método `mediaLinhas` cria uma **nova matriz** para armazenar os resultados, preservando os valores originais (arrays em Java são passados por referência)
- A validação do menu garante que apenas opções entre **0 e 14** sejam aceitas
- As coordenadas exibidas começam em **1** (e não em 0) para facilitar a leitura
- A opção 14 não substitui a matriz de trabalho pois pode ter dimensões diferentes de 3x3

---

## 🛠️ Tecnologias

- **Java** (versão 14+)
- `java.util.Scanner` — leitura de input do usuário
- `java.util.Random` — geração de números aleatórios
