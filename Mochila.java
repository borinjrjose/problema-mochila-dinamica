public class Mochila {
  private final int[][] itensInfo;
  private final int[][] resolução;

  Mochila(int capacidade, int[][] itensInfo) {
    this.itensInfo = itensInfo;

    this.resolução = new int[itensInfo.length + 1][capacidade + 1];
    for (int i = 0; i < this.resolução.length; i++)
      resolução[i][0] = 0;

    for (int i = 1; i < this.resolução[0].length; i++)
      resolução[0][i] = 0;
  }

  public void calcularResolução() {
    for (int i = 1; i < resolução.length; i++) {
      for (int capacidade = 1; capacidade < resolução[i].length; capacidade++) {
        int valorItem = itensInfo[i - 1][0];
        int pesoItem = itensInfo[i - 1][1];

        if (pesoItem <= capacidade)
          resolução[i][capacidade] = Math.max(resolução[i - 1][capacidade],
              valorItem + resolução[i - 1][capacidade - pesoItem]);
        else
          resolução[i][capacidade] = resolução[i - 1][capacidade];
      }
    }
  }

  public void imprimirResolução() {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_BLUE = "\u001B[34m";

    System.out.println("\nResolução:");
    System.out.print("\n" + ANSI_BLUE + "Itens" + ANSI_RESET + "\\" + ANSI_RED + "Capacidade" + ANSI_RESET);

    for (int k = 0; k < this.resolução[0].length; k++)
      System.out.printf(ANSI_RED + "%4d" + ANSI_RESET, k);

    System.out.println();

    for (int i = 0; i < this.resolução.length; i++) {
      if (i == 0)
        System.out.print(ANSI_BLUE + String.format("%16s", "∅") + ANSI_RESET);
      else
        System.out.print(ANSI_BLUE + String.format("%16s", "1.." + i) + ANSI_RESET);

      for (int j = 0; j < this.resolução[i].length; j++) {
        System.out.printf("%4d", this.resolução[i][j]);
      }

      System.out.println();
    }
  }
}
