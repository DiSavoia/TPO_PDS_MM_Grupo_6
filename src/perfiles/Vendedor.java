package perfiles;

public class Vendedor extends Usuario{

    public Vendedor(String nombre, String correoElectronico) {
        super(nombre, correoElectronico);
    }
    
    @Override
    public void avisar() {
        System.out.println("🔔 Vendedor " + nombre + 
                          ", hay una actualización en una de sus órdenes de venta.");
    }
    
    @Override
    public void avisar(String mensaje) {
        System.out.println("🔔 Vendedor " + nombre + ", " + mensaje);
    }
}
