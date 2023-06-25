package hust.soict.cysec.aims.screen;

import hust.soict.cysec.aims.cart.Cart;
import hust.soict.cysec.aims.exception.PlayerException;
import hust.soict.cysec.aims.media.Media;
import hust.soict.cysec.aims.media.Playable;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MediaStore extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Media media;

	public MediaStore(Media media, Cart cart) {
		
		this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton toCart = new JButton("Add to cart");
        toCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					JOptionPane.showMessageDialog(null, cart.addMedia(media));
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (LimitExceededException e1) {
					e1.printStackTrace();
				}
            }
        });
        container.add(toCart);
    
	    if (media instanceof Playable) {
	        JButton play = new JButton("Play");
	        play.addActionListener(new ActionListener() {
	        	@Override
	            public void actionPerformed(ActionEvent e) {
	
	                JDialog dialog = new JDialog();
	                dialog.setTitle(media.getTitle());
	                dialog.setSize(400, 300);
	
	                String mediaInfo = "";
                    try {
						mediaInfo = "<html>"+ media.play().replace("\n", "<br/>") + "</html>";
					} catch (PlayerException e1) {
						e1.printStackTrace();
					}
                    JLabel mediaLabel = new JLabel(mediaInfo);
                    mediaLabel.setVerticalAlignment(JLabel.CENTER); 
                    mediaLabel.setHorizontalAlignment(JLabel.CENTER);
                    JScrollPane scrollPane = new JScrollPane(mediaLabel);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                    
                    dialog.add(scrollPane);
                    dialog.setVisible(true);
	            }
	        });
	        container.add(play);
	    }
	
	    this.add(Box.createVerticalGlue());
	    this.add(title);
	    this.add(cost);
	    this.add(Box.createVerticalGlue());
	    this.add(container);
	    
	    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
