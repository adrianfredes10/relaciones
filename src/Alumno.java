import java.util.ArrayList;

public class Alumno {
    private String nombreCompleto;
    private long legajo;
    private ArrayList<Nota> notas;

    public Alumno(String nombreCompleto, long legajo) {
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
        this.notas = new ArrayList<>();
    }

    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    public double calcularPromedio() {
        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.getNotaExamen();
        }
        return notas.size() > 0 ? suma / notas.size() : 0;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public long getLegajo() {
        return legajo;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }
}
