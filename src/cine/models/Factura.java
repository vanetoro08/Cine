package cine.models;

/**
 * Representa una factura generada a partir de una venta de boletas
 * 
 * @author Nicolas Agudelo Grajales
 */
public class Factura {
    private Venta venta;

    /**
     * Crea una factura para una venta especifica
     * 
     * @param venta Objeto de tipo Venta relacionado a la factura
     */
    public Factura(Venta venta) {
        this.venta = venta;
    }

    /**
     * Muestra en consola los detalles de la factura:
     * numero de venta, fecha, valor total, pelicula y las boletas
     */
    public void mostrarDetalles() {
        System.out.println("*)num de venta: " + this.venta.getNumVenta()
                + "\n*)Fecha: " + this.venta.getFecha()
                + "\n*)valor total: " + venta.calcularValorTotal()
                + "\n*)pelicula: " + venta.getBoletas().get(0).getFuncionSeleccionada().getPelicula().getNombre());

        for (int i = 0; i < this.venta.getBoletas().size(); i++) {
            Boleta boleta = this.venta.getBoletas().get(i);
            System.out.println("boleta #" + (i + 1) + " " + boleta.getValorBoleta());
        }
    }

    /**
     * Devuelve la venta asociada a esta factura
     * 
     * @return Objeto de tipo Venta
     */
    public Venta getVenta() {
        return venta;
    }
}
