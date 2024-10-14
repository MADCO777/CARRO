package CARRO;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estacionamiento estacionamiento = new Estacionamiento();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("===== Menú de Estacionamiento =====");
            System.out.println("1. Agregar un vehículo");
            System.out.println("2. Buscar un vehículo por su placa");
            System.out.println("3. Retirar un vehículo");
            System.out.println("4. Mostrar todos los vehículos estacionados");
            System.out.println("5. Calcular ingresos totales");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarVehiculo(estacionamiento, scanner);
                    break;
                case 2:
                    buscarVehiculo(estacionamiento, scanner);
                    break;
                case 3:
                    retirarVehiculo(estacionamiento, scanner);
                    break;
                case 4:
                    mostrarVehiculos(estacionamiento);
                    break;
                case 5:
                    calcularIngresos(estacionamiento);
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }

    public static void agregarVehiculo(Estacionamiento estacionamiento, Scanner scanner) {
        System.out.println("Selecciona el tipo de vehículo a agregar:");
        System.out.println("1. Automóvil");
        System.out.println("2. Motocicleta");
        System.out.println("3. Camión");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingresa la placa del vehículo: ");
        String placa = scanner.nextLine();

        System.out.print("Ingresa el precio por hora: ");
        double precioPorHora = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer

        switch (tipo) {
            case 1:
                System.out.print("Número de puertas (2, 4, 5): ");
                int numPuertas = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                System.out.print("Tipo de vehículo (agrícola, SUV, sedán, jeep, pick-up): ");
                String tipoVehiculo = scanner.nextLine();
                Automovil automovil = new Automovil(placa, precioPorHora, numPuertas, tipoVehiculo);
                estacionamiento.agregarVehiculo(automovil);
                System.out.println("Automóvil agregado exitosamente.");
                break;
            case 2:
                System.out.print("Tipo de motocicleta (deportiva, crucero, scooter, etc.): ");
                String tipoMoto = scanner.nextLine();
                System.out.print("Cilindrada (cc): ");
                int cilindrada = scanner.nextInt();
                Motocicleta moto = new Motocicleta(placa, precioPorHora, tipoMoto, cilindrada);
                estacionamiento.agregarVehiculo(moto);
                System.out.println("Motocicleta agregada exitosamente.");
                break;
            case 3:
                System.out.print("Capacidad de carga (toneladas): ");
                double capacidadCarga = scanner.nextDouble();
                System.out.print("Número de ejes: ");
                int numEjes = scanner.nextInt();
                Camion camion = new Camion(placa, precioPorHora, capacidadCarga, numEjes);
                estacionamiento.agregarVehiculo(camion);
                System.out.println("Camión agregado exitosamente.");
                break;
            default:
                System.out.println("Tipo de vehículo no válido.");
        }
    }

    public static void buscarVehiculo(Estacionamiento estacionamiento, Scanner scanner) {
        System.out.print("Ingresa la placa del vehículo que deseas buscar: ");
        String placa = scanner.nextLine();
        Vehiculo vehiculo = estacionamiento.buscarPorPlaca(placa);
        if (vehiculo != null) {
            System.out.println("Vehículo encontrado: " + vehiculo);
        } else {
            System.out.println("No se encontró ningún vehículo con la placa " + placa);
        }
    }

    public static void retirarVehiculo(Estacionamiento estacionamiento, Scanner scanner) {
        System.out.print("Ingresa la placa del vehículo que deseas retirar: ");
        String placa = scanner.nextLine();
        estacionamiento.retirarVehiculo(placa);
    }

    public static void mostrarVehiculos(Estacionamiento estacionamiento) {
        estacionamiento.mostrarVehiculosEstacionados();
    }

    public static void calcularIngresos(Estacionamiento estacionamiento) {
        double ingresosTotales = estacionamiento.calcularIngresosTotales();
        System.out.println("El total de ingresos generados es: $" + ingresosTotales);
    }
}
