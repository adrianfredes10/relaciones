import java.util.ArrayList;
import java.util.Scanner;

public class CargaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();

        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = scanner.nextInt();

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.print("Nombre completo del alumno: ");
            scanner.nextLine();
            String nombre = scanner.nextLine();
            System.out.print("Legajo del alumno: ");
            long legajo = scanner.nextLong();
            Alumno alumno = new Alumno(nombre, legajo);

            System.out.print("Ingrese la cantidad de notas: ");
            int cantidadNotas = scanner.nextInt();
            if (cantidadNotas < 1) {
                System.out.println("Debe ingresar al menos una nota.");
                continue;
            }

            for (int j = 0; j < cantidadNotas; j++) {
                System.out.print("Cátedra: ");
                scanner.nextLine();
                String catedra = scanner.nextLine();
                System.out.print("Nota del examen: ");
                double notaExamen = scanner.nextDouble();
                alumno.agregarNota(new Nota(catedra, notaExamen));
            }
            alumnos.add(alumno);
        }

        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNombreCompleto());
            System.out.println("Legajo: " + alumno.getLegajo());
            System.out.println("Notas:");
            for (Nota nota : alumno.getNotas()) {
                System.out.println(" - " + nota.getCatedra() + ": " + nota.getNotaExamen());
            }
            System.out.println("Promedio: " + alumno.calcularPromedio());
        }
        scanner.close();
    }
}
