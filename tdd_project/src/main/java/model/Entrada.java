package model;
import exception.*;

public class Entrada {
    private double precio;
    private Pelicula pelicula;
    private Sala sala;
    private String asiento;

    public Entrada(double precio, Pelicula pelicula, Sala sala, String asiento) {
        this.precio = precio;
        this.pelicula = pelicula;
        this.sala = sala;
        this.asiento = asiento;
    }

    public static Entrada newEntrada(double precio, Pelicula pelicula, Sala sala, String asiento) {
        if (precio <= 0) {
            throw new precioInvalidoException("El precio debe ser mayor a 0");
        }
        if (pelicula == null) {
            throw new peliculaObligatoriaException("La película es obligatoria");
        }
        if (sala == null) {
            throw new salaObligatoriaException("La sala es obligatoria");
        }
        if (asiento == null || asiento.isBlank()) {
            throw new asientoObligatorioException("El asiento es obligatorio");
        }

        return new Entrada(precio, pelicula, sala, asiento);
    }

    public double getPrecio() { return precio; }
    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
    public String getAsiento() { return asiento; }
}
