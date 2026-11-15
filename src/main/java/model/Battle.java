package model;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;
@ToString
@Getter
@Setter

public class Battle {

    private Character personaje1,personaje2;
    private String fechaHora;

    public Battle(Character personaje1,Character personaje2,String fechaHora) {
        this.personaje1 = personaje1;
        this.personaje2 = personaje2;
        this.fechaHora = fechaHora;
    }
}