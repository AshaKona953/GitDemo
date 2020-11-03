package darwinbox;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Settings_BU_locators {
private WebDriver driver;
private WebDriverWait wait;
	
	@SuppressWarnings("deprecation")
	public Settings_BU_locators(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,40);
	} 
         
	    //BU auto numbering setting	
		 private By BU_Prefix = By.id("BusinessUnitAutoNumberSet_0_prefix");
		 private By BU_NextNumber = By.id("BusinessUnitAutoNumberSet_0_next_number");
		 private By BU_AutoNumbering_SAVE = By.id("tenant_metadata_update_btn");
		 
		//BU setting	
		 private By Create_BusinessUnit = By.id("add_businessunit_btn");
		 private By BusinessUnit_Name = By.id("TenantBusinessUnitForm_unit_name");
		 private By GroupCompany = By.cssSelector("li[class='search-field'] input");
		 private By GroupCompanyValue = By.cssSelector("ul[class='chosen-results'] li");
		 private By BusinessUnit_Address = By.cssSelector("TenantBusinessUnitForm_unit_address");
		 private By costcenter = By.cssSelector("div[id='businessunit_data_on'] div div");
		 private By costcenter_value = By.cssSelector("div[class='menu transition visible'] div");
		 private By Head_Of_BusinessUnit = By.id("employee-search-2-tokenfield");
		 private By Head_Of_BU_value = By.cssSelector("ul[id='ui-id-2'] li");
		 private By SAVE = By.id("create_businessunit_btn");
		 
		 //BU edit
		 private By BUsearch = By.cssSelector("input[aria-controls='business_unit_table']");
		 private By BUrows = By.xpath("//tbody/tr");
		 private By edit_BUname = By.cssSelector("form[id='edit_com_bus_form'] div div div input[id='TenantBusinessUnitForm_id']");
		 private By edit_desiredBUname = By.xpath("//td[2]");
		 private By edit_desiredBUcompany = By.xpath("//td[3]");
		 private By editBU_icon = By.xpath("//td[4]/a/i[1]");
		 
		 //BU auto numbering setting
		 public void BusinessUnit_AutoNumbering_ONOFF(String onoff,String prefix, String nextnumber){
			List <WebElement> a= driver.findElements(By.cssSelector("input[id='BusinessUnitAutoNumbering_autogen']"));
			if(onoff.equalsIgnoreCase("on")) {
				if(a.get(0).getAttribute("checked").equalsIgnoreCase("true")){
				}
				else {
				a.get(0).click();
				driver.findElement(BU_Prefix).sendKeys(prefix);
				driver.findElement(BU_NextNumber).sendKeys(nextnumber);
				driver.findElement(BU_AutoNumbering_SAVE).click();
				}
			}
			else {
				a.get(1).click();
			}
		 }
		 
		 //BU setting	 
		 public void Create_BusinessUnit() {
		   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Create_BusinessUnit)));
			 driver.findElement(Create_BusinessUnit).click();
		 }
		 
		 public void BusinessUnit_Name(String BUname) {
			 driver.findElement(BusinessUnit_Name).sendKeys(BUname);
		 }
		 
		 public void BusinessUnit_Address(String address){
			 driver.findElement(BusinessUnit_Address).sendKeys(address);
		 }
		 
		 public void GroupCompany(String gp){
			 driver.findElement(GroupCompany).click();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(GroupCompanyValue));
			 List<WebElement> a = driver.findElements(GroupCompanyValue);
			 a.remove(0);
			 
			 if(gp.equalsIgnoreCase("random")) {
				 driver.findElement(GroupCompany).click();
				 Random rand = new Random();
				 a.get(rand.nextInt(a.size())).click();
			 }			 
			 else {
				 String arr[] = gp.split(",");
				 for(int i=0;i<arr.length;i++) {
					 driver.findElement(GroupCompany).sendKeys(arr[i]);
					 wait.until(ExpectedConditions.visibilityOfElementLocated(GroupCompanyValue)); 
					 driver.findElement(GroupCompanyValue).click();
				 }				
			 }
		 }
		 
		 public void costcenter(String cc){
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].click();", driver.findElement(costcenter));  
			 driver.findElement(costcenter).click();
			 
			 wait.until(ExpectedConditions.visibilityOfElementLocated(costcenter_value));
			 List<WebElement> a = driver.findElements(costcenter_value);
			 a.remove(0);
			 
			 if(cc.equalsIgnoreCase("random")) {
					Random rand = new Random();
					a.get(rand.nextInt(a.size())).click();
			 }
			 else {
				 for(int i=0;i<a.size();i++) {
					 if(cc.equalsIgnoreCase(a.get(i).getText())){
						 a.get(i).click();
					 }
				 }
			 }
		 }
		 
         public void Head_Of_BusinessUnit(String headbu){
        	 JavascriptExecutor js = (JavascriptExecutor) driver;
        	 js.executeScript("arguments[0].click();", driver.findElement(Head_Of_BusinessUnit));  
        	 
			 if(headbu.equalsIgnoreCase("random")) {
				 driver.findElement(Head_Of_BusinessUnit).sendKeys("**");
	        	 wait.until(ExpectedConditions.visibilityOfElementLocated(Head_Of_BU_value));
				 List<WebElement> a = driver.findElements(Head_Of_BU_value);
				 a.remove(0);
				 Random rand = new Random();
				 a.get(rand.nextInt(a.size())).click();
			 }
			 else{
				 String arr[] = headbu.split(",");
				 for(int i=0;i<arr.length;i++) {
					 driver.findElement(Head_Of_BusinessUnit).sendKeys(arr[i]);
					 wait.until(ExpectedConditions.visibilityOfElementLocated(Head_Of_BU_value)); 
					 driver.findElement(Head_Of_BU_value).click();
				 }				
			 }
         }
		 
         public void SAVE(){
        	 JavascriptExecutor js = (JavascriptExecutor) driver;
        	 js.executeScript("arguments[0].click();", driver.findElement(SAVE));   	 
         }
         
         public void BUedit(String BUname, String company) throws InterruptedException {
        	 Thread.sleep(5000);
        	// driver.findElement(BUsearch).sendKeys(BUname);
        	// Thread.sleep(5000);
        	 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody/tr/td")));
        	 List<WebElement> a= driver.findElements(By.tagName("tr")); 
        	 a.remove(0);
        	 for(int i=0;i<a.size();i++) {
        		 System.out.println(a.get(i).findElement(By.xpath("//td[2]")).getText());
        		 System.out.println(a.get(i).findElement(By.xpath("//td[3]")).getText());
        		// System.out.println(driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText());
        		 //System.out.println(driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).getText());
        	}
        /*	wait.until(ExpectedConditions.elementToBeClickable(BusinessUnit_Name));
        	driver.findElement(edit_BUname).clear();
        	driver.findElement(edit_BUname).sendKeys("asha"); */
         }
}
