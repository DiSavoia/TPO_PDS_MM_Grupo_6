package empresa;

public class Concesionaria {
    // FACADE!
    private String nombre;
    private String ubicacion;
    public Catalogo catalogo;
    public ListaClientes clientes;
    public ListaVendedores vendedores;
    public ListaAdministradores administradores;

    public Concesionaria() {
        this.catalogo = new Catalogo();
        this.clientes = new ListaClientes();
    }

}
