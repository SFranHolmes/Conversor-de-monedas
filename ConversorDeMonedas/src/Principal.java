import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Conversor conversor = new Conversor();
            boolean continuar = true;

            while (continuar) {
                System.out.print("Ingrese la cantidad a convertir: ");
                double cantidad = scanner.nextDouble();

                System.out.print("Ingrese la moneda a convertir (MXN, CLP, PEN): ");
                String moneda = scanner.next().toUpperCase();

                if (!moneda.equals("MXN") && !moneda.equals("CLP") && !moneda.equals("PEN")) {
                    System.out.println("Error: Moneda no válida.");
                    continue;
                }

                System.out.print("¿Desea convertir a dólares (USD) o desde dólares (USD)? (ingrese 'a' o 'desde'): ");
                String direccion = scanner.next().toLowerCase();

                boolean aDolares = direccion.equals("a");

                double resultado = conversor.convertir(cantidad, moneda, aDolares);
                if (aDolares) {
                    System.out.println("Resultado: " + resultado + " USD");
                } else {
                    System.out.println("Resultado: " + resultado + " " + moneda);
                }

                System.out.println("¿Qué desea hacer ahora?");
                System.out.println("1. Continuar con otra conversión");
                System.out.println("2. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        continuar = true;
                        break;
                    case 2:
                        continuar = false;
                        System.out.println("Saliendo del programa. Gracias");
                        break;
                    default:
                        System.out.println("Opción no válida. Saliendo del programa.");
                        continuar = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error durante la conversión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
