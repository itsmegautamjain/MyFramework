package steps;

import java.io.IOException;
import org.TestLeaf.Base.SeleniumBase;


import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import utils.ReadExcel;

public class CreateLeadPage extends SeleniumBase {
	@And("Enters Company Name as \"(.*)\"")
	public CreateLeadPage enterCompanyName(String cName ) throws IOException {
		clearAndType(locateElement("id","createLeadForm_companyName"), new ReadExcel().storeDataFromExcel(cName, 0));
		return this;
	}
}
