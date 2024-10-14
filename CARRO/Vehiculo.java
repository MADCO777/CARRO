package CARRO;

import java.util.UUID;
import java.time.LocalDateTime;
import java.time.Duration;

public abstract class Vehiculo {
    private String id;
    private String placa;
    private boolean estacionado;
    private LocalDateTime horaIngreso;
    private LocalDateTime horaSalida;
    protected double precioPorHora;

    public Vehiculo(String placa, double precioPorHora) {
        this.id = UUID.randomUUID().toString(); // Genera un ID único
        this.placa = placa;
        this.estacionado = true;
        this.horaIngreso = LocalDateTime.now();
        this.precioPorHora = precioPorHora;
    }

    public String getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public boolean isEstacionado() {
        return estacionado;
    }

    public void retirar() {
        this.estacionado = false;
        this.horaSalida = LocalDateTime.now();
    }

    public double calcularTiempoEstacionado() {
        if (horaSalida != null) {
            Duration duracion = Duration.between(horaIngreso, horaSalida);
            return duracion.toHours(); // Devuelve el tiempo en horas
        }
        return 0;
    }

    public abstract double calcularPrecio();

    @Override
    public String toString() {
        return "ID: " + id + ", Placa: " + placa + ", Estado: " + (estacionado ? "Estacionado" : "Retirado");
    }
}
