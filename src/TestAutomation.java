import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
//import org.junit.Test;


public class TestAutomation {
	
	static final String homepage = "https://www.themoviedb.org/";
	static final String username = "aelalaily";
	static final String password = "2HekXk$ORY6VgUXNY";
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "utilities/driver/chromedriver");
		//System.setProperty("webdriver.chrome.driver", "utilities\driver\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(homepage);
    	
    	driver.findElement(By.xpath("//a[contains(@href, '/login')]")).click();
    	
    	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
    	
    	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    	
    	driver.findElement(By.xpath("//input[@value='Login']")).click();
    	
    	driver.quit();
	    
		
	}

}
