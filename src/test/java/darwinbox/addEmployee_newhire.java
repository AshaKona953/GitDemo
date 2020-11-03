package darwinbox;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.*;
import org.testng.annotations.*;

public class addEmployee_newhire {
	
	public WebDriver driver;
	newhirepage_locators newhirepage;
	Login loginpage;
	dashboardpage_locators dashboardpage;
	dashboard_employeespage_locators employeespage;
	
	public void addemployee(String firstname,String lastname,String email,String dob,String gp,String role,String doj,String loc,String emptype,String gender) throws IOException, InterruptedException{	
		
		loginpage = new Login();
		this.driver = loginpage.driver;
		dashboardpage = new dashboardpage_locators(driver);
		employeespage = new dashboard_employeespage_locators(driver);
		newhirepage = new newhirepage_locators(driver);
		loginpage.login();
		
		dashboardpage.employees();
		employeespage.directory().click();
		employeespage.newhire().click();
		
		newhirepage.firstname().sendKeys(firstname);
		newhirepage.lastname().sendKeys(lastname);
		
		newhirepage.email().sendKeys(email);
		
		newhirepage.groupcompany(gp);
		
		newhirepage.designation(role);
		
		newhirepage.date_of_birth().sendKeys(dob);
		
		newhirepage.date_of_joining().sendKeys(doj);
		
		newhirepage.location(loc);
			
		newhirepage.employeeType(emptype);	
		
		newhirepage.gender(gender);
		
		newhirepage.ADDEMPLOYEE();
	    
		newhirepage.ASSIGNORSKIP(); 
	}
	
	@Test
	public void run() throws IOException, InterruptedException {
		//make sure no mandatory fields are in new hire page
		//make sure pulse is submitted
		//make sure position is off
		//give employee full name or id for manager/dlm/hrbp search method
		//make sure employee id is on
		//select department with hods already selected
		//select dob from 1900 onwards
		//add.addemployee(firstname, lastname, email, dob, gp, role, doj, loc, emptype, gender);
		
		addEmployee_newhire add = new addEmployee_newhire();
				
		
	  add.addemployee("junk6", "test6", "junk6test6@yopmail.com", "10-10-1901", "Waseem profile", "(As&Ha_953)", "01-01-2020", "(CACAA)", "Full Time", "Female");
	  add.addemployee("junk7", "test7", "junk7test7@yopmail.com", "10-10-1901", "Waseem profile", "(As&Ha_953)", "01-01-2020", "(CACAA)", "Full Time", "Female");	 	
	  add.addemployee("junk4", "test4", "junk4test4@yopmail.com", "10-10-1901", "Waseem profile", "(As&Ha_953)", "01-01-2020", "(CACAA)", "Full Time", "Female");	 	
	  add.addemployee("junk5", "test5", "junk5test5@yopmail.com", "10-10-1901", "Waseem profile", "(As&Ha_953)", "01-01-2020", "(CACAA)", "Full Time", "Female");	 	
	
	}
}
