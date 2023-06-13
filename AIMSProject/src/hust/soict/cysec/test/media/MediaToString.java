package hust.soict.cysec.test.media;

import java.util.ArrayList;
import java.util.List;
import hust.soict.cysec.aims.media.*;

public class MediaToString {
	public static void main(String[] args) {
        List<Media> mediatest = new ArrayList<Media>();

        DigitalVideoDisc dvd = new DigitalVideoDisc("Spiderman", "Animation", "Someone", 100, 20f);
        Book book = new Book("Miss Peregrine's Home for Peculiar Children", "Fantasy", 18.5f);
        CompactDisc cd = new CompactDisc("Speak Now (TLVS)", "Pop", "Taylor Swift", 33.325f);
        
        mediatest.add(book);
        mediatest.add(dvd);   
        mediatest.add(cd);

        for (Media media : mediatest) {
            System.out.println(media.toString());
        }
    }

}
