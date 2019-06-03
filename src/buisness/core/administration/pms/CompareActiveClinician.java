package buisness.core.administration.pms;

import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class CompareActiveClinician extends Pms {


public boolean Verify(String elementmethod,String locator)

{
	System.out.println("CompareActiveClinician extends Pms");
	String Databasecount;
	String Webcount;
	ConfigurationManager config=new ConfigurationManager();
	String query = config.getQuery("CompareActiveClinician");
	
	query = query.replace("@PmsPracticeName",getPMSpracticeName());
	

	Databasecount = getdbcount(query);
	Webcount = getuicount(elementmethod,locator);
	
	
	Setup.log.info("Active Clinician from database : "+Databasecount);
	Setup.log.info("Active Clinician from Application Interface: "+Webcount);
	
	if(Databasecount.equals(Webcount))
	{
		Setup.log.trace("\nCount from Database and UI getting matched");
		Setup.testcase.assertTrue(true);
	
		return true;
    }
	else
	{
		Setup.log.trace("\nCount from Database and UI is not getting matched");
		Setup.testcase.fail();
		return false;
	}
}


}
