package darwinbox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashboardpage_locators extends Base1{
	public WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions act;
	
 	@SuppressWarnings("deprecation")
	public dashboardpage_locators(WebDriver driver) {
 		this.driver=driver;
 		wait = new WebDriverWait(driver,40);
 		js = (JavascriptExecutor) driver;
 		act = new Actions(driver);
 	}
	
private By employees = By.cssSelector("div[class='row_15 mobile-inlineBlock'] img[src='/images/Icons_latest/employees.png']");
private By settings = By.cssSelector("div[class='module-icon-wrapper'] img[src='/images/Icons_latest/settingsimg.png']");
	
public void employees() throws InterruptedException {
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(employees));
	js.executeScript("arguments[0].click();", driver.findElement(employees));
   // act.moveToElement(driver.findElement(employees)).click().perform();
	  }
     
public WebElement settings(){
	     wait.until(ExpectedConditions.elementToBeClickable(settings));
    	 return driver.findElement(settings);
     }

}
