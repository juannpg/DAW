public class ExcepcionPersonalizada extends Exception {
    public static String mensaje1 = "mensaje1";
    public static String mensaje2 = "mensaje2";

    public ExcepcionPersonalizada(String message) {
        super("Error: " + message);
    }
}
