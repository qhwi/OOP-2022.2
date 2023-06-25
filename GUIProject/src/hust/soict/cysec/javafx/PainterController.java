package hust.soict.cysec.javafx;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {

	@FXML
    private Pane drawingAreaPane;
	
	@FXML
    private RadioButton btnEraser;

    @FXML
    private RadioButton btnPen;

    @FXML
    private ResourceBundle resources;

    @FXML
    void clearButtonPressed(ActionEvent event) {
		  drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
      drawingAreaPane.setClip(new Rectangle(0, 0, drawingAreaPane.getWidth(), drawingAreaPane.getHeight()));
      Color inkColor = Color.BLACK;
      if (btnEraser.isSelected()) {
        inkColor = Color.WHITE;
      } 
      Circle newCircle = new Circle(event.getX(), event.getY(), 4, inkColor);
      drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void initialize() {
        assert drawingAreaPane != null : "Error: .fxml not loaded";
    }

}
