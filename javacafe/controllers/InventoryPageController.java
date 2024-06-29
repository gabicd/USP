package javacafe.controllers;

import javacafe.Models.Inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class InventoryPageController extends PageNavigationController {
    private Stage stage;
    private Scene scene;

    @FXML
    private Text capuccinoStock;
    @FXML
    private Text latteStock;
    @FXML
    private Text mateStock;
    @FXML
    private Text espressoFStock;
    @FXML
    private Text espressoStock;
    @FXML
    private Text cookieStock;
    @FXML
    private Text brownieStock;

    public void initialize(URL location, ResourceBundle resources) {
        // This method is called by the FXMLLoader when initialization is complete
        System.out.println("Inventory Page Initialized");
        try {
            Inventory inv = new Inventory();


            capuccinoStock.setText(String.valueOf(inv.getInventory(0)));
            latteStock.setText(String.valueOf(inv.getInventory(1)));
            mateStock.setText(String.valueOf(inv.getInventory(2)));
            espressoFStock.setText(String.valueOf(inv.getInventory(3)));
            espressoStock.setText(String.valueOf(inv.getInventory(4)));
            cookieStock.setText(String.valueOf(inv.getInventory(5)));
            brownieStock.setText(String.valueOf(inv.getInventory(6)));


        } catch (IOException e) {
            System.out.println("ERRO AO GERAR INVENTARIO");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void goToInventory(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("You already are on the inventory screen!");
        alert.showAndWait();
    }

    /**
     * Direciona para a página de editar estoque
     * @param event
     * @throws IOException
     */
    public void editStock(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../pages/editstockpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
