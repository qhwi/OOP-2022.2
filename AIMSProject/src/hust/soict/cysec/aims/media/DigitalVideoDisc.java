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
    
    @Override
	public String toString() {
		String dvdstr = String.format("DVD %d. - %s - %s - %s - %d secs: %f $", getId(), getTitle(), getCategory(), getDirector(), getLength(), getCost());
		return dvdstr;
	}

	
	@Override
	public void play() {
		System.out.printf("Playing DVD: %s - %d secs left\n",this.getTitle(), this.getLength());
	}

}
