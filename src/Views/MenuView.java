package Views;

import java.util.Scanner;

public class MenuView {
    private static LimpiarView limpiar = new LimpiarView();
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    public static int mostrarMenuLogin() {
        limpiar.limpia();
        System.out.println(ANSI_CYAN + "╔══════════════════════════════════════╗");
        System.out.println("║           TIPO DE USUARIO            ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. 👤 Cliente                       ║");
        System.out.println("║  2. 💼 Vendedor                      ║");
        System.out.println("║  3. ⚙️  Administrador                ║");
        System.out.println("╚══════════════════════════════════════╝" + ANSI_RESET);
        System.out.print("Seleccione tipo de usuario: ");
        
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    public static int mostrarMenuCliente() {
        limpiar.limpia();
        System.out.println(ANSI_GREEN + "╔══════════════════════════════════════╗");
        System.out.println("║            MENU CLIENTE              ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. 🚗 Ver catalogo de vehiculos     ║");
        System.out.println("║  2. 🛒 Realizar pedido               ║");
        System.out.println("║  3. 📋 Ver mis órdenes               ║");
        System.out.println("║  0. 🚪 Salir                         ║");
        System.out.println("╚══════════════════════════════════════╝" + ANSI_RESET);
        System.out.print("Seleccione una opción: ");
        
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    public static int mostrarMenuVendedor() {
        limpiar.limpia();
        System.out.println(ANSI_BLUE + "╔══════════════════════════════════════╗");
        System.out.println("║            MENU VENDEDOR             ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. 🚗 Ver catalogo de vehiculos     ║");
        System.out.println("║  2. 📦 Gestionar órdenes             ║");
        System.out.println("║  3. 📊 Ver reportes                  ║");
        System.out.println("║  0. 🚪 Salir                         ║");
        System.out.println("╚══════════════════════════════════════╝" + ANSI_RESET);
        System.out.print("Seleccione una opcion: ");
        
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    public static int mostrarMenuAdministrador() {
        limpiar.limpia();
        System.out.println(ANSI_CYAN + "╔══════════════════════════════════════╗");
        System.out.println("║          MENU ADMINISTRADOR          ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. 🚗 Ver catalogo de vehiculos     ║");
        System.out.println("║  2. ➕ Agregar vehiculo              ║");
        System.out.println("║  3. 📦 Gestionar órdenes             ║");
        System.out.println("║  4. 💾 Exportar órdenes              ║");
        System.out.println("║  5. 📊 Ver reportes completos        ║");
        System.out.println("║  6. 👥 Gestionar usuarios            ║");
        System.out.println("║  0. 🚪 Salir                         ║");
        System.out.println("╚══════════════════════════════════════╝" + ANSI_RESET);
        System.out.print("Seleccione una opción: ");
        
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    public static int mostrarMenuMediosPago() {
        System.out.println("\n" + ANSI_GREEN + "╔══════════════════════════════════════╗");
        System.out.println("║           METODO DE PAGO             ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. 💵 Contado                       ║");
        System.out.println("║  2. 🏦 Transferencia                 ║");
        System.out.println("║  3. 💳 Tarjeta                       ║");
        System.out.println("╚══════════════════════════════════════╝" + ANSI_RESET);
        System.out.print("Seleccione metodo de pago: ");
        
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    public static void mostrarMensaje(String mensaje) {
        System.out.println("\n" + ANSI_GREEN + "✓ " + mensaje + ANSI_RESET);
        esperarInput();
    }
    
    public static void mostrarError(String error) {
        System.out.println("\n" + "\u001B[31m" + "✗ " + error + ANSI_RESET);
        esperarInput();
    }
    
    private static void esperarInput() {
        System.out.print("Presione ENTER para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
} 