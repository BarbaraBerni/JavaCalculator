package application;

public class Calculator {

  public static Double realizarCalculo(Double valorUm, Double valorDois, String operacao) {
    Double respostaCalculo = null;

    switch (operacao) {
      case "+":
        respostaCalculo = valorUm + valorDois;
        break;
      case "-":
        respostaCalculo = valorUm - valorDois;
        break;
      case "*":
        respostaCalculo = valorUm * valorDois;
        break;
      case "/":
        if (valorDois == 0) {
          System.out.println("Divisão por zero não é permitida.");
          return null;
        } else {
          return valorUm / valorDois;
        }
      case "mmc":
        respostaCalculo = (double) calcularMMC(valorUm.intValue(), valorDois.intValue());
      case "mdc":
          respostaCalculo = (double) calcularMDC(valorUm.intValue(), valorDois.intValue());
        break;
      default:
        System.out.println("Operação inválida!");
    }
    return respostaCalculo;
  }

  public static int calcularMDC(int a, int b) {
    while (b != 0) {
      int resto = a % b;
      a = b;
      b = resto;
    }
    return a;
  }

  public static int calcularMMC(int a, int b) {
    int mdc = calcularMDC(a, b);
    return (a * b) / mdc;
  }
}
