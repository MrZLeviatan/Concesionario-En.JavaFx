package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import static javafx.stage.StageStyle.UNDECORATED;

public class BusesController {

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
    private Button botonCancelar;

    @FXML
    private Button botonRegistro;


    final FileChooser fc = new FileChooser();


    @FXML
    void eventoImagen(ActionEvent event) {
        fc.setTitle("Nose que poner");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.gif"));

        File file = fc.showOpenDialog(null);

    }
    

    @FXML
    void eventocancelar(MouseEvent event) throws IOException {
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
    void restriccionTeclas(KeyEvent event) {

    }

 }
