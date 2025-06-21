package transportes.strategies;

import transportes.Vehiculo;

public class MotoStrategy implements Strategy{
    @Override
    public int calcularImpuesto(Vehiculo vehiculo) {
        // Impuesto del 10% para motos
        return (int) Math.round(vehiculo.getPrecio() * 0.10);
    }
}
