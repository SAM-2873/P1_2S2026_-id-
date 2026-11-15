package util;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class ValidatorTest {

    private ByteArrayOutputStream out;
    private Validator validator;

    @org.junit.Before
    public void setUp() throws Exception {
        validator = new Validator();
        out = new ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
    }

    @Test
    public void testToString() {
        String obtenido = validator.toString();

        assertNotNull(obtenido);
        assertTrue(obtenido.contains("Validator"));
    }
}