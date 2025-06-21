package transportes.factory;

import transportes.Moto;
import transportes.Vehiculo;

public class MotoFactory implements Factory{
    @Override
    public Vehiculo crearVehiculo() {
        // Crear moto con valores por defecto
        return new Moto("Moto Estandar", "Negro", 5000, 500, 800, false);
    }
    
    // Metodo sobrecargado para crear con parametros especificos
    public Vehiculo crearVehiculo(String modelo, String color, int precio, int numeroChasis, int numeroMotor, boolean garantia) {
        return new Moto(modelo, color, precio, numeroChasis, numeroMotor, garantia);
    }
}
