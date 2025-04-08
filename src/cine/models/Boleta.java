package cine.models;

import cine.exceptions.ValorBoletaInvalidoException;

/**
 * Representa una boleta para una funcion de cine
 * 
 * @author Nicolas Agudelo Grajales
 */
public class Boleta {
    private int id;
    private Funcion funcionSeleccionada;
    private Usuario usuario;
    private double valorBoleta = 0;

    /**
     * Crea una nueva boleta con la funcion y el usuario asociados
     * 
     * @param id Identificador de la boleta
     * @param funcionSeleccionada Funcion para la que se compro la boleta
     * @param usuario Usuario que compro la boleta
     */
    public Boleta(int id, Funcion funcionSeleccionada, Usuario usuario) {
        this.id = id;
        this.funcionSeleccionada = funcionSeleccionada;
        this.usuario = usuario;
    }

    /**
     * Calcula el valor final de la boleta aplicando los descuentos de la funcion y del tipo de usuario
     */
    public void calcularValorBoleta() throws ValorBoletaInvalidoException{
        this.valorBoleta = this.usuario.aplicarDescuento(this.funcionSeleccionada.aplicarDescuento());
        if (valorBoleta <= 0) throw new ValorBoletaInvalidoException();
    }

    /**
     * Devuelve el valor total de la boleta
     * 
     * @return Valor final con descuentos aplicados
     */
    public double getValorBoleta() {
        return valorBoleta;
    }

    /**
     * Devuelve el id de la boleta
     * @return Id unico
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve la funcion asociada a esta boleta 
     * @return Objeto de tipo Funcion
     */
    public Funcion getFuncionSeleccionada() {
        return funcionSeleccionada;
    }
}

