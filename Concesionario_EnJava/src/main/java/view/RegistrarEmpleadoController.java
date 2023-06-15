package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Empleado;
import modelo.Estado;
import modelo.Genero;
import modelo.Consesionario;
import java.io.File;
import java.io.IOException;

import static javafx.stage.StageStyle.UNDECORATED;
import static view.consecionarioInstance.INSTANCE;

public class RegistrarEmpleadoController {

    @FXML
    private TextField bloqueCedula;

    @FXML
    private TextField bloqueContraseña;

    @FXML
    private TextField bloqueCorreo;

    @FXML
    private TextField bloqueEdad;

    @FXML
    private TextField bloqueNombre;

    @FXML
    private TextField bloquePalabraSecreta;

    @FXML
    private Button botonCancelar;

    @FXML
    private RadioButton botonFemenino;

    @FXML
    private RadioButton botonMasculino;

    @FXML
    private RadioButton botonOtros;

    @FXML
    private Button botonRegistro;

    @FXML
    private ToggleGroup genero;

    @FXML
    private HBox hbox;

    @FXML
    private GridPane tablaorden;



    @FXML
    void eventoAgregar(ActionEvent event) throws Exception {

        String nombre = bloqueNombre.getText();
        String contraseña = bloqueContraseña.getText();
        String correo = bloqueCorreo.getText();
        String edad=bloqueEdad.getText();
        String cedula= bloqueCedula.getText();
        String palabraSecreta = bloquePalabraSecreta.getText();


        if (nombre.isEmpty() && contraseña.isEmpty() && correo.isEmpty() && edad.isEmpty()
                            && cedula.isEmpty() && palabraSecreta.isEmpty()) {

            Alert alert1 = new Alert(Alert.AlertType.NONE);
            alert1.setTitle("ERROR!!!");
            alert1.setContentText("POR FAVOR LLENAR LOS BLOQUES VACIOS...");
            alert1.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenLlenarEspacios .png").toString()));
            alert1.setHeaderText("UPS! PARECE QUE SE TE OLVIDO ALGO");
            alert1.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert1.showAndWait();
            bloqueContraseña.setText("");
            bloquePalabraSecreta.setText("");



        }else {

            Estado estado = Estado.ACTIVO;
            Genero genero = obtenerGenero();
            Empleado empleado = new Empleado(bloqueNombre.getText(), bloqueCorreo.getText(), Integer.parseInt(bloqueEdad.getText()), bloqueCedula.getText(), genero, bloqueContraseña.getText(), bloquePalabraSecreta.getText(), estado);
            INSTANCE.getConsesionario().addEmpleado(empleado);

            Alert alert1 = new Alert(Alert.AlertType.NONE);
            alert1.setTitle("REGISTRO COMPLETO");
            alert1.setContentText("EMPLEADO REGISTRADO :D");
            alert1.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenBienvenidoLogo.png").toString()));
            alert1.setHeaderText("BIENVENIDO A HELL TAKER CONCESIONARIO...");
            alert1.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert1.showAndWait();

            bloqueNombre.setText("");
            bloqueContraseña.setText("");
            bloqueEdad.setText("");
            bloqueCedula.setText("");
            bloqueCorreo.setText("");
            bloquePalabraSecreta.setText("");
        }


    }
    @FXML
        void eventocancelar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OpcionesEmpleados.fxml"));
        Parent root= loader.load();
        Stage stage = new Stage();
        stage.initStyle(UNDECORATED);
        stage.setScene(new Scene(root));
        Node source = (Node) event.getSource();
        Stage stage2 = (Stage) source.getScene().getWindow();
        stage2.hide();
        stage.show();
    }
    @FXML

    private void restriccionTeclas (KeyEvent event){
        if(event.getTarget()== bloqueEdad ){
            if(!Character.isDigit(event.getCharacter().charAt(0))){
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("ERROR!!!");
                alert.setContentText("NO SE PERMITEN LETRAS EN LA EDAD");
                alert.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenError.png").toString()));
                alert.setHeaderText("UPS! HA OCURRIDO UN ERROR...");
                alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                alert.showAndWait();
                bloqueEdad.setText("");
            }
        }else if(event.getTarget()== bloqueCedula ) {
            if (!Character.isDigit(event.getCharacter().charAt(0))) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("ERROR!!!");
                alert.setContentText("NO SE PERMITEN LETRAS EN LA CEDULA");
                alert.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenError.png").toString()));
                alert.setHeaderText("UPS! HA OCURRIDO UN ERROR...");
                alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                alert.showAndWait();
                bloqueCedula.setText("");

            }
        }
    }

    private Genero obtenerGenero(){

        if(botonMasculino.isSelected()){
            return Genero.MASCULINO;
        }
        else if (botonFemenino.isSelected()){
            return Genero.FEMENINO;
        }
        else if (botonOtros.isSelected()){
            return Genero.OTROS;
        }
        return null;
    }



}
