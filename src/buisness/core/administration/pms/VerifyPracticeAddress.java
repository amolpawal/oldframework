package buisness.core.administration.pms;

import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class VerifyPracticeAddress extends Pms {


public boolean Verify(String elementmethod,String locator)

{
	String Databasecount;
	String Webcount;
	ConfigurationManager config=new ConfigurationManager();
	String query = config.getQuery("VerifyPracticeAddress");
	query = query.replace("@PmsPracticeName",getPMSpracticeName());
	

	Databasecount = getdbcount(query);
	Webcount = getuicountAngular(elementmethod,locator);
	
	
	Setup.log.info("  PmsPracticeName from database: "+Databasecount);
	Setup.log.info("  PmsPracticeName  from Application Interface: "+Webcount);
	
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
