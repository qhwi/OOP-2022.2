package hust.soict.cysec.aims.screen;

import hust.soict.cysec.aims.screen.controller.AddDVDScreenController;
import hust.soict.cysec.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.JFrame;

public class AddDigitalVideoDiscToStoreScreen extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Store store;
    
    public static void main(String[] args) {
		new AddDigitalVideoDiscToStoreScreen(store);
	}

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super();
        AddDigitalVideoDiscToStoreScreen.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add DVD");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cysec/aims/screen/fxml/addDVD.fxml"));
         
                    AddDVDScreenController controller = new AddDVDScreenController(store);
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
