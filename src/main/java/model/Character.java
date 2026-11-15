package model;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;
@ToString
@Getter
@Setter

public class Character {

    private int id,nivelPoder;
    private String nombre,arma;
    private String[] habilidad;

    public Character() {

    }

    public Character(int id, String nombre,String arma,String[] habilidad,int nivelPoder){
        setId(id);
        setArma(arma);
        setHabilidad(habilidad);
        setNombre(nombre);
        setNivelPoder(nivelPoder);
    }
}
