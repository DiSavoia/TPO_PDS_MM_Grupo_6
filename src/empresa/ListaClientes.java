package empresa;

import perfiles.Cliente;

import java.util.ArrayList;

public class ListaClientes {
    private ArrayList<Cliente> clientes;

    public ListaClientes() {
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente _cliente){
        this.clientes.add(_cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public Cliente getCliente(int _index){
        return this.clientes.get(_index);
    }
}
