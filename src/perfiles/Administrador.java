package perfiles;

public class Administrador extends Usuario{
    public Administrador(String nombre, String correoElectronico) {
        super(nombre, correoElectronico);
    }
    
    @Override
    public void avisar() {
        System.out.println("⚙️ Administrador " + nombre + 
                          ", hay cambios en el sistema que requieren su atencion");
    }
    
    @Override
    public void avisar(String mensaje) {
        System.out.println("⚙️ Administrador " + nombre + ", " + mensaje);
    }
}