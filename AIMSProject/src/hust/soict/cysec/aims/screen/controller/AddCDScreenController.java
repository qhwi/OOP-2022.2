package hust.soict.cysec.aims.screen.controller;

import hust.soict.cysec.aims.media.CompactDisc;
import hust.soict.cysec.aims.screen.AddTrackToCD;
import hust.soict.cysec.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.ResourceBundle;

public class AddCDScreenController {

    private Store store;
    
    private CompactDisc cd;
    
    @FXML
    private Button btnAddTrack;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnAddCD;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfArtist;

    @FXML
    private TextField tfTitle;
    
    @FXML
    private ResourceBundle resources;


    public AddCDScreenController(Store store) {
        super();
        this.store = store;
    }

    @FXML
    void btnAddCDPressed(ActionEvent event) {
        store.addMedia(cd);
        tfTitle.clear();
        tfCategory.clear();
        tfArtist.clear();
        tfCost.clear();
        btnSave.setDisable(true);
        btnAddCD.setDisable(true);
        btnAddTrack.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added CD:\n" + cd.getTitle());
        alert.setTitle("Add to Store");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
    @FXML
    void btnAddTrackPressed(ActionEvent event) {
        new AddTrackToCD(cd);
    }

    @FXML
    void btnSavePressed(ActionEvent event) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String artist = tfArtist.getText();
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
        cd = new CompactDisc(title, category, artist, cost);
        btnAddCD.setDisable(false);
        btnAddTrack.setDisable(false);
        btnSave.setDisable(true);
    }

    @FXML
    void initialize() {
        btnSave.setDisable(true);
        btnAddCD.setDisable(true);
        btnAddTrack.setDisable(true);
        
        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
        tfArtist.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
        tfCost.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
    }   

    private void isFilled() {
        if (!tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty() && !tfArtist.getText().isEmpty() &&  !tfCost.getText().isEmpty()) {
        	btnSave.setDisable(false);
        } else {
        	btnSave.setDisable(true);
        }
    }
    

}
