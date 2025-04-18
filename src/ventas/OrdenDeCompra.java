package ventas;

import perfiles.Cliente;
import perfiles.Vendendor;
import transportes.Vehiculo;
import empresa.Concesionaria;

import java.util.ArrayList;

public class OrdenDeCompra {
    private int numeroPedido;
    private String fechaDeCreacion;
    private Estados estado;
    private String entrega;
    private ArrayList<Estados> historialEstados;
    private Cliente comprador;
    private Vendendor vendendor;
    private Vehiculo vehiculoComprado;
    private MediosDePago medioDePago;
    private Concesionaria empresa;

    public OrdenDeCompra(Estados estado,
                         String entrega,
                         Cliente comprador,
                         Vendendor vendendor,
                         Vehiculo vehiculoComprado) {
        this.estado = estado;
        this.entrega = entrega;
        this.historialEstados = new ArrayList<>();
        this.comprador = comprador;
        this.vendendor = vendendor;
        this.vehiculoComprado = vehiculoComprado;
    }

    public void cambiarEstado(Estados _estado){
        this.historialEstados.add(this.estado);
        this.estado = _estado;
    }

}
