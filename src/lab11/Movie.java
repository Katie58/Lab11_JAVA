package lab11;

public class Movie {

	private String title;
	private String category;
	
	public String getTitle() {
		return title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Movie() {
	}
	
	public Movie(String title, String category) {
		this.title = title;
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "The movie " + title + " is in the " + category + " category.";
	}
	
}
