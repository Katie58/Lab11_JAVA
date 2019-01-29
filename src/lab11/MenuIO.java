package lab11;
import java.util.ArrayList;
import java.util.TreeSet;

public class MenuIO {
	
	public static Menu menuMain() {
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		menu.add(new MenuItem(1, "Browse by Category"));
		menu.add(new MenuItem(2, "Search by Title"));		
		return new Menu(menu);
	}
	
	public static void menuMainSelect(int select) {
		switch(select) {
		case 1: MovieApp.browse();
		break;
		case 2: MovieApp.search();
		break;
		}
	}
	
	public static Menu menuCategories() {
		int count = 1;
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		for (String category : MovieIO.categories()) {
			menu.add(new MenuItem(count, category));
			count++;
		}		
		return new Menu(menu);
	}
	
	public static void menuCategoriesSelect(int select) {
		int count = 1;
		for (String category : MovieIO.categories()) {
			if (count == select) {
				printMulti('=', category.length() + 17);
				System.out.println("\n| " + category.substring(0, 1).toUpperCase() + category.substring(1) + " Movie Titles |");
				printMulti('=', category.length() + 17);
				System.out.println();
				for (int i = 1; i <= MovieIO.categories().size(); i++) {
					if (i == select) {
						int movieCount = 0;
						for (String movieTitle : MovieIO.moviesInCategory(category)) {
							movieCount++;
							System.out.println(movieCount + ". " + movieTitle);
						}
						boolean retry = true;
						while(retry) {
							System.out.println("Select a movie title: (1-" + movieCount + ") ");
							int index = MovieApp.userInputInt(movieCount);
							int menuCount = 0;
							String title = "";
							for (String MovieTitle : MovieIO.moviesInCategory(category)) {
								menuCount++;
								if (index == menuCount) {
									title = MovieTitle;
								}
							}
							System.out.println("You selected " + title);
							MovieApp.addToCart(MovieApp.userInputString(title));
							retry = MovieApp.retry("select another movie");
						}
					}
				}				
			}
			count++;
		}
	}
	
	public static Menu menuByTitle(String category) {
		int count = 1;
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		TreeSet<String> moviesInCategory = new TreeSet<String>();
		for (int i = 1; i <= 100; i++) {
			if (category.equalsIgnoreCase(MovieIO.getMovie(i).getCategory())) {
				moviesInCategory.add(MovieIO.getMovie(i).getTitle());
			}
		}
		for (String title : moviesInCategory) {
			menu.add(new MenuItem(count, title));
			count++;
		}
		return new Menu(menu);
	}
	
	public static Menu menuError() {
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		menu.add(new MenuItem(1, "Error, Select 1 to Try Again"));
		
		return new Menu(menu);
	}
	
	public static void printMulti(char character, int multiple) {
		for (int i = 0; i < multiple; i++) {
			System.out.print(character);
		}
	}
}
