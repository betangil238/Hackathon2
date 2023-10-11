package agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactoService {

    Scanner leer = new Scanner(System.in);
    ArrayList<Contacto> contactos = new ArrayList<>();
//    HashMap<String, String> datos = new HashMap<>();

    private void crearContacto(int tamanio){
    	if(!agendaLlena(tamanio)) {
    		
    	}else {
	        System.out.println("Escribe el nombre de tu contacto: ");
	        String lecturaNombre = leer.nextLine();//nextLine si lee con espacios
	
	        System.out.println("Escribe el teléfono: "); //print es que no tiene salto de línea
	        String lecturaTelefono = leer.nextLine();
	
	
	        if(verificarDato(lecturaNombre)){
	            Contacto nuevoContacto = new Contacto(lecturaNombre, lecturaTelefono);
	            contactos.add(nuevoContacto);
	        } else {
	            System.out.println("El nombre ya existe en la base de datos y no se puede almacenar.");
	        }
    	}
    }

    private void imprimirContactos(){
        for (Contacto contacto: contactos) {
            System.out.println(contacto.toString());
        }
    }

    private void buscarContacto(){
        System.out.print("Dame el nombre del usuario que deseas buscar en la agenda: ");
        String busquedaDeContacto = leer.nextLine();
        Contacto busquedaDePersona = verificarBusquedaDato(busquedaDeContacto);
        if( busquedaDePersona == null){
            System.out.println("No se encontró ningún usuario con ese nombre");
        } else{
            System.out.println("El teléfono del usuario " + busquedaDePersona.getNombre() + " es " + busquedaDePersona.getTelefono());
        }
    }

    private Contacto verificarBusquedaDato(String dato){
        for (Contacto contacto : contactos) {
            if(contacto.getNombre().equals(dato)){
                return contacto;
            }
        }
        return null;
    }

    private boolean verificarDato(String dato){
        for (Contacto contacto : contactos) {
            if(contacto.getNombre().equals(dato)){
                return false;
            }
        }
        return true;
    }

    private void eliminarContacto(){
        System.out.print("Escribe el nombre del contacto que deseas eliminar: ");
        String contactoEliminarInput = leer.nextLine();
        Contacto contactoEliminar = verificarBusquedaDato(contactoEliminarInput);
        if(contactoEliminar == null){
            System.out.println("Lo sentimos, no encontramos un usuario con ese nombre");
        } else{
            contactos.remove(contactoEliminar);
            System.out.println("El contacto se eliminó con exito");
        }
    }

    private int espaciosLibres(int tamanio){
        return (tamanio - contactos.size());
    }

    public void definirTamanioAgenda(){
        System.out.println("Define el tamaño de contactos de tu agenda");
        int tamanioAgenda = leer.nextInt();
        menu(tamanioAgenda);
    }

    private boolean agendaLlena(int tamanio){
        if(tamanio == contactos.size()){
            System.out.println("Lo sentimos, la agenda está llena");
            return false;
        }
        return true;
    }

    private void menu(int tamanioEnt){
        System.out.println("--------------------Bienvenido a tu agenda----------------------");
        int tamanio = tamanioEnt;
        int num = 9;
        while(num != 0){
            String interfaz = """
                           ------------------------------------------
                           |                                        |
                           |     1. Agregar contacto                |
                           |     2. Buscar teléfono contacto        |
                           |     3. Listar contactos                |
                           |     4. Consultar tamaño                |
                           |     5. Eliminar contacto               |
                           |     6. Espacios libre en agenda        |
                           |     0. Salir del menu                  |
                           |                                        |
                           ------------------------------------------
                    """;
            System.out.println(interfaz);
            System.out.print("Ingrese una opción del menú ");
            num = leer.nextInt();
            leer.nextLine();
            switch (num){
                case 1:
                    crearContacto(tamanio);
                    break;
                case 2:
                    buscarContacto();
                    break;
                case 3:
                    imprimirContactos();
                    break;
                case 4:
                    System.out.println("El tamaño de la agenda es de: " + tamanio + " contactos.");
                    break;
                case 5:
                    eliminarContacto();
                    break;
                case 6:
                    System.out.println("El tamaño disponible es de " + espaciosLibres(tamanio));
                    break;
                case 0:
                    System.out.println("Muchas gracias, vuelva pronto");
                    break;
                default:
                    System.out.println("Ingrese una opción válida del menú");
                    break;
            }
        };
    }
}
