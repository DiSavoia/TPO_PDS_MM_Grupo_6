package transportes.strategies;

import transportes.Vehiculo;

public class CamionetaStrategy implements Strategy{
    @Override
    public int calcularImpuesto(Vehiculo vehiculo) {
        // Impuesto del 20% para camionetas
        return (int) Math.round(vehiculo.getPrecio() * 0.20);
    }
}
