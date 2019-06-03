package buisness.core.administration.pms.provider;

import buisness.core.administration.pms.Pms;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class VerifyPPopUpMessageUpdate  extends Pms {


public boolean Verify(String elementmethod,String locator,String data)

{

	String hardcoded;
	String Webcount ;
	ConfigurationManager config=new ConfigurationManager();
	
	hardcoded ="  NPI is not registered on CMS portal against this Clinician name. Are you sure, You want to proceed?";
	
	
	Webcount = getuicount(elementmethod,locator);
	//String[] ArrayCount = Webcount.split(";");
	//Webcount=ArrayCount[2];
	
	
	
	Setup.log.info("Expected Confirmation message: "+hardcoded);
	Setup.log.info("Actual Message from  from Application Interface: "+Webcount);
	
	
	
	if(hardcoded.equals(Webcount))
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
	
	
   

