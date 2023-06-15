package modelo;

import execciones.ValorRequeridoException;

import java.util.Objects;

public class Persona {
    private String nombre,correo,cc;
    private int edad;
    private Genero genero;

    public Persona(String nombre, String correo, int edad,String cc, Genero genero)throws Exception{
        this.nombre=nombre;
        this.correo=correo;
        this.edad=edad;
        this.cc=cc;
        this.genero=genero;
    }

    public static Persona of(String nombre,String correo,int edad,String cc, Genero genero) throws Exception {
        if(Objects.requireNonNull(nombre,"el nombre es requerido").isEmpty()){
            throw new ValorRequeridoException("nombre");
        }
        if(Objects.requireNonNull(correo,"el correo es requerido").isEmpty()){
            throw new ValorRequeridoException("correo");
        }
        if(Objects.requireNonNull(cc,"La cédula es requirida").isEmpty()){
            throw new ValorRequeridoException("cc");
        }
        Objects.requireNonNull(genero,"el genero es requerido");
        Objects.requireNonNull(edad,"la edad es er requerida");
        return  new Persona(nombre,correo,edad,cc,genero);

    }


    public Genero getGenero() {
        return genero;
    }
    public String getCc() {
        return cc;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public int getEdad(int edad) {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
