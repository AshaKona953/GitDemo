package darwinbox;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Create_BU {
	WebDriver driver;
	Login loginpage;
	dashboardpage_locators dashboardpage;
	Properties prop;
	Settings_BU_locators BUpage;
	settings_companypage_locators companypage;
	
	
	@Test
	public void create_BusinessUnit() throws InterruptedException, IOException{
		loginpage = new Login();
		loginpage.login();
		dashboardpage = new dashboardpage_locators(loginpage.driver);
		companypage = new settings_companypage_locators(loginpage.driver);
		BUpage = new Settings_BU_locators(loginpage.driver);
		
		dashboardpage.settings().click();
		companypage.BusinessUnit_AutoNumbering().click();
		BUpage.BusinessUnit_AutoNumbering_ONOFF("on",null,null);
		
		companypage.BusinessUnit().click();
		/*BUpage.Create_BusinessUnit();
		BUpage.BusinessUnit_Name("BU_Asha");
		BUpage.GroupCompany("Waseem Hospitality,Zydus FA Testing1");
		BUpage.costcenter("random"); 
		BUpage.Head_Of_BusinessUnit("WCS4,WS1097");
		BUpage.SAVE();*/
		BUpage.BUedit("BU_Asha","Waseem Hospitality");
	}
}
