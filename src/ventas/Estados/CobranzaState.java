package ventas.Estados;

import ventas.OrdenDeCompra;

public class CobranzaState implements State{
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
        System.out.println("Procesando cobranza - Orden ID: " + orden.getId() + 
                          " - Cliente: " + orden.getCliente().getNombre());
        
        // Simular procesamiento de pago
        if (orden.getMedioDePago() != null) {
            System.out.println("Procesando pago por " + orden.getMedioDePago());
            // Automaticamente pasar a Logistica despues de confirmación de pago
            cambiarEstado(orden, new LogisticaState());
        } else {
            System.out.println("Error: No se ha definido metodo de pago");
        }
    }

    @Override
    public String getNombreEstado() {
        return "Cobranza";
    }

    @Override
    public String getDescripcion() {
        return "Se esta procesando el pago de la orden";
    }

    @Override
    public boolean puedeTransicionarA(State nuevoEstado) {
        return nuevoEstado instanceof LogisticaState;
    }
}
