import java.util.ArrayList;
import java.util.Scanner;

public class MenuRestaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Plato> platosMenu = new ArrayList<>();

        System.out.print("Ingrese la cantidad de platos en el menú: ");
        int cantidadPlatos = scanner.nextInt();

        for (int i = 0; i < cantidadPlatos; i++) {
            System.out.print("Nombre del plato: ");
            scanner.nextLine();
            String nombrePlato = scanner.nextLine();
            System.out.print("Precio del plato: ");
            double precio = scanner.nextDouble();
            System.out.print("Es una bebida? (true/false): ");
            boolean esBebida = scanner.nextBoolean();

            Plato plato = new Plato(nombrePlato, precio, esBebida);
            if (!esBebida) {
                System.out.print("Cantidad de ingredientes: ");
                int cantidadIngredientes = scanner.nextInt();
                if (cantidadIngredientes < 1) {
                    System.out.println("Debe ingresar al menos un ingrediente.");
                    continue;
                }

                for (int j = 0; j < cantidadIngredientes; j++) {
                    System.out.print("Nombre del ingrediente: ");
                    scanner.nextLine();
                    String nombreIngrediente = scanner.nextLine();
                    System.out.print("Cantidad: ");
                    double cantidad = scanner.nextDouble();
                    System.out.print("Unidad de medida: ");
                    scanner.nextLine();
                    String unidad = scanner.nextLine();
                    plato.agregarIngrediente(new Ingrediente(nombreIngrediente, cantidad, unidad));
                }
            }
            platosMenu.add(plato);
        }

        System.out.println("MENÚ DEL RESTAURANT:");
        for (Plato plato : platosMenu) {
            System.out.println(plato.getNombreCompleto());
            System.out.println("Precio: $" + plato.getPrecio());
            if (!plato.isEsBebida()) {
                System.out.println("Ingredientes:");
                for (Ingrediente ingrediente : plato.getIngredientes()) {
                    System.out.println(ingrediente.getNombre() + " " + ingrediente.getCantidad() + " " + ingrediente.getUnidadDeMedida());
                }
            }
        }
        scanner.close();
    }
}
