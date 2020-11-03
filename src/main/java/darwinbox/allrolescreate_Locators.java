package darwinbox;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;
import java.util.*;
import java.io.*;

public class allrolescreate_Locators extends Base1{
 public WebDriver driver;
 WebDriverWait wait;
 Actions act;
		
	@SuppressWarnings("deprecation")
	public allrolescreate_Locators(WebDriver driver) {
			this.driver=driver;
			wait = new WebDriverWait(driver,40);
			act = new Actions(driver);
	}
	
	private By universal_search = By.cssSelector("[id='employee-search_dashboard']");
	private By employee_select = By.xpath("//*[@id='ui-id-1'] /li[2]");
	private By leftside_profile = By.cssSelector("[class='dbProfile']");
	private By personalDetails = By.linkText("Personal Details");
	private By employmentDetails = By.linkText("Employment Details");
	private By managercard_edit = By.xpath("//h4[contains(text(),'Manager')]/parent::div/parent::div/div[4]/div/div/div/div/a/df");
	
	
	public void universal_search(String employee) {	
		wait.until(ExpectedConditions.elementToBeClickable(universal_search));
		driver.findElement(universal_search).sendKeys(employee);
		wait.until(ExpectedConditions.visibilityOfElementLocated(employee_select));
		act.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();
	}
	
	public void leftside_profile() {	
		wait.until(ExpectedConditions.elementToBeClickable(universal_search));
		driver.findElement(leftside_profile).click();	
	}
	
	public void employmentDetails() {	
		wait.until(ExpectedConditions.elementToBeClickable(employmentDetails));
		driver.findElement(employmentDetails).click();		
	}
		
}
