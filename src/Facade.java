import empresa.Concesionaria;
import perfiles.*;
import transportes.Vehiculo;
import transportes.factory.FactoryManager;
import ventas.*;
import ventas.Estados.*;
import Views.*;

import java.util.Date;
import java.util.Scanner;

public class Facade{
    private static Concesionaria concesionaria;
    private static Scanner scanner;
    private static Usuario usuarioActual;
    
    public static void Sistema(){
        inicializar();
        LimpiarView.limpia();
        
        // Mostrar información del sistema
        ReporteView.mostrarInformacionSistema();
        
        // Login usando la View existente
        if (realizarLogin()) {
            Login.mostrarLoginExitoso(usuarioActual.getNombre());
            mostrarMenuPrincipal();
        } else {
            Login.mostrarLoginFallido();
            MenuView.mostrarError("Acceso denegado. Cerrando sistema.");
        }
        
        if (scanner != null) {
            scanner.close();
        }
    }
    
    private static void inicializar() {
        concesionaria = new Concesionaria();
        scanner = new Scanner(System.in);
        
        // Crear usuarios de ejemplo usando UsuarioView
        crearUsuariosDePrueba();
        
        // Agregar algunos vehiculos al catalogo usando Factory
        crearVehiculosDePrueba();
    }
    
    private static void crearUsuariosDePrueba() {
        // Crear usuarios directamente (simulando que fueron creados con UsuarioView)
        concesionaria.clientes.agregarCliente(
            new Cliente("Juan Perez", "juan@email.com", 12345678, "Perez", 555123456)
        );
        concesionaria.vendedores.agregarVendedor(
            new Vendedor("Mario Garcia", "maria@concesionaria.com")
        );
        concesionaria.administradores.agregarAdministrador(
            new Administrador("Admin", "admin@concesionaria.com")
        );
    }
    
    private static void crearVehiculosDePrueba() {
        FactoryManager factory = FactoryManager.getInstance();
        concesionaria.catalogo.agregarVehiculo(
            factory.crearVehiculo(FactoryManager.TipoVehiculo.AUTO, "Toyota Corolla 2020", "Rojo", 25000, 1001, 2001, true)
        );
        concesionaria.catalogo.agregarVehiculo(
            factory.crearVehiculo(FactoryManager.TipoVehiculo.MOTO, "Vespa 110 2001", "Negro", 8000, 1002, 2002, false)
        );
        concesionaria.catalogo.agregarVehiculo(
            factory.crearVehiculo(FactoryManager.TipoVehiculo.CAMION, "Iveco 300 2010", "Blanco", 80000, 1003, 2003, true)
        );
    }
    
    private static boolean realizarLogin() {
        int tipoUsuario = MenuView.mostrarMenuLogin();
        scanner.nextLine();
        
        String[] credenciales = Login.login();
        String email = credenciales[0]; // Usuario como email
        
        switch (tipoUsuario) {
            case 1:
                usuarioActual = buscarCliente(email);
                break;
            case 2:
                usuarioActual = buscarVendedor(email);
                break;
            case 3:
                usuarioActual = buscarAdministrador(email);
                break;
            default:
                MenuView.mostrarError("Tipo de usuario invalido");
                return false;
        }
        
        return usuarioActual != null;
    }
    
    private static void mostrarMenuPrincipal() {
        boolean continuar = true;
        
        while (continuar) {
            if (usuarioActual instanceof Cliente) {
                continuar = procesarMenuCliente();
            } else if (usuarioActual instanceof Vendedor) {
                continuar = procesarMenuVendedor();
            } else if (usuarioActual instanceof Administrador) {
                continuar = procesarMenuAdministrador();
            }
        }
    }
    
    private static boolean procesarMenuCliente() {
        int opcion = MenuView.mostrarMenuCliente();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                CatalogoView.mostrarCatalogo(concesionaria.catalogo.getCatalogo());
                break;
            case 2:
                realizarPedido();
                break;
            case 3:
                OrdenView.mostrarOrdenesCliente(concesionaria.ordenes.getOrdenes(), (Cliente) usuarioActual);
                break;
            case 0:
                MenuView.mostrarMensaje("Hasta luego! Gracias por usar nuestro sistema.");
                return false;
            default:
                MenuView.mostrarError("Opcion invalida");
        }
        return true;
    }
    
    private static boolean procesarMenuVendedor() {
        int opcion = MenuView.mostrarMenuVendedor();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                CatalogoView.mostrarCatalogo(concesionaria.catalogo.getCatalogo());
                break;
            case 2:
                OrdenView.mostrarTodasLasOrdenes(concesionaria.ordenes.getOrdenes());
                break;
            case 3:
                ReporteView.mostrarMenuReportes();
                ReporteView.mostrarEstadisticas(concesionaria.ordenes);
                break;
            case 0:
                MenuView.mostrarMensaje("¡Hasta luego! Gracias por usar nuestro sistema.");
                return false;
            default:
                MenuView.mostrarError("Opción invalida");
        }
        return true;
    }
    
    private static boolean procesarMenuAdministrador() {
        int opcion = MenuView.mostrarMenuAdministrador();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                CatalogoView.mostrarCatalogo(concesionaria.catalogo.getCatalogo());
                break;
            case 2:
                agregarVehiculo();
                break;
            case 3:
                OrdenView.mostrarTodasLasOrdenes(concesionaria.ordenes.getOrdenes());
                break;
            case 4:
                exportarOrdenes();
                break;
            case 5:
                ReporteView.mostrarMenuReportes();
                ReporteView.mostrarEstadisticas(concesionaria.ordenes);
                break;
            case 6:
                gestionarUsuarios();
                break;
            case 0:
                MenuView.mostrarMensaje("¡Hasta luego! Gracias por usar nuestro sistema.");
                return false;
            default:
                MenuView.mostrarError("Opción invalida");
        }
        return true;
    }
    
    private static void realizarPedido() {
        int indiceVehiculo = CatalogoView.seleccionarVehiculo(concesionaria.catalogo.getCatalogo());
        
        if (indiceVehiculo == -1) {
            MenuView.mostrarError("No se pudo seleccionar un vehiculo valido");
            return;
        }
        
        Vehiculo vehiculo = concesionaria.catalogo.getCatalogo().get(indiceVehiculo);
        
        // Buscar un vendedor disponible
        Vendedor vendedor = null;
        if (!concesionaria.vendedores.getVendedores().isEmpty()) {
            vendedor = concesionaria.vendedores.getVendedores().get(0);
        }
        
        // Crear orden
        OrdenDeCompra orden = new OrdenDeCompra(
            new VentaState(),
            new Date(),
            (Cliente) usuarioActual,
            vendedor,
            vehiculo
        );
        
        // Seleccionar metodo de pago usando MenuView
        int medioPago = MenuView.mostrarMenuMediosPago();
        
        switch (medioPago) {
            case 1:
                orden.setMedioDePago(MediosDePago.Contado);
                break;
            case 2:
                orden.setMedioDePago(MediosDePago.Transferencia);
                break;
            case 3:
                orden.setMedioDePago(MediosDePago.Tarjeta);
                break;
            default:
                MenuView.mostrarError("Metodo de pago invalido");
                return;
        }
        
        // Agregar orden al sistema
        concesionaria.ordenes.AgregarOrden(orden);
        
        // Mostrar confirmación usando OrdenView
        OrdenView.mostrarConfirmacionOrden(orden);
        
        // Procesar automaticamente la orden
        orden.getEstado().procesar(orden);
    }
    
    private static void agregarVehiculo() {
        LimpiarView.limpia();
        System.out.println("=== AGREGAR NUEVO VEHiCULO ===");
        System.out.println("Seleccione tipo de vehiculo:");
        System.out.println("1. Auto");
        System.out.println("2. Moto");
        System.out.println("3. Camión");
        System.out.println("4. Camioneta");
        System.out.print("Opción: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        // Usar VehiculoView existente
        Vehiculo nuevoVehiculo = VehiculoView.crearVehiculoConsola(tipo);
        concesionaria.catalogo.agregarVehiculo(nuevoVehiculo);
        MenuView.mostrarMensaje("Vehiculo agregado exitosamente al catalogo");
    }
    
    private static void exportarOrdenes() {
        concesionaria.ordenes.exportar();
        ReporteView.mostrarExportacionExitosa("ordenes_export.csv", 
                                            concesionaria.ordenes.getOrdenes().size());
    }
    
    private static void gestionarUsuarios() {
        LimpiarView.limpia();
        System.out.println("=== GESTIÓN DE USUARIOS ===");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Agregar Vendedor");
        System.out.println("3. Agregar Administrador");
        System.out.print("Seleccione opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                Cliente nuevoCliente = UsuarioView.crearCliente();
                concesionaria.clientes.agregarCliente(nuevoCliente);
                MenuView.mostrarMensaje("Cliente agregado exitosamente");
                break;
            case 2:
                Vendedor nuevoVendedor = (Vendedor) UsuarioView.crearAdmOVen(true);
                concesionaria.vendedores.agregarVendedor(nuevoVendedor);
                MenuView.mostrarMensaje("Vendedor agregado exitosamente");
                break;
            case 3:
                Administrador nuevoAdmin = (Administrador) UsuarioView.crearAdmOVen(false);
                concesionaria.administradores.agregarAdministrador(nuevoAdmin);
                MenuView.mostrarMensaje("Administrador agregado exitosamente");
                break;
            default:
                MenuView.mostrarError("Opción invalida");
        }
    }
    
    // Metodos de busqueda de usuarios
    private static Cliente buscarCliente(String email) {
        for (Cliente cliente : concesionaria.clientes.getClientes()) {
            if (cliente.getCorreoElectronico().equals(email)) {
                return cliente;
            }
        }
        return null;
    }
    
    private static Vendedor buscarVendedor(String email) {
        for (Vendedor vendedor : concesionaria.vendedores.getVendedores()) {
            if (vendedor.getCorreoElectronico().equals(email)) {
                return vendedor;
            }
        }
        return null;
    }
    
    private static Administrador buscarAdministrador(String email) {
        for (Administrador admin : concesionaria.administradores.getAdministradores()) {
            if (admin.getCorreoElectronico().equals(email)) {
                return admin;
            }
        }
        return null;
    }
}