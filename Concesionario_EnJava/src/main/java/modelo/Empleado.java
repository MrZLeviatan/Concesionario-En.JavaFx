package modelo;

public class Empleado extends Seguridad{

    private Estado estado;
    private Nivel nivel;

    public Empleado(String nombre, String correo, int edad, String cc, Genero genero, String clave, String palabraSecreta,Estado estado) throws Exception {
        super(nombre, correo, edad, cc, genero, clave, palabraSecreta);
        this.estado=estado;
        this.nivel=Nivel.INFERIOR;
    }

    public static Estado getEstado(Estado estado) {
        return estado;
    }

    public Nivel getNivel() {
        return nivel;
    }


}
