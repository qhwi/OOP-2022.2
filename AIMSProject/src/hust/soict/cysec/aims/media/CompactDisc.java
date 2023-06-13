package hust.soict.cysec.aims.media;
import java.util.*;

public class CompactDisc extends Disc {
	private String artist;
    private List<Track> tracks = new ArrayList<Track>();; 

	public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }
    
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.printf("Added track: %s\n", track.getTitle());
        } else {
            System.out.printf("Track %s already added...\n", track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.printf("Removed track: %s\n", track.getTitle());
        } else {
            System.out.printf("Track %s not found...\n", track.getTitle());
        }
    }
    
    public int getLength() {
        int total = 0;
        for (Track track : tracks) {
        	total += track.getLength();
        }
        return total;
    }
    
	public String getArtist() {
		return artist;
	}
    

}
