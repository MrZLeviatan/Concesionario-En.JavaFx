package modelo;

import javax.jms.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class RecuperarCorreo {
    private static String usuario;
    private static String contraseña;

    private String Remitente;
    private String asunto;
    private String textMensaje;

    private Properties mProperties;
    private Session mSession;
    private MimeMessage mTextMensaje;



    public void EnviarCorreo(){
        mProperties= new Properties();

    }


}
