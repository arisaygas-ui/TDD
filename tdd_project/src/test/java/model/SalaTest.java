package model;
import exception.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaTest {

    //Caso valido
    @Test
    void salaConDatosValidos() {
        Sala sala = Sala.newSala(1, 100, "2D");

        assertEquals(1, sala.getNumeroSala());
        assertEquals(100, sala.getCapacidadAsientos());
        assertEquals("2D", sala.getTipoProyeccion());
    }

    @Test
    void salaConNuemeroInvalido() {
        assertThrows(numeroSalaInvalidoException.class, () -> {
            Sala.newSala(0, 100, "2D");
        });
    }

    @Test
    void salaConCapacidadInvalida() {
        assertThrows(capacidadInvalidaException.class, () -> {
            Sala.newSala(1, -10, "2D");
        });
    }

    @Test
    void salaConTipoDeProyeccionVacio(){
        assertThrows(tipoProyeccionObligatorioException.class, () -> {
        Sala.newSala(1, 100, "");
        });
    }
}
