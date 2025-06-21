package transportes;

import transportes.strategies.Strategy;

public abstract class Vehiculo {
    private String modelo;
    private String color;
    private float precio;
    private int numeroChasis;
    private int numeroMotor;
    private boolean garantia;
    private String equipamientoAdd;
    private Strategy estrategia;

    public Vehiculo(String modelo, String color, int precio, int numeroChasis, int numeroMotor, boolean garantia) {
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.numeroChasis = numeroChasis;
        this.numeroMotor = numeroMotor;
        this.garantia = garantia;
    }

    public int calcularImpuesto(){
        if (estrategia == null) {
            throw new IllegalStateException("Estrategia no inicializada para el vehiculo");
        }
        return estrategia.calcularImpuesto(this);
    }

    // Setter para estrategia
    public void setEstrategia(Strategy estrategia) {
        this.estrategia = estrategia;
    }

    // Getter para precio (necesario para las estrategias)
    public float getPrecio() {
        return precio;
    }

    // Getters adicionales
    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getNumeroChasis() {
        return numeroChasis;
    }

    public int getNumeroMotor() {
        return numeroMotor;
    }

    public boolean isGarantia() {
        return garantia;
    }

    public String getEquipamientoAdd() {
        return equipamientoAdd;
    }

    public void setEquipamientoAdd(String equipamientoAdd) {
        this.equipamientoAdd = equipamientoAdd;
    }

    @Override
    public String toString() {
        return modelo + " " + color + " " + precio + " " + numeroChasis + " "
                + numeroMotor + " " + garantia;
    }
}
