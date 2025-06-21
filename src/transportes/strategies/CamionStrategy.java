package transportes.strategies;

import transportes.Vehiculo;

public class CamionStrategy implements Strategy{
    @Override
    public int calcularImpuesto(Vehiculo vehiculo) {
        // Impuesto del 25% para camiones
        return (int) Math.round(vehiculo.getPrecio() * 0.25);
    }
}
