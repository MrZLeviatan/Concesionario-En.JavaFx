package modelo;

import javafx.scene.control.Alert;
import util.PersonaUtil;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Consesionario {



    //listas necessarias para guardar la información
    private final ArrayList<Administrador> listaAdministradores;
    private final   ArrayList<Empleado> listaEmpleado ;
    private final ArrayList <Vehiculo> listaVehiculos;

    private final ArrayList <Registros> listaRegistros;

    private final ArrayList <Cliente> listaCliente;

    // variable para agregar el empleado o administrador existente
    private  Persona personaverificada;
    //constructor del concesionario

    Empleado empleado;
    Consesionario consesionario;

    private String ruta_txt = "mi.txt";

    public void cargar_txt() {
        File ruta = new File(ruta_txt);
        try {
            FileReader fi = new FileReader(ruta);
            BufferedReader bu = new BufferedReader(fi);

            String linea = null;
            while ((linea = bu.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ",");
                empleado = new Empleado(null, null, 0, null, null, null, null, null);
                empleado.setNombre(st.nextToken());
                empleado.setCc(st.nextToken());
                empleado.setCorreo(st.nextToken());
                empleado.setEdad(Integer.parseInt(st.nextToken()));

            }
            bu.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void grabar_txt(){
            FileWriter fw;
            PrintWriter pw;
            try{
                fw = new FileWriter(ruta_txt);
                pw = new PrintWriter(fw);


                for( int i = 0; i< consesionario.listaEmpleado.size(); i++ ){
                empleado = consesionario.obtenerRegistro(i);
                pw.println(String.valueOf(empleado.getNombre()+","+empleado.getCc()+","+empleado.getCorreo()));

                }
                pw.close();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }


    public Consesionario() {
        listaAdministradores = new ArrayList<>();
        listaEmpleado=new ArrayList<>();
        listaVehiculos=new ArrayList<>();
        listaCliente= new ArrayList<>();
        listaRegistros= new ArrayList<>();

    }


    //metodos get para las listas y variables
    public  ArrayList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }
    public  ArrayList<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }
    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public Persona getPersonaverificada() {return personaverificada;}


    //metodos para añadir objetos a las listas
    public void addCliente(Cliente cliente){
        listaCliente.add(cliente);
    }
    public  void addVehiculo(Vehiculo vehiculo){
        listaVehiculos.add(vehiculo);
    }
    public void addEmpleado(Empleado empleado){
        listaEmpleado.add(empleado);
    }
    public void addAministrador(Administrador administrador){
        listaAdministradores.add(administrador);
    }


    //verifica que el correo que fue enviado sea de un administrador
    public  boolean verificarAdm(String correo,String contraseña){
        boolean x= false;
        for (Administrador administrador:listaAdministradores) {
            if(administrador.getCorreo().equalsIgnoreCase(correo)&&administrador.getClave().equals(contraseña)){
                x= true;
                break ;
            }
        }
        return x;
    }
    public boolean verificarEmpleado(String correo, String contraseña) {
        boolean x= false;
        for (Empleado empleado:listaEmpleado) {
            if(empleado.getCorreo().equals(correo)&&empleado.getClave().equals(contraseña)){
                x= true;
                break ;
            }
        }
        return x;
    }



    //añadirExistencia
    public void verificarExistencia(Persona persona){
        personaverificada=persona;
    }

    // metodos para buscar Personas en las listas
    public  Empleado buscarEmpleadoCorreo(String correo){
        Empleado empleado= (Empleado) listaEmpleado.stream().filter(Empleado->Empleado.getCorreo()==correo);
        return empleado;
    }
    public  Empleado buscarEmpleadoCC(String cc){
        return (Empleado) listaEmpleado.stream().filter(Empleado->Empleado.getClave().equalsIgnoreCase(cc)).findFirst().get();
    }
    public Administrador buscarAdm(String correo){
        Optional<Administrador> administrador=listaAdministradores.stream().filter(Administrador->Administrador.getCorreo().equalsIgnoreCase(correo)).findFirst();
        return administrador.get();
    }

    //Metodo para eliminar empleado de la lista
    public void eliminarEmpleado(String cc) {
        Empleado empleado= buscarEmpleadoCC(cc);
        listaEmpleado.remove(empleado);
    }
    //busca contraseñas de los empleados y administradores
    public String buscarContraseñaAdm(String correo){
        return listaAdministradores.stream().filter(Administrador->Administrador.getCorreo().equals(correo)).findFirst().get().getClave();
    }
    public String buscarContraseñaEmpleado(String correo){
        return listaEmpleado.stream().filter(Empleado->Empleado.getCorreo().equals(correo)).findFirst().get().getClave();
    }
    public  String obtenerContraseña(String correo){
        if(buscarContraseñaAdm(correo)!=null){
            return buscarContraseñaAdm(correo);
        }
        else if ( buscarContraseñaEmpleado(correo)!=null){
            return buscarContraseñaEmpleado(correo);
        }else {
            return null;
        }
    }
    public void addRegistro(Registros registros){listaRegistros.add(registros);}

    public Registros buscarRegistro(String id){
        return listaRegistros.stream().filter(Registros->Registros.getId().equals(id)).findFirst().get();
    }
    public void eliminarRegistro(String id){
        Registros registros= buscarRegistro(id);
        listaRegistros.remove(registros);

    }







    public void enviarCorreo(String correo, String contraseña) {
        // Información de autenticación
        final String username = "soportetucarrouniquindio@gmail.com";
        final String password = "xvdmiwqzecyphxtc";

        // Información del correo electrónico

        //destinatario llega por el metodo recuperar
        String to = correo;
        String subject = "Recuperacion de la contraseña";
        String body = "Su contraseña es " + contraseña;

        // Configuración de la conexión SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable","true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user",username);
        props.setProperty("mail.smtp.ssl.protocols", "TLSvi.2");
        props.setProperty("mail.smtp.auth", "true");



        // Creación de la sesión SMTP
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Creación del mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
            // Envío del mensaje
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

public List <Empleado> buscar (String nombre, String cedula, String correo, String contraseña){

        return listaEmpleado.stream().filter(PersonaUtil.buscarDatosPersona(cedula,correo,nombre,null))
                .collect(Collectors.toUnmodifiableList());
}

public Empleado obtenerRegistro (int i) {return (Empleado)listaEmpleado.get(i);}
}