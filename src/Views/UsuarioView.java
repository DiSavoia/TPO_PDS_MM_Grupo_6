package Views;

import perfiles.Administrador;
import perfiles.Cliente;
import perfiles.Usuario;
import perfiles.Vendedor;

import java.util.Scanner;

public class UsuarioView {

    public static Cliente crearCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("||     REGISTRO DE NUEVO USUARIO   ||");
        System.out.println("=====================================");

        System.out.print(">> Ingrese su Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print(">> Ingrese su Correo electronico: ");
        String correoElectronico = scanner.nextLine();

        System.out.print(">> Ingrese su Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print(">> Ingrese su DNI: ");
        int dni = Integer.parseInt(scanner.nextLine());


        System.out.print(">> Ingrese su Numero de Telefono: ");
        int numeroTelefonico = Integer.parseInt(scanner.nextLine());
        
        return  new Cliente (nombre,correoElectronico,dni,apellido,numeroTelefonico);
    }

    public  static Usuario crearAdmOVen(boolean n){

        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("||     REGISTRO DE NUEVO USUARIO   ||");
        System.out.println("=====================================");

        System.out.print(">> Ingrese su Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print(">> Ingrese su Correo Electrónico: ");
        String correo = scanner.nextLine();

        if(n==true){
            return new Vendedor(nombre,correo);
        }else{
            return new Administrador(nombre,correo);
        }
    }


}



