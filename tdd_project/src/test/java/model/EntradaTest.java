package model;
import exception.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntradaTest {

    //caso valido
    @Test
    void entradaConDatosValidos() {
        Pelicula pelicula = Pelicula.newPelicula("El rey Leon", "Autor",120, "20:30", 3, "descripcion");
        Sala sala = Sala.newSala(3, 100, "2D");
        Entrada entrada = Entrada.newEntrada(1500.0, pelicula, sala, "A1");

        assertEquals(1500.0, entrada.getPrecio());
        assertEquals(pelicula, entrada.getPelicula());
        assertEquals(sala, entrada.getSala());
        assertEquals("A1", entrada.getAsiento());
    }

    //casos inválidos
    @Test
    void entradaConPrecioInvalido() {
        Pelicula pelicula = Pelicula.newPelicula("El rey Leon", "Autor",120, "20:30", 3, "descripcion");
        Sala sala = Sala.newSala(3, 100, "2D");

        assertThrows(precioInvalidoException.class, () -> {
            Entrada.newEntrada(0.0, pelicula, sala, "A1");
        });
    }

    @Test
    void entradaConPeliculaObligatoria() {
        Sala sala = Sala.newSala(3, 100, "2D");

        assertThrows(peliculaObligatoriaException.class, () -> {
            Entrada.newEntrada(1500.0, null, sala, "A1");
        });
    }

    @Test
    void entradaConSalaObligatoria() {
        Pelicula pelicula = Pelicula.newPelicula("El rey Leon", "Autor",120, "20:30", 3, "descripcion");

        assertThrows(salaObligatoriaException.class, () -> {
            Entrada.newEntrada(1500.0, pelicula, null, "A1");
        });
    }

    @Test
    void entradaConAsientoVacio() {
        Pelicula pelicula = Pelicula.newPelicula("El rey Leon", "Autor",120, "20:30", 3, "descripcion");
        Sala sala = Sala.newSala(3, 100, "2D");

        assertThrows(asientoObligatorioException.class, () -> {
            Entrada.newEntrada(1500.0, pelicula, sala, "");
        });
    }
}


