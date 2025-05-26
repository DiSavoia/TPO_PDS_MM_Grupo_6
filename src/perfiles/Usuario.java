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
        //TODO
    }
}
