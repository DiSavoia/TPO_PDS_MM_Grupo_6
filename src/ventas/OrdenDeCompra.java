package ventas;

import perfiles.Cliente;
import perfiles.Vendedor;
import transportes.Vehiculo;
import ventas.Estados.State;

import java.util.ArrayList;
import java.util.Date;

public class OrdenDeCompra {
    private int id;
    private Date fechaDeEntrega;
    private Date fechaDeCreacion;
    private Cliente cliente;
    private Vendedor vendedor;
    private MediosDePago medioDePago;
    private State estado;
    private Vehiculo vehiculo;
    private ArrayList<Observer> observadores;

    public OrdenDeCompra(State estado,
                         Date entrega,
                         Cliente comprador,
                         Vendedor vendedor,
                         Vehiculo vehiculoComprado) {
        this.estado = estado;
        this.fechaDeEntrega = entrega;
        this.cliente = comprador;
        this.vendedor = vendedor;
        this.vehiculo = vehiculoComprado;
    }

    public void cambiarEstado(State _estado){
        this.estado = _estado;
    }

    public void agregarObservador(Observer _observer){
        this.observadores.add(_observer);
    }

    public boolean quitarObservador(Observer _observer){
        return this.observadores.remove(_observer);
    }

    public void notificarObservadores(){
        observadores.forEach(Observer::avisar);
    }
}
