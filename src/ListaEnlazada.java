class ListaEnlazada {

    NodoTicket cabeza;

    ListaEnlazada() {
        this.cabeza = null;
    }

    void agregar(Ticket t) {
        NodoTicket nuevo = new NodoTicket(t);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoTicket actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    Ticket buscarPorId(int id) {
        NodoTicket actual = cabeza;
        while (actual != null) {
            if (actual.ticket.id == id) {
                return actual.ticket;
            }
            actual = actual.siguiente;
        }
        return null;
    }
}