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
			System.out.println("Disc added!");
		}
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
	            System.out.println("Disc removed!");
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
}
