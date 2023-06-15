package modelo;

public class Vans extends Padre{
    private Poseer abs;


    public Vans(byte[] foto,int matricula,Poseer abs, String marca, int modelo, int cilindraje, EstadoUso estadoUso, Combustible combustible, int velocidadMax, int cambios, Transmision transmision, int numeroPasajeros, int numeroPuertas, int numeroBolsaAire, Poseer poseer, Poseer camaraReserva, Poseer aireAcondicionado) {
        super(foto,matricula, marca, modelo, cilindraje, estadoUso, combustible, velocidadMax, cambios, transmision, numeroPasajeros, numeroPuertas, numeroBolsaAire, poseer, camaraReserva, aireAcondicionado);
        this.abs=abs;
    }
}
