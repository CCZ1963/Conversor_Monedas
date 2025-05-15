import java.util.Scanner;

public class ConversorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                **********************************
                CONVERSOR DE MONEDAS
                1. Sol Peruano -> Dólares
                2. Dólares -> Sol Peruano
                3. Pesos Argentinos -> Dólares
                4. Dólares -> Pesos Argentinos
                5. Real Brasileño -> Dólares
                6. Dólares -> Real Brasileño
                7. Peso Colombiano -> Dólares
                8. Dólares -> Peso Colombiano
                9. Salir
                **********************************
                Elija una opción válida:
            """);

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1 -> ConversorMoneda.convertir("PEN", "USD");
                    case 2 -> ConversorMoneda.convertir("USD", "PEN");
                    case 3 -> ConversorMoneda.convertir("ARS", "USD");
                    case 4 -> ConversorMoneda.convertir("USD", "ARS");
                    case 5 -> ConversorMoneda.convertir("BRL", "USD");
                    case 6 -> ConversorMoneda.convertir("USD", "BRL");
                    case 7 -> ConversorMoneda.convertir("COP", "USD");
                    case 8 -> ConversorMoneda.convertir("USD", "COP");
                    case 9 -> System.out.println("Gracias por usar nuestra aplicación.");
                    default -> System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida.");
                opcion = 0;
            }

        } while (opcion != 9);
    }
}
