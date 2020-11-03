package darwinbox;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginpage_Locators extends Base1{
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	@SuppressWarnings("deprecation")
	public loginpage_Locators(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
	}
	
	
	//login page
	private By username = By.id("UserLogin_username");
	private By password = By.id("UserLogin_password");
	private By signin = By.id("login-submit");
	
	public WebElement username() {
		return driver.findElement(username);
	}
	public WebElement password() {
		return driver.findElement(password);
	}
	public WebElement signin() {
		return driver.findElement(signin);
	}
	
	
	//switch to admin
	private By topside_menu = By.xpath("//ul[@class='list-inline mt-6']/li[3]/div/div/*");	
	private By switch_to_admin = By.linkText("Switch to Admin");
	
	public WebElement topside_menu(){
		wait.until(ExpectedConditions.elementToBeClickable(topside_menu));
		return driver.findElement(topside_menu);
	}
	public WebElement switch_to_admin(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(switch_to_admin));
		return driver.findElement(switch_to_admin);
	}
	
}
