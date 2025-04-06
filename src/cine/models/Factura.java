package cine.models;

// @author vanes
public class Factura {
    
    private Venta venta; 

    public Factura(Venta venta) {
        this.venta = venta;
    }
    
    
    public void mostrarDetalles(){
        System.out.println("*)num de venta: " + this.venta.getNumVenta() 
                       + "\n*)Fecha: "+ this.venta.getFecha()
                       + "\n*)valor total: "+ venta.calcularValorTotal()
                        + "\n*)pelicula: " + venta.getBoletas().get(0).getFuncionSeleccionada().getPelicula().getNombre());
        for(int i =0; i< this.venta.getBoletas().size(); i++){
            Boleta boleta = this.venta.getBoletas().get(i);
            System.out.println("boleta #" + i+1 + " "+boleta.getValorBoleta());
        }
    }

    public Venta getVenta() {
        return venta;
    }
    
}
