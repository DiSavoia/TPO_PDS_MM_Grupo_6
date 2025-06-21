package transportes;

import transportes.strategies.CamionStrategy;

public class Camion extends Vehiculo{
    public Camion(String modelo, String color, int precio, int numeroChasis, int numeroMotor, boolean garantia) {
        super(modelo, color, precio, numeroChasis, numeroMotor, garantia);
        // Inicializar estrategia especifica para Camion
        this.setEstrategia(new CamionStrategy());
    }
}
