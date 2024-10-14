package CARRO;


public class Automovil extends Vehiculo {
    private int numPuertas;
    private String tipoVehiculo;

    public Automovil(String placa, double precioPorHora, int numPuertas, String tipoVehiculo) {
        super(placa, precioPorHora);
        this.numPuertas = numPuertas;
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public double calcularPrecio() {
        return calcularTiempoEstacionado() * super.precioPorHora;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Automóvil, Puertas: " + numPuertas + ", Tipo Vehículo: " + tipoVehiculo;
    }
}
