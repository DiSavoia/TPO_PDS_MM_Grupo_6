package empresa;

import ventas.ListaOrdenes;

public class Concesionaria {
    // FACADE!
    private String nombre;
    private String ubicacion;
    public Catalogo catalogo;
    public ListaClientes clientes;
    public ListaVendedores vendedores;
    public ListaAdministradores administradores;
    public ListaOrdenes ordenes;

    public Concesionaria() {
        this.catalogo = new Catalogo();
        this.clientes = new ListaClientes();
        this.vendedores = new ListaVendedores();
        this.administradores = new ListaAdministradores();
        this.ordenes = new ListaOrdenes();
    }
}
