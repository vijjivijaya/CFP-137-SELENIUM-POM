package com.fb.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.fb.qa.util.UtilityClass;
import com.fb.qa.util.WebEventListener;

public class BaseClass {
	
	public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver eventFiringWebdriver;
    public static WebEventListener eventListener;
    public static Logger log = Logger.getLogger(BaseClass.class);
    
    public BaseClass() {
    	
    	try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\PageObjectModel\\src\\main\\java\\com\\fb\\qa\\config\\config.properties");
            prop.load(ip);
          
    	 } catch (FileNotFoundException ex) {
             ex.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

    public static void initialiazation() {
    	 log.info("***************************Starting the execution*************************");
        String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver1_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C://Users//Documents//Eclipse//LinkedIn//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		// Capture screenshot when test failed
        eventFiringWebdriver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        eventFiringWebdriver.register(eventListener);
        driver = eventFiringWebdriver;
        
        
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(UtilityClass.IMPLICITY_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		log.info("entering application URL");
	}
}
        
        
        
   