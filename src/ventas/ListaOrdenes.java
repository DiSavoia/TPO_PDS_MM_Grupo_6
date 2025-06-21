package ventas;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class ListaOrdenes {
    private ArrayList<OrdenDeCompra> ordenes;

    public ListaOrdenes() {
        this.ordenes = new ArrayList<>();
    }

    public void AgregarOrden(OrdenDeCompra _orden){
        this.ordenes.add(_orden);
    }

    public ArrayList<OrdenDeCompra> getOrdenes(){
        return this.ordenes;
    }

    public boolean deleteOrden(OrdenDeCompra _orden){
        return this.ordenes.remove(_orden);
    }

    public void exportar(){
        exportarCSV("ordenes_export.csv");
    }
    
    public void exportarCSV(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            // Escribir cabecera
            writer.write("ID,FechaCreacion,FechaEntrega,Cliente,Vendedor,Vehiculo,Estado,MedioPago\n");
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            // Escribir datos de cada orden
            for (OrdenDeCompra orden : ordenes) {
                writer.write(String.format("%d,%s,%s,%s,%s,%s,%s,%s\n",
                    orden.getId(),
                    orden.getFechaDeCreacion() != null ? formato.format(orden.getFechaDeCreacion()) : "",
                    orden.getFechaDeEntrega() != null ? formato.format(orden.getFechaDeEntrega()) : "",
                    orden.getCliente() != null ? orden.getCliente().getNombre() : "",
                    orden.getVendedor() != null ? orden.getVendedor().getNombre() : "",
                    orden.getVehiculo() != null ? orden.getVehiculo().getModelo() : "",
                    orden.getEstado() != null ? orden.getEstado().getNombreEstado() : "",
                    orden.getMedioDePago() != null ? orden.getMedioDePago().toString() : ""
                ));
            }
            
            System.out.println("Exportación completada: " + nombreArchivo);
            System.out.println("Total de órdenes exportadas: " + ordenes.size());
            
        } catch (IOException e) {
            System.err.println("Error al exportar: " + e.getMessage());
        }
    }
    
    // Metodo para filtrar órdenes por estado
    public ArrayList<OrdenDeCompra> getOrdenesPorEstado(String nombreEstado) {
        ArrayList<OrdenDeCompra> ordenesFiltradas = new ArrayList<>();
        for (OrdenDeCompra orden : ordenes) {
            if (orden.getEstado() != null && 
                orden.getEstado().getNombreEstado().equalsIgnoreCase(nombreEstado)) {
                ordenesFiltradas.add(orden);
            }
        }
        return ordenesFiltradas;
    }
    
    // Metodo para obtener estadisticas
    public void mostrarEstadisticas() {
        System.out.println("=== ESTADiSTICAS DE ÓRDENES ===");
        System.out.println("Total de órdenes: " + ordenes.size());
        
        // Contar por estado
        int[] contadores = new int[5]; // Venta, Cobranza, Logistica, Embarque, Entrega
        String[] estados = {"Venta", "Cobranza", "Logistica", "Embarque", "Entrega"};
        
        for (OrdenDeCompra orden : ordenes) {
            if (orden.getEstado() != null) {
                String estado = orden.getEstado().getNombreEstado();
                for (int i = 0; i < estados.length; i++) {
                    if (estados[i].equals(estado)) {
                        contadores[i]++;
                        break;
                    }
                }
            }
        }
        
        for (int i = 0; i < estados.length; i++) {
            System.out.println("- " + estados[i] + ": " + contadores[i] + " órdenes");
        }
    }
}
