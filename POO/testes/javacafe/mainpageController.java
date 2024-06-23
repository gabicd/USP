package javacafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class mainpageController extends pageNavigation {
   //funcoes de navegacao entre telas

  public void goToOrder(ActionEvent event) throws IOException {super.goToOrder(event);}

 @Override
    public void goToItems(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("You already are on the items screen!");
        alert.showAndWait();
    }

    public void goToInventory(ActionEvent event) throws IOException {super.goToInventory(event);}

    public void goToSales(ActionEvent event) throws IOException { super.goToSales(event); }

    public void exitScreen(ActionEvent event) throws IOException { super.exitScreen(event); }

    //funcoes de pedido
    public void takeCapuccino(ActionEvent event) throws IOException {}

    public void addCapuccino(ActionEvent event) throws IOException {}

    public void takeLatte (ActionEvent event) throws IOException {}

    public void addLatte(ActionEvent event) throws IOException {}

    public void takeMate(ActionEvent event) throws IOException {}

    public void addMate(ActionEvent event) throws IOException {}

    public void takeEspressoF (ActionEvent event) throws IOException {}

    public void addEspressoF(ActionEvent event) throws IOException {}

    public void takeEspresso (ActionEvent event) throws IOException {}

    public void addEspresso(ActionEvent event) throws IOException {}

    public void takeCookie (ActionEvent event) throws IOException {}

    public void addCookie(ActionEvent event) throws IOException {}

    public void takeBrownie (ActionEvent event) throws IOException {}

    public void addBrownie(ActionEvent event) throws IOException {}
}
