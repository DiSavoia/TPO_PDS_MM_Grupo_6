package perfiles;

public abstract class Usuario {
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
}
