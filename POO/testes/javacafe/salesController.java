package javacafe;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;

public class salesController extends pageNavigation {
    public void goToOrder(ActionEvent event) throws IOException {super.goToOrder(event);}

    public void goToItems(ActionEvent event) throws IOException { super.goToItems(event); }

    public void goToInventory(ActionEvent event) throws IOException {super.goToInventory(event);}
    @Override
    public void goToSales(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("You already are on the sales screen!");
        alert.showAndWait();

    }

    public void exitScreen(ActionEvent event) throws IOException {super.exitScreen(event);}

    public void generateReport (ActionEvent event) throws IOException{

    }
}
