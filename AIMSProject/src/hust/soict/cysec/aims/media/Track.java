package hust.soict.cysec.aims.media;

public class Track implements Playable {
	private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.printf("Playing Track: %s - %d secs left\n",this.getTitle(), this.getLength());
	}

}
