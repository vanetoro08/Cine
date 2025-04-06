package cine.models;

// @author vanes

import java.util.ArrayList;
import java.util.Date;

public class Venta {
    private int numVenta;
    private Date fecha;
    private ArrayList <Boleta> boletas;

    public Venta() {
        this.numVenta ++;
        this.fecha = new Date();
        this.boletas = new ArrayList<>();   
    }
    
    public void agregarBoleta(Boleta boleta){
        boletas.add(boleta);
    }
       

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (int i = 0; i < boletas.size(); i++) {
            valorTotal += boletas.get(i).getValorBoleta();
        }
        return valorTotal;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public ArrayList<Boleta> getBoletas() {
        return boletas;
    }
    
}
