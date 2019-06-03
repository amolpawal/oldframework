package buisness.core.mipss;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import configuration.Setup;

public class ExactPracticeSelection {
	
	
	
	
	public boolean verify(String elementmethod,String locator,String data)
	{
		
	try {
		Setup.driver.findElement(By.xpath("//table[@id='tblPracticeDropDownList']//td[.//text()='"+data+"']/../td/input")).click();
	
		return true;
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		return false;
		
	}
		
	
	
			
		
		
	}
	
	
	
	
	
	

}
