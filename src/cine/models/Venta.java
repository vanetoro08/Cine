package cine.models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Representa una venta realizada en el cine
 * 
 * @autor Vanessa Toro Sepulveda
 */
public class Venta {
    private int numVenta;
    private Date fecha;
    private ArrayList <Boleta> boletas;
    
    /**
     * Constructor de Venta
     */
    public Venta() {
        this.numVenta ++;
        this.fecha = new Date();
        this.boletas = new ArrayList<>();   
    }
    
    /**
     * Agrega una boleta a la venta
     *
     * @param boleta Boleta que se desea agregar
     */    
    public void agregarBoleta(Boleta boleta){
        boletas.add(boleta);
    }
       
    /**
     * Calcula el valor total de la venta sumando el valor de todas las boletas
     *
     * @return Valor total de la venta
     */
    public double calcularValorTotal() {
        double valorTotal = 0;
        for (int i = 0; i < boletas.size(); i++) {
            valorTotal += boletas.get(i).getValorBoleta();
        }
        return valorTotal;
    }

    /**
     * Devuelve el numero de la venta
     * @return Numero identificador de la venta
     */
    public int getNumVenta() {
        return numVenta;
    }

    /**
     * Devuelve la fecha en la que se realizo la venta
     * @return Fecha de la venta
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Devuelve la lista de boletas asociadas a la venta
     * @return Lista de boletas de la venta
     */
    public ArrayList<Boleta> getBoletas() {
        return boletas;
    }
    
}
