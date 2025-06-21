package ventas.Estados;

import ventas.OrdenDeCompra;

public class EntregaState implements State{
    @Override
    public void cambiarEstado(OrdenDeCompra orden, State nuevoEstado) {
        // Estado final - no se puede transicionar a otro estado
        throw new IllegalStateException("La orden ya ha sido entregada. No se permiten mas cambios de estado.");
    }

    @Override
    public void procesar(OrdenDeCompra orden) {
        System.out.println("🎉 ENTREGA COMPLETADA - Orden ID: " + orden.getId());
        System.out.println("Vehiculo " + orden.getVehiculo().getModelo() + 
                          " entregado exitosamente a " + orden.getCliente().getNombre());
        System.out.println("Fecha de entrega: " + orden.getFechaDeEntrega());
        
        // Notificar a todos los observadores sobre la entrega exitosa
        orden.getObservadores().forEach(observer -> {
            if (observer instanceof perfiles.Usuario) {
                ((perfiles.Usuario) observer).avisar("Su orden ha sido entregada exitosamente");
            } else {
                observer.avisar();
            }
        });
        
        System.out.println("Proceso de venta completado satisfactoriamente");
    }

    @Override
    public String getNombreEstado() {
        return "Entrega";
    }

    @Override
    public String getDescripcion() {
        return "El vehiculo ha sido entregado al cliente";
    }

    @Override
    public boolean puedeTransicionarA(State nuevoEstado) {
        // Estado final - no se puede transicionar a ningun otro estado
        return false;
    }
}
