import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;


public class TestAutomation {
	
	public static WebDriver driver;
	
	static final String homepage = "https://www.themoviedb.org/";
	
	
	public static void main(String[] args) {
		
		String OS = System.getProperty("os.name");
		
		
		if (OS.toLowerCase().contains("windows")) {
			
			System.setProperty("webdriver.chrome.driver", "utilities/driver/chromedriver.exe");
		
		} else if (OS.toLowerCase().contains("mac")) {
			
			System.setProperty("webdriver.chrome.driver", "utilities/driver/chromedriver");
			
		} else {
			
			System.setProperty("webdriver.chrome.driver", "utilities/driver/chromedriver_lunix");
			
		}
		
		
		driver = new ChromeDriver();
		
		driver.get(homepage);
		
		
		Login loginPage = new Login(driver);
		
		loginPage.findCredentials();
		loginPage.login();
		
		Lists myList = new Lists(driver);
		
		myList.openLists();
		myList.createList();
		myList.deleteList();
		
		loginPage.logout();
    	
    	
    	driver.quit();
	    
		
	}

}
