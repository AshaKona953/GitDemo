package darwinbox;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

public class Base1 {
	 public String browser;
	 public String url;
	 public WebDriver driver;
	 public String username;
	 public String password;
	 
	 
	public WebDriver Browserchoose() throws IOException{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\darwinbox\\resources.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");
		username=prop.getProperty("username");
		password=prop.getProperty("password");
		
		if(browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");   
					driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
		    driver = new FirefoxDriver();
	}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	
	}
}
