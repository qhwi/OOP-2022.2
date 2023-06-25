package hust.soict.cysec.aims.cart;

import hust.soict.cysec.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.naming.LimitExceededException;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    public String addMedia(Media media) throws LimitExceededException {
    	String m = null;
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			throw new LimitExceededException("ERROR: Cart is full...");
		} else if (itemsOrdered.contains(media)) {
            m = (media.getTitle() + "  already added to cart...");
        } else {
            itemsOrdered.add(media);
            m = ("Added to Cart: " + media.getTitle());
        }
		return m;
	}
	
    public String removeMedia(Media media) {
    	String m = null;
		if (itemsOrdered.size() == 0) {
			m = ("Cart is empty...");
			return m;
		} else {
            if (itemsOrdered.remove(media)) {
           		m = ("Removed from Cart: " + media.getTitle());
            } else {
           		m = (media.getTitle() + "  not found in cart...");
           	}
            return m;
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
			if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
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
    
    public int getItemsCount() {
		return itemsOrdered.size();
	}
    
    public String order() {
        if (itemsOrdered.size() == 0) {
            return ("Cart is empty...");
        } else {
        	//order here
            itemsOrdered.clear();
            return "Order created successfully.\\nYour Cart will be cleared.";
        }
    }

	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
}
