package service;

import model.Battle;
import model.Character;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;
@ToString
@Getter
@Setter

public class BattleGestor {

    private Battle[] peleas;
    private int totalPeleas;

    public BattleGestor(Battle[] peleas, int totalPeleas) {
        setPeleas(peleas);
        setTotalPeleas(totalPeleas);
    }

    public BattleGestor() {
        this(new Battle[20], 0);
    }

    public void registrarPelea(Character personaje1, Character personaje2) {
        if (totalPeleas >= peleas.length) {
            System.out.println("No hay espacio suficiente para mas peleas, lo siento");
            return;
        }

        if (personaje1 == null || personaje2 == null) {
            System.out.println("Hubo un problemita uno de los personajes o ambos no existen! ¿que raro no?.");
            return;
        }

        //-------------------Parte del reloj-------------------
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String fechaHora = ahora.format(formato);
        //-------------------Parte del reloj--------------------

        Battle nuevaPelea = new Battle(personaje1, personaje2, fechaHora);
        peleas[totalPeleas] = nuevaPelea;
        totalPeleas = totalPeleas + 1;

        System.out.println("¡Pelea realizada con exito!");
    }

    public void mostrarHistorialPelea() {
        if (totalPeleas == 0) {
            System.out.println("No hay peleas realizadas con anterioridad.");
            return;
        }

        System.out.println("\n--- ¡HISTORIAL DE PELEAS! ---");
        int i = 0;
        while (i < totalPeleas) {
            System.out.println("Pelea " + (i + 1) + ":");
            System.out.println("  - Personaje 1: " + peleas[i].getPersonaje1().getNombre());
            System.out.println("  - Personaje 2: " + peleas[i].getPersonaje2().getNombre());
            System.out.println("  - Fecha y Hora: " + peleas[i].getFechaHora());
            System.out.println("-----------------------------");
            i++;
        }
    }
}