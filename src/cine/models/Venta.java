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
    
    public void eliminarBoleta(Boleta boleta){
        boletas.remove(boleta);
    }
    
    public void modificarBoleta(long id,Boleta boleta){
        for (int i = 0; i < this.boletas.size(); i++) {
            if (this.boletas.get(i).getId() == id) {
                this.boletas.set(i, boleta);              
            }
        }    
    }   

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (int i = 0; i < boletas.size(); i++) {
            valorTotal += boletas.get(i).calcularValorBoleta();
        }
        return valorTotal;
    }
}
