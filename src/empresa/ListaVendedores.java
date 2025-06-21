package empresa;

import perfiles.Vendedor;

import java.util.ArrayList;

public class ListaVendedores {
    private ArrayList<Vendedor> vendendores;

    public ListaVendedores(){
        this.vendendores = new ArrayList<>();
    }

    public void agregarVendedor(Vendedor _vendedor) {this.vendendores.add(_vendedor);}
    public ArrayList<Vendedor> getVendedores(){return this.vendendores;}
    public Vendedor getVendedor(int _index){return this.vendendores.get(_index);}
}
