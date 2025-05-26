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
        empresa.catalogo.agregarVehiculo(moto);
        empresa.catalogo.agregarVehiculo(cami);
        ArrayList<Vehiculo> catalogo = empresa.catalogo.getCatalogo();
        catalogo.stream().forEach(vehiculo -> System.out.println(vehiculo.toString()));

        empresa.clientes.agregarCliente(eugenio);
        ArrayList<Cliente> clientes = empresa.clientes.getClientes();
        clientes.stream().forEach(cliente -> System.out.println(cliente.toString()));
    }
}
