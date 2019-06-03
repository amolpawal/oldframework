package buisness.core.administration.pms.provider;

import buisness.core.administration.pms.Pms;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class VerifySearchInactive  extends Pms {


public boolean Verify(String elementmethod,String locator,String data)

{

	String Databasecount;
	String Webcount;
	ConfigurationManager config=new ConfigurationManager();
	
	
	String query = config.getQuery("VerifySearchInactive");
	query = query.replace("@PmsPracticeName",getPMSpracticeName());
	query=query.replace("@SearchText",data);

	

	Databasecount = getdbcount(query);
	Webcount = getuicount(elementmethod,locator);
	String[] ArrayCount = Webcount.split(" ");
	Webcount=ArrayCount[4];
	
	
     
	
	
	Setup.log.info("Search count  from database: "+Databasecount);
	Setup.log.info("Search count  from Application Interface: "+Webcount);
	
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
