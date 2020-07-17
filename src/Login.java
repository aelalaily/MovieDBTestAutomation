import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class Login {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//a[contains(@href, '/login')]")
	WebElement loginLink;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameInput;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordInput;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath = "//span[contains(@class, 'avatar background_color')]")
	WebElement userAvatar;
	
	@FindBy(xpath = "//div[@class='k-tooltip-content']/child::div[@class='settings_content']")
	WebElement userMenu;
	
	@FindBy(xpath = "//div[@role='tooltip']//a[contains(@href, '/logout')]")
	WebElement logoutButton;
	
	private static String username, password;
	
	
	public Login(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	
	public void findCredentials() {
		
		
		try {
			
			File credFile = new File("utilities/credentials");
			
			Reporter.log("Opening credentials file.");
			
			Scanner credScanner = new Scanner(credFile);
			
			username = credScanner.nextLine();
			password = credScanner.nextLine();
			
			username = username.replace("username:", "");
			username = username.replace(" ", "");
			
			Assert.assertNotNull("Username was not correctly retrieved from file.", username);
			Reporter.log("Username successfully parsed.");
			
			password = password.replace("password:", "");
			password = password.replace(" ", "");
			
			Assert.assertNotNull("Password was not correctly retrieved from file.", password);
			Reporter.log("Password successfully parsed.");
			
			credScanner.close();
			
			Reporter.log("Completed credentials acquisition.");
			
		} catch(FileNotFoundException e) {
			
			Reporter.log("Error: Credentials file was not found.");
			Assert.fail("Credentials file was not found.");
			
		}
		
	}
	
	
	public String getUsername() {
		
		return username;
		
	}
	
	public void login() {
		
		Assert.assertTrue(loginLink.isDisplayed(), "Error: Link to the Login Page was not found.");
		loginLink.click();
		
		Reporter.log("Logging into the portal.");
		
		Assert.assertTrue(usernameInput.isDisplayed(), "Error: Username input field was not found.");
		usernameInput.sendKeys(username);
		
		Assert.assertTrue(passwordInput.isDisplayed(), "Error: Password input field was not found.");
		passwordInput.sendKeys(password);
		
		Assert.assertTrue(loginButton.isDisplayed(), "Error: Login button was not found.");
		loginButton.click();
		
		Reporter.log("Logged in as user: "+username);
	}
	
	public void logout() {
		
		Assert.assertTrue(userAvatar.isDisplayed(), "Error: User avatar/button was not found.");
		userAvatar.click();
		
		Reporter.log("Logging out of the portal.");
		
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userMenu));
    	
    	Assert.assertTrue(logoutButton.isDisplayed(), "Error: Logout button was not found.");
    	logoutButton.click();
    	
    	Reporter.log("Logged out as user: "+username);
		
	}

}
