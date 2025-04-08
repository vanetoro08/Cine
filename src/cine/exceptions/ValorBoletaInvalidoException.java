package cine.exceptions;

// @author vanes
public class ValorBoletaInvalidoException extends RuntimeException{
    public ValorBoletaInvalidoException(){
        super("El valor de la boleta debe ser mayor a 0");
    }
}
