package darwinbox;

import java.io.*;
import java.util.*;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

public class newhirepage_locators extends Base1 {
	private WebDriver driver;
	private Select select_groupcompany;
	private Select select_employeeType;
	private JavascriptExecutor js;
	private Select select_gender;
	public Properties prop;
	WebDriverWait wait;
	Actions act;
	
	@SuppressWarnings("deprecation")
	public newhirepage_locators(WebDriver driver) throws IOException {
		this.driver=driver;
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\darwinbox\\addemploye_newhire.properties");
	    prop = new Properties();
		prop.load(fis);
	
	    act = new Actions(driver);
	    js = (JavascriptExecutor) driver;
	    wait = new WebDriverWait(driver,40);
	}
	
	private By firstname = By.id("UserAddForm_firstname");
	private By lastname = By.id("UserAddForm_lastname");
	private By email = By.id("UserAddForm_email");
	
	private By dob = By.id("from_date");
	
	//using select class here
	private By groupcompany = By.id("dept_grp_company");
	
	private By designation = By.cssSelector("div[id='parent_dept_load_chosen'] a span");
	private By designation_value = By.cssSelector("ul[class='chosen-results'] li[class='active-result group-option']");
	private By designation_search = By.xpath("//div[@id='parent_dept_load_chosen']/div/div/input");
	
	private By location = By.cssSelector("div[id='officelocation_chosen'] a span");
	private By location_value = By.cssSelector("ul[class='chosen-results'] li[class='active-result']");
	private By location_search = By.xpath("//div[@id='officelocation_chosen']/div/div/input");
	
	//using select class here
	private By employeeType = By.id("emp_type");
	
	private By doj = By.id("from_date_doj");
	
	//using select class here
	private By gender = By.id("UserAddForm_gender");
	
	private By ADDEMPLOYEE =By.name("yt1");
	
	private By ASSIGNORSKIP = By.name("yt0");
	
	
	public WebElement firstname() {
		return driver.findElement(firstname);
	}
	public WebElement lastname() {
		return driver.findElement(lastname);
	}
	public WebElement email() {
		return driver.findElement(email);
	}
	
	public WebElement date_of_birth() {
		WebElement datepicker =driver.findElement(dob);
   	 js.executeScript("document.getElementById('from_date').removeAttribute('readonly')");
   	 datepicker.clear();
   	return  driver.findElement(dob);
	}
	
	public void groupcompany(String gp) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(groupcompany));
		select_groupcompany = new Select(driver.findElement(groupcompany));
		if(gp.equalsIgnoreCase("random")) {		
		}
		else {
		select_groupcompany.selectByVisibleText(gp);
		}
	}
	
	public void designation(String desg) {
		wait.until(ExpectedConditions.elementToBeClickable(designation));
		driver.findElement(designation).click();
		
		if(desg.equalsIgnoreCase("random")){
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(designation_value));
			List<WebElement> a = driver.findElements(designation_value);
			Random rand = new Random();
			a.get(rand.nextInt(a.size())).click();
	      }
		else {
			 driver.findElement(designation_search).sendKeys(desg);
			 act.sendKeys(Keys.ENTER).perform();
		}
		
	}
	
	public void location(String loc) throws InterruptedException{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(location));
		js.executeScript("arguments[0].click();", driver.findElement(location));
		driver.findElement(location).click();
		
		if(loc.equalsIgnoreCase("random")){
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(location_value));
			List<WebElement> a = driver.findElements(location_value);
			Random rand = new Random();
			a.get(rand.nextInt(a.size())).click();
	      }
		
		else{ 
			   act.moveToElement(driver.findElement(location_search)).sendKeys(loc).perform();
		       act.sendKeys(Keys.ENTER).perform();
		}
		
	}
	
	public void employeeType(String employeetype1) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeType));
		select_employeeType=new Select(driver.findElement(employeeType));
		if(employeetype1.equalsIgnoreCase("random")) {
		 select_employeeType.selectByIndex(1);
		}
		else {
			select_employeeType.selectByVisibleText(employeetype1);
		}
	}
	
    public WebElement date_of_joining() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(doj));
    	WebElement datepicker =driver.findElement(doj);
    	 js.executeScript("document.getElementById('from_date_doj').removeAttribute('readonly')");
    	 datepicker.clear();
    	return  driver.findElement(doj);
    }
    
    public void gender(String gender1) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(gender));
    	select_gender = new Select(driver.findElement(gender));
    	if(gender1.equalsIgnoreCase("random")) {
    		select_gender.selectByIndex(1);
    	}
    	else {
		select_gender.selectByVisibleText(gender1);
    	}
	}
    
    public void ADDEMPLOYEE() {
    	wait.until(ExpectedConditions.presenceOfElementLocated(ADDEMPLOYEE));
    	driver.findElement(ADDEMPLOYEE).click();
    }
    public void ASSIGNORSKIP() {
    	 driver.findElement(ASSIGNORSKIP).click();
    	 driver.close();
    }
}	
