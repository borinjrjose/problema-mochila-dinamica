import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
  public static void main(String[] args) {
    System.out.println("Problema da mochila dinâmica\n");

    Console cnsl = System.console();
    if (cnsl == null) {
      System.out.println("Nenhum console disponível!");
      return;
    }

    int capacidade = Integer.parseInt(cnsl.readLine("Digite a capacidade da mochila: "));

    String[] itens = cnsl
        .readLine("Digite os itens da mochila na forma (valor1,peso1);(valor2,peso2);...;(valorn,peson):\n").split(";");
    int[][] itensInfo = new int[itens.length][2];

    Pattern regex = Pattern.compile("^\\((\\d+),(\\d+)\\)$");
    for (int i = 0; i < itens.length; i++) {
      Matcher m = regex.matcher(itens[i]);
      if (!m.matches())
        throw new Error("Itens da mochila não seguem o padrão (valor1,peso1);(valor2,peso2);...;(valorn,peson)!");

      itensInfo[i][0] = Integer.parseInt(m.group(1));
      itensInfo[i][1] = Integer.parseInt(m.group(2));
    }

    Mochila mochila = new Mochila(capacidade, itensInfo);
    mochila.calcularResolução();
    mochila.imprimirResolução();
  }
}