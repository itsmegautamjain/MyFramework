package steps;

import org.TestLeaf.Base.SeleniumBase;
import cucumber.api.java.en.And;

public class MyHomePage extends SeleniumBase  {
	
	@And("click on createLead link") 
   	public CreateLeadPage clickCreateLeadLink() {
		click(locateElement("link", "Create Lead"));
		return new CreateLeadPage();
	}

}