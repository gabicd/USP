package javacafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void newCafe (ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("registerscreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void logCafe (ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("logscene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void titlescreen (ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("firstpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
