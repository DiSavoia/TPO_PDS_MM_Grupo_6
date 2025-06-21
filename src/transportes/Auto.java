package transportes;

import transportes.strategies.AutoStrategy;

public class Auto extends Vehiculo{

    public Auto(String modelo, String color, int precio, int numeroChasis, int numeroMotor, boolean garantia) {
        super(modelo, color, precio, numeroChasis, numeroMotor, garantia);
        // Inicializar estrategia especifica para Auto
        this.setEstrategia(new AutoStrategy());
    }
}
