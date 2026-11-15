package service;

import static org.junit.Assert.*;
import org.junit.Test;
import model.Character;

import java.io.ByteArrayOutputStream;

public class CharacterGestorTest {

    private CharacterGestor gestor;
    private ByteArrayOutputStream out;

    @org.junit.Before
    public void setUp() throws Exception {
        gestor = new CharacterGestor();
        out = new ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
    }

    @Test
    public void testAgregarPersonajeExitoso() {
        String[] habilidades = {"Espadaso"};
        gestor.agregarPersonaje(1,"Link","Espada",habilidades,60);

        assertTrue(out.toString().toLowerCase().contains("personaje fue agregado"));
        assertEquals(1, gestor.getTotal());
    }

    @Test
    public void testAgregarPersonajePoderInvalido() {
        String[] habilidades = {"Superfuerza"};
        gestor.agregarPersonaje(2, "SuperMan", "Ninguna", habilidades, 150);

        assertTrue(out.toString().toLowerCase().contains("nivel de poder alto"));
        assertEquals(0, gestor.getTotal());
    }

    @Test
    public void testListaVacia() {
        gestor.lista();
        assertTrue(out.toString().toLowerCase().contains("no hay personajes"));
    }

    @Test
    public void testToString() {
        String obtenido = gestor.toString();

        assertNotNull(obtenido);
        assertTrue(obtenido.contains("total"));
    }
}