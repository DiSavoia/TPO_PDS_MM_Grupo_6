package empresa;

public class Concesionaria {
    public Catalogo listaVehiculos;
    public ListaClientes listaClientes;

    public Concesionaria() {
        this.listaVehiculos = new Catalogo();
        this.listaClientes = new ListaClientes();
    }

}
