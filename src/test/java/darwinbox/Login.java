package darwinbox;

import java.io.IOException;

import org.openqa.selenium.*;
import org.testng.annotations.*;

public class Login extends Base1{
	loginpage_Locators loc;
	public WebDriver driver;
	
	public Login() throws IOException{
		this.driver=Browserchoose();
	}
	
	@Test
	public void login()   {
		loc = new loginpage_Locators(driver);
		
		driver.manage().window().maximize();
		driver.get(url);	  
		loc.username().sendKeys(username);
		loc.password().sendKeys(password);
		loc.signin().click(); 
		
		loc.topside_menu().click();
		loc.switch_to_admin().click();
	}
}
