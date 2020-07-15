import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;

import org.junit.jupiter.api.Test;

class Login {
	
	@FindBy(xpath = "//a[contains(@href, '/login')]")
	WebElement loginLink;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameInput;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordInput;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;
	
	static final String username = "aelalaily";
	static final String password = "2HekXk$ORY6VgUXNY";

	@Test
	void test(WebDriver driver) {
		
		Assert.assertTrue("Link to the Login Page was not found", loginLink.isDisplayed());
		loginLink.click();
		
		
		Assert.assertTrue("Username input field was not found", usernameInput.isDisplayed());
		usernameInput.sendKeys(username);
		
		
		Assert.assertTrue("Password input field was not found", passwordInput.isDisplayed());
		passwordInput.sendKeys(password);
		
		Assert.assertTrue("Login button was not found", loginButton.isDisplayed());
		loginButton.click();
	}

}
