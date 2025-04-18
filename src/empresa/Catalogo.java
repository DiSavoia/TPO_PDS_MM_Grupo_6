package empresa;

import transportes.Vehiculo;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Vehiculo> listaVehiculos;

    public Catalogo() {
        this.listaVehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo _vehiculo){
        this.listaVehiculos.add(_vehiculo);
    }

    public ArrayList<Vehiculo> getCatalogo() {
        return this.listaVehiculos;
    }

    public Vehiculo getVehiculo(int _index){
        return this.listaVehiculos.get(_index);
    }
}
