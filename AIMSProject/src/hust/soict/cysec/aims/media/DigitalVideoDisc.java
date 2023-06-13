package hust.soict.cysec.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

	public DigitalVideoDisc(String title) {
        super(title);
    }    
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    
    
	public String toString() {
		String dvdstr = String.format("%d. DVD - %s - %s - %s - %d: %f $", getId(), getTitle(), getCategory(), getDirector(), getLength(), getCost());
		return dvdstr;
	}

	public boolean isMatch(int id) {
		if (this.getId() == id)
			return true;
		return false;		
	}
	
	public boolean isMatch(String title) {
		if (this.getTitle().equals(title))
			return true;
		return false;
	}
	
	@Override
	public void play() {
		System.out.printf("Playing DVD: %s - %d secs left\n",this.getTitle(), this.getLength());
	}

}
