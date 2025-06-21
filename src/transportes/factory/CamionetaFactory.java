package transportes.factory;

import transportes.Camioneta;
import transportes.Vehiculo;

public class CamionetaFactory implements Factory{
    @Override
    public Vehiculo crearVehiculo() {
        // Crear camioneta con valores por defecto
        return new Camioneta("Camioneta Estandar", "Gris", 30000, 800, 1500, true);
    }
    
    // Metodo sobrecargado para crear con parametros especificos
    public Vehiculo crearVehiculo(String modelo, String color, int precio, int numeroChasis, int numeroMotor, boolean garantia) {
        return new Camioneta(modelo, color, precio, numeroChasis, numeroMotor, garantia);
    }
}
