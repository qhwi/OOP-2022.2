package hust.soict.cysec.aims.screen.controller;

import hust.soict.cysec.aims.store.Store;
import hust.soict.cysec.aims.media.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.ResourceBundle;

public class AddBookScreenController {
    private Store store;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button btnSave;

    @FXML
    private TextField tfTitle;
    
    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost; 


    public AddBookScreenController(Store store) {
        super();
        this.store = store;
    }

    @FXML
    void btnSavePressed(ActionEvent event) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
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
        Book book = new Book(title, category, cost);
        store.addMedia(book);
        tfTitle.clear();
        tfCategory.clear();
        tfCost.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION,  "Added Book:\n" + book.getTitle());
        alert.setTitle("Add to Store");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        btnSave.setDisable(true);
        
        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
        tfCost.textProperty().addListener((observable, oldValue, newValue) -> isFilled());
    }   

    private void isFilled() {
        if (!tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty() && !tfCost.getText().isEmpty()) {
        	btnSave.setDisable(false);
        } else {
        	btnSave.setDisable(true);
        }
    }
    

}