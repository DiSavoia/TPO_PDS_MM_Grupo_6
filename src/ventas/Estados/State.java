package ventas.Estados;

import ventas.OrdenDeCompra;

public interface State {
    void cambiarEstado(OrdenDeCompra orden, State nuevoEstado);
    void procesar(OrdenDeCompra orden);
    String getNombreEstado();
    String getDescripcion();
    boolean puedeTransicionarA(State nuevoEstado);
}
