package Views;
import  java.util.Scanner;

import transportes.*;

public class VehiculoView {
    static LimpiarView limpiar = new LimpiarView();


    public static void mostrarDatos(String modelo, String color, double precio, String numeroChasis, String numeroMotor, int garantia) {
        limpiar.limpia();
        System.out.println("🚗 Datos del auto ingresado:");
        System.out.println("Modelo: " + modelo);
        System.out.println("Color: " + color);
        System.out.println("Precio: $" + precio);
        System.out.println("Número de chasis: " + numeroChasis);
        System.out.println("Número de motor: " + numeroMotor);
        System.out.println("Garantía: " + garantia + " meses");
    }



    public static Vehiculo crearVehiculoConsola(int n) {
        limpiar.limpia();
        Scanner sc = new Scanner(System.in);

        System.out.println("╔════════════════════════════════╗");
        System.out.println("║   Ingreso de datos del auto    ║");
        System.out.println("╚════════════════════════════════╝");

        System.out.print("📌 Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("🎨 Color: ");
        String color = sc.nextLine();

        System.out.print("💲 Precio: ");
        int precio = Integer.parseInt(sc.nextLine());

        System.out.print("🔢 Número de chasis: ");
        int numeroChasis = Integer.parseInt(sc.nextLine());

        System.out.print("🔧 Número de motor: ");
        int numeroMotor = Integer.parseInt(sc.nextLine());

        System.out.print("⏳ Garantía (en meses): ");
        boolean garantia = Boolean.parseBoolean(sc.nextLine());

        sc.close();

        if(n==1) {
        return new Auto(modelo, color, precio, numeroChasis, numeroMotor, garantia);}
        else if (n==2) {
            return  new Moto(modelo, color, precio, numeroChasis, numeroMotor, garantia);
        } else if (n==3) {
            return new Camion(modelo, color, precio, numeroChasis, numeroMotor, garantia);

        }else{
            return new Camioneta(modelo, color, precio, numeroChasis, numeroMotor, garantia);
        }

    }

}
