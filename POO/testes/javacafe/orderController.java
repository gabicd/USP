package javacafe;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;

public class orderController extends pageNavigation {
    @Override
    public void goToOrder(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("You already are on the orders screen!");
        alert.showAndWait();
    }

    public void goToItems(ActionEvent event) throws IOException { super.goToItems(event); }

    public void goToInventory(ActionEvent event) throws IOException {super.goToInventory(event);}

    public void goToSales(ActionEvent event) throws IOException {super.goToSales(event);}

    public void exitScreen(ActionEvent event) throws IOException {super.exitScreen(event);}

    public void finishOrder(ActionEvent event) throws IOException {}

}
