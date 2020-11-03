package darwinbox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashboard_employeespage_locators {
	public WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	@SuppressWarnings("deprecation")
	public dashboard_employeespage_locators(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,40);
		js= (JavascriptExecutor)driver;
	}
	
	private By directory = By.linkText("DIRECTORY");
	private By directory_search = By.id("employee-search_new");
	private By newhire = By.xpath("//a[contains(text(),'+ NEW HIRE')]");
	
	public WebElement directory() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(directory));
		js.executeScript("arguments[0].click();",driver.findElement(directory));
		return driver.findElement(directory);
	}
	public WebElement directory_search() {
		return driver.findElement(directory_search);
	}
	public WebElement newhire() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(newhire));
		return driver.findElement(newhire);
	}

}
