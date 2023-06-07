package hust.soict.cysec.aims.store;

import hust.soict.cysec.aims.disc.DigitalVideoDisc;

public class Store {

	public static final int MAX_NUMBERS_INSTORE = 100;
	
	public int numberInStore = 0;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_INSTORE];
	
	public int getNumberInStore() {
		return numberInStore;
	}

	public void addDVD(DigitalVideoDisc dvd) {
		if (numberInStore == MAX_NUMBERS_INSTORE) {
			System.out.println("Store is full...");
			return;
		}

		itemsInStore[numberInStore] = dvd;
		numberInStore++;
		System.out.println("Disc added to Store!");
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		
		if (numberInStore == 0) {
			System.out.println("Store is empty...");
			return;
		}
		
		for (int i = 0; i < numberInStore; i++) {
			if (itemsInStore[i].equals(disc)) {
				for (int j = i; j < numberInStore - 1; j++) {
					itemsInStore[j] = itemsInStore[j + 1];
				}
				numberInStore--;
				itemsInStore[numberInStore] = null;
				System.out.println("Disc removed from Store!");
				return;
			}
		}
	}
}
