package Views;

import java.util.Scanner;

public class MenuView {
    private static LimpiarView limpiar = new LimpiarView();
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private static final Scanner scanner = new Scanner(System.in);


    public static int mostrarMenuLogin(Scanner scanner) {
        limpiar.limpia();
        System.out.println(ANSI_CYAN + "╔══════════════════════════════════════╗");
        System.out.println("║           TIPO DE USUARIO            ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. 👤 Cliente                       ║");
        System.out.println("║  2. 💼 Vendedor                      ║");
        System.out.println("║  3. ⚙️  Administrador                ║");
        System.out.println("╚══════════════════════════════════════╝" + ANSI_RESET);
        System.out.print("Seleccione tipo de usuario: ");

        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    public static int mostrarReinicioIniciarSesion(Scanner scanner) {
        LimpiarView.limpia();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║           CERRANDO SESIÓN            ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ ¿Desea iniciar sesión con otro       ║");
        System.out.println("║ usuario?                             ║");
        System.out.println("║                                      ║");
        System.out.println("║ 1. ✅ Sí, iniciar nueva sesión       ║");
        System.out.println("║ 2. ❌ No, salir del sistema          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Seleccione una opcion: ");

        try {
            return Integer.parseInt(MenuView.scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public static int mostrarMenuCliente(Scanner scanner) {
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
        
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public static int mostrarMenuVendedor(Scanner scanner) {
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
        
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public static int mostrarMenuAdministrador(Scanner scanner) {
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

        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1; // valor inválido
        }
    }
    
    public static int mostrarMenuMediosPago(Scanner scanner) {
        System.out.println("\n" + ANSI_GREEN + "╔══════════════════════════════════════╗");
        System.out.println("║           METODO DE PAGO             ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. 💵 Contado                       ║");
        System.out.println("║  2. 🏦 Transferencia                 ║");
        System.out.println("║  3. 💳 Tarjeta                       ║");
        System.out.println("╚══════════════════════════════════════╝" + ANSI_RESET);
        System.out.print("Seleccione metodo de pago: ");
        
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public static void mostrarMensaje(String mensaje) {
        System.out.println("\n" + ANSI_GREEN + "✓ " + mensaje + ANSI_RESET);
        esperarInput(scanner);
    }
    
    public static void mostrarError(String error) {
        System.out.println("\n" + "\u001B[31m" + "✗ " + error + ANSI_RESET);
        esperarInput(scanner);
    }
    
    private static void esperarInput(Scanner scanner) {
        System.out.print("Presione ENTER para continuar...");
        scanner.nextLine();
    }

} 