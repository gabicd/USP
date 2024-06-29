package javacafe.controllers;

import javacafe.Models.Inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;


import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class mainPageController extends PageNavigationController {
    @FXML
    private Text numbercookie;
    @FXML
    private Text numbercapuccino;
    @FXML
    private Text numberlatte;
    @FXML
    private Text numbermate;
    @FXML
    private Text numberespressof;
    @FXML
    private Text numberespresso;
    @FXML
    private Text numberbrownie;

    /**
     * This method is called by the FXMLLoader when initialization is complete
     * @param location
     * @param resources
     */
    public void initialize(URL location, ResourceBundle resources) {
        // This method is called by the FXMLLoader when initialization is complete
        System.out.println("Main Page Initialized");

        numbercookie.setText("0");
        numbercapuccino.setText("0");
        numberlatte.setText("0");
        numbermate.setText("0");
        numberespressof.setText("0");
        numberespresso.setText("0");
        numberbrownie.setText("0");


        // Save counts to file initially
        saveCountsToFile();
        saveHistoryFile();

    }

    private void saveHistoryFile() {
        String filePath = "files/resumo.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("----------------------------------\n");
            if (isGreaterThanZero(numbercapuccino)){
                writer.write("cap: " + numbercapuccino.getText() + " | ");
            }
            if (isGreaterThanZero(numberlatte)){
                writer.write("lat: " + numberlatte.getText() + " | ");
            }
            if (isGreaterThanZero(numbermate)){
                writer.write("Mat: " + numbermate.getText() + " | ");
            }
            if (isGreaterThanZero(numberespressof)){
                writer.write("Esp F: " + numberespressof.getText() + " | ");
            }
            if (isGreaterThanZero(numberespresso)){
                writer.write("Esp: " + numberespresso.getText() + " | ");
            }
            if (isGreaterThanZero(numbercookie)){
                writer.write("Coo: " + numbercookie.getText() + " | ");
            }
            if (isGreaterThanZero(numberbrownie)) {
                writer.write("Bro" + numberbrownie.getText() + " | ");
            }

            double sum = Integer.parseInt(numbercapuccino.getText()) * 10.90 + Integer.parseInt(numberlatte.getText()) * 6.90 + Integer.parseInt(numbermate.getText()) * 8.90 +  Integer.parseInt(numberespressof.getText()) * 4.90 + Integer.parseInt(numberespresso.getText()) * 5.90 + Integer.parseInt(numbercookie.getText()) * 10.90 + Integer.parseInt(numberbrownie.getText()) * 10.90;
            if (sum > 0){
                writer.write("\nR$"  + String.format("%.2f", sum));
            }
            System.out.println("Counts saved to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving counts to file: " + e.getMessage());
        }
    }

    private void saveCountsToFile() {
        String filePath = "counts.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            if (isGreaterThanZero(numbercapuccino)){
                writer.write("Capuccino:............ " + numbercapuccino.getText() + "       R$ " + Integer.parseInt(numbercapuccino.getText()) * 10.90 +"\n");
            }
            if (isGreaterThanZero(numberlatte)){
                writer.write("Latte:............ " + numberlatte.getText() + "       R$ " + Integer.parseInt(numberlatte.getText()) * 6.90 +"\n");
            }
            if (isGreaterThanZero(numbermate)){
                writer.write("Mate:............ " + numbermate.getText() + "       R$ " + Integer.parseInt(numbermate.getText()) * 8.90 +"\n");
            }
            if (isGreaterThanZero(numberespressof)){
                writer.write("EspressoF:............ " + numberespressof.getText() + "       R$ " + Integer.parseInt(numberespressof.getText()) * 4.90 +"\n");
            }
            if (isGreaterThanZero(numberespresso)){
                writer.write("Espresso:............ " + numberespresso.getText() + "       R$ " + Integer.parseInt(numberespresso.getText()) * 5.90 +"\n");
            }
            if (isGreaterThanZero(numbercookie)){
                writer.write("Cookies:............ " + numbercookie.getText() + "       R$ " + Integer.parseInt(numbercookie.getText()) * 10.90 +"\n");
            }
            if (isGreaterThanZero(numberbrownie)) {
                writer.write("Brownie:............ " + numberbrownie.getText() + "       R$ " + Integer.parseInt(numberbrownie.getText()) * 10.90 + "\n");
            }

            writer.write("------------------------------------------------------------------" + "\n");

            double sum = Integer.parseInt(numbercapuccino.getText()) * 10.90 + Integer.parseInt(numberlatte.getText()) * 6.90 + Integer.parseInt(numbermate.getText()) * 8.90 +  Integer.parseInt(numberespressof.getText()) * 4.90 + Integer.parseInt(numberespresso.getText()) * 5.90 + Integer.parseInt(numbercookie.getText()) * 10.90 + Integer.parseInt(numberbrownie.getText()) * 10.90;
            if (sum > 0){
                writer.write("Valor:............. R$"  + String.format("%.2f", sum));
            }

            System.out.println("Counts saved to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving counts to file: " + e.getMessage());
        }
    }

    //funcoes de navegacao entre telas

    private boolean isGreaterThanZero(Text text) {
        int num = Integer.parseInt(text.getText());
        return num > 0;
    }
    //funcoes de pedido
    public void takeCapuccino(ActionEvent event) throws IOException {
        int num = Integer.parseInt(numbercapuccino.getText());
        if (num > 0){
            numbercapuccino.setText(String.valueOf(num - 1));
        }

        saveCountsToFile();
        saveHistoryFile();
    }

    public void addCapuccino(ActionEvent event) throws IOException {
        Inventory inv = new Inventory();
        if (inv.getInventory(0) > 0) {
            int num = Integer.parseInt(numbercapuccino.getText());
            numbercapuccino.setText(String.valueOf(num + 1));
            saveCountsToFile();
            saveHistoryFile();
            inv.update(0, 0);
        }
        else {
            showAlert("CAPUCCINO");
        }
    }

    public void takeLatte (ActionEvent event) throws IOException {
        int num = Integer.parseInt(numberlatte.getText());
        if (num > 0){
            numberlatte.setText(String.valueOf(num - 1));
        }
        saveCountsToFile();
        saveHistoryFile();
    }

    public void addLatte(ActionEvent event) throws IOException {
        Inventory inv = new Inventory();
        if (inv.getInventory(1) > 0) {
            int num = Integer.parseInt(numberlatte.getText());
            numberlatte.setText(String.valueOf(num + 1));
            saveCountsToFile();
            saveHistoryFile();
            inv.update(1, 0);
        }
        else {
            showAlert("LATTE");
        }
    }

    public void takeMate(ActionEvent event) throws IOException {
        int num = Integer.parseInt(numbermate.getText());
        if (num > 0){
            numbermate.setText(String.valueOf(num - 1));
        }
        saveCountsToFile();
        saveHistoryFile();
    }

    public void addMate(ActionEvent event) throws IOException {
        Inventory inv = new Inventory();
        if (inv.getInventory(2) > 0) {
            int num = Integer.parseInt(numbermate.getText());
            numbermate.setText(String.valueOf(num + 1));
            saveCountsToFile();
            saveHistoryFile();
            inv.update(2, 0);
        }
        else {
            showAlert("MATE");
        }
    }

    public void takeEspressoF (ActionEvent event) throws IOException {
        int num = Integer.parseInt(numberespressof.getText());
        if (num > 0){
            numberespressof.setText(String.valueOf(num - 1));
        }
        saveCountsToFile();
        saveHistoryFile();
    }

    public void addEspressoF(ActionEvent event) throws IOException {
        Inventory inv = new Inventory();
        if (inv.getInventory(3) > 0) {
            int num = Integer.parseInt(numberespressof.getText());
            numberespressof.setText(String.valueOf(num + 1));
            saveCountsToFile();
            saveHistoryFile();
            inv.update(3, 0);
        }
        else {
            showAlert("ESPRESSO EXTRAFORTE");
        }
    }

    public void takeEspresso (ActionEvent event) throws IOException {
        int num = Integer.parseInt(numberespresso.getText());
        if (num > 0){
            numberespresso.setText(String.valueOf(num - 1));
        }
        saveCountsToFile();
        saveHistoryFile();
    }

    public void addEspresso(ActionEvent event) throws IOException {
        Inventory inv = new Inventory();
        if (inv.getInventory(4) > 0) {
            int num = Integer.parseInt(numberespresso.getText());
            numberespresso.setText(String.valueOf(num + 1));
            saveCountsToFile();
            saveHistoryFile();
            inv.update(4, 0);
        }
        else {
            showAlert("ESPRESSO");
        }
    }

    public void takeCookie (ActionEvent event) throws IOException {
        int num = Integer.parseInt(numbercookie.getText());
        if (num > 0){
        numbercookie.setText(String.valueOf(num - 1));
        }
        saveCountsToFile();
        saveHistoryFile();
    }

    public void addCookie(ActionEvent event) throws IOException {
        Inventory inv = new Inventory();
        if (inv.getInventory(5) > 0) {
            int num = Integer.parseInt(numbercookie.getText());
            numbercookie.setText(String.valueOf(num + 1));
            saveCountsToFile();
            saveHistoryFile();
            inv.update(5, 0);
        }
        else {
            showAlert("COOKIES");
        }
    }

    public void takeBrownie (ActionEvent event) throws IOException {
        int num = Integer.parseInt(numberbrownie.getText());
        if (num > 0){
            numberbrownie.setText(String.valueOf(num - 1));

        }
        saveCountsToFile();
        saveHistoryFile();
    }

    public void addBrownie(ActionEvent event) throws IOException {
        Inventory inv = new Inventory();
        if (inv.getInventory(6) > 0) {
            int num = Integer.parseInt(numberbrownie.getText());
            numberbrownie.setText(String.valueOf(num + 1));
            saveCountsToFile();
            saveHistoryFile();
            inv.update(6, 0);
        }
        else {
            showAlert("BROWNIE");
        }
    }

    private void showAlert(String item) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("ACABOU O ESTOQUE DE >" + item + "<");
        alert.setContentText("Compre mais itens e atulize o estoque!");
        alert.showAndWait();
    }


}
