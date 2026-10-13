package model;
import exception.*;

public class Sala {
    private int numeroSala;
    private int capacidadAsientos;
    private String tipoProyeccion;

    public Sala(int numeroSala, int capacidadAsientos, String tipoProyeccion){
        this.numeroSala = numeroSala;
        this.capacidadAsientos = capacidadAsientos;
        this.tipoProyeccion = tipoProyeccion;
    }

    public static Sala newSala(int numeroSala, int capacidadAsientos, String tipoProyeccion) {
        if (numeroSala <= 0) {
            throw new numeroSalaInvalidoException("El número de sala debe ser mayor a 0");
        }

        if(capacidadAsientos <= 0){
            throw new capacidadInvalidaException("La capaccidad de asientos debe ser mayor a 0");
        }

        if(tipoProyeccion == null || tipoProyeccion.isBlank()){
            throw new tipoProyeccionObligatorioException("El tipo de proyección es obligatorio");
        }

        return new Sala(numeroSala, capacidadAsientos, tipoProyeccion);
    }

    public int getNumeroSala() { return numeroSala; }
    public int getCapacidadAsientos() { return capacidadAsientos; }
    public String getTipoProyeccion() { return tipoProyeccion; }
}
