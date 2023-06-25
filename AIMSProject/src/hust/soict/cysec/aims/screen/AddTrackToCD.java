package hust.soict.cysec.aims.screen;

import hust.soict.cysec.aims.media.CompactDisc;
import hust.soict.cysec.aims.screen.controller.AddTrackToCDController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.JFrame;

public class AddTrackToCD extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static CompactDisc cd;
    
    public static void main(String[] args) {
		new AddTrackToCD(cd);
	}

    public AddTrackToCD(CompactDisc cd) {
        super();
        AddTrackToCD.cd = cd;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Track to CD");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cysec/aims/screen/fxml/addTrack.fxml"));
                    
                    AddTrackToCDController controller = new AddTrackToCDController(cd);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
