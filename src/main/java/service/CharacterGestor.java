package service;

import model.Character;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;
@ToString
@Getter
@Setter

public class CharacterGestor {

    private Character[] personajes;
    private int total;

    public CharacterGestor(Character[] personajes, int total) {
        setPersonajes(personajes);
        setTotal(total);
    }

    public CharacterGestor() {
        this(new Character[20], 0);
    }

    public void agregarPersonaje(int id, String nombre, String arma, String[] habilidad, int nivelPoder) {
        if (total >= personajes.length) {
            System.out.println("-- No hay espacio para mas personajes");
            return;
        }

        if (existeNombre(nombre)) {
            System.out.println("-- Ya hay un personaje con ese nombre");
            return;
        }

        if (nivelPoder < 1) {
            System.out.println("-- No se puede tener poder por debajo de 1, es muy debil...");
            return;
        }

        if (nivelPoder > 100) {
            System.out.println("-- ¡Su nivel de poder es muy alto! deberia contenerse... ¿talvez por abajo de 100?");
            return;
        }

        Character nuevoPersonaje = new Character(id, nombre, arma, habilidad, nivelPoder);
        personajes[total] = nuevoPersonaje;
        total = total + 1;

        System.out.println("-- Su personaje fue agregado!");
    }


    public boolean existeNombre(String nombre) {
        for (int i = 0; i < total; i++) {
            if (personajes[i].getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void modificarPersonaje(int id, String nuevaArma, String[] nuevasHabilidades, int nuevoNivelPoder) {
        int i = 0;
        while (i < total) {
            if (personajes[i].getId() == id) {
                personajes[i].setArma(nuevaArma);
                personajes[i].setHabilidad(nuevasHabilidades);
                personajes[i].setNivelPoder(nuevoNivelPoder);
                System.out.println("-- Personaje modificado con exito!");
                return;
            }
            i++;
        }
        System.out.println("-- No pudimos encontrar al personaje");
    }


    public void eliminarPersonaje(int id) {
        int indiceEncontrado = -1;

        for (int i = 0; i < total; i++) {
            if (personajes[i].getId() == id) {
                indiceEncontrado = i;
            }
        }

        if (indiceEncontrado == -1) {
            System.out.println("-- No pudimos encontrar al personaje");
            return;
        }

        for (int i = indiceEncontrado; i < total - 1; i++) {
            personajes[i] = personajes[i + 1];
        }

        personajes[total - 1] = null;
        total = total - 1;
        System.out.println("-- Personaje eliminado...");
    }

    public void lista() {
        if (total == 0) {
            System.out.println("-- Oye ¿no hay personajes aqui?");
            return;
        }

        System.out.println("LISTADO DE PERSONAJES:");
        for (int i = 0; i < total; i++) {
            System.out.println("ID: " + personajes[i].getId() + " - Nombre: " + personajes[i].getNombre() + " - Poder: " + personajes[i].getNivelPoder());
        }
    }


    public void mostrarDetalle(int id) {
        for (int i = 0; i < total; i++) {
            if (personajes[i].getId() == id) {
                System.out.println("DETALLES DEL PERSONAJE:");
                System.out.println("ID: " + personajes[i].getId());
                System.out.println("Nombre: " + personajes[i].getNombre());
                System.out.println("Arma: " + personajes[i].getArma());
                System.out.println("Poder: " + personajes[i].getNivelPoder());
                return;
            }
        }
        System.out.println("-- No pudimos encontrar al personaje");
    }
}