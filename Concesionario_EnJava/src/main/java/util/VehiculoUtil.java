package util;

import modelo.Combustible;
import modelo.EstadoUso;
import modelo.Transmision;
import modelo.Vehiculo;

import java.util.function.Predicate;

public class VehiculoUtil {
    public static Predicate<Vehiculo> buscarPorMatricula(int matricula ) {
        return vehiculo -> vehiculo.getMatricula()==matricula;
    }

    public static Predicate<Vehiculo> buscarPorMarca(String marca){
        return vehiculo -> vehiculo.getMarca().equals(marca);
    }

    public static Predicate<Vehiculo> buscarPorModelo(int modelo){
        return vehiculo -> vehiculo.getModelo()==modelo;
    }

    public static Predicate<Vehiculo> buscarPorCilindraje(float cilindraje){
        return vehiculo -> vehiculo.getCilindraje()==cilindraje;
    }

    public static Predicate<Vehiculo> buscarPorEstadoUso(EstadoUso estadoUso){
        return vehiculo -> vehiculo.getEstadoUso()==estadoUso;
    }

    public static Predicate<Vehiculo> buscarPorCombustible (Combustible combustible){
        return vehiculo -> vehiculo.getCombustible()==combustible;
    }

    public static Predicate<Vehiculo> buscarPorVelocidadMax(int velocidadMax){
        return vehiculo -> vehiculo.getVelocidadMax()==velocidadMax;
    }

    public static Predicate<Vehiculo> buscarPorCambios(int cambios){
        return vehiculo -> vehiculo.getCambios()==cambios;
    }

    public static Predicate<Vehiculo> buscarPorTrasmicion(Transmision transmision){
        return vehiculo -> vehiculo.getTransmision()==transmision;
    }


    public static Predicate<Vehiculo> buscarTodoVehiculo(int matricula,String marca, int modelo, float cilindraje, EstadoUso estadoUso,Combustible combustible, int velocidadMax, int cambios, Transmision transmision){
        Predicate<Vehiculo> predicado= vehiculo -> true;
        if(matricula !=0){
          predicado.and(buscarPorMatricula(matricula));
        }
        if(marca !=null && !marca.isEmpty()){
            predicado.and(buscarPorMarca(marca));
        }
        if(modelo !=0){
            predicado.and(buscarPorModelo(modelo));
        }
        if(cilindraje !=0){
            predicado.and(buscarPorCilindraje(cilindraje));
        }
        if(estadoUso != null){
            predicado.and(buscarPorEstadoUso(estadoUso));
        }
        if(combustible !=null){
            predicado.and(buscarPorCombustible(combustible));
        }
        if(velocidadMax !=0){
            predicado.and(buscarPorVelocidadMax(velocidadMax));
        }
        if(cambios !=0){
            predicado.and(buscarPorCambios(cambios));
        }
        if(transmision !=null){
            predicado.and(buscarPorTrasmicion(transmision));
        }
        return predicado;
    }
}
