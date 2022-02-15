package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.ConnectionDB;
import modelo.Login;
import modelo.Operator;
import pruebalogin.pruebalogin.Principal;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController extends ConnectionDB {
    Stage stage;
    BorderPane scenePane = null;

    @FXML
    public TextField entradaUsuario;
    @FXML
    public TextField InPassword;
    @FXML
    public Button click;

    @FXML
    public void clickLogin(ActionEvent actionEvent) {

        /*
        String usuario = entradaUsuario.getText();
        String contr = InPassword.getText();*/

        String usuario = "juan.lopez";
        String contr = "juan123";

        entradaUsuario.setText("juan.lopez");
        InPassword.setText("juan123");

        Boolean log = false;

        try {
            Connection connection = connectDB();
            Statement st = connection.createStatement();
            String sql = "select * from operator where user_op = '"+usuario+"' and password_op = '"+contr+"' ";
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                log = true;
                if(log){
                    System.out.printf("Login correcto\n");
                }
            } else {
                System.out.printf("Usuario o contraseña incorrectos");
            }

            while (rs.next()) {
                String user = rs.getString("user_op");
                String passw = rs.getString("password_op");
                System.out.println("user: " + user + " | " + "password: " + passw);
            }
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //launchOperatorView();
    }

    @FXML
    public void launchOperatorView() {
        try {
            FXMLLoader loader = new FXMLLoader(Principal.class.getResource("/vistas/OperatorView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Creación usuarios");
            stage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}