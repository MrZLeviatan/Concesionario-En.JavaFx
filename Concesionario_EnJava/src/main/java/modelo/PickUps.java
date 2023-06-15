package modelo;

public class PickUps extends Padre {
    private Poseer potencia;
    private int capacidadCajaCarga;


    public PickUps(byte[] foto,int matricula,Poseer potencia, int capacidadCajaCarga,String marca, int modelo, int cilindraje, EstadoUso estadoUso, Combustible combustible, int velocidadMax, int cambios, Transmision transmision, int numeroPasajeros, int numeroPuertas, int numeroBolsaAire, Poseer poseer, Poseer camaraReserva, Poseer aireAcondicionado) {
        super(foto,matricula, marca, modelo, cilindraje, estadoUso, combustible, velocidadMax, cambios, transmision, numeroPasajeros, numeroPuertas, numeroBolsaAire, poseer, camaraReserva, aireAcondicionado);
        this.capacidadCajaCarga=capacidadCajaCarga;
        this.potencia=potencia;
    }
}