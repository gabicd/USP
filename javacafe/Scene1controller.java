package javacafe;

import javacafe.Models.User;
import javacafe.backend_files.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField nameTextField;
    @FXML
    TextField passwordField;

    public void goToNewCafePage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("pages/registerscreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToLogPage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("pages/logscene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void firstPage (ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("pages/firstpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Recebe o nome do café e a senha e efetua o login se existir este registro.
     * Ao fazer o login direciona para a página principal.
     *
     * @param event
     * @throws IOException
     */
    public void login (ActionEvent event) throws IOException {
        LoginController controller = new LoginController();

        String username = nameTextField.getText();
        String pass = passwordField.getText();
        User user = new User(username, pass);

        if(controller.validUser(user)) {
            Parent root = FXMLLoader.load(getClass().getResource("pages/mainpage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            System.out.print("Incorrect username or password");
        }
    }



}
