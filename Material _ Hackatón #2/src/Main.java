// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universidad universidad = new Universidad();
        while (true) {
            System.out.println("Ingrese el nombre del estudiante (o 'salir' para terminar):");
            String nombre = scanner.nextLine();
            if (nombre.equals("salir")) {
                break;
            }
            System.out.println("Ingrese el apellido del estudiante:");
            String apellido = scanner.nextLine();
            Estudiante estudiante = new Estudiante(nombre, apellido);
            boolean continuar = true;
            while (continuar) {
                System.out.println("Ingrese una nota (o -1 para terminar):");
                double nota = scanner.nextDouble();
                scanner.nextLine();
                if (nota == -1) {
                    continuar = false;
                } else {
                    estudiante.agregarNota(nota);
                }
            }
            universidad.registrarEstudiante(estudiante);
        }
        scanner.close();
        universidad.imprimirPromedios();
    }
}


