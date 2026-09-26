class ColaPrioridad {

    NodoTicket frente;

    ColaPrioridad() {
        this.frente = null;
    }

    void encolar(Ticket t) {
        NodoTicket nuevo = new NodoTicket(t);

        if (frente == null) {
            frente = nuevo;
            return;
        }

        if (t.fechaCreacion.before(frente.ticket.fechaCreacion)) {
            nuevo.siguiente = frente;
            frente = nuevo;
            return;
        }

        NodoTicket actual = frente;
        while (actual.siguiente != null && !t.fechaCreacion.before(actual.siguiente.ticket.fechaCreacion)) {
            actual = actual.siguiente;
        }
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
    }

    Ticket verFrente() {
        if (frente == null) {
            return null;
        }
        return frente.ticket;
    }

    Ticket desencolar() {
        if (frente == null) {
            return null;
        }
        Ticket t = frente.ticket;
        frente = frente.siguiente;
        return t;
    }

    boolean estaVacia() {
        return frente == null;
    }
}