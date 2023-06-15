package modelo;

import java.util.Objects;

public class Seguridad extends Persona{
    private  String clave, palabraSecreta;
    public Seguridad(String nombre, String correo, int edad, String cc, Genero genero, String clave, String palabraSecreta) throws Exception {
        super(nombre, correo, edad, cc, genero);

        this.clave= Objects.requireNonNull(clave,"la clave es requerida");
        if(clave.isBlank()){
            throw new RuntimeException("la clave es requerida");
        }
        this.palabraSecreta= Objects.requireNonNull(palabraSecreta,"palabra secreta requerida");
        if(palabraSecreta.isBlank()){
            throw  new RuntimeException("la palabra secreta es requerida");
        }
    }






    public String getClave() {
        return clave;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }
}


