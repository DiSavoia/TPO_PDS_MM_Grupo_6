package transportes;

import transportes.strategies.CamionetaStrategy;

public class Camioneta extends Vehiculo{
    public Camioneta(String modelo, String color, int precio, int numeroChasis, int numeroMotor, boolean garantia) {
        super(modelo, color, precio, numeroChasis, numeroMotor, garantia);
        // Inicializar estrategia especifica para Camioneta
        this.setEstrategia(new CamionetaStrategy());
    }
}
