package hust.soict.cysec.test.cart;

import javax.naming.LimitExceededException;

import hust.soict.cysec.aims.cart.Cart;
import hust.soict.cysec.aims.media.DigitalVideoDisc;

public class CartTest {
	
	public static void main(String[] args) throws LimitExceededException {
		
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addMedia(dvd3);
		
		cart.printCart();
		
		cart.searchCart(1);
		cart.searchCart("Aladin");
		cart.searchCart("none");
		
	}
}
