package perfiles;

public class Cliente extends Usuario{
    private int dni;
    private String apellido;
    private int numeroTelefonico;


    public Cliente(String _nombre, String _correoElectronico, int _dni, String _apellido, int _numeroTelefonico) {
        super(_nombre, _correoElectronico);
        this.dni = _dni;
        this.apellido = _apellido;
        this.numeroTelefonico = _numeroTelefonico;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " " + dni + " " + correoElectronico + " " + numeroTelefonico;
    }
}
