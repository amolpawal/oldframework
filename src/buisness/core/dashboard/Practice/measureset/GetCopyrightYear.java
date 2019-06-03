package buisness.core.dashboard.Practice.measureset;

import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class GetCopyrightYear extends MasterLogicUIdb{
	
	public boolean verify(String elementmethod,String locator,String data)  
	{
		String ExpectedCopyrightyear="2018";
		String ActualCopyrightyear;
		
		
		ActualCopyrightyear =getuicount(elementmethod,locator);
		ActualCopyrightyear = ActualCopyrightyear.substring(2);
	    
				
		
		
		
		
		Setup.log.info("ActualCopyrightyear"+ActualCopyrightyear);
		Setup.log.info("ExpectedCopyrightyear"+ExpectedCopyrightyear);
		
		
		if(ActualCopyrightyear.equals(ExpectedCopyrightyear))
		{
			Setup.log.trace("Copyright year is getting mathched");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else
		{
			Setup.log.trace("Copyright year is not getting mathched");
			Setup.testcase.fail();
			return false;
		}
		
	}
	
	
	
	
	
	
	
	
	

}
