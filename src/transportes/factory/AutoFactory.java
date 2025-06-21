package transportes.factory;

import transportes.Auto;
import transportes.Vehiculo;

public class AutoFactory implements Factory{
    @Override
    public Vehiculo crearVehiculo() {
        // Crear auto con valores por defecto mas realistas
        return new Auto("Auto Estandar", "Rojo", 20000, 600, 1200, true);
    }
    
    // Metodo sobrecargado para crear con parametros especificos
    public Vehiculo crearVehiculo(String modelo, String color, int precio, int numeroChasis, int numeroMotor, boolean garantia) {
        return new Auto(modelo, color, precio, numeroChasis, numeroMotor, garantia);
    }
}
