package empresa;

import perfiles.Administrador;

import java.util.ArrayList;

public class ListaAdministradores {
    private ArrayList<Administrador> administradores;

    public ListaAdministradores(){
        this.administradores = new ArrayList<>();
    }

    public void agregarAdministrador(Administrador _administrador) {this.administradores.add(_administrador);}
    public ArrayList<Administrador> getAdministradores(){return this.administradores;}
    public Administrador getAdministrador(int _index){return this.administradores.get(_index);}
}
