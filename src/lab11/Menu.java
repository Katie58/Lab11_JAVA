package lab11;
import java.util.ArrayList;

public class Menu {

	private ArrayList<MenuItem> menu;
	
	public void setMenu(ArrayList<MenuItem> menu) {
		this.menu = menu;
	}
	
	public ArrayList<MenuItem> getMenu() {
		return menu;
	}

	public Menu() {
	}
	
	public Menu(ArrayList<MenuItem> menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		String printMenu = "";
		for (MenuItem item : menu) {
			printMenu += item.getMenuNumber() + ". " + item.getMenuTitle() + "\n";
		}
		return printMenu;
	}
}
