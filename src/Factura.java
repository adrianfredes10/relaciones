import java.util.ArrayList;

public class Factura {
    private String fechaFactura;
    private long numeroFactura;
    private double totalCalculadoFactura;
    private String cliente;
    private ArrayList<DetalleFactura> detallesFactura;

    public Factura() {
        this.detallesFactura = new ArrayList<>();
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void agregarDetalle(DetalleFactura detalle) {
        detallesFactura.add(detalle);
    }

    public void calcularMontoTotal() {
        totalCalculadoFactura = detallesFactura.stream().mapToDouble(DetalleFactura::getSubtotal).sum();
    }

    public void imprimirFactura() {
        System.out.println("Fecha: " + fechaFactura);
        System.out.println("Numero: " + numeroFactura);
        System.out.println("Cliente: " + cliente);
        System.out.println("Detalles:");
        for (DetalleFactura detalle : detallesFactura) {
            System.out.println(
                    detalle.getCodigoArticulo() + " " +
                            detalle.getNombreArticulo() + " " +
                            detalle.getCantidad() + " " +
                            detalle.getPrecioUnitario() + " " +
                            detalle.getDescuento() + " " +
                            detalle.getSubtotal()
            );
        }
        System.out.println("Total: " + totalCalculadoFactura);
    }
}
