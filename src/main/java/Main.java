
import model.Character;
import service.CharacterGestor;
import service.BattleGestor;
import util.Validator;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;
@ToString
@Getter
@Setter

public class Main {

    private CharacterGestor gestorPersonajes;
    private BattleGestor gestorPeleas;

    public Main(CharacterGestor gestorPersonajes, BattleGestor gestorPeleas) {
        setGestorPersonajes(gestorPersonajes);
        setGestorPeleas(gestorPeleas);
    }

    public Main() {
        this(new CharacterGestor(), new BattleGestor());
    }

    public void iniciar() {
        int opcion = 0;

        do {
            System.out.println("\n===== ¡MENU! =====");
            System.out.println("1. Agregar un personaje");
            System.out.println("2. Listado de personajes");
            System.out.println("3. Detalles de personaje");
            System.out.println("4. Modificar un personaje");
            System.out.println("5. Eliminar un personaje");
            System.out.println("6. Registrar una pelea");
            System.out.println("7. Historial de peleas");
            System.out.println("8. Salir");

            opcion = Validator.leerNumEntero("Seleccione una opcion con su numero asignado: ", 1, 8);

            switch (opcion) {
                case 1:
                    System.out.println("\n--- ¡REGISTRA TU PERSONAJE! ---");
                    int id = Validator.leerNumEntero("ID del personaje (numero entero por favor): ", 1, 999);
                    String nombre = Validator.leerTextoNoVacio("¿Cual es su nombre?: ");
                    String arma = Validator.leerTextoNoVacio("¿Que arma usa?: ");

                    System.out.println("Ingrese 2 habilidades para el personaje:");
                    String[] habilidades = new String[2];

                    habilidades[0] = Validator.leerTextoNoVacio("  - Habilidad 1: ");
                    habilidades[1] = Validator.leerTextoNoVacio("  - Habilidad 2: ");

                    int poder = Validator.leerNumEntero("¿Cual es su nivel de poder? ( 1 - 100 ): ", 1, 100);

                    gestorPersonajes.agregarPersonaje(id, nombre, arma, habilidades, poder);
                    break;

                case 2:
                    gestorPersonajes.lista();
                    break;

                case 3:
                    System.out.println("\n--- ¡DETALLES DEL PERSONAJE! ---");
                    int idBuscar = Validator.leerNumEntero("ID del personaje: ", 1, 9999);

                    gestorPersonajes.mostrarDetalle(idBuscar);
                    break;

                case 4:
                    System.out.println("\n--- ¡MODIFICAR PERSONAJE! ---");
                    int idMod = Validator.leerNumEntero("ID del personaje a modificar: ", 1, 9999);
                    String nuevaArma = Validator.leerTextoNoVacio("¿Cual sera su nueva arma?: ");

                    System.out.println("Cual seran sus 2 nuevas habilidades:");
                    String[] nuevasHabs = new String[2];
                    nuevasHabs[0] = Validator.leerTextoNoVacio("  - Nueva Habilidad 1: ");
                    nuevasHabs[1] = Validator.leerTextoNoVacio("  - Nueva Habilidad 2: ");

                    int nuevoPoder = Validator.leerNumEntero("¿Cual es su nivel de poder? ( 1 - 100 ): ", 1, 100);

                    gestorPersonajes.modificarPersonaje(idMod, nuevaArma, nuevasHabs, nuevoPoder);
                    break;

                case 5:
                    System.out.println("\n--- ELIMINAR PERSONAJE... ---");
                    int idEliminar = Validator.leerNumEntero("ID del personaje a eliminar definitivamente: ", 1, 9999);
                    gestorPersonajes.eliminarPersonaje(idEliminar);
                    break;

                case 6:
                    System.out.println("\n--- ¡¡¡REGISTRAR PELEA!!! ---");
                    gestorPersonajes.lista();
                    if (gestorPersonajes.getTotal() > 0) {
                        int id1 = Validator.leerNumEntero("ID del Personaje 1: ", 1, 9999);
                        int id2 = Validator.leerNumEntero("ID del Personaje 2: ", 1, 9999);

                        Character p1 = null;
                        Character p2 = null;

                        Character[] listaActual = gestorPersonajes.getPersonajes();
                        for (int i = 0; i < gestorPersonajes.getTotal(); i++) {
                            if (listaActual[i].getId() == id1) {
                                p1 = listaActual[i];
                            }
                            if (listaActual[i].getId() == id2) {
                                p2 = listaActual[i];
                            }
                        }

                        if (p1 != null && p2 != null) {
                            gestorPeleas.registrarPelea(p1, p2);
                        } else {
                            System.out.println("-- Hubo un problemita, uno o ambos ID's de los personajes no fueron encontrados :/");
                        }
                    }
                    break;

                case 7:
                    gestorPeleas.mostrarHistorialPelea();
                    break;

                case 8:
                    System.out.println("\nSaliendo del sistema...  \n¡Hasta la proxima!");
                    break;

                default:
                    System.out.println("-- Opcion no valida.");
                    break;
            }

        } while (opcion != 8);
    }

    public static void main(String[] args) {
        Main programa = new Main();
        programa.iniciar();
    }
}