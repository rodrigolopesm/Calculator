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

    /**
     *
     * @param valorProduto
     * @param valorPago
     * Utiliza os dois parametros para calcular o valor do troco
     * O forEach entra elemento por elemento do map, caso a nota - troco for maior que zero, então ele subtrai o valor
     * da nota do troco e adiciona um ao value de elemento.
     */
    public void calculaTroco(double valorProduto, double valorPago) {

            mapInput();

        BigDecimal valorTroco = new BigDecimal(valorPago - valorProduto).setScale(2, RoundingMode.HALF_UP);

        for (Integer k : notas.keySet()) {
            value = notas.get(k);
            while (valorTroco.doubleValue() - k >= 0) {
                notas.put(k, value += 1);
                valorTroco = valorTroco.subtract(BigDecimal.valueOf(k));
            }
        }

        for (Double k : moedas.keySet()) {
            value = moedas.get(k);
            while (valorTroco.doubleValue() - k >= 0) {
                moedas.put(k, value += 1);
                valorTroco = valorTroco.subtract(BigDecimal.valueOf(k));

            }
        }
    }

    /**
     * Método utilizado para inicializar todos os elementos do map
     */
    private void mapInput(){
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

    }
}
