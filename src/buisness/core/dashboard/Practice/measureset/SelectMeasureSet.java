package buisness.core.dashboard.Practice.measureset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import configuration.Setup;

public class SelectMeasureSet extends DashboardUI  {
	

	public boolean verify(String data)
	{
	
	   String MeasureSet = SelectMeasureSet(data);
	   
	   if(MeasureSet.equalsIgnoreCase(data))
	   {
		   return true;
		   
	   }
	   else
		   return false;
		   
	   }
	   
	   
	   
	  
	
	
	
	
	

}
