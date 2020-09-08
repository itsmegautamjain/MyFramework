package utils;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumDriver {

    private static SeleniumDriver seleniumDriver;
 
    //initialize webdriver
    private static WebDriver driver;
    
    //initialize timeouts
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50; 
    private static String sName;
    private static String screenShotsPath; 
    private static String browser;
    private static ChromeOptions options; 
    private static FirefoxOptions p;
    
    private  SeleniumDriver() {
       
  //  	driver = new ChromeDriver();
  //      driver.manage().window().maximize();

 //       waitDriver = new WebDriverWait(driver, TIMEOUT);
 //       driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
 //       driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
 //       String window=driver.getWindowHandle();
 //       System.out.println("Window ->"+window);
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"./Drivers/chromedriver.exe");
				options =new ChromeOptions();
				driver = new ChromeDriver(options);
			    options.addArguments("--disable-notifications");
			} else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"./Drivers/geckodriver.exe");
				p = new FirefoxOptions();
				p.addPreference("javascript.enabled", false);
				p.addPreference("security.insecure_field_warning.contextual.enabled", false);
				driver = new FirefoxDriver(p);
			} else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						"./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
//			driver.navigate().to(url);
			driver.manage().window().maximize();
			waitDriver = new WebDriverWait(driver, TIMEOUT);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	        String window=driver.getWindowHandle();
	        System.out.println("Window ->"+window);
			} catch (Exception e) {
				throw new RuntimeException();
		} 
    }
    
    private SeleniumDriver(String sName) {
    	this();
//		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
//		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
//		Date curDate = new Date();		
//		String strDate = sdf.format(curDate);
//    	this.sName = sName;
    	SeleniumDriver.sName = sName;
      }
    
    public static void setPath(String browser, String screenShotsPath) {
    	SeleniumDriver.browser = browser;
       	SeleniumDriver.screenShotsPath = screenShotsPath;     	
    }
    
    public static void openPage(String url) {
    	System.out.println(url);
    	System.out.println(driver);
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }
    
    public static String getScenarioName() {
    	return sName;
    }
    
    public static String getScreenshotsPath() {
    	return screenShotsPath;
    }

    public static void setUpDriver(String scenario) {
       if (seleniumDriver == null) {
            seleniumDriver = new SeleniumDriver(scenario);            
       }
    }

    public static void tearDown() {
        if (driver != null) {
//            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
    }
    public static void waitForPageToLoad()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
