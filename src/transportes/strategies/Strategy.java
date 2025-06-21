package transportes.strategies;

import transportes.Vehiculo;

public interface Strategy {
    int calcularImpuesto(Vehiculo vehiculo);
}
