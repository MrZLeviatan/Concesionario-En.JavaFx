package util;

import modelo.Genero;
import modelo.Persona;

import java.util.function.Predicate;

public class PersonaUtil {
    public static Predicate<Persona> buscarPorCc(String cc) {
        return persona -> persona.getCc()==(cc);
    }

    public static Predicate<Persona> buscarPorCorreo(String correo) {
        return persona -> persona.getCorreo().contains(correo);
    }


    public static Predicate<Persona> buscarPorNombre(String nombre) {
        return persona -> persona.getNombre().equals(nombre);
    }


    public static Predicate<Persona> buscarPorGenero(Genero genero){
        return persona -> persona.getGenero()==genero;

    }



    public static Predicate<Persona>buscarDatosPersona(String cc,String correo,String nombre,Genero genero){
        Predicate<Persona> predicado= persona -> true;
        if(cc != null && !cc.isEmpty()){
            predicado.and(buscarPorCc(cc));
        }
        if(correo != null && !correo.isEmpty()){
            predicado.and(buscarPorCorreo(correo));
        }
        if(nombre !=null && !nombre.isEmpty()){
            predicado.and(buscarPorNombre(nombre));
        }
        if(genero !=null){
            predicado.and(buscarPorGenero(genero));
        }
        return predicado;
    }

}





