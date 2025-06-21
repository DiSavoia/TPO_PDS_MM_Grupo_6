package ventas.Estados;

import ventas.OrdenDeCompra;

public class LogisticaState implements State{
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
        System.out.println("Procesando logistica - Orden ID: " + orden.getId() + 
                          " - Preparando vehiculo para embarque");
        System.out.println("Verificando disponibilidad del vehiculo: " + orden.getVehiculo().getModelo());
        
        // Simular preparación logistica
        System.out.println("Vehiculo preparado y documentado para embarque");
        // Pasar automaticamente a Embarque
        cambiarEstado(orden, new EmbarqueState());
    }

    @Override
    public String getNombreEstado() {
        return "Logistica";
    }

    @Override
    public String getDescripcion() {
        return "Se esta preparando el vehiculo para embarque";
    }

    @Override
    public boolean puedeTransicionarA(State nuevoEstado) {
        return nuevoEstado instanceof EmbarqueState;
    }
}
