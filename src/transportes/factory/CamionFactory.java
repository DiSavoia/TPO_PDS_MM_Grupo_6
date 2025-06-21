package transportes.factory;

import transportes.Camion;
import transportes.Vehiculo;

public class CamionFactory implements Factory{
    @Override
    public Vehiculo crearVehiculo() {
        // Crear camión con valores por defecto
        return new Camion("Camión Estandar", "Blanco", 50000, 1000, 2000, true);
    }
    
    // Metodo sobrecargado para crear con parametros especificos
    public Vehiculo crearVehiculo(String modelo, String color, int precio, int numeroChasis, int numeroMotor, boolean garantia) {
        return new Camion(modelo, color, precio, numeroChasis, numeroMotor, garantia);
    }
}
