package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class CorreoController {

    @FXML
    private TextField bloqueCorreo;

    @FXML
    private TextField bloquePalabra;

    @FXML
    private Button botonCerrar;

    @FXML
    private Button botonIngresar;

    @FXML
    private Label x;


    @FXML
    private void labCerrar(MouseEvent event) throws IOException {
        Stage stage= (Stage) this.x.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void eventoRecuperar (ActionEvent event) throws IOException {
        if(bloqueCorreo.getText().isEmpty()){
            Alert alert= new Alert(Alert.AlertType.NONE);
            alert.setTitle("ERROR!!!");
            alert.setContentText("POR FAVOR LLENAR LOS ESPACIOS VACIOS");
            alert.setGraphic(new ImageView(this.getClass().getResource("/imagenes/ImagenLlenarEspacios .png").toString()));
            alert.setHeaderText("UPS!! PARECE QUE SE TE OLVIDO ALGO");
            alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            alert.showAndWait();

        }else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AceptarCerrar.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();
        }

            }

        }


