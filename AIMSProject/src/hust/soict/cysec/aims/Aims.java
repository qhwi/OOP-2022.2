package hust.soict.cysec.aims;

import hust.soict.cysec.aims.cart.Cart;
import hust.soict.cysec.aims.disc.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {

		// create cart
		Cart anOrder = new Cart();

		// create and add dvds
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);

		// print cost
		System.out.print("Total cost: ");
		System.out.println(anOrder.totalCost());

		// remove dvd
		anOrder.removeDigitalVideoDisc(dvd1);
	}
}
