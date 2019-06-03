package buisness.core.administration.pms.agreement;

import buisness.core.dashboard.Practice.PracticeLocationPopUp;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.practice.PracticeLocationPopUpGrid;
import buisness.util.datastructures.pms.FourVariablesCompare;
import configuration.Setup;

public class PracticeAgreementPopUpView extends PracticeAgreementGrid {
	
	public FourVariablesCompare getDatabaseGrid(String query)
	{

	
		return super.getDatabaseGrid(query);
		
	}
	

	public boolean verify(String elementmethod,String locator,String data)
	{
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("VerifyAgreementStatus");
	
		query=query.replace( "@PmsPracticeName",getPMSpracticeName());

	
	
		FourVariablesCompare databaseGrid =getDatabaseGrid(query);
	
		FourVariablesCompare webGrid =getWebGrid(elementmethod,locator);
		
	
		if(webGrid.compareTo(databaseGrid)== 0)
		{
			Setup.log.info("Patient Details from UI and Database is matched");
		
			Setup.testcase.assertTrue(true);
			return true;			
		}
		else
		{
			Setup.log.info("Patient Details from UI and Database is not  matched");
		
			Setup.testcase.fail();
			return false;
		}
	}	
}