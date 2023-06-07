package pkg;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    private int qtyOrdered = 0;
    
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("Cart is full...");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("Disc added to Cart!");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		int count = 0;
		for (DigitalVideoDisc disc : dvdList) {
			if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
				System.out.println("Cart is full...");
				break;				
			} else {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				count++;
			}
		}
		System.out.println(count + "/" + dvdList.length + " Disks added!");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		addDigitalVideoDisc(disc1);
		addDigitalVideoDisc(disc2);
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == 0) {
			System.out.println("Cart is empty...");
			return;
		}
		
	    for (int i = 0; i < qtyOrdered; i++) {
	        if (itemsOrdered[i].equals(disc)) {
	            for (int j = i; j < qtyOrdered - 1; j++) {
	                itemsOrdered[j] = itemsOrdered[j + 1];
	            }
	            itemsOrdered[qtyOrdered - 1] = null;
	            qtyOrdered--;
	            System.out.println("Disc removed from Cart!");
	            return;
	        }
	    }
	    
	    System.out.println("Disc not found...");
	}
	
	public float totalCost() {
        float total = 0;
        
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
	}

	public void printCart() {
		boolean printed = false;
		System.out.println("********************CART*******************");
		System.out.println("Ordered Items: ");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(itemsOrdered[i].toString());
			printed = true;
		}
		if (!printed)
			System.out.println("None");
		System.out.printf("Total cost: %f\n", totalCost());
		System.out.println("*******************************************");
	}

	public void searchCart(int id) {
		boolean printed = false;
		boolean found = false;
		System.out.printf("Searching for ID '%d':\n", id);
		for (int i = 0; i < qtyOrdered; i++) {
			found = itemsOrdered[i].isMatch(id);
			if (found) {
				System.out.println(itemsOrdered[i].toString());
				printed = true;
			}
		}
		if (!printed)
			System.out.println("ID not found!");
	}
	
	public void searchCart(String title) {
		boolean printed = false;
		boolean found = false;
		System.out.printf("Searching for Title '%s':\n", title);
		for (int i = 0; i < qtyOrdered; i++) {
			found = itemsOrdered[i].isMatch(title);
			if (found) {
				System.out.println(itemsOrdered[i].toString());
				printed = true;
			}
		}
		if (!printed)
			System.out.println("Title not found!");
	}
}
