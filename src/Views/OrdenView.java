package Views;

import ventas.OrdenDeCompra;
import perfiles.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

public class OrdenView {
    private static LimpiarView limpiar = new LimpiarView();
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    public static void mostrarOrdenesCliente(ArrayList<OrdenDeCompra> ordenes, Cliente cliente) {
        limpiar.limpia();
        System.out.println(ANSI_BLUE + "╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                       MIS ORDENES                             ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣" + ANSI_RESET);
        
        boolean tieneOrdenes = false;
        
        for (OrdenDeCompra orden : ordenes) {
            if (orden.getCliente().equals(cliente)) {
                mostrarOrdenDetallada(orden);
                tieneOrdenes = true;
            }
        }
        
        if (!tieneOrdenes) {
            System.out.println(ANSI_YELLOW + "║                No tiene ordenes registradas                    ║");
        }
        
        System.out.println(ANSI_BLUE + "╚════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
        esperarInput();
    }
    
    public static void mostrarTodasLasOrdenes(ArrayList<OrdenDeCompra> ordenes) {
        limpiar.limpia();
        System.out.println(ANSI_CYAN + "╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    GESTION DE ORDENES                         ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣" + ANSI_RESET);
        
        if (ordenes.isEmpty()) {
            System.out.println(ANSI_YELLOW + "║                No hay ordenes registradas                      ║");
        } else {
            for (OrdenDeCompra orden : ordenes) {
                mostrarOrdenResumida(orden);
            }
        }
        
        System.out.println(ANSI_CYAN + "╚════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
        esperarInput();
    }
    
    public static void mostrarConfirmacionOrden(OrdenDeCompra orden) {
        limpiar.limpia();
        System.out.println(ANSI_GREEN + "╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                   ✓ ORDEN CREADA EXITOSAMENTE                 ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣" + ANSI_RESET);
        
        mostrarOrdenDetallada(orden);
        
        System.out.println(ANSI_GREEN + "╚════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "\n🔄 Procesando orden..." + ANSI_RESET);
        esperarInput();
    }
    
    private static void mostrarOrdenDetallada(OrdenDeCompra orden) {
        String estadoColor = obtenerColorEstado(orden.getEstado().getNombreEstado());
        
        System.out.println(ANSI_GREEN + "║ 📦 Orden ID: " + orden.getId() + 
                          " | Estado: " + estadoColor + orden.getEstado().getNombreEstado() + ANSI_GREEN + "                    ║");
        System.out.println("║ 🚗 Vehiculo: " + orden.getVehiculo().getModelo() + 
                          " (" + orden.getVehiculo().getClass().getSimpleName() + ")                           ║");
        System.out.println("║ 👤 Cliente: " + orden.getCliente().getNombre() + "                               ║");
        System.out.println("║ 💰 Precio: $" + orden.getVehiculo().getPrecio() + 
                          " | Impuesto: $" + orden.getVehiculo().calcularImpuesto() + "                         ║");
        if (orden.getMedioDePago() != null) {
            System.out.println("║ 💳 Pago: " + orden.getMedioDePago() + "                                      ║");
        }
        System.out.println("╠════════════════════════════════════════════════════════════════╣");
    }
    
    private static void mostrarOrdenResumida(OrdenDeCompra orden) {
        String estadoColor = obtenerColorEstado(orden.getEstado().getNombreEstado());
        
        System.out.println(ANSI_GREEN + "║ ID: " + orden.getId() + 
                          " | " + orden.getCliente().getNombre() + 
                          " | " + orden.getVehiculo().getModelo() + 
                          " | " + estadoColor + orden.getEstado().getNombreEstado() + ANSI_GREEN + "        ║");
    }
    
    private static String obtenerColorEstado(String estado) {
        switch (estado) {
            case "Venta": return ANSI_YELLOW;
            case "Cobranza": return ANSI_BLUE;
            case "Logistica": return ANSI_CYAN;
            case "Embarque": return "\u001B[35m"; // Magenta
            case "Entrega": return ANSI_GREEN;
            default: return ANSI_RESET;
        }
    }
    
    private static void esperarInput() {
        System.out.print("\nPresione ENTER para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
} 