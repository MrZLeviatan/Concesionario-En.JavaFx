package modelo;

public class Deportivo extends  Vehiculo{
    private int numeroPasajeros,numeroPuertas,numeroBolsas,caballosFuerza;
    private float tiempo100k;


    public Deportivo(byte[] foto,float tiempo100k, int matricula,int numeroPuertas,int numeroPasajeros,int caballosFuerza, int numeroBolsas ,String marca, int modelo, int cilindraje, EstadoUso estadoUso, Combustible combustible, int velocidadMax, int cambios, Transmision transmision) {
        super(foto,matricula, marca, modelo, cilindraje, estadoUso, combustible, velocidadMax, cambios, transmision);
        this.numeroPuertas=numeroPuertas;
        this.numeroPasajeros=numeroPasajeros;
        this.caballosFuerza=caballosFuerza;
        this.numeroBolsas=numeroBolsas;
        this.tiempo100k=tiempo100k;
    }




}
