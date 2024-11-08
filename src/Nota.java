public class Nota {
    private String catedra;
    private double notaExamen;

    public Nota(String catedra, double notaExamen) {
        this.catedra = catedra;
        this.notaExamen = notaExamen;
    }

    public String getCatedra() {
        return catedra;
    }

    public double getNotaExamen() {
        return notaExamen;
    }
}
