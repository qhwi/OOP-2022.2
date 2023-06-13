package hust.soict.cysec.aims.store;

import hust.soict.cysec.aims.media.Media;
import java.util.*;

public class Store {

	public static final int MAX_NUMBERS_INSTORE = 100;
	
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public int getNumberInStore() {
		return itemsInStore.size();
	}
	
    public void addMedia(Media media) {
		if (itemsInStore.size() >= MAX_NUMBERS_INSTORE) {
			System.out.println("Store is full...");
		} else if (itemsInStore.contains(media)) {
            System.out.println(media.getTitle() + "  already added to store...");
        } else {
        	itemsInStore.add(media);
            System.out.println("Added to Store: " + media.getTitle());
        }
	}
	
    public void removeMedia(Media media) {
		if (itemsInStore.size() == 0) {
			System.out.println("Store is empty...");
			return;
		} else {
            if (itemsInStore.remove(media)) {
           		System.out.println("Removed from Store: " + media.getTitle());
            } else {
           		System.out.println(media.getTitle() + "  not found in store...");
           	}
        }
	}
    
	public void printStore() {
		boolean printed = false;
		System.out.println("********************STORE*******************");
		System.out.println("Ordered Items: ");
		for (Media media : itemsInStore) {
            System.out.println(media.toString());
            printed = true;
        }
		if (!printed)
			System.out.println("None");
		System.out.println("********************************************");
	}
	
	public Media searchStore(String title) {
		for (Media media : itemsInStore) {
			if (media.isMatch(title)) {
				System.out.println(media.toString());
				return media;
			}
        }
		return null;
	}
}
