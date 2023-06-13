package hust.soict.cysec.aims.cart;

import hust.soict.cysec.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    public void addMedia(Media media) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("Cart is full...");
		} else if (itemsOrdered.contains(media)) {
            System.out.println(media.getTitle() + "  already added to cart...");
        } else {
            itemsOrdered.add(media);
            System.out.println("Added to Cart: " + media.getTitle());
        }
	}
	
    public void removeMedia(Media media) {
		if (itemsOrdered.size() == 0) {
			System.out.println("Cart is empty...");
			return;
		} else {
            if (itemsOrdered.remove(media)) {
           		System.out.println("Removed from Cart: " + media.getTitle());
            } else {
           		System.out.println(media.getTitle() + "  not found in cart...");
           	}
        }
	}
	
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
        	total += media.getCost();
        }
        return total;
    }

	public void printCart() {
		boolean printed = false;
		System.out.println("********************CART*******************");
		System.out.println("Ordered Items: ");
		for (Media media : itemsOrdered) {
            System.out.println(media.toString());
            printed = true;
        }
		if (!printed)
			System.out.println("None");
		System.out.printf("Total cost: %f\n", totalCost());
		System.out.println("*******************************************");
	}

	public void searchCart(int id) {
		boolean printed = false;
		System.out.printf("Searching for ID '%d':\n", id);
		for (Media media : itemsOrdered) {
			if (media.isMatch(id)) {
				System.out.println(media.toString());
				printed = true;
				break;
			}
        }
		if (!printed)
			System.out.println("ID not found!");
	}
	
	public void searchCart(String title) {
		boolean printed = false;
		System.out.printf("Searching for Title '%s':\n", title);
		for (Media media : itemsOrdered) {
			if (media.isMatch(title)) {
				System.out.println(media.toString());
				printed = true;
			}
        }
		if (!printed)
			System.out.println("Title not found!");
	}
	
	public void sortCartByTitle() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void sortCartByCost() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
}
