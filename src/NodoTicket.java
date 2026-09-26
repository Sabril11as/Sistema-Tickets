class NodoTicket {
    Ticket ticket;
    NodoTicket siguiente;

    NodoTicket(Ticket ticket) {
        this.ticket = ticket;
        this.siguiente = null;
    }
}