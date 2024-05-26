package gui;

import application.Calculator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ViewController {

  @FXML
  private Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btsoma, btmult, btdiv, btsub, btMMC, btEnter;
  @FXML
  private TextField textField;

  private StringBuilder currentInput = new StringBuilder();
  private Double valorUm = null;
  private Double valorDois = null;
  private String operacao = null;

  @FXML
  public void onBt1Action() { appendDigit("1"); }
  @FXML
  public void onBt2Action() { appendDigit("2"); }
  @FXML
  public void onBt3Action() { appendDigit("3"); }
  @FXML
  public void onBt4Action() { appendDigit("4"); }
  @FXML
  public void onBt5Action() { appendDigit("5"); }
  @FXML
  public void onBt6Action() { appendDigit("6"); }
  @FXML
  public void onBt7Action() { appendDigit("7"); }
  @FXML
  public void onBt8Action() { appendDigit("8"); }
  @FXML
  public void onBt9Action() { appendDigit("9"); }
  @FXML
  public void onBt0Action() { appendDigit("0"); }

  @FXML
  public void onBtSomaAction() { setOperacao("+"); }
  @FXML
  public void onBtMultiAction() { setOperacao("*"); }
  @FXML
  public void onBtDivAction() { setOperacao("/"); }
  @FXML
  public void onBtSubAction() { setOperacao("-"); }
  @FXML
  public void onBtMMCAction() { setOperacao("mmc"); }
  @FXML
  public void onBtMDCAction() { setOperacao("mdc"); }

  @FXML
  public void onbtEnterAction() {
    if (valorUm != null && currentInput.length() > 0 && operacao != null) {
      valorDois = Double.valueOf(currentInput.toString());
      Double resultado = Calculator.realizarCalculo(valorUm, valorDois, operacao);
      if (resultado != null) {
    	  textField.setText(String.valueOf(resultado));
      } else {
    	  textField.setText("Erro");
      }
      resetValues();
    }
  }

  private void appendDigit(String digit) {
    currentInput.append(digit);
    textField.setText(currentInput.toString());
  }

  private void setOperacao(String operacao) {
    if (currentInput.length() > 0) {
      valorUm = Double.valueOf(currentInput.toString());
      currentInput.setLength(0); // Clear the input for the next number
    }
    this.operacao = operacao;
  }

  private void resetValues() {
    currentInput.setLength(0);
    valorUm = null;
    valorDois = null;
    operacao = null;
  }
}
