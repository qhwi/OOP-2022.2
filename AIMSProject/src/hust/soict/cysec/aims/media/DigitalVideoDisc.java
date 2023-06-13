package hust.soict.cysec.aims.media;

public class DigitalVideoDisc extends Media {
	private String director;
    private int length;
	
	public DigitalVideoDisc(String title) {
        super(title);
    }    
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
    
    public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
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

}
