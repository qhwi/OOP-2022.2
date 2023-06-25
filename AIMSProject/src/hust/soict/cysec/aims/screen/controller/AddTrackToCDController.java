package hust.soict.cysec.aims.screen.controller;

import hust.soict.cysec.aims.media.CompactDisc;
import hust.soict.cysec.aims.media.Track;
import hust.soict.cysec.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.ResourceBundle;

public class AddTrackToCDController {
    private CompactDisc cd;

    @FXML
    private Button btnSave;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;
    
    @FXML
    private ResourceBundle resources;
    
    public AddTrackToCDController(CompactDisc CD) {
        super();
        this.cd = CD;
    }

    @FXML
    void btnSavePressed(ActionEvent event) {
        String title = tfTitle.getText();
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
        Track track = new Track(title, length);
        cd.addTrack(track);
        tfTitle.clear();
        tfLength.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added Track:\n" + track.getTitle());
        alert.setTitle("Add to Store");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
    	btnSave.setDisable(true);
        
        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
        tfLength.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
    }   

    private void isFilled() {
        if (!tfTitle.getText().isEmpty() && !tfLength.getText().isEmpty()) {
        	btnSave.setDisable(false);
        } else {
        	btnSave.setDisable(true);
        }
    }

}
