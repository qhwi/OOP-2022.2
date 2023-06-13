package hust.soict.cysec.aims.media;

public abstract class Media {

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
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

}
