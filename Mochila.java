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
    System.out.println("Resolução:");
    for (int i = 0; i < this.resolução.length; i++) {
      for (int j = 0; j < this.resolução[i].length; j++) {
        System.out.print(this.resolução[i][j] + " ");
      }
      System.out.print("\n");
    }
  }
}
