package transportes.factory;

import transportes.Auto;
import transportes.Vehiculo;

public class AutoFactory implements Factory{
    @Override
    public Vehiculo crearVehiculo() {
        return new Auto("Corola", "Rojo", 200, 23, 52, true);
        // TODO Hay que modificar el constructor de vehículo y el método de los factory.
    }
}
