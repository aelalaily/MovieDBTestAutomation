import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.Assert;

import java.util.Random;

class Lists {
	
	WebDriver driver;
	WebDriverWait wait;
	
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
	
	@FindBy(xpath = "//form[@id='list_info']/child::input[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//input[@id='list_item_search']")
	WebElement searchInput;
	
	@FindBy(xpath = "//div[@id='list_item_search-list']")
	WebElement searchList;
	
	@FindBy(xpath = "//li[@data-offset-index='0']")
	WebElement searchResult;
	
	@FindBy(xpath = "//div[contains(@class, 'notification success')]")
	WebElement successPopup;
	
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
	static String[] listDesc = {"Description for ", "The description for ", "Simple description for ", "Descriptive description for "};
	
	static int listCount = 1;
	static Random r = new Random();
	
	
	public Lists(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}


	public void openLists() {
		
		Assert.assertTrue(listsMenu.isDisplayed(), "ERROR: Lists page link was not found.");
		listsMenu.click();
		
		Reporter.log("INFO: Navigating to Lists page.", true);
		
	}

	public void createList() {
		
		Assert.assertTrue(newListButton.isDisplayed(), "ERROR: New List button was not found.");
		newListButton.click();
		
		Reporter.log("INFO: Creating a new list.", true);
		
		int lst = r.nextInt(listDesc.length-1);
		
		Assert.assertTrue(nameInput.isDisplayed(), "ERROR: List Name input was not found.");
		nameInput.sendKeys("myList"+(lst+1));
		
		Reporter.log("INFO: Naming the list: myList"+(lst+1), true);
		
		Assert.assertTrue(descriptionInput.isDisplayed(), "ERROR: List Description input was not found.");
		String description = listDesc[lst]+"My List ";
		descriptionInput.sendKeys(description+(lst+1));
		
		Reporter.log("INFO: Giving the list the description: "+description+(lst+1), true);
		
		Assert.assertTrue(publicSelector.isDisplayed(), "ERROR: Public/Private selector was not found.");
		publicSelector.click();
		
		
		Assert.assertTrue(publicSelector_private.isDisplayed(), "ERROR: Private option was not found.");
		Assert.assertTrue(publicSelector_public.isDisplayed(), "ERROR: Public option was not found.");
		
		int rad = r.nextInt(1);
		
		switch(rad) {
			case 0: publicSelector_private.click(); Reporter.log("INFO: Making the list private.", true); break;
			case 1: publicSelector_public.click(); Reporter.log("INFO: Making the list public.", true); break;
		}
		
		Assert.assertTrue(sortSelector.isDisplayed(), "ERROR: Ascending/Descending sort selector was not found.");
		sortSelector.click();
		
		Assert.assertTrue(sortSelector_originasc.isDisplayed(), "ERROR: Original ascending sort option was not found.");
		Assert.assertTrue(sortSelector_origindesc.isDisplayed(), "ERROR: Original descending sort option was not found.");
		Assert.assertTrue(sortSelector_voteasc.isDisplayed(), "ERROR: Rating ascending sort option was not found.");
		Assert.assertTrue(sortSelector_votedesc.isDisplayed(), "ERROR: Rating descending sort was not found.");
		Assert.assertTrue(sortSelector_relasc.isDisplayed(), "ERROR: Release ascending sort option was not found.");
		Assert.assertTrue(sortSelector_reldesc.isDisplayed(), "ERROR: Release descending sort option was not found.");
		Assert.assertTrue(sortSelector_titleasc.isDisplayed(), "ERROR: Title ascending sort option was not found.");
		Assert.assertTrue(sortSelector_titledesc.isDisplayed(), "ERROR: Title descending sort was not found.");
		
		rad = r.nextInt(7);
		
		switch(rad) {
			case 0: sortSelector_originasc.click(); Reporter.log("INFO: Sorting the list order by: orginal ascending", true); break;
			case 1: sortSelector_origindesc.click(); Reporter.log("INFO: Sorting the list order by: orginal descending", true); break;
			case 2: sortSelector_voteasc.click(); Reporter.log("INFO: Sorting the list order by: rating ascending", true); break;
			case 3: sortSelector_votedesc.click(); Reporter.log("INFO: Sorting the list order by: rating descending", true); break;
			case 4: sortSelector_relasc.click(); Reporter.log("INFO: Sorting the list order by: release ascending", true); break;
			case 5: sortSelector_reldesc.click(); Reporter.log("INFO: Sorting the list order by: release descending", true); break;
			case 6: sortSelector_titleasc.click(); Reporter.log("INFO: Sorting the list order by: title ascending", true); break;
			case 7: sortSelector_titledesc.click(); Reporter.log("INFO: Sorting the list order by: title descending", true); break;
			
		}
		
		Assert.assertTrue(submitButton.isDisplayed(), "ERROR: Continue button was not found.");
		submitButton.click();
		
		Reporter.log("INFO: Saving the list: myList"+(lst+1), true);
		
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(deleteList));
		
		
		listCount++;
		
		
	}
	
	public void updateList() {
		
		Assert.assertTrue(editList.isDisplayed(), "ERROR: Edit List link was not found.");
		editList.click();
		
		Assert.assertTrue(nameInput.isDisplayed(), "ERROR: List Name input was not found.");
		String name = nameInput.getAttribute("value");
		Reporter.log("INFO: Updating list: "+name, true);
		
		name = name.replace("myList", "myNewListName");
		nameInput.clear();
		nameInput.sendKeys(name);
		Reporter.log("INFO: Changing the list title to: "+name, true);
		
		Assert.assertTrue(descriptionInput.isDisplayed(), "ERROR: List Description input was not found.");
		String description = descriptionInput.getAttribute("innerHTML");
		description = description.replace("Description", "New description"); description = description.replace("description", "new description");
		descriptionInput.clear();
		descriptionInput.sendKeys(description);
		Reporter.log("INFO: Changing the list description to: "+description, true);
		
		Assert.assertTrue(publicSelector.isDisplayed(), "ERROR: Public/Private selector was not found.");
		publicSelector.click();
		
		Assert.assertTrue(publicSelector_private.isDisplayed(), "ERROR: Private option was not found.");
		Assert.assertTrue(publicSelector_public.isDisplayed(), "ERROR: Public option was not found.");
		
		int rad = r.nextInt(1);
		
		switch(rad) {
		case 0: publicSelector_private.click(); Reporter.log("INFO: Changing the list to private.", true); break;
		case 1: publicSelector_public.click(); Reporter.log("INFO: Changing the list to public.", true); break;
		}
		
		Assert.assertTrue(sortSelector.isDisplayed(), "ERROR: Ascending/Descending sort selector was not found.");
		sortSelector.click();
		
		Assert.assertTrue(sortSelector_originasc.isDisplayed(), "ERROR: Original ascending sort option was not found.");
		Assert.assertTrue(sortSelector_origindesc.isDisplayed(), "ERROR: Original descending sort option was not found.");
		Assert.assertTrue(sortSelector_voteasc.isDisplayed(), "ERROR: Rating ascending sort option was not found.");
		Assert.assertTrue(sortSelector_votedesc.isDisplayed(), "ERROR: Rating descending sort was not found.");
		Assert.assertTrue(sortSelector_relasc.isDisplayed(), "ERROR: Release ascending sort option was not found.");
		Assert.assertTrue(sortSelector_reldesc.isDisplayed(), "ERROR: Release descending sort option was not found.");
		Assert.assertTrue(sortSelector_titleasc.isDisplayed(), "ERROR: Title ascending sort option was not found.");
		Assert.assertTrue(sortSelector_titledesc.isDisplayed(), "ERROR: Title descending sort was not found.");
		
		rad = r.nextInt(7);
		
		switch(rad) {
		case 0: sortSelector_originasc.click(); Reporter.log("INFO: Changing the list order to: orginal ascending", true); break;
		case 1: sortSelector_origindesc.click(); Reporter.log("INFO: Changing the list order to: orginal descending", true); break;
		case 2: sortSelector_voteasc.click(); Reporter.log("INFO: Changing the list order to: rating ascending", true); break;
		case 3: sortSelector_votedesc.click(); Reporter.log("INFO: Changing the list order to: rating descending", true); break;
		case 4: sortSelector_relasc.click(); Reporter.log("INFO: Changing the list order to: release ascending", true); break;
		case 5: sortSelector_reldesc.click(); Reporter.log("INFO: Changing the list order to: release descending", true); break;
		case 6: sortSelector_titleasc.click(); Reporter.log("INFO: Changing the list order to: title ascending", true); break;
		case 7: sortSelector_titledesc.click(); Reporter.log("INFO: Changing the list order to: title descending", true); break;
			
		}
		
		Assert.assertTrue(submitButton.isDisplayed(), "ERROR: Save button was not found.");
		submitButton.click();
		
		Reporter.log("INFO: Saving changes to list: "+name, true);
		
	}
	
	public void addFilms() {
				
		Assert.assertTrue(searchInput.isDisplayed(), "ERROR: Input search bar was not found.");
		
		wait = new WebDriverWait(driver, 30);
		
		int rad = r.nextInt(11)+3;
		Reporter.log("INFO: Adding "+rad+" new films to the list.", true);
		
		int[] indices = new int[rad];
		int numOfFilms = films.length-1;
		
		for(int i=0; i<indices.length; i++) {
			
			rad = r.nextInt(numOfFilms);
			while(numInArray(indices, rad, i)) {
				rad = r.nextInt(numOfFilms);
			}
			
			
			searchInput.sendKeys(films[rad]);
			
			wait.until(ExpectedConditions.visibilityOf(searchResult));
			
			searchResult.click();
			
			wait.until(ExpectedConditions.visibilityOf(successPopup));
			
			Reporter.log("INFO: Film "+(i+1)+" to add: "+films[rad]+".", true);
			
			searchInput.clear();
			
			indices[i] = rad;
		}
		
		Reporter.log("INFO: Completed adding films to the list.", true);
		
	}
	
	public void removeFilms() {
		
		
	}
	
	public void deleteList() {
		
		Reporter.log("INFO: Deleting the film list.", true);
		
		Assert.assertTrue(deleteList.isDisplayed(), "ERROR: Delete List link was not found.");
		deleteList.click();
		
		Assert.assertTrue(deleteListButton.isDisplayed(), "ERROR: Delete Button was not found.");
		deleteListButton.click();
		
		Assert.assertTrue(deleteConfirmButton.isDisplayed(), "ERROR: Confirm Delete Button was not found.");
		deleteConfirmButton.click();
		
		Reporter.log("INFO: Deleted the film list.", true);
		
		wait.until(ExpectedConditions.invisibilityOf(deleteConfirmButton));
		
	}
	
	public boolean numInArray(int[] arr, int num, int c) {
		
		for(int i=0; i<c; i++) {
			if(arr[i]==num)
				return true;
		}
		
		return false;
		
	}

	

}
