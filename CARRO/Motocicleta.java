package CARRO;
public class Motocicleta extends Vehiculo {
    private String tipoMoto;
    private int cilindrada;

    public Motocicleta(String placa, double precioPorHora, String tipoMoto, int cilindrada) {
        super(placa, precioPorHora);
        this.tipoMoto = tipoMoto;
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularPrecio() {
        return calcularTiempoEstacionado() * super.precioPorHora;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Motocicleta, Tipo Moto: " + tipoMoto + ", Cilindrada: " + cilindrada + "cc";
    }
}
