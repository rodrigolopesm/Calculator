package Exceptions;

public class ValorInvalidoException extends Exception{

    public ValorInvalidoException(){
        super("Valor insuficiente, produto mais caro que o valor pago.");
    }
}
