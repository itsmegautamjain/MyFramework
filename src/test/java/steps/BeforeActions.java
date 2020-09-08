package steps;

import java.text.SimpleDateFormat;
import java.util.Date;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import utils.SeleniumDriver;

public class BeforeActions  {
	
	@Before
    public static void setUp(Scenario scenario) {
		//ExtentCucumberFormatter.initiateExtentCucumberFormatter(); 
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		Date curDate = new Date();		
		String strDate = sdf.format(curDate);		
		String[] split = scenario.getId().split(";")[0].split("-");
    	System.out.println("Before");    
    	SeleniumDriver.setPath(split[split.length-1], strDate); 
    	SeleniumDriver.setUpDriver(scenario.getName());    	    	
    	System.out.println(scenario.getId());
    	System.out.println("Executing Scenario :--> "+scenario.getName());
    }
}