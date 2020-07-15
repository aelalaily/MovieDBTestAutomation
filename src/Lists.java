import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;

import org.junit.jupiter.api.Test;

class Lists {
	
	@FindBy(xpath = "//a[contains(@href,'/lists')]")
	WebElement listsMenu;
	
	@FindBy(xpath = "//a[contains(@href, '/list/new')]")
	WebElement newListButton;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement nameInput;
	
	@FindBy(xpath = "//input[@id='description']")
	WebElement descriptionInput;
	
	@FindBy(xpath = "//select[@id='public']/parent::span")
	WebElement publicSelector;
	
	@FindBy(xpath = "//select[@id='sort_by']/parent::span")
	WebElement sortSelector;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement submitButton;
	
	@FindBy(xpath = "//input[@id='list_item_search']")
	WebElement searchInput;
	
	@FindBy(xpath = "//div[@id='list_item_search-list']")
	WebElement searchList;
	
	@FindBy(xpath = "//li[@data-offset-index='0']")
	WebElement searchResult;
	
	@FindBy(xpath = "//a[contains(@href, 'step_1')]")
	WebElement editListButton;
	
	@FindBy(xpath = "//a[contains(@href, 'step_2')]")
	WebElement editItemsButton;
	
	@FindBy(xpath = "//a[contains(@href, 'delete')]")
	WebElement deleteListButton;
	
	static String[] films = {"The Shawshank Redemption", "The Godfather", "The Godfather: Part II", "The Dark Knight", "12 Angry Men", "Schindler's List", "Pulp Fiction", "The Lord of the Rings: The Return of the King", "Fight Club", "The Lord of the Rings: The Fellowship of the Ring", "Forrest Gump", "Star Wars: The Empire Strikes Back", "Inception", "The Lord of the Rings: The Two Towers", "One Flew Over The Cuckoo's Nest", "GoodFellas", "The Matrix", "Seven Samura", "Star Wars", "City of God", "Se7en", "The Silence of the Lambs", "It's A Wonderful Life", "The Usual Suspects", "Saving Private Ryan", "Spirited Awa", "Coco", "American History X", "Interstellar", "The Green Mile", "Psycho", "Casablanca", "City Lights", "Intouchables", "Modern Times", "The Pianist", "Raiders of the Lost Ark", "The Departed", "Rear Window", "Terminator 2: Judgment Day", "Back to the Future", "Whiplash", "Gladiator", "The Lion King", "The Prestige", "Memento", "Apocalypse Now", "Alien", "The Great Dictator", "Sunset Boulevard"};



	@Test
	void test() {
		
		Assert.assertTrue("Link to the Lists page was not found", listsMenu.isDisplayed());
		listsMenu.click();
		
	}

}
