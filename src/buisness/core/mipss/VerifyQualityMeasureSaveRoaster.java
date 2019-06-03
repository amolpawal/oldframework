package buisness.core.mipss;

import org.openqa.selenium.By;

import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.MeasureGrid;
import configuration.Setup;

public class VerifyQualityMeasureSaveRoaster {
	String ExpectedMessage;
	String ActualMessage;

	public boolean verify(String elementmethod,String locator)
	{

		ConfigurationManager config=new ConfigurationManager();
		Setup.driver.findElement(By.xpath(locator)).click();
	
		ExpectedMessage =" Quality data saved for submission successfully.";
	    ActualMessage=Setup.driver.findElement(By.xpath("//*[@id='divmessage']/div")).getText();
	    

		Setup.log.info("ExpectedMessage : "+ExpectedMessage);
		
		Setup.log.info("ActualMessage: "+ActualMessage);
		
		
		
		if(ExpectedMessage.equals(ActualMessage))
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