package org.digital.testautomation.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.digital.testautomation.Util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * 
 * @author ANKIT THAKUR This class will initialise WebDriver with chosen browser
 */

public class BrowserManager {

	public static WebDriver driver;
	public static Properties prop;
	private static final Logger logger = LogManager.getLogger(BrowserManager.class);
	
	  public BrowserManager(){ 
		  try { 
			  prop = new Properties(); 
			  FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/" +
					  "/org/digital/testautomation/config/config.properties");
			  System.out.println("Config Path is: "+ip); 
			  prop.load(ip);
		  	} catch (FileNotFoundException e) 
		  { e.printStackTrace(); } 
		  catch (IOException e) 
		  { e.printStackTrace(); }
	  }
	  
	  @SuppressWarnings("deprecation")
	public static WebDriver initialization(String browser){ 
		  
		  String browserName = browser;
		  try {
			  if(browserName.equalsIgnoreCase("chrome"))
		  		{
				  logger.info("Chrome Driver is invoked");
				  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
						  + "/src/main/resources/Drivers/" + "chromedriver.exe"); 
				  //driver = new ChromeDriver();
				  ChromeOptions options = new ChromeOptions();
			      driver = new ChromeDriver(options);
		  		}else if(browserName.equalsIgnoreCase("Firefox"))
		  		{
			  		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + 
			  				"/src/main/resources/Drivers/" + "geckodriver.exe");
			  		driver = new FirefoxDriver(); 
		  		} 
		  		else if(browserName.equalsIgnoreCase("IE")){
		  			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +
		  					"/src/main/resources/Drivers/" + "IEDriverServer.exe");
		  			driver = new InternetExplorerDriver(); 
		  		}
		  }
		  catch (Exception e)
		  {
			logger.info("Exception thrown: ", e);
		  }
		  driver.manage().window().maximize(); 
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS); 
		  driver.get(prop.getProperty("url")); 
		  return driver; 
	  }
	 
	public static void closeAllBrowser() {
		driver.quit();
		}

}