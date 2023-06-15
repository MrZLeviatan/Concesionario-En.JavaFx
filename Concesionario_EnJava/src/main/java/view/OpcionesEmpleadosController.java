package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.Empleado;

import java.io.IOException;
import java.util.List;
import java.util.Observable;

import  static view.consecionarioInstance.INSTANCE;

import static javafx.stage.StageStyle.UNDECORATED;

public class OpcionesEmpleadosController {

    @FXML
    private Button botonActualizar;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonRegistrar;

    @FXML
    private Label volver;

    @FXML
    private Label x;

    @FXML
    private Button botonMostrar;

    @FXML
    private TableView<Empleado> tablaEmpleados;
    @FXML
    private TableColumn<?, ?> tCedula;

    @FXML
    private TableColumn<?, ?> tContraseña;

    @FXML
    private TableColumn<?, ?> tCorreo;

    @FXML
    private TableColumn<?, ?> tNombres;

    @FXML
    void labCerrar(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AceptarCerrar.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void eventoVolver (MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Administrador.fxml"));
        Parent root= loader.load();
        Stage stage = new Stage();
        stage.initStyle(UNDECORATED);
        stage.setScene(new Scene(root));
        Node source = (Node) event.getSource();
        Stage stage2 = (Stage) source.getScene().getWindow();
        stage2.hide();
        stage.show();
    }
   public void eventoRegistro (ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrarEmpleado.fxml"));
       Parent root= loader.load();
       Stage stage = new Stage();
       stage.initStyle(UNDECORATED);
       stage.setScene(new Scene(root));
       Node source = (Node) event.getSource();
       Stage stage2 = (Stage) source.getScene().getWindow();
       stage2.hide();
       stage.show();

   }

    public void eventoEliminar (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BuscadorEmpleado.fxml"));
        Parent root= loader.load();
        Stage stage = new Stage();
        stage.initStyle(UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();

   }
    public void llenarCampos(Empleado empleado) {
        if (empleado != null) {
            tCedula.setText(empleado.getCc());
            tContraseña.setText(empleado.getClave());
            tNombres.setText(empleado.getNombre());
            tCorreo.setText(empleado.getCorreo());
        }
    }
    private void llenarTabla(List<Empleado> empleados) {
        tablaEmpleados.setItems(FXCollections.observableArrayList(empleados));
        tablaEmpleados.refresh();
    }

   public void eventoLlenar (ActionEvent event){

        tablaEmpleados.setItems(FXCollections.observableArrayList(INSTANCE.getConsesionario().getListaEmpleado()
        ));
        tablaEmpleados.refresh();
        initialize();
        llenarTabla(INSTANCE.getConsesionario().getListaEmpleado());
        INSTANCE.getConsesionario().getListaEmpleado().forEach(Empleado -> llenarCampos(Empleado));

    }

    public void initialize(){
        llenarTabla(INSTANCE.getConsesionario().buscar(null,null,null,null));
        tNombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        tCedula.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tContraseña.setCellValueFactory(new PropertyValueFactory<>("contraseña"));
        tablaEmpleados.getSelectionModel()
                .selectedItemProperty().addListener(( observable, oldValue,newValue)->llenarCampos(newValue));


    }

    }
