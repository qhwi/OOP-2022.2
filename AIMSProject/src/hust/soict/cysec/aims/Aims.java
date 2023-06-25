package hust.soict.cysec.aims;

import hust.soict.cysec.aims.cart.Cart;
import hust.soict.cysec.aims.exception.PlayerException;
import hust.soict.cysec.aims.media.*;
import hust.soict.cysec.aims.store.Store;
import java.util.Scanner;

import javax.naming.LimitExceededException;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;
        while (!exit) {
            
            showMenu();
            int option = -1;
            if(scanner.hasNextInt())
            	option = scanner.nextInt();
            scanner.nextLine();
        	System.out.println("\n");

            switch (option) {
                case 0:
                    exit = true;
                    System.out.println("Good bye!");
                    break;
                case 1:
                    storeMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    cartMenu();
                    break;
                default:
                    System.out.println("Invalid option, please choose again.");
                    break;
            }
        }
    }
    
    
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number (0-3): ");
    }
    
    public static void storeMenu() {
        boolean back = false;
        boolean found = false;
        while (!back) {
        	store.printStore();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number (0-4): ");
            int option = -1;
            if(scanner.hasNextInt())
            	option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");
            switch (option) {
                case 0:
                    back = true;
                    break;
                case 1:
                    found = false;
                    while (!found) {
                        System.out.print("Enter the Media title (type Enter to stop): ");
                        String title = scanner.nextLine().strip();
                        System.out.println("\n");
                        if (title.length() == 0)
                            break;
                        Media media = store.searchStore(title);
                        if (media != null) {
                            System.out.println("Media Details: ");
                            System.out.println(media.toString());
                            mediaDetailsMenu(media);
                            found = true;
                        } else {
                            System.out.println("Title not found...");
                        }
                    }
                    break;
                case 2:
                    found = false;
                    store.printStore();
                    while (!found) {
                        System.out.print("Enter the Media title (type Enter to stop): ");
                        String title = scanner.nextLine().strip();
                        System.out.println("\n");
                        if (title.length() == 0)
                            break;
                        Media media = store.searchStore(title);
                        if (media != null) {
                        	try {
								System.out.println(cart.addMedia(media));
							} catch (LimitExceededException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                            System.out.println("Current number of items in Cart: " + cart.getItemsCount());
                            found = true;
                        } else {
                            System.out.println("Title not found...");
                        }
                    }
                    break;
                case 3:
                    found = false;
                    while (!found) {
                        System.out.print("Enter the Media title (type Enter to stop): ");
                        String title = scanner.nextLine().strip();
                        System.out.println("\n");
                        if (title.length() == 0)
                            break;
                        Media media = store.searchStore(title);
                        if (media != null) {
                            if (media instanceof Disc) {
                                try {
									media.play();
								} catch (PlayerException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
                            } else {
                                System.out.println("Media not supported for playing...");
                            }
                            found = true;
                        } else {
                            System.out.println("Title not found...");
                        }
                    }
                    break;
                case 4:
                    cartMenu();
                    break;    
                default:
                    System.out.println("Invalid option, please choose again.");
                    break;
            }
        }
    }
    public static void mediaDetailsMenu(Media media) {
        boolean back = false;
        while (!back) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Disc)
            	System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number (0-2): ");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");
            switch (option) {
                case 0:
                    back = true;
                    break;
                case 1:
				try {
					System.out.println(cart.addMedia(media));
				} catch (LimitExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    break;
                case 2:
                    if (media instanceof Disc) {
                        try {
							media.play();
						} catch (PlayerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        break;
                    }
                default:
                    System.out.println("Invalid option...");
                    break;
            }
        }
    }
    
    public static void cartMenu() {
        boolean back = false;
        while (!back) {
            cart.printCart();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number (0-5): ");
            int option = -1;
            if(scanner.hasNextInt())
            	option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");
            switch (option) {
                case 0:
                    back = true;
                    break;
                case 1:
                    System.out.print("Filter medias in cart by (1) id or (2) title: ");
                    int filterOption = -1;
                    if(scanner.hasNextInt())
                    	filterOption = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("\n");

                    while (true) {
                        if (filterOption == 1) {
                            System.out.print("Enter the id to filter (type 0 to stop): ");
                            int id = 0;
                            if(scanner.hasNextInt())
                            	id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("\n");
                            if (id == 0) {
                                break;
                            }
                            cart.searchCart(id);
                            break;
                        } else if (filterOption == 2) {
                            System.out.print("Enter the title to filter (type Enter to stop): ");
                            String title = scanner.nextLine().strip();
                            System.out.println("\n");
                            if (title.length() == 0)
                                break;
                            cart.searchCart(title);
                            break;
                        } else {
                            System.out.println("Invalid input...");
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.print("Sort medias in cart by (1) title or (2) cost: ");
                    int sortOption = -1;
                    if(scanner.hasNextInt())
                    	sortOption = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("\n");
                    if (sortOption == 1) {
                        cart.sortCartByTitle();
                        cart.printCart();
                    } else if (sortOption == 2) {
                        cart.sortCartByCost();
                        cart.printCart();
                    } else {
                        System.out.println("Invalid option...");
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.print("Enter the Media title (type Enter to stop): ");
                        String title = scanner.nextLine().strip();
                        System.out.println("\n");
                        if (title.length() == 0)
                            break;
                        Media media = store.searchStore(title);
                        if (media != null) {
                        	System.out.println(cart.removeMedia(media));
                            break;
                        } else {
                            System.out.println("Title not found...");
                        }
                    } 
                    break;
                case 4:
                    while (true) {
                        System.out.print("Enter the Media title (type Enter to stop): ");
                        String title = scanner.nextLine().strip();
                        System.out.println("\n");
                        if (title.length() == 0)
                            break;
                        Media media = store.searchStore(title);
                        if (media != null) {
                            if (media instanceof Disc) {
                                try {
									media.play();
								} catch (PlayerException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
                            } else {
                                System.out.println("Media type not supported for playing!");
                            }
                            break;
                        } else {
                            System.out.println("Title not found...");
                        }
                    }
                    break; 
                case 5:
                	cart.order();
                    break;
                default:
                    System.out.println("Invalid option, please choose again.");
                    break;
            }
        }
    }
    public static void updateStoreMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number (0-2): ");
            int option = -1;
            if(scanner.hasNextInt())
            	option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");
            switch (option) {
                case 0:
                    back = true;
                    break;
                case 1:
                    boolean valid = true;
                    int mediaOption = 0;
                	String mediaTitle = null;
                	String mediaCate = null;
                	Float mediaCost = null;
                	while (valid) {
                		System.out.print("Enter the category of the media (1) Book, (2) CD, (3) DVD or (0) exit: ");
                        if(scanner.hasNextInt())
                        	mediaOption = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("\n");
                        if (mediaOption == 0)
                        	break;
                        else if (mediaOption < 0 || mediaOption > 3) valid = false;
                        System.out.print("Enter Title: ");
                        mediaTitle = scanner.nextLine().strip();
                        System.out.print("\n");
                        if (mediaTitle.length() == 0) valid = false;
                        if (!valid) {
                        	System.out.println("Invalid input... Please try again!");
                        	valid = true;
                        } else {
	                        System.out.print("Enter Category: ");
	                        mediaCate = scanner.nextLine().strip();
	                        System.out.print("\n");
	                        if (mediaCate.length() == 0) mediaCate = null;
	                        System.out.print("Enter Cost: ");
	                        if(scanner.hasNextFloat())
	                        	mediaCost = scanner.nextFloat();
	                        scanner.nextLine();
	                        System.out.print("\n");
	                        if (mediaCost != null)
	                        	if (mediaCost == null || mediaCost < 0) mediaCost = null;
	                        break;
                        }
                	}
                    
                    if (mediaOption == 1) {
                    	if (mediaCost == null || mediaCate == null) {
                    		Book newBook = new Book(mediaTitle);
                    		System.out.println(store.addMedia(newBook));
                    	}
                    	else {
                    		Book newBook = new Book(mediaTitle, mediaCate, mediaCost);
                    		System.out.println(store.addMedia(newBook));
                    	}
                        
                    } else if (mediaOption == 2) {
                        System.out.print("Enter CD artist: ");
                        String cdArtist = scanner.nextLine().strip();
                        System.out.println("\n");
                        if (cdArtist.length() == 0) cdArtist = null;

                        CompactDisc newCD = new CompactDisc(mediaTitle, mediaCate, cdArtist, mediaCost);  
                        System.out.print("Input number of tracks in your CD to be added: ");
                        int nTrack = -1;
                        if(scanner.hasNextInt())
                        	nTrack = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("\n");
                        
                        if (nTrack > 0) {
                            for (int i = 0; i < nTrack; i++) {
                                System.out.println("Your " + (i+1) + " track: ");
                                valid = true;
                            	String trackTitle = null;
                            	int trackLength = 0;
                            	while (valid) {
                                    System.out.print("Enter Track title: ");
                                    trackTitle = scanner.nextLine().strip();
                                    System.out.print("\n");
                                    if (trackTitle.length() == 0) valid = false;
                                    if(scanner.hasNextInt())
                                    	trackLength = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("\n");
                                    if (trackLength < 1) valid = false;
                                    if (!valid) {
                                    	System.out.println("Invalid input... Please try again!");
                                    	valid = true;
                                    } else
            	                        break;
                            	}

                                Track newTrack = new Track(trackTitle, trackLength);
                                newCD.addTrack(newTrack);
                            }
                        } else
                        	System.out.println("No track added.");
                        System.out.println(store.addMedia(newCD));
                        
                    } else if (mediaOption == 3) {
                        DigitalVideoDisc newDVD = new DigitalVideoDisc(mediaTitle, mediaCate, mediaCost);
                        System.out.println(store.addMedia(newDVD));
                        
                    } else if (mediaOption == 0) {
                        break;
                    } else {
                        System.out.println("Invalid option...");
                    }
                    break;
                case 2:
                    boolean found = false;
                    while (!found) {
                        System.out.print("Enter the Media title (type Enter to stop): ");
                        String title = scanner.nextLine().strip();
                        System.out.println("\n");
                        if (title.length() == 0)
                            break;
                        Media media = store.searchStore(title);
                        if (media != null) {
                        	System.out.println(store.removeMedia(media));
                            found = true;
                        } else {
                            System.out.println("Title not found...");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid option, please choose again.");
                    break;
            }
        }
    }
}
