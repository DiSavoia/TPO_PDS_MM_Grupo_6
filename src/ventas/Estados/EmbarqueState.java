package ventas.Estados;

import ventas.OrdenDeCompra;

public class EmbarqueState implements State{
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
        System.out.println("Procesando embarque - Orden ID: " + orden.getId());
        System.out.println("Vehiculo " + orden.getVehiculo().getModelo() + " cargado para transporte");
        System.out.println("Fecha estimada de entrega: " + orden.getFechaDeEntrega());
        
        // Simular embarque
        System.out.println("Vehiculo en transito hacia el cliente");
        // Pasar automaticamente a Entrega
        cambiarEstado(orden, new EntregaState());
    }

    @Override
    public String getNombreEstado() {
        return "Embarque";
    }

    @Override
    public String getDescripcion() {
        return "El vehiculo esta en transito hacia el cliente";
    }

    @Override
    public boolean puedeTransicionarA(State nuevoEstado) {
        return nuevoEstado instanceof EntregaState;
    }
}
