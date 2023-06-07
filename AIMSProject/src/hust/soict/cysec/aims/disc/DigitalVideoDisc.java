package hust.soict.cysec.aims.disc;
public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs = 0;
	private int id;
    private String title;
    private String category;
	private String director;
    private int length;
    private float cost;
 
	public int getId() {
		return id;
	}
    public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}

	
    public DigitalVideoDisc(String title) {
    	super();
        this.title = title;
        nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
    	super();
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
    	super();
    	this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    	super();
    	this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
    }
    
	public void setTitle(String title) {
		this.title = title;
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
