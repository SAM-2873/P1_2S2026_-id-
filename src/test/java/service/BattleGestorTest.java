package service;

import static org.junit.Assert.*;
import org.junit.Test;
import model.Battle;
import model.Character;

import java.io.ByteArrayOutputStream;

public class BattleGestorTest {

    private BattleGestor gestor;
    private ByteArrayOutputStream out;

    @org.junit.Before
    public void setUp() throws Exception {
        gestor = new BattleGestor();
        out = new ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
    }

    @Test
    public void testMostrarHistorialVacio() {
        gestor.mostrarHistorialPelea();
        assertTrue(out.toString().toLowerCase().contains("no hay peleas"));
    }

    @Test
    public void testToString() {
        String obtenido = gestor.toString();

        assertNotNull(obtenido);
        assertTrue(obtenido.contains("totalPeleas"));
    }
}