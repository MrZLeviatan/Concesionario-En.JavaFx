package modelo;

public class Registros {

    private String id;
    private String nombreEmpleado;
    private String descripcion;

    public Registros(String id, String nombreEmpleado,String descripcion) {
        this.id = id;
        this.nombreEmpleado = nombreEmpleado;
        this.descripcion = descripcion;
    }


    public String getId(){
        return id;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
