

package modelo;

public class Administrador extends Seguridad {
    private Nivel nivel;

    //Contructor del administrador
    public Administrador(String nombre, String correo, int edad,String cc, Genero genero, String clave, String palabraSecreta) throws Exception {
        super(nombre, correo, edad, cc, genero, clave, palabraSecreta);
        this.nivel= Nivel.SUPERIOR;
    }


    public Nivel getNivel() {
        return this.nivel;
    }


}
