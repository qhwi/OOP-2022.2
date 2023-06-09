package hust.soict.cysec.aims.media;

import java.util.Comparator;

import hust.soict.cysec.aims.exception.PlayerException;

public abstract class Media {
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	private static int nbMedia = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	
	
	public Media(String title) {
        this.title = title;
		this.id = ++nbMedia;
    }
    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = ++nbMedia;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbMedia;
    }
    
    public boolean isMatch(int id) {
		if (this.getId() == id)
			return true;
		return false;		
	}
	
	public boolean isMatch(String title) {
		if (this.getTitle().toLowerCase().equals(title.toLowerCase()))
			return true;
		return false;
	}
	
	@Override
    public boolean equals(Object o) {
        if (!(o instanceof Media)) {
            return false;
        }
        return ((Media)o).getTitle() == this.getTitle();
    }
	
	public String toString() {
		return String.format("Playing Media: " + getTitle());
	}

	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String play() throws PlayerException {
		return ("Playing media");
	}

}
