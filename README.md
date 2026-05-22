# 🔢 Operações com Matrizes

Projeto desenvolvido em Java que gera uma matriz 3x3 com valores aleatórios e oferece um menu interativo para realizar diversas operações matemáticas sobre ela.

---

## 📋 Funcionalidades

| Opção | Operação | Descrição |
|-------|----------|-----------|
| 1 | Média das linhas | Calcula a média dos elementos de cada linha e exibe uma nova matriz com os resultados |
| 2 | Soma das colunas | Soma todos os elementos de cada coluna e exibe os totais |
| 3 | Maior elemento | Encontra o maior valor da matriz e exibe suas coordenadas |
| 4 | Matriz simétrica | Verifica se a matriz é igual à sua transposta (M[i][j] == M[j][i]) |
| 5 | Matriz diagonal | Verifica se todos os elementos fora da diagonal principal são zero |
| 6 | Matriz identidade | Verifica se a diagonal principal é 1 e o restante é 0 |
| 0 | Sair | Encerra o programa |

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
git clone https://github.com/Klauz-code/Vetores-Multidimensionais-.git
cd Vetores-Multidimensionais-
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
 1. Média das linhas
 2. Soma das colunas
 3. Maior elemento da matriz
 4. Verificar matriz simétrica
 5. Verificar matriz diagonal
 6. Verificar matriz identidade
 0. Sair

Sua opção >>>> 3

MATRIZ ORIGINAL:
|  7    23    41 |
| 15    38    12 |
| 44     6    29 |

OPÇÃO 3 - Maior elemento da matriz:

COORDENADAS DO ELEMENTO DE VALOR MÁXIMO:
Linha: 3
Coluna: 1
```

---

## 🔍 Detalhes técnicos

- A matriz é gerada automaticamente com números aleatórios entre **1 e 50** usando a classe `Random`
- O método `mediaLinhas` cria uma **nova matriz** para armazenar os resultados, preservando os valores originais (arrays em Java são passados por referência)
- A validação do menu garante que apenas opções entre **0 e 6** sejam aceitas
- As coordenadas exibidas começam em **1** (e não em 0) para facilitar a leitura

---

## 🛠️ Tecnologias

- **Java** (versão 14+)
- `java.util.Scanner` — leitura de input do usuário
- `java.util.Random` — geração de números aleatórios
