import java.util.Scanner;

// Clase principal con el menu de usuario y de administrador
public class Main {

    static ColaPrioridad ticketsPendientes = new ColaPrioridad();
    static ListaEnlazada ticketsResueltos = new ListaEnlazada();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("");
            System.out.println("===== SISTEMA DE GESTION DE TICKETS =====");
            System.out.println("1. Menu de Usuario");
            System.out.println("2. Menu de Administrador");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = leerNumero();

            switch (opcion) {
                case 1:
                    menuUsuario();
                    break;
                case 2:
                    menuAdministrador();
                    break;
                case 0:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }

        sc.close();
    }

    static void menuUsuario() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("");
            System.out.println("--- MENU DE USUARIO ---");
            System.out.println("1. Crear ticket");
            System.out.println("2. Buscar ticket resuelto");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = leerNumero();

            switch (opcion) {
                case 1:
                    crearTicket();
                    break;
                case 2:
                    buscarTicketResuelto();
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }
    }

    static void crearTicket() {
        System.out.print("Ingrese la descripcion del ticket: ");
        String descripcion = sc.nextLine();

        if (descripcion.trim().isEmpty()) {
            System.out.println("La descripcion no puede estar vacia. Ticket no creado.");
            return;
        }

        System.out.print("Ingrese su nombre completo: ");
        String nombre = sc.nextLine();

        if (nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacio. Ticket no creado.");
            return;
        }

        Ticket nuevo = new Ticket(descripcion, nombre);
        ticketsPendientes.encolar(nuevo);

        System.out.println("Ticket creado con exito. Su ID es: " + nuevo.id);
    }

    static void buscarTicketResuelto() {
        System.out.print("Ingrese el ID del ticket a buscar: ");
        int id = leerNumero();

        Ticket encontrado = ticketsResueltos.buscarPorId(id);

        if (encontrado != null) {
            System.out.println("Ticket encontrado:");
            encontrado.imprimir();
        } else {
            System.out.println("El ticket #" + id + " esta pendiente.");
        }
    }

    static void menuAdministrador() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("");
            System.out.println("--- MENU DE ADMINISTRADOR ---");
            System.out.println("1. Ver ticket al frente de la cola");
            System.out.println("2. Resolver ticket al frente de la cola");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = leerNumero();

            switch (opcion) {
                case 1:
                    verFrenteDeCola();
                    break;
                case 2:
                    resolverTicket();
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }
    }

    static void verFrenteDeCola() {
        Ticket frente = ticketsPendientes.verFrente();

        if (frente == null) {
            System.out.println("No hay tickets pendientes.");
        } else {
            System.out.println("Ticket al frente de la cola:");
            frente.imprimir();
        }
    }

    static void resolverTicket() {
        Ticket resuelto = ticketsPendientes.desencolar();

        if (resuelto == null) {
            System.out.println("No hay tickets pendientes para resolver.");
            return;
        }

        resuelto.resolver();
        ticketsResueltos.agregar(resuelto);

        System.out.println("El ticket #" + resuelto.id + " fue resuelto.");
        resuelto.imprimir();
    }

    static int leerNumero() {
        String texto = sc.nextLine();
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}