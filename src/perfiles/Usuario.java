package perfiles;

import ventas.Observer;

public abstract class Usuario implements Observer {
    protected String nombre;
    protected String correoElectronico;

    public Usuario(String nombre, String correoElectronico) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return nombre + " " + correoElectronico;
    }

    @Override
    public void avisar() {
        // Implementación base de notificación
        System.out.println("Notificación para " + this.getClass().getSimpleName() + 
                          " " + nombre + " (" + correoElectronico + ")");
    }
    
    // Metodo especifico que puede ser sobrescrito por las subclases
    public void avisar(String mensaje) {
        System.out.println("Notificación para " + this.getClass().getSimpleName() + 
                          " " + nombre + ": " + mensaje);
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
}
