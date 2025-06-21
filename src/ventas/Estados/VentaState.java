package ventas.Estados;

import ventas.OrdenDeCompra;

public class VentaState implements State{
    @Override
    public void cambiarEstado(OrdenDeCompra orden, State nuevoEstado) {
        if (puedeTransicionarA(nuevoEstado)) {
            orden.cambiarEstado(nuevoEstado);
            orden.notificarObservadores();
        } else {
            throw new IllegalStateException("No se puede transicionar de " + getNombreEstado() + 
                                          " a " + nuevoEstado.getNombreEstado());
        }
    }

    @Override
    public void procesar(OrdenDeCompra orden) {
        System.out.println("Procesando venta - Orden ID: " + orden.getId() + 
                          " - Vehiculo: " + orden.getVehiculo().getModelo());
        // Automaticamente pasar a Cobranza despues del procesamiento
        cambiarEstado(orden, new CobranzaState());
    }

    @Override
    public String getNombreEstado() {
        return "Venta";
    }

    @Override
    public String getDescripcion() {
        return "La orden esta siendo procesada inicialmente";
    }

    @Override
    public boolean puedeTransicionarA(State nuevoEstado) {
        return nuevoEstado instanceof CobranzaState;
    }
}
