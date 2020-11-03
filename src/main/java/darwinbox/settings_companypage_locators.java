package darwinbox;

import org.openqa.selenium.*;
import org.openqa.selenium.*;

public class settings_companypage_locators {
	private WebDriver driver;
	
	public settings_companypage_locators(WebDriver driver) {
		this.driver=driver;
	}

	 private By BusinessUnit_AutoNumbering = By.cssSelector("a[href='/settings/company/businessauto']");
	 private By BusinessUnit = By.cssSelector("a[href='/settings/company/businessunit']");
	 
	 public WebElement BusinessUnit_AutoNumbering() {
		 return driver.findElement(BusinessUnit_AutoNumbering);
	 }
	 
	 public WebElement BusinessUnit() {
		 return driver.findElement(BusinessUnit);
	 }	
}
