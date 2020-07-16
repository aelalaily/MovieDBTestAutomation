import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.util.Random;

class Lists {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(@href,'/lists')]")
	WebElement listsMenu;
	
	@FindBy(xpath = "//a[contains(@href, '/list/new')]")
	WebElement newListButton;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement nameInput;
	
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement descriptionInput;
	
	@FindBy(xpath = "//select[@id='public']/parent::span")
	WebElement publicSelector;
	
	@FindBy(xpath = "//ul[@id='public_listbox']/child::li[@data-offset-index='0']")
	WebElement publicSelector_private;
	
	@FindBy(xpath = "//ul[@id='public_listbox']/child::li[@data-offset-index='1']")
	WebElement publicSelector_public;
	
	@FindBy(xpath = "//select[@id='sort_by']/parent::span")
	WebElement sortSelector;
	
	@FindBy(xpath = "//ul[@id='sort_by_listbox']/child::li[@data-offset-index='0']")
	WebElement sortSelector_originasc;
	
	@FindBy(xpath = "//ul[@id='sort_by_listbox']/child::li[@data-offset-index='1']")
	WebElement sortSelector_origindesc;
	
	@FindBy(xpath = "//ul[@id='sort_by_listbox']/child::li[@data-offset-index='2']")
	WebElement sortSelector_voteasc;
	
	@FindBy(xpath = "//ul[@id='sort_by_listbox']/child::li[@data-offset-index='3']")
	WebElement sortSelector_votedesc;
	
	@FindBy(xpath = "//ul[@id='sort_by_listbox']/child::li[@data-offset-index='4']")
	WebElement sortSelector_relasc;
	
	@FindBy(xpath = "//ul[@id='sort_by_listbox']/child::li[@data-offset-index='5']")
	WebElement sortSelector_reldesc;
	
	@FindBy(xpath = "//ul[@id='sort_by_listbox']/child::li[@data-offset-index='6']")
	WebElement sortSelector_titleasc;
	
	@FindBy(xpath = "//ul[@id='sort_by_listbox']/child::li[@data-offset-index='7']")
	WebElement sortSelector_titledesc;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement submitButton;
	
	@FindBy(xpath = "//input[@id='list_item_search']")
	WebElement searchInput;
	
	@FindBy(xpath = "//div[@id='list_item_search-list']")
	WebElement searchList;
	
	@FindBy(xpath = "//li[@data-offset-index='0']")
	WebElement searchResult;
	
	@FindBy(xpath = "//li/child::a[contains(@href, 'step_1')]")
	WebElement editList;
	
	@FindBy(xpath = "//li/child::a[contains(@href, 'step_2')]")
	WebElement editItems;
	
	@FindBy(xpath = "//li/child::a[contains(@href, 'delete')]")
	WebElement deleteList;
	
	@FindBy(xpath = "//button[@id='delete_list']")
	WebElement deleteListButton;
	
	@FindBy(xpath = "//div[@role='toolbar']/child::button[contains(text(), 'Yes')]")
	WebElement deleteConfirmButton;
	
	static String[] films = {"The Shawshank Redemption", "The Godfather", "The Godfather: Part II", "The Dark Knight", "12 Angry Men", "Schindler's List", "Pulp Fiction", "The Lord of the Rings: The Return of the King", "Fight Club", "The Lord of the Rings: The Fellowship of the Ring", "Forrest Gump", "Star Wars: The Empire Strikes Back", "Inception", "The Lord of the Rings: The Two Towers", "One Flew Over The Cuckoo's Nest", "GoodFellas", "The Matrix", "Seven Samura", "Star Wars", "City of God", "Se7en", "The Silence of the Lambs", "It's A Wonderful Life", "The Usual Suspects", "Saving Private Ryan", "Spirited Awa", "Coco", "American History X", "Interstellar", "The Green Mile", "Psycho", "Casablanca", "City Lights", "Intouchables", "Modern Times", "The Pianist", "Raiders of the Lost Ark", "The Departed", "Rear Window", "Terminator 2: Judgment Day", "Back to the Future", "Whiplash", "Gladiator", "The Lion King", "The Prestige", "Memento", "Apocalypse Now", "Alien", "The Great Dictator", "Sunset Boulevard"};
	
	static int listCount = 1;
	static Random r = new Random();
	
	
	public Lists(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}


	public void openLists() {
		
		Assert.assertTrue("Link to the Lists page was not found.", listsMenu.isDisplayed());
		listsMenu.click();
		
	}

	public void createList() {
		
		Assert.assertTrue("New List button was not found.", newListButton.isDisplayed());
		newListButton.click();
		
		Assert.assertTrue("List Name input was not found.", nameInput.isDisplayed());
		nameInput.sendKeys("myList"+listCount);
		
		Assert.assertTrue("List Description input was not found.", descriptionInput.isDisplayed());
		descriptionInput.sendKeys("Description for My List "+listCount);
		
		Assert.assertTrue("Public/Private selector was not found.", publicSelector.isDisplayed());
		publicSelector.click();
		
		Assert.assertTrue("Private option was not found.", publicSelector_private.isDisplayed());
		Assert.assertTrue("Public option was not found.", publicSelector_public.isDisplayed());
		
		int rad = r.nextInt(1);
		
		switch(rad) {
			case 0: publicSelector_private.click(); break;
			case 1: publicSelector_public.click(); break;
		}
		
		Assert.assertTrue("Ascending/Descending sort selector was not found.", sortSelector.isDisplayed());
		sortSelector.click();
		
		Assert.assertTrue("Original ascending sort option was not found.", sortSelector_originasc.isDisplayed());
		Assert.assertTrue("Original descending sort option was not found.", sortSelector_origindesc.isDisplayed());
		Assert.assertTrue("Rating ascending sort option was not found.", sortSelector_voteasc.isDisplayed());
		Assert.assertTrue("Rating descending sort was not found.", sortSelector_votedesc.isDisplayed());
		Assert.assertTrue("Release ascending sort option was not found.", sortSelector_relasc.isDisplayed());
		Assert.assertTrue("Release descending sort option was not found.", sortSelector_reldesc.isDisplayed());
		Assert.assertTrue("Title ascending sort option was not found.", sortSelector_titleasc.isDisplayed());
		Assert.assertTrue("Title descending sort was not found.", sortSelector_titledesc.isDisplayed());
		
		rad = r.nextInt(7);
		
		switch(rad) {
			case 0: sortSelector_originasc.click(); break;
			case 1: sortSelector_origindesc.click(); break;
			case 2: sortSelector_voteasc.click(); break;
			case 3: sortSelector_votedesc.click(); break;
			case 4: sortSelector_relasc.click(); break;
			case 5: sortSelector_reldesc.click(); break;
			case 6: sortSelector_titleasc.click(); break;
			case 7: sortSelector_titledesc.click(); break;
			
		}
		
		Assert.assertTrue("Continue button was not found.", submitButton.isDisplayed());
		submitButton.click();
		
		
		listCount++;
		
		
	}
	
	public void updateList() {
		
	}
	
	public void addFilms() {
		
		
	}
	
	public void removeFilms() {
		
		
	}
	
	public void deleteList() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/child::a[contains(@href, 'delete')]")));
		
		
		Assert.assertTrue("Link to the Delete List was not found.", deleteList.isDisplayed());
		deleteList.click();
		
		Assert.assertTrue("Delete Button was not found.", deleteListButton.isDisplayed());
		deleteListButton.click();
		
		Assert.assertTrue("Confirm Delete Button was not found.", deleteConfirmButton.isDisplayed());
		deleteConfirmButton.click();
		
	}

	

}
