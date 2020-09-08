package steps;

import org.TestLeaf.Base.SeleniumBase;
import cucumber.api.java.en.And;

public class HomePage extends SeleniumBase {

	@And("click on crm-sfa link") 
	public MyHomePage clickCrmSfaLink() {
		click(locateElement("xpath","//div[@class='crmsfa']//img[1]"));
		return new MyHomePage();
	}
}
