package model;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharacterTest {

    private Character character1;

    @org.junit.Before
    public void setUp() throws Exception {
        String[] habilidades = {"Impactrueno","Pararrayo"};
        character1 = new Character(1,"Pikachu","Electricidad",habilidades,20);
    }

    @Test
    public void testObtenerNombre() {
        String esperado = "Pikachu";
        String obtenido = character1.getNombre();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testToString() {
        String obtenido = character1.toString();

        assertNotNull(obtenido);
        assertTrue(obtenido.contains("Pikachu"));
        assertTrue(obtenido.contains("Electricidad"));
        assertTrue(obtenido.contains("20"));
    }
}