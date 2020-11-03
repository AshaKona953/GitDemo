package darwinbox;


import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;


public class directorypage_locators extends Base1 {
	public WebDriver driver;
	 WebDriverWait wait;
	 Actions act;
	 JavascriptExecutor js;
			
		@SuppressWarnings("deprecation")
		public directorypage_locators(WebDriver driver) {
				this.driver=driver;
				wait = new WebDriverWait(driver,30);
				act = new Actions(driver);
				js = (JavascriptExecutor)driver;
		}
		
		private By advance_search_icon = By.cssSelector("[data-target='.advance-search']");
		private By Employee_status = By.cssSelector("[id='newUrl']");
		private By bulkselection_all_checkbox = By.cssSelector("[id='bulk_check1']");
		
		private By directory_search = By.cssSelector("[id='employee-search_new']");	
		
		private By select_employee = By.xpath("//ul[@id='ui-id-2']/li[2]");
		private By directory_search_icon = By.cssSelector("[class='db-Search']");	
		
		private By employee_name = By.xpath("//a[contains(@href,'/employeeprofile/view/id/')]");
		private By settings_icon = By.xpath("//i[contains(@class,'settingsite-color')]");
		private By reset_password = By.xpath("//i[contains(@class,'settingsite-color')]/parent::a/parent::span/parent::div/ul/li[2]/a");
		private By newpassword = By.cssSelector("[id='UserChangePassword_newPassword']");
		private By retype_password = By.cssSelector("[id='UserChangePassword_verifyNewPassword']");
		private By password_SAVE_button = By.cssSelector("[id='reset_password_btn']");
		
		
		private By bulk_checkbox_singleemp = By.cssSelector("[id='employee_bulk']");
		private By BulkAction_button = By.xpath("//button[contains(@class,'bulk-actions-btn')]");
		
		private By bulkaction_activate_employee = By.cssSelector("[data-id='change-activated-user']");
		private By Activate_Button_Confirmation = By.cssSelector("[id='force_act']");
		
		private By change_manager = By.cssSelector("[data-id='change-manager']");
		private By search_manager = By.cssSelector("[id='employee-search-2']");	    
		private By update_manager_button = By.cssSelector("[id='update_manager_btn1']");
		
		private By change_dlm = By.cssSelector("[data-id='change-dotted-manager']");
		private By search_dlm = By.cssSelector("[id='employee-search-3']");
		private By update_dlm_button = By.cssSelector("[id='update_manager_btn1']");
		
		private By change_hrbp = By.cssSelector("[data-id='change-hrbp']");
		private By search_hrbp = By.cssSelector("[id='employee-search-3']");
		private By update_hrbp_button = By.cssSelector("[id='update_manager_btn1']");		
	
		
		public void advance_search_icon() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(advance_search_icon));
			driver.findElement(advance_search_icon).click();
		}
		
		public void Employee_status(String status) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Employee_status));
			Select sel = new Select(driver.findElement(Employee_status));
			
			if(status.equalsIgnoreCase("active")) {
				sel.selectByIndex(0);
			}
			else if(status.equalsIgnoreCase("pending")){
				sel.selectByIndex(1);
			}
			else if(status.equalsIgnoreCase("inactive")){
				sel.selectByIndex(2);
			}   
		}
		
		public void directory_search(String employee) {
			String emp[] = employee.split(",");
			
			for(int i=0;i<emp.length;i++) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(directory_search));
			driver.findElement(directory_search).sendKeys(emp[i]);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(select_employee));
			driver.findElement(select_employee).click();
		   }
		}
		
		public void bulkselection_all_checkbox() throws InterruptedException {
			wait.until(ExpectedConditions.presenceOfElementLocated(bulk_checkbox_singleemp));
			driver.findElement(bulkselection_all_checkbox).click();				
		}
		
		public void directory_search_icon() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(directory_search_icon));
			driver.findElement(directory_search_icon).click();
		}
				
		public void bulk_checkbox_singleemp() {
			driver.findElement(bulk_checkbox_singleemp).click();
		}
		
		public void BulkAction_button() {
			wait.until(ExpectedConditions.elementToBeClickable(BulkAction_button));
			driver.findElement(BulkAction_button).click();
		}
		
		public void bulkaction_activate_employee() {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(bulkaction_activate_employee));
			driver.findElement(bulkaction_activate_employee).click();
			driver.findElement(Activate_Button_Confirmation).click();
		}
		
		public void settings_icon() throws InterruptedException {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(bulk_checkbox_singleemp));
			List<WebElement> a1 = driver.findElements(settings_icon);
			List<WebElement> b1 = driver.findElements(bulk_checkbox_singleemp);
				
			for(int i=0;i<a1.size();i++) {
				
				js.executeScript("arguments[0].click();", b1.get(i));
				
				act.moveToElement(b1.get(i)).click().perform();
				//a1.get(i).click();
				js.executeScript("arguments[0].click();", a1.get(i));
				
				driver.findElement(reset_password).click();	
				
				wait.until(ExpectedConditions.elementToBeClickable(newpassword));
				driver.findElement(newpassword).sendKeys("12345678");
				driver.findElement(retype_password).sendKeys("12345678");
				act.sendKeys(Keys.ENTER).perform();
				//driver.findElement(password_SAVE_button);
			}
		}
		
		
		//changing manager
		public void change_manager() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(change_manager));
			driver.findElement(change_manager).click();
		}
		
		public void search_manager(String manager) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(search_manager));
			driver.findElement(search_manager).sendKeys(manager);
			driver.findElement(By.xpath("//li[contains(text(),'"+manager+"')]")).click();
		}
		
		public void update_manager_button() throws InterruptedException {
			wait.until(ExpectedConditions.visibilityOfElementLocated(update_manager_button));
			driver.findElement(update_manager_button).click();
			driver.switchTo().alert().accept();
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(update_manager_button)));
		}
		
		
		//changing dotted line manager
		public void change_dlm() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(change_dlm));
			driver.findElement(change_dlm).click();
		}
		
		public void search_dlm(String dlm) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(search_dlm));
			driver.findElement(search_dlm).sendKeys(dlm);
			driver.findElement(By.xpath("//li[contains(text(),'"+dlm+"')]")).click();
		}
		
		public void update_dlm_button() throws InterruptedException {
			wait.until(ExpectedConditions.visibilityOfElementLocated(update_dlm_button));
			driver.findElement(update_dlm_button).click();
			driver.switchTo().alert().accept();
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(update_dlm_button)));
		}
		
		
		//changing hrbp
		public void change_hrbp() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(change_hrbp));
			driver.findElement(change_hrbp).click();
		}
		
		public void search_hrbp(String hrbp) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(search_hrbp));
			driver.findElement(search_hrbp).sendKeys(hrbp);
			driver.findElement(By.xpath("//li[contains(text(),'"+hrbp+"')]")).click();
		}
		
		public void update_hrbp_button() throws InterruptedException {
			wait.until(ExpectedConditions.visibilityOfElementLocated(update_hrbp_button));
			driver.findElement(update_hrbp_button).click();
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(update_hrbp_button)));
		}
		
}
