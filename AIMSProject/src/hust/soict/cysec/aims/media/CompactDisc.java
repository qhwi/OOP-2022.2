package hust.soict.cysec.aims.media;
import java.util.ArrayList;
import java.util.List;

import hust.soict.cysec.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private String artist;
    private List<Track> tracks = new ArrayList<Track>();; 

	public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }
    
    public String addTrack(Track track) {
    	String m = null;
        if (!tracks.contains(track)) {
            tracks.add(track);
            m = String.format("Added track: %s\n", track.getTitle());
        } else {
            m = String.format("Track %s already added...\n", track.getTitle());
        }
		return m;
    }

    public String removeTrack(Track track) {
    	String m = null;
        if (tracks.remove(track)) {
        	m = String.format("Removed track: %s\n", track.getTitle());
        } else {
        	m = String.format("Track %s not found...\n", track.getTitle());
        }
		return m;
    }
    
    @Override
    public String toString() {
		return String.format("CD %d. %s - %s - %s - %d secs: %.2f $", getId(), getTitle(), getCategory(), getArtist(), getLength(), getCost());
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
	@Override
	public String play() throws PlayerException {
		String m = "";
		m += ("Playing CD: " + this.getTitle());
		m += ("\nTotal tracks: " + this.tracks.size());
        m+= ("\nTotal length: " + this.getLength() + "secs");
        for (Track track : tracks) {
            m += "\n" + track.play();
        }
        return m;
	}
    

}
