package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modelo.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static javafx.stage.StageStyle.UNDECORATED;

public class PickUpsController extends Component {

    @FXML
    private ToggleGroup Combustible;

    @FXML
    private ToggleGroup Posesion;

    @FXML
    private ToggleGroup Posesion11;

    @FXML
    private ToggleGroup Trasmicion;

    @FXML
    private ToggleGroup Uso;

    @FXML
    private TextField bloqueBolsa;

    @FXML
    private TextField bloqueCaja;

    @FXML
    private TextField bloqueCambios;

    @FXML
    private TextField bloqueCilindraje;

    @FXML
    private TextField bloqueMarca;

    @FXML
    private TextField bloqueMatricula;

    @FXML
    private TextField bloqueModelo;

    @FXML
    private TextField bloquePasajeros;

    @FXML
    private TextField bloquePrecio;

    @FXML
    private TextField bloquePuertas;

    @FXML
    private TextField bloqueVelocidad;

    @FXML
    private RadioButton botonAutomatica;

    @FXML
    private Button botonCancelar;

    @FXML
    private RadioButton botonDisiel;

    @FXML
    private RadioButton botonElectricos;

    @FXML
    private RadioButton botonGasolina;

    @FXML
    private RadioButton botonHibridos;

    @FXML
    private RadioButton botonManual;

    @FXML
    private RadioButton botonNoUsado;

    @FXML
    private Button botonRegistro;

    @FXML
    private RadioButton botonUsado;

    @FXML
    private RadioButton noPosee4;

    @FXML
    private RadioButton noPoseeAco;

    @FXML
    private RadioButton noPoseeCam;

    @FXML
    private RadioButton posee4;

    @FXML
    private RadioButton poseeAco;

    @FXML
    private RadioButton poseeCam;

    
    final FileChooser fc = new FileChooser();

    @FXML
    void eventocancelar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrarVehiculo.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.initStyle(UNDECORATED);
        stage.setScene(new Scene(root));
        Node source = (Node) event.getSource();
        Stage stage2 = (Stage) source.getScene().getWindow();
        stage2.hide();
        stage.show();
    }

    @FXML
    private void restriccionTeclas(KeyEvent event) {
        if (event.getTarget() == bloqueVelocidad) {
            if (!Character.isDigit(event.getCharacter().charAt(0))) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("ERROR!!!");
                alert.setContentText("NO SE PERMITEN LETRAS EN LA VELOCIDAD");
                alert.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenError.png").toString()));
                alert.setHeaderText("UPS! HA OCURRIDO UN ERROR...");
                alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                alert.showAndWait();
                bloqueVelocidad.setText("");
            }
        } else if (event.getTarget() == bloquePasajeros) {
            if (!Character.isDigit(event.getCharacter().charAt(0))) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("ERROR!!!");
                alert.setContentText("NO SE PERMITEN LETRAS EN EL NUMERO DE PASAJEROS");
                alert.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenError.png").toString()));
                alert.setHeaderText("UPS! HA OCURRIDO UN ERROR...");
                alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                alert.showAndWait();
                bloquePasajeros.setText("");

            }
        } else if (event.getTarget() == bloquePuertas) {
            if (!Character.isDigit(event.getCharacter().charAt(0))) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("ERROR!!!");
                alert.setContentText("NO SE PERMITEN LETRAS EN LA CANTIDAD DE PUERTAS");
                alert.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenError.png").toString()));
                alert.setHeaderText("UPS! HA OCURRIDO UN ERROR...");
                alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                alert.showAndWait();
                bloquePuertas.setText("");
            }
        } else if (event.getTarget() == bloqueModelo) {
            if (!Character.isDigit(event.getCharacter().charAt(0))) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("ERROR!!!");
                alert.setContentText("NO SE PERMITEN LETRAS EN EL MODELO");
                alert.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenError.png").toString()));
                alert.setHeaderText("UPS! HA OCURRIDO UN ERROR...");
                alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                alert.showAndWait();
                bloqueModelo.setText("");
            }

        } else if (event.getTarget() == bloqueCilindraje) {
            if (!Character.isDigit(event.getCharacter().charAt(0))) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("ERROR!!!");
                alert.setContentText("NO SE PERMITEN LETRAS EN EL CILINDRAJE");
                alert.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenError.png").toString()));
                alert.setHeaderText("UPS! HA OCURRIDO UN ERROR...");
                alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                alert.showAndWait();
                bloqueCilindraje.setText("");
            }

        } else if (event.getTarget() == bloqueCambios) {
            if (!Character.isDigit(event.getCharacter().charAt(0))) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("ERROR!!!");
                alert.setContentText("NO SE PERMITEN LETRAS EN LOS CAMBIOS");
                alert.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenError.png").toString()));
                alert.setHeaderText("UPS! HA OCURRIDO UN ERROR...");
                alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                alert.showAndWait();
                bloqueCambios.setText("");


            }
        } else if (event.getTarget() == bloqueBolsa) {
            if (!Character.isDigit(event.getCharacter().charAt(0))) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("ERROR!!!");
                alert.setContentText("NO SE PERMITEN LETRAS EN EL NUMERO DE BOLSAS");
                alert.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenError.png").toString()));
                alert.setHeaderText("UPS! HA OCURRIDO UN ERROR...");
                alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                alert.showAndWait();
                bloqueBolsa.setText("");
            }

        } else if (event.getTarget() == bloqueCaja) {
            if (!Character.isDigit(event.getCharacter().charAt(0))) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("ERROR!!!");
                alert.setContentText("NO SE PERMITEN LETRAS EN LA CAJA DE CAMBIOS");
                alert.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenError.png").toString()));
                alert.setHeaderText("UPS! HA OCURRIDO UN ERROR...");
                alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                alert.showAndWait();
                bloqueCaja.setText("");
            }
        }
    }


    @FXML
    void eventoImagen (ActionEvent event){

        fc.setTitle("Nose que poner");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.gif"));
        
        File file = fc.showOpenDialog(null);

        }
    private EstadoUso obtenerPosesionUso(){

        if(botonUsado.isSelected()){
            return EstadoUso.USADO;
        }
        else if (botonNoUsado.isSelected()){
            return EstadoUso.NOUSADO;
        }
        return null;
    }
    private Combustible obtenerPosesionCombustible (){
        if(botonGasolina.isSelected()){
            return modelo.Combustible.GASOLINA;
        }
        else if (botonDisiel.isSelected()){
            return modelo.Combustible.DIESEL;

        }else if (botonHibridos.isSelected()){
            return modelo.Combustible.HIBRIDOS;

        }else if (botonElectricos.isSelected()){
            return modelo.Combustible.ELECTRICOS;
        }
        return null;

    }

    private Transmision obtenerPosesionTransimicion (){
        if(botonManual.isSelected()){
            return Transmision.MANUAL;
        }
        else if (botonAutomatica.isSelected()){
            return Transmision.AUTOMATICA;
        }
        return null;

    }
    private Poseer obtenerCamara(){
        if(noPoseeCam.isSelected()){
            return Poseer.NOPOSEE;

        }else if( poseeCam.isSelected()){
            return Poseer.POSEER;

        }
        return null;
    }
    private Poseer obtenerAcondicionado(){
        if(noPoseeAco.isSelected()){
            return Poseer.NOPOSEE;

        }else if( poseeAco.isSelected()){
            return Poseer.POSEER;

        }
        return null;
    }
    private Poseer obtener4x4(){
        if(noPosee4.isSelected()){
            return Poseer.NOPOSEE;

        }else if( poseeAco.isSelected()){
            return Poseer.POSEER;

        }
        return null;
    }




}
