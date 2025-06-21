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
    private static int contadorId = 1;

    public OrdenDeCompra(State estado,
                         Date entrega,
                         Cliente comprador,
                         Vendedor vendedor,
                         Vehiculo vehiculoComprado) {
        this.id = contadorId++;
        this.estado = estado;
        this.fechaDeEntrega = entrega;
        this.fechaDeCreacion = new Date();
        this.cliente = comprador;
        this.vendedor = vendedor;
        this.vehiculo = vehiculoComprado;
        this.observadores = new ArrayList<>();
        
        // Agregar automaticamente cliente y vendedor como observadores
        if (comprador != null) {
            this.observadores.add(comprador);
        }
        if (vendedor != null) {
            this.observadores.add(vendedor);
        }
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
        if (observadores != null) {
            observadores.forEach(Observer::avisar);
        }
    }
    
    // Getters
    public int getId() {
        return id;
    }

    public Date getFechaDeEntrega() {
        return fechaDeEntrega;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public MediosDePago getMedioDePago() {
        return medioDePago;
    }

    public State getEstado() {
        return estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public ArrayList<Observer> getObservadores() {
        return observadores;
    }
    
    // Setters adicionales
    public void setMedioDePago(MediosDePago medioDePago) {
        this.medioDePago = medioDePago;
    }
}
