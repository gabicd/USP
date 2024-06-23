package javacafe;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;

public class inventoryController extends pageNavigation{
    public void goToOrder(ActionEvent event) throws IOException {super.goToOrder(event);}

    public void goToItems(ActionEvent event) throws IOException { super.goToItems(event); }
    @Override
    public void goToInventory(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("You already are on the inventory screen!");
        alert.showAndWait();
    }

    public void goToSales(ActionEvent event) throws IOException {super.goToSales(event);}

    public void exitScreen(ActionEvent event) throws IOException {super.exitScreen(event);}

    public void editStock(ActionEvent event) throws IOException{

    }

}
