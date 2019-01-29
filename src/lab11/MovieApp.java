package lab11;
import java.util.Scanner;
import java.util.ArrayList;

public class MovieApp {
	static Scanner scnr = new Scanner(System.in);
	static ArrayList<Movie> cart = new ArrayList<Movie>();

	public static void main(String[] args) {
		boolean retry = true;
		
		while(retry) {
			greeting();
			menu();
			cart();
			retry = retry("empty cart and shop again");
		}
		exit();
		scnr.close();
	}
	
	public static void greeting() {//display application title
		System.out.println("Welcome to the Cinema Shop!");
	}
	
	public static void menu() {
		boolean retry = true;
		while(retry) {
			System.out.println("\nMain Menu:");
			System.out.println(MenuIO.menuMain());//prints menu
			System.out.print("What would you like to do? (1-" + MenuIO.menuMain().getMenu().size() + "): ");
			MenuIO.menuMainSelect(userInputInt(MenuIO.menuMain().getMenu().size()));	
			retry = retry("return to the main menu");
		}
	}
	
	public static void browse() {
		boolean retry = true;
		while(retry) {
			System.out.println("\nMovie Categories:");
			System.out.println(MenuIO.menuCategories());
			System.out.print("Select a category (1-" + MovieIO.categories().size() + "): ");
			MenuIO.menuCategoriesSelect(userInputInt(MovieIO.categories().size()));
			retry = retry("browse a different category");
		}
	}
	
	public static void search() {
		boolean retry = true;
		while(retry) {
			System.out.println("\nMovie Title Search:");
			Movie result = userInputString(scnr.nextLine());
			System.out.println(result);
			addToCart(result);
			retry = retry("search another movie title");
		}
	}
	
	public static int userInputInt(int menuSize) {
		boolean valid = false;
		int input = 0;
		while (!valid) {
			if (scnr.hasNextInt()) {
				input = scnr.nextInt();
				if (input > 0 && input <= menuSize) {
					scnr.nextLine();
					return input;
				} else {
					scnr.nextLine();
					System.out.print("There are " + menuSize + " menu items, try again... ");
				}
			} else {
				scnr.nextLine();
				System.out.print("Please enter a number from 1-" + menuSize + "... ");
			}			
		}
		return -1;
	}
	
	public static Movie userInputString(String input) {
		input = input.trim();
		if (!input.isEmpty()) {
			for (int i = 1; i <= 100; i++) {
				if (input.equalsIgnoreCase(MovieIO.getMovie(i).getTitle())) {
					return MovieIO.getMovie(i);
				}
			}
		}	
		return new Movie("TITLE NOT FOUND", "N/A");
	}
 	
	public static void addToCart(Movie movie) {
		if (!movie.getTitle().equalsIgnoreCase("TITLE NOT FOUND")) {
			System.out.print("\nWould you like to add this movie to your cart? ");
			if (validateYesNo(scnr.nextLine().charAt(0))) {
				cart.add(movie);
			}			
		}

	}
	
	public static void cart() {
		System.out.println("\nYour cart:");
		if (cart.isEmpty()) {
			System.out.println("IS EMPTY!");
		} else {
			for (Movie item : cart) {
				System.out.println(item.getTitle());
			}			
		}
	}
	
 	public static boolean retry(String question) {
		System.out.print("\nWould you like to " + question + "? (y/n) ");
		return validateYesNo(scnr.nextLine().charAt(0));
	}
	
	public static boolean validateYesNo(char input) {//validate yes/no user input
		while (input != 'y' && input != 'Y' && input != 'n' && input != 'N') {
			System.out.print("This is a simple yes or no question, try again...");
			input = scnr.nextLine().charAt(0);
		}
		return (input == 'y' || input == 'Y');
	}
	
	private static void exit() {//let user know the program is exiting
		System.out.println("Don't be a stranger, visit again soon!");
	}
	
}
