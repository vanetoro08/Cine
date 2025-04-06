package cine.models;

// @author vanes
public class Factura {
    
    private Venta venta; 
    
    public void mostrarDetalles(){
        System.out.println("*)num de venta: " + this.venta.getNumVenta() 
                       + "\n*)Fecha: "+ this.venta.getFecha()
                       + "\n*)valor total: "+ venta.calcularValorTotal());
        for(int i =0; i< this.venta.getBoletas().size(); i++){
            Boleta boleta = this.venta.getBoletas().get(i);
            System.out.println("boleta #" + i+1 + " "+boleta.getValorBoleta());
        }
    }
}
