package util;

import java.util.Scanner;
import java.util.InputMismatchException;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;
@ToString
@Getter
@Setter

public class Validator {

    private static Scanner s = new Scanner(System.in);

    public static int leerNumEntero(String mensaje, int min, int max) {
        int numero = 0;
        boolean valido = false;

        while (valido == false) {
            try {
                System.out.print(mensaje);
                numero = s.nextInt();
                s.nextLine();

                if (numero >= min && numero <= max) {
                    valido = true;
                } else {
                    System.out.println("Hubo un problemita, el numero debe estar entre " + min + " y " + max);
                }
            } catch (InputMismatchException e) {
                System.out.println("Hubo un problemita, debes escribir un numero entero.");
                s.nextLine();
            }
        }

        return numero;
    }

    public static String leerTextoNoVacio(String mensaje) {
        String texto = "";
        boolean valido = false;

        while (valido == false) {
            System.out.print(mensaje);
            texto = s.nextLine();

            if (texto != null && !texto.trim().isEmpty()) {
                valido = true;
            } else {
                System.out.println("Hubo un problemita ¡esto no puede estar vacio!");
            }
        }

        return texto.trim();
    }
}