package cine.models;

// @author vanes

import java.util.ArrayList;
import java.util.Date;

public class Venta {
    private int numVenta;
    private Date fecha;
    private ArrayList <Boleta> boletas;

    public Venta() {
        this.numVenta = 0;
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

        }    
    }   
    
    
    
}
