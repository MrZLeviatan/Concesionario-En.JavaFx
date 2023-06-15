package modelo;

public class Vehiculo extends Serializar {
    private  int matricula;
    private String marca;
    private int modelo;
    private  int cilindraje;
    private EstadoUso estadoUso;
    private Combustible combustible;
    private int velocidadMax;
    private int cambios;
    private Transmision transmision;
    private byte[] foto;

    public Vehiculo(byte[] foto,int matricula,String marca, int modelo, int cilindraje, EstadoUso estadoUso,Combustible combustible, int velocidadMax, int cambios, Transmision transmision) {
        this.foto= foto;
        this.matricula= matricula;
        this.marca = marca;
        this.modelo= modelo;
        this.cilindraje=cilindraje;
        this.estadoUso=estadoUso;
        this.combustible=combustible;
        this.velocidadMax=velocidadMax;
        this.cambios=cambios;
        this.transmision=transmision;
    }
    public Transmision getTransmision() {
        return transmision;
    }
    public void setTransmision(Transmision transmision) {
        this.transmision = transmision;
    }
    public int getCambios() {
        return cambios;
    }
    public int getVelocidadMax() {
        return velocidadMax;
    }
    public Combustible getCombustible() {
        return combustible;
    }
    public EstadoUso getEstadoUso() {
        return estadoUso;
    }
    public float getCilindraje() {
        return cilindraje;
    }
    public int getModelo() {
        return modelo;
    }
    public String getMarca() {
        return marca;
    }
    public int getMatricula() {
        return matricula;
    }


    public byte[] getFoto() {
        return foto;
    }
}
