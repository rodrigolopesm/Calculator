import Exceptions.ValorInvalidoException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class App {
    public void incializa() {

        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<Integer, Integer> mapNotas = calculator.getNotas();
        LinkedHashMap<Double, Integer> mapMoedas = calculator.getMoedas();
        int value;

        try {
            double valorPago;
            double valorProduto;
            BigDecimal valorTroco;

            do {
                System.out.println("Digite o valor do produto: ");
                valorProduto = sc.nextDouble();

            } while (valorProduto < 0);

            do {
                System.out.println("Digite o valor que voce ira pagar: ");
                valorPago = sc.nextDouble();
                valorTroco = BigDecimal.valueOf(valorPago - valorProduto).setScale(2, RoundingMode.HALF_UP);

            } while (valorPago < 0);

            if (valorProduto > valorPago) {
                throw new ValorInvalidoException();
            }

            calculator.calculaTroco(valorProduto, valorPago);

            System.out.println("Valor do Troco: R$ " + valorTroco);
            if (valorTroco.doubleValue() < 0.05 && valorTroco.doubleValue()!= 0) {
                System.out.println("Troco menor que 5 centavos");
            } else {
                for (Integer k : mapNotas.keySet()) {
                    value = mapNotas.get(k);
                    String nota = " Nota";
                    if (value > 1) nota = " Notas";
                    if (value > 0) {
                        System.out.println(value + nota + " de " + k + " Reais");
                    }

                }
                for (Double k : mapMoedas.keySet()) {
                    value = mapMoedas.get(k);
                    String moeda = " Moeda de ";
                    if (value > 1) moeda = " Moedas de";
                    if (k == 1. && value != 0) {
                        System.out.println(value + moeda + k.intValue() + " Real");
                    } else if (value > 0) {
                        System.out.println(value + moeda + (int) (k * 100) + " Centavos");
                    }

                }
            }
        } catch (ValorInvalidoException exception) {
            System.out.println(exception.getMessage());
        } catch (Exception exception){
            System.out.println("Valor invalido");
        }
    }
}