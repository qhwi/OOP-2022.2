package hust.soict.cysec.aims;
import java.util.*;

public class Book {

	private int id;
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		// TODO Auto-generated constructor stub
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
				System.out.printf("Author %s already exists...\n", aut);
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
}
