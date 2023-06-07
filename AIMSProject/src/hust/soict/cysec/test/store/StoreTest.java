package hust.soict.cysec.test.store;

import hust.soict.cysec.aims.disc.DigitalVideoDisc;
import hust.soict.cysec.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);	
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);
		System.out.printf("Number in Store: %d\n", store.getNumberInStore());
		
		store.removeDVD(dvd1);
		System.out.printf("Number in Store: %d\n", store.getNumberInStore());

		store.removeDVD(dvd2);
		System.out.printf("Number in Store: %d\n", store.getNumberInStore());
	}
}