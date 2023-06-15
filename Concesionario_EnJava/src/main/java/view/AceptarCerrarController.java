package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.stage.StageStyle.UNDECORATED;

public class AceptarCerrarController {

    @FXML
    private Button aceptarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    void aceptarCerrar(ActionEvent event) throws IOException {
        System.exit(0);

    }

    @FXML
    void cancelarCerrar(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage2 = (Stage) source.getScene().getWindow();
        stage2.close();


    }


}
