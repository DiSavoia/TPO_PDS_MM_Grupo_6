package transportes.strategies;

import transportes.Vehiculo;

public class AutoStrategy implements Strategy{
    @Override
    public int calcularImpuesto(Vehiculo vehiculo) {
        // Impuesto del 15% para autos
        return (int) Math.round(vehiculo.getPrecio() * 0.15);
    }
}
