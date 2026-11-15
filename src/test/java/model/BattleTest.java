package model;

import static org.junit.Assert.*;
import org.junit.Test;

public class BattleTest {

    private Battle battle1;
    private Character personaje1;
    private Character personaje2;

    @org.junit.Before
    public void setUp() throws Exception {
        personaje1 = new Character();
        personaje2 = new Character();
        battle1 = new Battle(personaje1, personaje2, "14/11/2026 22:00");
    }

    @Test
    public void testObtenerFechaHora() {
        String esperado = "14/11/2026 22:00";
        String obtenido = battle1.getFechaHora();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testToString() {
        String obtenido = battle1.toString();

        assertNotNull(obtenido);
        assertTrue(obtenido.contains("14/11/2026 22:00"));
    }
}