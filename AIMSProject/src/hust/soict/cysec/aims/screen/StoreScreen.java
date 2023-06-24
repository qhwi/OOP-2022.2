package hust.soict.cysec.aims.screen;

import hust.soict.cysec.aims.store.Store;
import hust.soict.cysec.aims.cart.Cart;
import hust.soict.cysec.aims.media.Media;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
	private static Store store = new Store();
    private static Cart cart = new Cart();
    
    public static void main(String[] args) {
		new StoreScreen(store);
	}

	public StoreScreen(Store store) {
		StoreScreen.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        
        setVisible(true);
        setTitle("Store");
		setSize(1024, 768);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {

        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem smAddBook = new JMenuItem("Add Book");
        JMenuItem smAddCD = new JMenuItem("Add CD");
        JMenuItem smAddDVD = new JMenuItem("Add DVD");
        smUpdateStore.add(smAddBook);
        smUpdateStore.add(smAddCD);
        smUpdateStore.add(smAddDVD);        

        smAddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new AddBookToStoreScreen(store);
            }
        });
        smAddCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new AddCompactDiscToStoreScreen(store);
            }
        });
        smAddDVD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new AddDigitalVideoDiscToStoreScreen(store);
            }
        });

        menu.add(smUpdateStore);

        JMenuItem viewStore = new JMenuItem("View store");
        JMenuItem viewCart = new JMenuItem("View cart");
        menu.add(viewStore);
        menu.add(viewCart);
        
        viewStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreScreen(store);
            }
        });
        viewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
            }
        });

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }
	
	JPanel createHeader() {

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
    
        JButton viewCart = new JButton("View cart");
        viewCart.setPreferredSize(new Dimension(100, 50));
        viewCart.setMaximumSize(new Dimension(100, 50));
        
        viewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
            }
        });
        
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(viewCart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }
	
	JPanel createCenter() {

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }
        
        return center;
    }

}
