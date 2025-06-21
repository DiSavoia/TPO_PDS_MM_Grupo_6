package Views;

import transportes.Vehiculo;
import java.util.ArrayList;
import java.util.Scanner;

public class CatalogoView {
    private static LimpiarView limpiar = new LimpiarView();
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    
    public static void mostrarCatalogo(ArrayList<Vehiculo> catalogo) {
        limpiar.limpia();
        System.out.println(ANSI_CYAN + "╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    CATALOGO DE VEHiCULOS                       ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣" + ANSI_RESET);
        
        if (catalogo.isEmpty()) {
            System.out.println(ANSI_YELLOW + "║              No hay vehiculos en el catalogo                   ║");
            System.out.println("╚════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
            return;
        }
        
        for (int i = 0; i < catalogo.size(); i++) {
            Vehiculo vehiculo = catalogo.get(i);
            System.out.println(ANSI_GREEN + "║ " + (i + 1) + ". " + 
                formatearVehiculo(vehiculo) + " ║");
        }
        
        System.out.println(ANSI_CYAN + "╚════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
        esperarInput();
    }
    
    public static int seleccionarVehiculo(ArrayList<Vehiculo> catalogo) {
        mostrarCatalogo(catalogo);
        
        if (catalogo.isEmpty()) {
            return -1;
        }
        
        System.out.print("\n" + ANSI_YELLOW + "Seleccione un vehiculo (numero): " + ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        int seleccion = scanner.nextInt() - 1;
        
        if (seleccion >= 0 && seleccion < catalogo.size()) {
            return seleccion;
        } else {
            System.out.println("\n" + "\u001B[31m" + "✗ Seleccion invalida" + ANSI_RESET);
            return -1;
        }
    }
    
    private static String formatearVehiculo(Vehiculo vehiculo) {
        String tipo = vehiculo.getClass().getSimpleName();
        String emoji = obtenerEmoji(tipo);
        
        return String.format("%s %-12s | %-15s | $%-8.0f | Impuesto: $%-6d", 
            emoji,
            tipo,
            vehiculo.getModelo(), 
            vehiculo.getPrecio(),
            vehiculo.calcularImpuesto()
        );
    }
    
    private static String obtenerEmoji(String tipo) {
        switch (tipo) {
            case "Auto": return "🚗";
            case "Moto": return "🏍️";
            case "Camion": return "🚛";
            case "Camioneta": return "🚙";
            default: return "🚗";
        }
    }
    
    private static void esperarInput() {
        System.out.print("\nPresione ENTER para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
} 