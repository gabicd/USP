package javacafe.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class orderController extends PageNavigationController {
    @FXML
    private Text ordertxt;


    public void initialize(URL location, ResourceBundle resources) {
        // This method is called by the FXMLLoader when initialization is complete
        System.out.println("Order Page Initialized");
        try {
            String content = readFile("counts.txt"); // Replace with your file path
            ordertxt.setText(content);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    private String readFile(String path) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }
        return contentBuilder.toString();
    }

    @Override
    public void goToOrder(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("You already are on the orders screen!");
        alert.showAndWait();
    }



    public void finishOrder(ActionEvent event) throws IOException {
        // Get current date and time for unique file name
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "receipt_" + timestamp + ".txt";

        String receiptContent = "Receipt\n\n" + ordertxt.getText();
        String historyContent = readFile("files/resumo.txt");


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(receiptContent);
            System.out.println("Receipt generated successfully: " + fileName);

            // Show an alert to indicate success
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Order Completed");
            alert.setContentText("The receipt has been generated successfully.");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();

            // Show an alert to indicate failure
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Failed to generate the receipt.");
            alert.showAndWait();
        }
        // ler o arquivo

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("files/sales.txt", true))) {
            writer.write(historyContent);

        } catch (IOException e) {
            e.printStackTrace();

            // Show an alert to indicate failure
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("Failed");
            alert.showAndWait();
        }
        // ler o arquivo
    }
}
