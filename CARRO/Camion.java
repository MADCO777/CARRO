package CARRO;
public class Camion extends Vehiculo {
    private double capacidadCarga;
    private int numEjes;

    public Camion(String placa, double precioPorHora, double capacidadCarga, int numEjes) {
        super(placa, precioPorHora);
        this.capacidadCarga = capacidadCarga;
        this.numEjes = numEjes;
    }

    @Override
    public double calcularPrecio() {
        return calcularTiempoEstacionado() * super.precioPorHora;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Camión, Capacidad: " + capacidadCarga + " toneladas, Ejes: " + numEjes;
    }
}
