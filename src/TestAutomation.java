import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Assert;


public class TestAutomation {
	
	static final String homepage = "https://www.themoviedb.org/";
	static final String username = "aelalaily";
	static final String password = "2HekXk$ORY6VgUXNY";
	
	public static void main(String[] args) {
		
		String OS = System.getProperty("os.name");
		
		
		if (OS.toLowerCase().contains("windows")) {
			
			System.setProperty("webdriver.chrome.driver", "utilities/driver/chromedriver.exe");
		
		} else if (OS.toLowerCase().contains("mac")) {
			
			System.setProperty("webdriver.chrome.driver", "utilities/driver/chromedriver");
			
		} else {
			
			System.setProperty("webdriver.chrome.driver", "utilities/driver/chromedriver_lunix");
			
		}
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(homepage);
		
		WebElement loginLink = driver.findElement(By.xpath("//a[contains(@href, '/login')]"));
		Assert.assertTrue("Link to the Login Page was not found", loginLink.isDisplayed());
		loginLink.click();
		
		WebElement usernameInput = driver.findElement(By.xpath("//input[@id='username']"));
		Assert.assertTrue("Username input field was not found", usernameInput.isDisplayed());
		usernameInput.sendKeys(username);
		
		WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
		Assert.assertTrue("Password input field was not found", passwordInput.isDisplayed());
		passwordInput.sendKeys(password);
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		Assert.assertTrue("Login button was not found", loginButton.isDisplayed());
		loginButton.click();
    	
    	
		WebElement userAvatar = driver.findElement(By.xpath("//span[contains(@class, 'avatar background_color')]"));
		Assert.assertTrue("User avatar/button was not found", userAvatar.isDisplayed());
		userAvatar.click();
    	
    	WebElement logoutButton = driver.findElement(By.xpath("//a[contains(@href, '/logout')]"));
    	Assert.assertTrue("Logout button was not found", logoutButton.isDisplayed());
    	logoutButton.click();
    	
    	driver.quit();
	    
		
	}

}
