import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class Login {
	
	WebDriver driver;
	
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
			
			Scanner credScanner = new Scanner(credFile);
			
			username = credScanner.nextLine();
			password = credScanner.nextLine();
			
			username = username.replace("username:", "");
			username = username.replace(" ", "");
			
			Assert.assertNotNull("Username was not correctly retrieved from file.", username);
			
			password = password.replace("password:", "");
			password = password.replace(" ", "");
			
			
			Assert.assertNotNull("Password was not correctly retrieved from file.", password);
			
			credScanner.close();
			
		} catch(FileNotFoundException e) {
			
			Assert.fail("Credentials file was not found.");
			
		}
		
	}
	
	
	public String getUsername() {
		
		return username;
		
	}
	
	public void login() {
		
		Assert.assertTrue("Link to the Login Page was not found.", loginLink.isDisplayed());
		loginLink.click();
		
		
		Assert.assertTrue("Username input field was not found.", usernameInput.isDisplayed());
		usernameInput.sendKeys(username);
		
		
		Assert.assertTrue("Password input field was not found.", passwordInput.isDisplayed());
		passwordInput.sendKeys(password);
		
		Assert.assertTrue("Login button was not found.", loginButton.isDisplayed());
		loginButton.click();
	}
	
	public void logout() {
		
		Assert.assertTrue("User avatar/button was not found.", userAvatar.isDisplayed());
		userAvatar.click();
    	
    	Assert.assertTrue("Logout button was not found.", logoutButton.isDisplayed());
    	logoutButton.click();
		
	}

}
