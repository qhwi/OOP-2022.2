package hust.soict.cysec.aims.screen.controller;

import hust.soict.cysec.aims.media.DigitalVideoDisc;
import hust.soict.cysec.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.ResourceBundle;

public class AddDVDScreenController {

    private Store store;

    @FXML
    private Button btnSave;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;

    @FXML
    private ResourceBundle resources;


    public AddDVDScreenController(Store store) {
        super();
        this.store = store;
    }

    @FXML
    void btnSavePressed(ActionEvent event) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String director = tfDirector.getText();
        int length = 0;
        try {
            length = Integer.parseInt(tfLength.getText());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid length!");
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        float cost = 0.0f;
        try {
            cost = Float.parseFloat(tfCost.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid cost!");
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length,cost);
        store.addMedia(dvd);
        tfTitle.clear();
        tfCategory.clear();
        tfDirector.clear();
        tfLength.clear();
        tfCost.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added DVD:\n" + dvd.getTitle());
        alert.setTitle("Add to Store");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        btnSave.setDisable(true);
        
        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
        tfDirector.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
        tfLength.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
        tfCost.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
    }   

    private void isFilled() {
        if (!tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty() && !tfDirector.getText().isEmpty() && !tfLength.getText().isEmpty() && !tfCost.getText().isEmpty()) {
        	btnSave.setDisable(false);
        } else {
        	btnSave.setDisable(true);
        }
    }
}
