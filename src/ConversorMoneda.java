import java.util.Scanner;

public class ConversorMoneda {

    public static void convertir(String monedaOrigen, String monedaDestino) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ingrese la cantidad en %s: ", monedaOrigen);
        try {
            double cantidad = Double.parseDouble(scanner.nextLine());
            double tasa = ConsultaTasaCambio.obtenerTasa(monedaOrigen, monedaDestino);
            if (tasa > 0) {
                double resultado = cantidad * tasa;
                System.out.printf("%.2f %s equivalen a %.2f %s%n",
                        cantidad, monedaOrigen, resultado, monedaDestino);
            } else {
                System.out.println("No se pudo obtener la tasa de cambio.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Cantidad inválida.");
        }
    }
}