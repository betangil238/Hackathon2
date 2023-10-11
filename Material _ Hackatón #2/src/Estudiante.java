import java.util.ArrayList;

public class Estudiante {
	private String nombre;
    private String apellido;
    private ArrayList<Double> notas;

    public Estudiante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.notas = new ArrayList<Double>();
    }

    public void agregarNota(double nota) {
        notas.add(nota);
    }

    public double calcularPromedio() {
        double suma = 0.0;
        for (Double nota: notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

}
