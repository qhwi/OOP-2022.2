package hust.soict.cysec.aims.store;

import hust.soict.cysec.aims.media.Media;
import java.util.*;

public class Store {

	public static final int MAX_NUMBERS_INSTORE = 100;
	
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public int getItemsCount() {
		return itemsInStore.size();
	}
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
    public String addMedia(Media media) {
    	String m = null;
		if (itemsInStore.size() >= MAX_NUMBERS_INSTORE) {
			m = ("Store is full...");
		} else if (itemsInStore.contains(media)) {
            m = (media.getTitle() + "  already added to store...");
        } else {
        	itemsInStore.add(media);
            m = ("Added to Store: " + media.getTitle());
        }
		return m;
	}
	
    public String removeMedia(Media media) {
    	String m = null;
		if (itemsInStore.size() == 0) {
			m = ("Store is empty...");
		} else {
            if (itemsInStore.remove(media)) {
           		m = ("Removed from Store: " + media.getTitle());
            } else {
           		m = (media.getTitle() + "  not found in store...");
           	}
        }
		return m;
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
