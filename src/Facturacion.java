import java.util.ArrayList;
import java.util.Scanner;

public class Facturacion {
    private static final String[][] articulos = {
            {"101", "Leche", "25"},
            {"102", "Gaseosa", "30"},
            {"103", "Fideos", "15"},
            {"104", "Arroz", "28"},
            {"105", "Vino", "120"},
            {"106", "Manteca", "20"},
            {"107", "Lavandina", "18"},
            {"108", "Detergente", "46"},
            {"109", "Jabon en Polvo", "96"},
            {"110", "Galletas", "60"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Factura factura = new Factura();

        System.out.print("Fecha de factura: ");
        factura.setFechaFactura(scanner.nextLine());
        System.out.print("Número de factura: ");
        long numeroFactura = scanner.nextLong();
        scanner.nextLine(); // limpiar buffer
        while (numeroFactura <= 0) {
            System.out.println("Número de factura debe ser mayor a cero.");
            numeroFactura = scanner.nextLong();
            scanner.nextLine();
        }
        factura.setNumeroFactura(numeroFactura);

        System.out.print("Cliente: ");
        String cliente = scanner.nextLine();
        while (cliente.isEmpty()) {
            System.out.println("Cliente no puede estar vacío.");
            cliente = scanner.nextLine();
        }
        factura.setCliente(cliente);

        boolean continuar = true;
        while (continuar) {
            System.out.print("Código del artículo: ");
            String codigoArticulo = scanner.nextLine();
            int indice = buscarArticulo(codigoArticulo);
            if (indice == -1) {
                System.out.println("El código ingresado no existe, intente nuevamente.");
                continue;
            }

            String nombreArticulo = articulos[indice][1];
            double precioUnitario = Double.parseDouble(articulos[indice][2]);

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            double descuento = cantidad > 5 ? precioUnitario * 0.1 : 0;
            double subtotal = (precioUnitario - descuento) * cantidad;

            DetalleFactura detalle = new DetalleFactura(codigoArticulo, nombreArticulo, cantidad, precioUnitario, descuento, subtotal);
            factura.agregarDetalle(detalle);

            System.out.print("¿Desea agregar otro artículo? (s/n): ");
            continuar = scanner.nextLine().equalsIgnoreCase("s");
        }

        factura.calcularMontoTotal();
        factura.imprimirFactura();
        scanner.close();
    }

    private static int buscarArticulo(String codigoArticulo) {
        for (int i = 0; i < articulos.length; i++) {
            if (articulos[i][0].equals(codigoArticulo)) {
                return i;
            }
        }
        return -1;
    }
}
