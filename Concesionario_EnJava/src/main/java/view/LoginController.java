/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.stage.StageStyle.UNDECORATED;
import static view.consecionarioInstance.INSTANCE;

/**
 * FXML Controller class
 *
 * @author Mr. Nicolas
 */
public class LoginController implements Initializable {
    @FXML
    private PasswordField bloqueContraseña;

    @FXML
    private TextField bloqueUsuario;

    @FXML
    private Button botonIngreso;

    @FXML
    private Button botonRecuperar;

    @FXML
    private Label textoContraseña;

    @FXML
    private Label textoUsuario;

    @FXML
    private Label x;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void labCerrar(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AceptarCerrar.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    private void eventEspaciosBlancos(KeyEvent event) throws IOException {

        Object evt = event.getSource();

        if (evt.equals(bloqueUsuario)) {
            if (event.getCharacter().equals(" ")) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("ERROR!!!");
                alert.setContentText("NO SE PERMITEN ESPACIOS EN BLANCO");
                alert.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenError.png").toString()));
                alert.setHeaderText("UPS! HA OCURRIDO UN ERROR...");
                alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                alert.showAndWait();
                bloqueUsuario.setText("");
            }
        } else if (evt.equals(bloqueContraseña)) {
            if (event.getCharacter().equals(" ")) {
                Alert alert1= new Alert(Alert.AlertType.NONE);
                alert1.setTitle("ERROR!!!");
                alert1.setContentText("NO SE PERMITEN ESPACIOS EN BLANCO");
                alert1.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenError.png").toString()));
                alert1.setHeaderText("UPS! HA OCURRIDO UN ERROR...");
                alert1.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                alert1.showAndWait();
                bloqueContraseña.setText("");
            }

        }

    }

    @FXML
    private void eventoRecuperar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Correo.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    public void eventoValidacion(ActionEvent event) throws Exception {


        if(INSTANCE.getConsesionario().verificarAdm(bloqueUsuario.getText(),bloqueContraseña.getText())){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Administrador.fxml"));
            Parent root= loader.load();
            Stage stage = new Stage();
            stage.initStyle(UNDECORATED);
            stage.setScene(new Scene(root));
            Node source = (Node) event.getSource();
            Stage stage2 = (Stage) source.getScene().getWindow();
            stage2.close();
            stage.show();

        } else if(INSTANCE.getConsesionario().verificarEmpleado(bloqueUsuario.getText(),bloqueContraseña.getText())){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Empleado.fxml"));
            Parent root= loader.load();
            Stage stage = new Stage();
            stage.initStyle(UNDECORATED);
            stage.setScene(new Scene(root));
            Node source = (Node) event.getSource();
            Stage stage2 = (Stage) source.getScene().getWindow();
            stage2.close();
            stage.show();
        }

        else{
            Alert alert1= new Alert(Alert.AlertType.NONE);
            alert1.setTitle("ERROR!!!");
            alert1.setContentText("USUARIO NO ENCONTRADO...");
            alert1.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenLlenarEspacios .png").toString()));
            alert1.setHeaderText("PARECE QUE NO TE ENCONTRAMOS...");
            alert1.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert1.showAndWait();
            bloqueContraseña.setText("");


        }
    }

}


       
      





