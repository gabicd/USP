package javacafe.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class salesController extends PageNavigationController {
    @FXML
    private Text ordertxt;

    public void initialize(URL location, ResourceBundle resources) {
        // This method is called by the FXMLLoader when initialization is complete
        System.out.println("Sales Page Initialized");
        try {
            String content = readFile("files/sales.txt"); // Replace with your file path
            ordertxt.setText(content);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    private String readFile(String counts) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(counts))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }
        return contentBuilder.toString();
    }

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
