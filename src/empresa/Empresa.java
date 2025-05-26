package empresa;

import java.util.Scanner;

public class Empresa {
    private int cuit;
    private String nombre;
    private static Empresa singleton;

    private Empresa(int _cuit, String _nombre){
        this.cuit = _cuit;
        this.nombre = _nombre;
    }

    public static Empresa getInstance(){
        if (singleton == null){
            Scanner sc = new Scanner(System.in);
            int _cuit = sc.nextInt();
            String _nombre = sc.nextLine();
            singleton = new Empresa(_cuit, _nombre);
        }
        return singleton;
    }

}
