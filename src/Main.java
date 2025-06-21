public class Main {
    public static void main(String[] args) {
        // Iniciar el sistema completo a traves del Facade
        System.out.println("Iniciando Sistema de Concesionaria...");
        System.out.println("===========================================");
        
        // Ejecutar el sistema principal
        Facade.Sistema();
        
        System.out.println("===========================================");
        System.out.println("Sesion Finalizada. Gracias por usar nuestro sistema!");
    }
}