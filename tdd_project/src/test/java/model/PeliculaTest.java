package model;
import exception.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PeliculaTest {

    //caso valido
    @Test
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



    //caso valido
    @Test
    void peliculaSinDescripcion() {
        Pelicula peli = Pelicula.newPelicula("El rey Leon", "Autor", 120, "20:30", 3, "");


        //Assert
        assertEquals("El rey Leon", peli.getNombre());
        assertEquals("Autor", peli.getAutor());
        assertEquals(120, peli.getDuracion());
        assertEquals("20:30", peli.getHorario());
        assertEquals(3, peli.getSala());
        assertEquals("", peli.getDescripcion());
    }


    //casos invalidos
    @Test
    void peliculaConNombreVacio() {
        assertThrows(nombreNoValidoException.class, () -> {
            Pelicula.newPelicula("","Autor",120,"20:30", 3, "descripcion");
        });
    }

    @Test
    void peliculaConAutorVacio() {
        assertThrows(autorObligatorioException.class, () -> {
            Pelicula.newPelicula("El rey Leon", "", 120, "20:30", 3, "descripcion");
        });
    }

    @Test
    void peliculaConDuracionInvalida() {
        assertThrows(duracionNegativaException.class, () -> {
            Pelicula.newPelicula("El rey Leon", "Autor", -5, "20:30", 3, "descripcion");
        });
    }

    @Test
    void peliculaConHorarioVacio() {
        assertThrows(horarioObligatorioException.class, () -> {
            Pelicula.newPelicula("El rey Leon", "Autor", 120, "", 3,"descripcion");
        });
    }

    @Test
    void peliculaConSalaInvalida() {
        assertThrows(salaMayorAUnoException.class, () -> {
            Pelicula.newPelicula("El rey Leon", "Autor", 120, "20:30", 0, "descripcion");
        });
    }
}



