import java.util.ArrayList;

public class Universidad {
	
	private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	
    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void imprimirPromedios() {
    	if(estudiantes.size()==0) {
    		System.out.println("No hay estudiantes en esta universidad");
    	}else {
			System.out.println("Promedios de estudiantes:");
			for (Estudiante estudiante: estudiantes) {
				double promedio = estudiante.calcularPromedio();
			    System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + ": " + promedio);
			}
    	}
    }
}
