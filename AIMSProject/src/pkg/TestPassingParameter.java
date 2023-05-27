package pkg;

public class TestPassingParameter {
	static class DVDWrapper {
	    public DigitalVideoDisc disc;
	    
	    DVDWrapper(DigitalVideoDisc disc){
	    	this.disc = disc;
	    }
	}
	
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        
        DVDWrapper wjungleDVD = new DVDWrapper(jungleDVD);
        DVDWrapper wcinderellaDVD = new DVDWrapper(cinderellaDVD);

        swap(wjungleDVD, wcinderellaDVD);
        System.out.println("jungle dvd title: " + wjungleDVD.disc.getTitle());
        System.out.println("cinderella dvd title: " + wcinderellaDVD.disc.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }
	
    // Correct swap()
    public static void swap(DVDWrapper o1, DVDWrapper o2) {
    	DigitalVideoDisc tmp = o1.disc;
        o1.disc = o2.disc;
        o2.disc = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
