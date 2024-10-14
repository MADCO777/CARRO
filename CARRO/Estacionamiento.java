package CARRO;

import java.util.ArrayList;
import java.util.List;

public class Estacionamiento {
    private List<Vehiculo> vehiculos;

    public Estacionamiento() {
        vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    public void retirarVehiculo(String placa) {
        Vehiculo vehiculo = buscarPorPlaca(placa);
        if (vehiculo != null && vehiculo.isEstacionado()) {
            vehiculo.retirar();
            System.out.println("Vehículo retirado: " + vehiculo);
            System.out.println("Costo: $" + vehiculo.calcularPrecio());
        } else {
            System.out.println("Vehículo no encontrado o ya retirado.");
        }
    }

    public void mostrarVehiculosEstacionados() {
        System.out.println("Vehículos estacionados:");
        for (Vehiculo v : vehiculos) {
            if (v.isEstacionado()) {
                System.out.println(v);
            }
        }
    }

    public double calcularIngresosTotales() {
        double total = 0;
        for (Vehiculo v : vehiculos) {
            if (!v.isEstacionado()) {
                total += v.calcularPrecio();
            }
        }
        return total;
    }
}
