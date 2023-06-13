package hust.soict.cysec.aims.media;
import java.util.*;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	
	public Book(String title) {
        super(title);
    }
    public Book(String title, String category) {
        super(title, category);
    }
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost);
		this.authors = authors;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		for (String aut : authors) {
			if (authorName.equalsIgnoreCase(aut)) {
				System.out.printf("Author %s already added...\n", aut);
				return;
			}
		}
		authors.add(authorName);
		System.out.printf("Added author: %s\n", authorName);
		return;
	}

	public void removeAuthor(String authorName) {
		for (String aut : authors) {
			if (authorName.equalsIgnoreCase(aut)) {
				authors.remove(aut);
				System.out.printf("Removed author: %s\n", aut);
				return;	
			}
		}
		System.out.printf("Author %s not found...\n", authorName);
		return;
	}
	
    @Override
	public String toString() {
		String bookstr = String.format("Book %d. %s - %s : %.2f $", getId(), getTitle(), getCategory(), getCost());
		return bookstr;
	}
}
