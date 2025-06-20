package Views;
import Views.LimpiarView;
import  java.util.Scanner;

public class Login {

    static LimpiarView limpiar = new LimpiarView();


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public static String[] login() {
        limpiar.limpia();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║          INICIO DE SESIÓN            ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║   Bienvenido. Ingrese sus datos:     ║");
        System.out.println("╚══════════════════════════════════════╝");

        Scanner sc = new Scanner(System.in);

        System.out.print("🧑 Usuario: ");
        String user = sc.nextLine();
        System.out.print("🔒 Contraseña: ");
        String password = sc.nextLine();

        sc.close();

        return new String[]{user, password};
    }


    public static void mostrarLoginExitoso(String usuario) {
        limpiar.limpia();
        System.out.println(ANSI_GREEN + "╔════════════════════════╗");
        System.out.println("║   LOGIN EXITOSO!       ║");
        System.out.println("║    ¡Bienvenido!        ║");
        System.out.println( "║        "+ usuario + "           ║");
        System.out.println("╚════════════════════════╝" + ANSI_RESET);
    }

    public static void mostrarLoginFallido() {
        limpiar.limpia();
        System.out.println(ANSI_RED + "╔════════════════════════╗");
        System.out.println("║    LOGIN FALLIDO       ║");
        System.out.println("║  Usuario o contraseña  ║");
        System.out.println("║      incorrectos       ║");
        System.out.println("╚════════════════════════╝" + ANSI_RESET);
    }





}
