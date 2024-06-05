package Helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import com.autoweb.enums.DriverType;
//import com.autoweb.enums.EnvironmentType;
//import com.autoweb.managers.FileReaderManager;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	public static WebDriver driver;
	
	private static String driverType="CHROME";
	private static String envType = "LOCAL";
	
//	@Before
//	public void setup() {
//		System.setProperty("webdriver.chrome.driver","<<your chrome driver path>>\\chromedriver.exe");
//		driver=new ChromeDriver();  
//		driver.manage().window().maximize();
//	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	
	public static WebDriver getDriver() {
		if(driver==null) driver=createDriver();
		try {
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	private static WebDriver createDriver()
	{
		switch(envType){
			case "LOCAL":
				driver=createLocalDriver();
				break;
			case "REMOTE":
//				driver=createRemoteDriver();
				break;
		}
		return driver;
	}
	
	private static WebDriver createLocalDriver() {
		switch(driverType){
			case "FIREFOX": 
				driver=new FirefoxDriver();
				break;
			case "CHROME":
				System.setProperty("webdriver.chrome.driver","<<your chrome driver path>>\\chromedriver.exe");
				driver=new ChromeDriver();
				break;
			case "INTERNETEXPLORER":
				driver=new InternetExplorerDriver();
				break;
		}
		//if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;
	}
}
