import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;

public class Calculator {



    private LinkedHashMap<Integer,Integer> notas = new LinkedHashMap<>();
    private int value;
    private LinkedHashMap<Double,Integer> moedas = new LinkedHashMap<>();
    public LinkedHashMap<Integer, Integer> getNotas() {
        return notas;
    }

    public LinkedHashMap<Double, Integer> getMoedas() {
        return moedas;
    }

    public void calculaTroco(double valorProduto, double valorPago) {
        notas.put(200, 0);
        notas.put(100, 0);
        notas.put(50, 0);
        notas.put(20, 0);
        notas.put(10, 0);
        notas.put(5, 0);
        notas.put(2,0);

        moedas.put(1.0,0);
        moedas.put(0.50,0);
        moedas.put(0.25,0);
        moedas.put(0.10,0);
        moedas.put(0.05,0);


        BigDecimal valorTotal = new BigDecimal(valorPago - valorProduto).setScale(2, RoundingMode.HALF_UP);

        for (Integer k : notas.keySet()) {
            value = notas.get(k);
            while (valorTotal.doubleValue() - k >= 0) {
                notas.put(k, value += 1);
                valorTotal = valorTotal.subtract(BigDecimal.valueOf(k));
            }
        }

        for (Double k : moedas.keySet()) {
            value = moedas.get(k);
            while (valorTotal.doubleValue() - k >= 0) {
                moedas.put(k, value += 1);
                valorTotal = valorTotal.subtract(BigDecimal.valueOf(k));

            }
        }
    }
}
