package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helpers.Hook;
import Helpers.common;

public class loginPage extends common {
	WebDriver driver;

	public loginPage() {
//		this.driver= Hook.getDriver();
//		PageFactory.initElements(driver, this);
//		super(driver);
		this.driver = Hook.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	public WebElement userName;
	
	@FindBy(name="password")
	public WebElement passWord;

	@FindBy(xpath="//button[contains(@class,'login-button')]")
	public WebElement loginButton;
	
	@FindBy(xpath="//*[text()='Time']")
	public WebElement timeObj;
	
	
	public void launchURL(String url) {
//		driver.navigate().to(url);
		driver.get(url);
	}
	
	public void enterUserDetails(String user, String pass) {
		waitForUntilVisible(driver, 120,By.name("username"));
		userName.sendKeys(user);
		passWord.sendKeys(pass);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void verifyHomePage() {
		waitForUntilVisible(driver, 300, By.xpath("//*[text()='Time']"));
		System.out.println("Home screen appeared : " + checkElementExist(driver, timeObj));
	}
}
