package buisness.core.administration.pms.custominformation;

import buisness.core.administration.pms.Pms;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class VerifyGpro  extends Pms {


public boolean Verify(String elementmethod,String locator)

{
	String Databasecount;
	String Webcount;
	ConfigurationManager config=new ConfigurationManager();
	String query = config.getQuery("VerifyGpro");
	query = query.replace("@PmsPracticeName",getPMSpracticeName());
	

	Databasecount = getdbcount(query);
	Webcount = getuicountAngular(elementmethod,locator);
	
	
	Setup.log.info(" Gpro  from database: "+Databasecount);
	Setup.log.info(" Gpro  from Application Interface: "+Webcount);
	
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
