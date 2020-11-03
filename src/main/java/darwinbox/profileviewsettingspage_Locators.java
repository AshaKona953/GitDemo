package darwinbox;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

public class profileviewsettingspage_Locators {
	public WebDriver driver;
	WebDriverWait wait;
	Actions act;
	JavascriptExecutor js;
	
 	@SuppressWarnings("deprecation")
	public profileviewsettingspage_Locators(WebDriver driver) {
 		this.driver=driver;
 		wait = new WebDriverWait(driver,40);
 		act = new Actions(driver);
 		js = (JavascriptExecutor)driver;
 	}
 	
 	private By AddCustomField = By.cssSelector("[id='add_custom_field']");
 	private By ChooseSection = By.cssSelector("[id='section_personal_chosen'] a span");
 	private By ChooseSection_value = By.xpath("//div[@id='section_personal_chosen']/div/div/input");
 	private By FieldName = By.cssSelector("[id='field_name']");
 	private By FieldType = By.cssSelector("[id='field_type_chosen']");
 	private By FieldType_value = By.xpath("//div[@id='field_type_chosen']/div/div/input");
 	private By Validations = By.cssSelector("[id='field_validation_chosen']");
 	private By validations_value = By.xpath("//div[@id='field_validation_chosen']/a/span");
 	
 	private By updateview = By.xpath("(//select[@id='update']/parent::*)/div/button/span");
 	private By updateview_value = By.xpath("(//select[@id='update']/parent::*)/div/ul/li/div/input");
 	private By updateview_checkbox = By.xpath("(//select[@id='update']/parent::*)/div/ul/li/a/label/input");
 	private By updateview_rolename = By.xpath("(//select[@id='update']/parent::*)/div/ul/li/a/label");
 	
 	private By createview = By.xpath("(//select[@id='create']/parent::*)/div/button/span");
 	private By createview_value = By.xpath("(//select[@id='create']/parent::*)/div/ul/li/div/input");
 	private By createview_checkbox = By.xpath("(//select[@id='create']/parent::*)/div/ul/li/a/label/input");
 	private By createview_rolename = By.xpath("(//select[@id='create']/parent::*)/div/ul/li/a/label");
 	
 	private By view = By.xpath("(//select[@id='read']/parent::*)/div/button/span");
 	private By view_value = By.xpath("(//select[@id='read']/parent::*)/div/ul/li/div/input");
 	private By view_checkbox = By.xpath("(//select[@id='read']/parent::*)/div/ul/li/a/label/input");
 	private By view_rolename = By.xpath("(//select[@id='read']/parent::*)/div/ul/li/a/label");
 	
 	private By delete = By.xpath("(//select[@id='delete']/parent::*)/div/button/span");
 	private By delete_value = By.xpath("(//select[@id='delete']/parent::*)/div/ul/li/div/input");
 	private By delete_checkbox = By.xpath("(//select[@id='delete']/parent::*)/div/ul/li/a/label/input");
 	private By delete_rolename = By.xpath("(//select[@id='delete']/parent::*)/div/ul/li/a/label"); 	
 	
 	private By ADDFIELD = By.cssSelector("[id='add_field']");
 	
 	public void AddCustomField() {
 		wait.until(ExpectedConditions.elementToBeClickable(AddCustomField));
 		driver.findElement(AddCustomField).click();
 	}
 	
 	public void ChooseSection(String sectionname) {
 		wait.until(ExpectedConditions.elementToBeClickable(ChooseSection));
 		driver.findElement(ChooseSection).click();
 		driver.findElement(ChooseSection_value).sendKeys(sectionname);
 		driver.findElement(By.xpath("//ul[@class='chosen-results']/li")).click();		
 	}
 	
 	public void FieldName(String fieldname1) {
 		wait.until(ExpectedConditions.elementToBeClickable(FieldName));
 		driver.findElement(FieldName).sendKeys(fieldname1);
 	}
 	
     public void FieldType(String fieldtype, String validation_required, String validation) {
  		driver.findElement(FieldType).click();
  		driver.findElement(FieldType_value).sendKeys(fieldtype);
  		act.sendKeys(Keys.ENTER).perform();
  		
  		if(fieldtype.equalsIgnoreCase("text") && validation_required.equalsIgnoreCase("yes")) {
  			driver.findElement(Validations).click();
  	    	act.moveToElement(driver.findElement(validations_value)).click().perform();
  	    	act.sendKeys(validation).perform();
  	   	     act.sendKeys(Keys.ENTER).perform();
  		}
     }
  
     public void updateview(String roles) {
    	 String role[] = roles.split(",");
    	 driver.findElement(updateview).click();
    	 List<WebElement> a = driver.findElements(updateview_rolename);
    	 List<WebElement> b = driver.findElements(updateview_checkbox);
    	 
    	 for(int j=0;j<role.length;j++) {
    	   driver.findElement(updateview_value).sendKeys(role[j]); 
    	 for(int i=0;i<a.size();i++) {  
    		 if(a.get(i).getText().equalsIgnoreCase(role[j])) {    			
    			 b.get(i).click();
    			 driver.findElement(updateview_value).clear();
    		 }
    	 }
       }
    }
     
     public void createview(String roles) {
    	 String role[] = roles.split(",");
    	 driver.findElement(createview).click();
    	 List<WebElement> a = driver.findElements(createview_rolename);
    	 List<WebElement> b = driver.findElements(createview_checkbox);
    	 
    	 for(int j=0;j<role.length;j++) {
    	   driver.findElement(createview_value).sendKeys(role[j]); 
    	 for(int i=0;i<a.size();i++) {  
    		 if(a.get(i).getText().equalsIgnoreCase(role[j])) {    			
    			 b.get(i).click();
    			 driver.findElement(createview_value).clear();
    		 }
    	 }
       }
    }
     
     public void view(String roles) {
    	 String role[] = roles.split(",");
    	 driver.findElement(view).click();
    	 List<WebElement> a = driver.findElements(view_rolename);
    	 List<WebElement> b = driver.findElements(view_checkbox);
    	 
    	 for(int j=0;j<role.length;j++) {
    	   driver.findElement(view_value).sendKeys(role[j]); 
    	 for(int i=0;i<a.size();i++) {  
    		 if(a.get(i).getText().equalsIgnoreCase(role[j])) {    			
    			 b.get(i).click();
    			 driver.findElement(view_value).clear();
    		 }
    	 }
       }
    }
     
     public void delete(String roles) {
    	 String role[] = roles.split(",");
    	 driver.findElement(delete).click();
    	 List<WebElement> a = driver.findElements(delete_rolename);
    	 List<WebElement> b = driver.findElements(delete_checkbox);
    	 
    	 for(int j=0;j<role.length;j++) {
    	   driver.findElement(delete_value).sendKeys(role[j]); 
    	 for(int i=0;i<a.size();i++) {  
    		 if(a.get(i).getText().equalsIgnoreCase(role[j])) {    			
    			 b.get(i).click();
    			 driver.findElement(delete_value).clear();
    		 }
    	 }
       }
    	 driver.findElement(delete).click();
    }
     
     public void ADDFIELD() {
    	 driver.findElement(ADDFIELD).click();
    	 driver.close();
     }
     
}
