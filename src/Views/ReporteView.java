package Views;

import ventas.ListaOrdenes;
import java.util.Scanner;

public class ReporteView {
    private static LimpiarView limpiar = new LimpiarView();
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    public static void mostrarEstadisticas(ListaOrdenes listaOrdenes) {
        limpiar.limpia();
        System.out.println(ANSI_CYAN + "╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    📊 ESTADISTICAS DEL SISTEMA                 ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣" + ANSI_RESET);
        
        if (listaOrdenes != null) {
            // Usar el metodo ya implementado en ListaOrdenes
            listaOrdenes.mostrarEstadisticas();
        } else {
            System.out.println(ANSI_YELLOW + "║              No hay datos disponibles para mostrar             ║");
        }
        
        System.out.println(ANSI_CYAN + "╚════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
        esperarInput();
    }
    
    public static void mostrarExportacionExitosa(String nombreArchivo, int cantidadOrdenes) {
        limpiar.limpia();
        System.out.println(ANSI_GREEN + "╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                 ✓ EXPORTACION COMPLETADA                      ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 📄 Archivo: " + nombreArchivo + "                                   ║");
        System.out.println("║ 📊 Ordenes exportadas: " + cantidadOrdenes + "                                   ║");
        System.out.println("║                                                                ║");
        System.out.println("║ El archivo se ha guardado en el directorio actual del         ║");
        System.out.println("║ proyecto.                               ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
        esperarInput();
    }
    
    public static void mostrarMenuReportes() {
        System.out.println(ANSI_BLUE + "\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      📊 TIPOS DE REPORTE                       ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣");
        System.out.println("║  Los reportes incluyen:                                       ║");
        System.out.println("║  • Total de órdenes por estado                                ║");
        System.out.println("║  • Distribución de ventas por tipo de vehiculo                ║");
        System.out.println("║  • Resumen de medios de pago utilizados                       ║");
        System.out.println("║  • Analisis de impuestos generados                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
    }
    
    public static void mostrarInformacionSistema() {
        limpiar.limpia();
        System.out.println(ANSI_CYAN + "╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    ℹ️  INFORMACIÓN DEL SISTEMA                  ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                                                ║");
        System.out.println("║ 🏗️  PATRONES DE DISEÑO IMPLEMENTADOS:                         ║");
        System.out.println("║   ✓ Singleton Pattern (Empresa)                               ║");
        System.out.println("║   ✓ Facade Pattern (Concesionaria)                            ║");
        System.out.println("║   ✓ Factory Pattern (Creacion de vehiculos)                   ║");
        System.out.println("║   ✓ Strategy Pattern (Calculo de impuestos)                   ║");
        System.out.println("║   ✓ Observer Pattern (Sistema de notificaciones)              ║");
        System.out.println("║   ✓ State Pattern (Flujo de órdenes)                          ║");
        System.out.println("║                                                                ║");
        System.out.println("║ 🚗 TIPOS DE VEHICULOS SOPORTADOS:                             ║");
        System.out.println("║   • Autos (Impuesto: 15%)                                     ║");
        System.out.println("║   • Motos (Impuesto: 10%)                                     ║");
        System.out.println("║   • Camiones (Impuesto: 25%)                                  ║");
        System.out.println("║   • Camionetas (Impuesto: 20%)                                ║");
        System.out.println("║                                                                ║");
        System.out.println("║ 📦 FLUJO DE ORDENES:                                          ║");
        System.out.println("║   Venta → Cobranza → Logistica → Embarque → Entrega           ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
        esperarInput();
    }
    
    private static void esperarInput() {
        System.out.print("\nPresione ENTER para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
} 