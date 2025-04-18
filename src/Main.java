import empresa.Concesionaria;
import perfiles.Cliente;
import transportes.Camion;
import transportes.Moto;
import transportes.Vehiculo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Vehículos
        Moto moto = new Moto("Motomel", "Verde", 100, 25, 21, false);
        Camion cami = new Camion("Camión", "Fuchsia", 1000, 52, 12, true);

        // Clientes
        Cliente eugenio = new Cliente("Eugenio", "eugenio@gmail.com", 12345678, "Ramirez", 123456);


        Concesionaria empresa = new Concesionaria();
        empresa.listaVehiculos.agregarVehiculo(moto);
        empresa.listaVehiculos.agregarVehiculo(cami);
        ArrayList<Vehiculo> catalogo = empresa.listaVehiculos.getCatalogo();
        catalogo.stream().forEach(vehiculo -> System.out.println(vehiculo.toString()));

        empresa.listaClientes.agregarCliente(eugenio);
        ArrayList<Cliente> clientes = empresa.listaClientes.getClientes();
        clientes.stream().forEach(cliente -> System.out.println(cliente.toString()));
    }
}
