package javacafe.controllers;

import javacafe.Models.Inventory;
import javacafe.Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditStockController extends PageNavigationController {
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
        try {
            Inventory inv = new Inventory();


            numbercapuccino.setText(String.valueOf(inv.getInventory(0)));
            numberlatte.setText(String.valueOf(inv.getInventory(1)));
            numbermate.setText(String.valueOf(inv.getInventory(2)));
            numberespressof.setText(String.valueOf(inv.getInventory(3)));
            numberespresso.setText(String.valueOf(inv.getInventory(4)));
            numbercookie.setText(String.valueOf(inv.getInventory(5)));
            numberbrownie.setText(String.valueOf(inv.getInventory(6)));


        } catch (IOException e) {
            System.out.println("ERRO AO GERAR INVENTARIO");
            throw new RuntimeException(e);
        }
    }

    //funcoes de navegacao entre telas

    //funcoes de pedido
    public void takeCapuccino(ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        if (invent.getInventory(0) > 0) {
            invent.update(0, 0);
            numbercapuccino.setText(String.valueOf(invent.getInventory(0)));
        }
    }

    public void addCapuccino(ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        invent.update(0, 1);
        numbercapuccino.setText(String.valueOf(invent.getInventory(0)));
    }

    public void takeLatte (ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        if (invent.getInventory(1) > 0) {
            invent.update(1, 0);
            numberlatte.setText(String.valueOf(invent.getInventory(1)));
        }
    }

    public void addLatte(ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        invent.update(1, 1);
        numberlatte.setText(String.valueOf(invent.getInventory(1)));
    }

    public void takeMate(ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        if (invent.getInventory(2) > 0) {
            invent.update(2, 0);
            numbermate.setText(String.valueOf(invent.getInventory(2)));
        }
    }

    public void addMate(ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        invent.update(2, 1);
        numbermate.setText(String.valueOf(invent.getInventory(2)));
    }

    public void takeEspressoF (ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        if (invent.getInventory(3) > 0) {
            invent.update(3, 0);
            numberespressof.setText(String.valueOf(invent.getInventory(3)));
        }
    }

    public void addEspressoF(ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        invent.update(3, 1);
        numberespressof.setText(String.valueOf(invent.getInventory(3)));
    }

    public void takeEspresso (ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        if (invent.getInventory(4) > 0) {
            invent.update(4, 0);
            numberespresso.setText(String.valueOf(invent.getInventory(4)));
        }
    }

    public void addEspresso(ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        invent.update(4, 1);
        numberespresso.setText(String.valueOf(invent.getInventory(4)));
    }

    public void takeCookie (ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        if (invent.getInventory(5) > 0) {
            invent.update(5, 0);
            numbercookie.setText(String.valueOf(invent.getInventory(5)));
        }
    }

    public void addCookie(ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        invent.update(5, 1);
        numbercookie.setText(String.valueOf(invent.getInventory(5)));
    }

    public void takeBrownie (ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        if (invent.getInventory(6) > 0) {
            invent.update(6, 0);
            numberbrownie.setText(String.valueOf(invent.getInventory(6)));
        }
    }

    public void addBrownie(ActionEvent event) throws IOException {
        Inventory invent = new Inventory();
        invent.update(6, 1);
        numberbrownie.setText(String.valueOf(invent.getInventory(6)));
    }



}
