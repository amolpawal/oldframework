package buisness.core.mipss;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import configuration.Setup;

public class SelectSubmissionFromDropDown {
	String a;
	
	
	public boolean verify(String elementmethod,String locator,String data)
	{
		
		Select dropdown = new Select(Setup.driver.findElement(By.xpath(locator)));
		
		dropdown.selectByVisibleText(data);
		
		if (dropdown != null) {
			return true;
		}
		else 
			return false;
			
	
		
	
		
		
		
	}
	
	
	
	
	
	

}
