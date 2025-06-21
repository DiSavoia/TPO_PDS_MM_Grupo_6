package transportes.factory;

import transportes.Vehiculo;

public class FactoryManager {
    
    public enum TipoVehiculo {
        AUTO, MOTO, CAMION, CAMIONETA
    }
    
    private static FactoryManager instance;
    
    private FactoryManager() {
        // Constructor privado para singleton
    }
    
    public static FactoryManager getInstance() {
        if (instance == null) {
            instance = new FactoryManager();
        }
        return instance;
    }
    
    public Factory getFactory(TipoVehiculo tipo) {
        switch (tipo) {
            case AUTO:
                return new AutoFactory();
            case MOTO:
                return new MotoFactory();
            case CAMION:
                return new CamionFactory();
            case CAMIONETA:
                return new CamionetaFactory();
            default:
                throw new IllegalArgumentException("Tipo de vehiculo no soportado: " + tipo);
        }
    }
    
    public Vehiculo crearVehiculo(TipoVehiculo tipo) {
        Factory factory = getFactory(tipo);
        return factory.crearVehiculo();
    }
    
    public Vehiculo crearVehiculo(TipoVehiculo tipo, String modelo, String color, int precio, int numeroChasis, int numeroMotor, boolean garantia) {
        switch (tipo) {
            case AUTO:
                return ((AutoFactory) getFactory(tipo)).crearVehiculo(modelo, color, precio, numeroChasis, numeroMotor, garantia);
            case MOTO:
                return ((MotoFactory) getFactory(tipo)).crearVehiculo(modelo, color, precio, numeroChasis, numeroMotor, garantia);
            case CAMION:
                return ((CamionFactory) getFactory(tipo)).crearVehiculo(modelo, color, precio, numeroChasis, numeroMotor, garantia);
            case CAMIONETA:
                return ((CamionetaFactory) getFactory(tipo)).crearVehiculo(modelo, color, precio, numeroChasis, numeroMotor, garantia);
            default:
                throw new IllegalArgumentException("Tipo de vehiculo no soportado: " + tipo);
        }
    }
} 