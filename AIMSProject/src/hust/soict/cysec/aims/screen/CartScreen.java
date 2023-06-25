package hust.soict.cysec.aims.screen;

import hust.soict.cysec.aims.cart.Cart;
import hust.soict.cysec.aims.screen.controller.CartScreenController;

import javax.swing.*;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;


public class CartScreen extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Cart cart;

    public CartScreen(Cart cart) {
        super();
        CartScreen.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                	System.out.println("GETTING");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cysec/aims/screen/fxml/cart.fxml"));
                    System.out.println("DONE");
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static void main(String[] args) {
		new CartScreen(cart);
	}
    
}