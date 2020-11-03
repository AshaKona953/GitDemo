package darwinbox;

import java.io.*;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class allrolescreate {
   public WebDriver driver;
	Login loginpage;
	dashboardpage_locators dashboardpage;
	dashboard_employeespage_locators employees;
	directorypage_locators directory;
	allrolescreate_Locators all;
	
	
	public void login() throws IOException {
		loginpage = new Login();
		this.driver= loginpage.driver;
		dashboardpage = new dashboardpage_locators(driver);
		employees = new dashboard_employeespage_locators(driver);
		directory = new directorypage_locators(driver);
	    all = new allrolescreate_Locators(driver);
	    
	    loginpage.login();
	}
	
	public void activate_employee(String pendingemp, String status) throws IOException, InterruptedException {
		loginpage = new Login();
		this.driver= loginpage.driver;
		dashboardpage = new dashboardpage_locators(driver);
		employees = new dashboard_employeespage_locators(driver);
		directory = new directorypage_locators(driver);
	    all = new allrolescreate_Locators(driver);
	    
	    loginpage.login();
	    
		dashboardpage.employees();
		employees.directory();
		
		directory.advance_search_icon();
		directory.Employee_status(status);
		
		directory.directory_search(pendingemp);

		directory.directory_search_icon();
		
		directory.bulkselection_all_checkbox();
		
		directory.BulkAction_button();
		
		directory.bulkaction_activate_employee();
	}
	
	public void ManagerChange(String emp,String manager) throws InterruptedException, IOException{	
		loginpage = new Login();
		this.driver= loginpage.driver;
		dashboardpage = new dashboardpage_locators(driver);
		employees = new dashboard_employeespage_locators(driver);
		directory = new directorypage_locators(driver);
	    all = new allrolescreate_Locators(driver);
	    
		loginpage.login();
    	dashboardpage.employees();
		employees.directory();
		
		directory.directory_search(emp);

		directory.directory_search_icon();
				
		directory.bulk_checkbox_singleemp();
		directory.BulkAction_button();
		
		directory.change_manager();
		directory.search_manager(manager);
		directory.update_manager_button();
     }
	
	public void DlmChange(String dlm) throws InterruptedException {
        directory.BulkAction_button();
		
		directory.change_dlm();
		directory.search_dlm(dlm);
		directory.update_dlm_button();
	}
	
	public void HRBPChange(String hrbp) throws InterruptedException {
        directory.BulkAction_button();
		
		directory.change_hrbp();
		directory.search_hrbp(hrbp);
		directory.update_hrbp_button();
	}
	
	public void reset_password(String emp) throws InterruptedException, IOException {
		loginpage = new Login();
		this.driver= loginpage.driver;
		dashboardpage = new dashboardpage_locators(driver);
		employees = new dashboard_employeespage_locators(driver);
		directory = new directorypage_locators(driver);
	    all = new allrolescreate_Locators(driver);
	    
		loginpage.login();
    	dashboardpage.employees();
		employees.directory();
		
		directory.directory_search(emp);

		directory.directory_search_icon();
		
		directory.settings_icon();
	}
	
	@Test
	public void run() throws IOException, InterruptedException{
		//make sure no mandatory fields are in new hire page
		//make sure pulse is submitted
		//make sure position is off
		//give employee full name or id for manager/dlm/hrbp search method
		//make sure employee id is on
		//select department,role with hods already selected
		//select dob from 1900 onwards
		//gp,role,loc i can give random or specific value
		//add.addemployee(firstname, lastname, email, dob, gp, role, doj, loc, emptype, gender);
		//give starting letter as capital for firstname,lastname
		
		allrolescreate all = new allrolescreate();
		addEmployee_newhire newhire = new addEmployee_newhire();
		
		//newhire.addemployee("firstsel1", "emp", "firstsel1emp@yopmail.com", "01-01-1900", "Waseem profile", "(As&Ha_953)", "01-10-2020", "(CACAA)", "Full Time", "Male");
		//newhire.addemployee("firstsel2", "manager", "firstsel2manager@yopmail.com", "01-01-1900", "Waseem profile", "(As&Ha_953)", "01-10-2020", "(CACAA)", "Full Time", "Male");
	//	newhire.addemployee("firstsel3", "dlm", "firstsel3dlm@yopmail.com", "01-01-1900", "Waseem profile", "(As&Ha_953)", "01-10-2020", "(CACAA)", "Full Time", "Male");
	//	newhire.addemployee("firstsel4", "hrbp", "firstsel4hrbp@yopmail.com", "01-01-1900", "Waseem profile", "(As&Ha_953)", "01-10-2020", "(CACAA)", "Full Time", "Male");
		
	//	all.login();
	//	all.activate_employee("firstsel1emp@yopmail.com,firstsel2manager@yopmail.com,firstsel3dlm@yopmail.com,firstsel4hrbp@yopmail.com", "pending");		
	//    all.activate_employee("W_04,W_03,RETIRE4,W11831", "pending");
	//	all.ManagerChange("firstsel1emp@yopmail.com", "Firstsel2");
	//	all.DlmChange("Firstsel3");
	//	all.HRBPChange("Firstsel4");
		all.reset_password("wp10,wp11,wp13,wp14,wp15,wp16,wp17");		
	}
}
