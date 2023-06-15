package modelo;

public class Sedan extends  Padre{

    private int capacidadMaletero,velocidadCruzero;
    private Poseer abs,sensorColision,sensorTraficoCruzado,asistentePermanenciaCarril;


    public Sedan(byte[] foto,int matricula,int capacidadMaletero, int velocidadCruzero, Poseer abs, Poseer sensorColision, Poseer sensorTraficoCruzado, Poseer asistentePermanenciaCarril ,String marca, int modelo, int cilindraje, EstadoUso estadoUso, Combustible combustible, int velocidadMax, int cambios, Transmision transmision, int numeroPasajeros, int numeroPuertas, int numeroBolsaAire, Poseer poseer, Poseer camaraReserva, Poseer aireAcondicionado) {
        super(foto,matricula, marca, modelo, cilindraje, estadoUso, combustible, velocidadMax, cambios, transmision, numeroPasajeros, numeroPuertas, numeroBolsaAire, poseer, camaraReserva, aireAcondicionado);
        this.capacidadMaletero=capacidadMaletero;
        this.velocidadCruzero=velocidadCruzero;
        this.abs=abs;
        this.sensorColision=sensorColision;
        this.sensorTraficoCruzado=sensorTraficoCruzado;
        this.asistentePermanenciaCarril=asistentePermanenciaCarril;

    }
}
