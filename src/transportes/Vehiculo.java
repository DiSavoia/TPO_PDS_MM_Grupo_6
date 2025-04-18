package transportes;

public abstract class Vehiculo {
    private String modelo;
    private String color;
    private int precio;
    private int numeroChasis;
    private int numeroMotor;
    private boolean garantia;

    public Vehiculo(String modelo, String color, int precio, int numeroChasis, int numeroMotor, boolean garantia) {
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.numeroChasis = numeroChasis;
        this.numeroMotor = numeroMotor;
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return modelo + " " + color + " " + precio + " " + numeroChasis + " "
                + numeroMotor + " " + garantia;
    }
}
