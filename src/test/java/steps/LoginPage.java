package steps;

import org.TestLeaf.Base.SeleniumBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import utils.SeleniumDriver;

public class LoginPage extends SeleniumBase  {
	
	@Given("User launches following url \"(.*)\"")
	public void launchBrowser(String url) {
//		startApp(browserName, url);
		SeleniumDriver.openPage(url);
	}
	
	@And("Enter \"(.*)\" as UserName")
	public void enterUserName(String uName) {
		clearAndType(locateElement("id", "username"), uName);
	}
	
	@And("Enter \"(.*)\" as Password") 
	public void enterPassword(String pwd) {
		clearAndType(locateElement("id", "password"), pwd);
	}
	
	@And("Click on login button")
	public HomePage clickLogin() {
		click(locateElement("class","decorativeSubmit"));
		return new HomePage();
	}	

}
