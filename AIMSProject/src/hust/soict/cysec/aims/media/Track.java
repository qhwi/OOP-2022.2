package hust.soict.cysec.aims.media;

public class Track implements Playable {
	private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    
    @Override
	public String toString() {
		String dvdstr = String.format("Track: - %d secs", getTitle(), getLength());
		return dvdstr;
	}
    
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Track)) {
            return false;
        }
        return ((Track)o).getTitle() == this.getTitle() && ((Track)o).getLength() == this.getLength();
    }

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.printf("Playing Track: %s - %d secs left\n",this.getTitle(), this.getLength());
	}

}
