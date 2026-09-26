import java.util.Date;

class Ticket {

    static int cantidad = 0;

    int id;
    String descripcion;
    String nombreCompleto;
    Date fechaCreacion;
    Date fechaResolucion;

    Ticket(String descripcion, String nombreCompleto) {
        cantidad = cantidad + 1;
        this.id = cantidad;
        this.descripcion = descripcion;
        this.nombreCompleto = nombreCompleto;
        this.fechaCreacion = new Date();
        this.fechaResolucion = null; // empieza pendiente
    }

    void resolver() {
        this.fechaResolucion = new Date();
    }

    void imprimir() {
        System.out.println("Ticket #" + id);
        System.out.println("  Descripcion: " + descripcion);
        System.out.println("  Nombre: " + nombreCompleto);
        System.out.println("  Fecha creacion: " + fechaCreacion);
        if (fechaResolucion == null) {
            System.out.println("  Fecha resolucion: Pendiente");
        } else {
            System.out.println("  Fecha resolucion: " + fechaResolucion);
        }
    }
}