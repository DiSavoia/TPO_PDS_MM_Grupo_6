package transportes;

import transportes.strategies.MotoStrategy;

public class Moto extends Vehiculo{
    public Moto(String modelo, String color, int precio, int numeroChasis, int numeroMotor, boolean garantia) {
        super(modelo, color, precio, numeroChasis, numeroMotor, garantia);
        // Inicializar estrategia especifica para Moto
        this.setEstrategia(new MotoStrategy());
    }
}
