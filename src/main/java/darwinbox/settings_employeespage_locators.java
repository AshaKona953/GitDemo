package darwinbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class settings_employeespage_locators extends Base1 {
	public WebDriver driver;
	WebDriverWait wait;
	
 	@SuppressWarnings("deprecation")
	public settings_employeespage_locators(WebDriver driver) {
 		this.driver=driver;
 		wait = new WebDriverWait(driver,40);
 	}
 	
 	private By employees = By.cssSelector("a[href='/settings/employees']");
 	private By ProfileViewSettings = By.cssSelector("a[href='/settings/employees/profilesetting']");	
 	
 	public void employees() {
 		wait.until(ExpectedConditions.elementToBeClickable(employees));
 		driver.findElement(employees).click();
 	}
 	
 	public void ProfileViewSettings() {
 		wait.until(ExpectedConditions.elementToBeClickable(ProfileViewSettings));
 		driver.findElement(ProfileViewSettings).click();
 	}
}
