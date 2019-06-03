package buisness.core.administration.pms;

import org.openqa.selenium.By;

import buisness.managers.ConfigurationManager;
import configuration.Setup;

public class VerifyRoasterMessage extends  Pms {


public boolean Verify(String elementmethod,String locator)

{
	String Expectedtext;
	String ActualText;
	
	Setup.driver.findElement(By.xpath(locator)).click();
	
	///locator="//*[@id='divmessage']/div/text()";
	ActualText=Setup.driver.findElement(By.xpath("//*[@id='divmessage']/div")).getText();
  

	Expectedtext = " Practice information updated successfully!";
	
	
	
	Setup.log.info("Expectedtext : "+Expectedtext);
	
	Setup.log.info("ActualText: "+ActualText);
	
	if(Expectedtext.equals(ActualText))
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