package model;
import exception.duracionNegativaException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PeliculaTest {

    @Test
        //camino feliz
    void peliculaConTodosLosArgumentos() {
        //Arrange + Act
        Pelicula peli = Pelicula.newPelicula("El rey Leon",
                "Autor",
                120,
                "20:30",
                3,
                "Un joven leon debe recuperar su reino");

        //Assert
        assertEquals("El rey Leon", peli.getNombre());
        assertEquals("Autor", peli.getAutor());
        assertEquals(120, peli.getDuracion());
        assertEquals("20:30", peli.getHorario());
        assertEquals(3, peli.getSala());
        assertEquals("Un joven leon debe recuperar su reino", peli.getDescripcion());
    }



    //camino intermedio
    @Test
    void peliculaConAtributosObligatorios() {
        //Arrange + Act
        Pelicula peli = new Pelicula("El rey Leon", "Autor", 120, "20:30", 3, "descripcion");


        //Assert
        assertEquals("El rey Leon", peli.getNombre());
        assertEquals("Autor", peli.getAutor());
        assertEquals(120, peli.getDuracion());
        assertEquals("20:30", peli.getHorario());
        assertEquals(3, peli.getSala());
        assertEquals("descripcion", peli.getDescripcion());
    }

    ;

    //camino triste
    @Test
    void peliculaConDuracionInvalida() {
        //Arrange + Act
        assertThrows(duracionNegativaException.class, () -> {
            Pelicula.newPelicula("El rey Leon", "Autor", -5, "20:30", 3, "descripcion");
        });
    }
}



