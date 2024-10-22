package funciones.actividades;
import java.util.Scanner;

public class A1x11_SueldoEmpleados {
    /**
     * acepta tres parametros categoria, horas y horas extra, y devuelve
     * el sueldo bruto de un empleado en base a ellas.
     * @param cat
     * @param horas
     * @param extra
     * @return
     */
    public static double calcularSueldoBruto(int cat, double horas, double extra) {
        double sueldoBruto = 0;
        switch (cat) {
            case 1:
                sueldoBruto = 39.95 * horas + 49.95 * extra;
                break;
            case 2:
                sueldoBruto = 29.95 * horas + 39.95 * extra;
                break;
            case 3:
                sueldoBruto = 19.95 * horas + 29.95 * extra;
        }
        return sueldoBruto;
    }

    /**
     * acepta dos parametros categoria y sueldo bruto,
     * y devuelve el sueldo neto en base a ellas
     * @param cat
     * @param sueldoBruto
     * @return
     */
    public static double calcularSueldoNeto(int cat, double sueldoBruto) {
        double sueldoNeto = 0;
        switch (cat) {
            case 1:
                sueldoNeto = sueldoBruto - sueldoBruto * 0.16;
                break;
            case 2:
                sueldoNeto = sueldoBruto - sueldoBruto * 0.14;
                break;
            case 3:
                sueldoNeto = sueldoBruto - sueldoBruto * 0.12;
        }
        return sueldoNeto;
    }

    /**
     * pide un numero de empleados por teclado, y por cada empleado pide
     * su categoria, horas y horas extra. si los datos son validos,
     * imprime por consola su sueldo bruto y neto. Si no, saca un mensaje
     * de error general y pasa al siguiente empleado.
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Número de empelados? ");
        int numConductores = sc.nextInt();

        for (int i = 1; i <= numConductores; i++) {
            System.out.printf("EMPLEADO %d\n", i);

            System.out.print("¿Categoría? ");
            int cat = sc.nextInt();
            System.out.print("¿Horas Normales? ");
            double horas = sc.nextDouble();
            System.out.print("¿Horas Extraordinarias? ");
            double extra = sc.nextDouble();

            if (cat < 1 || cat > 3 || horas < 0 || extra < 0) {
                System.out.println("Algún dato del empleado no es válido:\n" +
                        "La categoría debe estar comprendida entre 1 y 3.\n" +
                        "Las horas normales deben ser positivas.\n" +
                        "Las horas extraordinarias deben ser positivas.");
            } else {
                System.out.printf("Sueldo bruto: %.2f euros\n", calcularSueldoBruto(cat, horas, extra));
                System.out.printf("Sueldo neto: %.2f euros\n", calcularSueldoNeto(cat, calcularSueldoBruto(cat, horas, extra)));
            }

        }
    }
}
