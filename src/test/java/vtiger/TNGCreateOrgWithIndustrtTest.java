package vtiger;

import org.testng.annotations.Test;

import genereicUtilities.BaseClasses;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;


public class TNGCreateOrgWithIndustrtTest extends BaseClasses
{			


@Test(groups={"SmokeSuite","RegressionSuite"})
public void TNGCreateOrgWithIndustrtTest() throws Exception
{
	String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
	String INDUSTRY=eUtil.readDataFromExcel("Organization", 4, 3);
	HomePage hp = new HomePage(driver);
	hp.clickOrganizationLink();

	// Step 4: Click on Create Org Look Up Image
	OrganizationPage op = new OrganizationPage(driver);
	op.oragnizationLookUpImg();

	// Step 5: Create Organization with mandatory fields
	CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	cnop.createNewOrganizationWithIndustry(ORGNAME, INDUSTRY);

	// Step 8: Validate
	OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	String orgHeader = oip.getOrgHeader();

	if (orgHeader.contains(ORGNAME)) {
		System.out.println(orgHeader);
		System.out.println("Test Script Passed");
	} else {
		System.out.println("FAIL");
	}

	
}
	
	
	
	
	
	
}
