package util;

import modelo.Padre;
import modelo.Poseer;

import java.util.function.Predicate;

public class PadreUtil extends PersonaUtil{
    public static Predicate<Padre> buscarPorAireAcondiconado(Poseer poseer){
        return padre -> padre.getAireAcondicionado()==poseer;
    }

    public static Predicate<Padre> buscarPorNumeroDePuertas(int numeroDePuertas){
        return padre -> padre.getNumeroPuertas()==numeroDePuertas;
    }

    public static Predicate<Padre> buscarPorCamaraDeReserva(Poseer poseer){
        return padre -> padre.getCamaraReserva()==poseer;
    }

    public static Predicate<Padre> buscarPorNumeroBolsaDeAire(int numeroBolsaDeAire){
        return padre -> padre.getNumeroBolsaAire()==numeroBolsaDeAire;
    }

   /// public static Predicate<Padre>BuscarPorTodoPadre(){}

}
