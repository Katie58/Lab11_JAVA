package lab11;

public class MenuItem {
	
	private int menuNumber;
	private String menuTitle;
	
	public void setMenuNumber(int menuNumber) {
		this.menuNumber = menuNumber;
	}
	
	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	
	public int getMenuNumber() {
		return menuNumber;
	}
	
	public String getMenuTitle() {
		return menuTitle;
	}
	
	public MenuItem() {
	}
	
	public MenuItem(int menuNumber, String menuTitle) {
		this.menuNumber = menuNumber;
		this.menuTitle = menuTitle;
	}
	
}
