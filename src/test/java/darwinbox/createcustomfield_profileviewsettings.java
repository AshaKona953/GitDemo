package darwinbox;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class createcustomfield_profileviewsettings extends Base1{
	WebDriver driver;
	Login loginpage;
	dashboardpage_locators dashboardpage;
	Properties prop;
	settings_employeespage_locators employeespage;
	profileviewsettingspage_Locators profileviewsettings;
	
	public void createcustomfield(String sectionname,String fieldname,String fieldtype,String validation_required,String validation,String updateview,String createview,String view, String delete) throws IOException, InterruptedException{
		loginpage = new Login();
		loginpage.login();
		dashboardpage = new dashboardpage_locators(loginpage.driver);
		employeespage = new settings_employeespage_locators(loginpage.driver);
		profileviewsettings = new profileviewsettingspage_Locators(loginpage.driver);
		
		dashboardpage.settings().click();
		
		employeespage.employees();
		employeespage.ProfileViewSettings();
		
		profileviewsettings.AddCustomField();
		profileviewsettings.ChooseSection(sectionname);
		profileviewsettings.FieldName(fieldname);
		profileviewsettings.FieldType(fieldtype, validation_required, validation);
		
		profileviewsettings.updateview(updateview);
		profileviewsettings.createview(createview);
		profileviewsettings.view(view);
		profileviewsettings.delete(delete);
		
		profileviewsettings.ADDFIELD();
    }
	
	@Test
	public void run() throws IOException, InterruptedException {
		createcustomfield_profileviewsettings pvs = new createcustomfield_profileviewsettings();
		pvs.createcustomfield("Job", "asha_selenium1_job1", "file", "no", "", "Admin,Self", "Admin,Self", "Admin,Self", "Admin,Self");
		pvs.createcustomfield("Contact", "asha_selenium1_job1", "file", "no", "", "Admin,Self", "Admin,Self", "Admin,Self", "Admin,Self");
	
	}
}
