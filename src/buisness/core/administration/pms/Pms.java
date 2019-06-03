package buisness.core.administration.pms;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.core.ElementMethod;
import buisness.managers.DatabaseManger;
import configuration.Setup;


public class Pms extends DashboardUI

{
	
	ResultSet resultset = null;
	public String query;

	public String getdbcount(String query)
	{
		DatabaseManger.SQLserverConnection();
	    System.out.println(query);
		try {
			resultset = DatabaseManger.exeQuery(query);
			if (resultset.next()) 
			{
	                return resultset.getString("totalcount");
			}
			else
			{
				Setup.log.error("no record is found for the executed Query");
			}
			
		}

		 catch(SQLException e)
		{
			Setup.log.error("SQL Exception. Please check query in query repository");
			Setup.testcase.fail();
		}
		catch(Exception e)
		{
			Setup.log.error("Exception faced while fetching data from Database.");
			Setup.testcase.fail();
		}
		Setup.testcase.fail();
		return "0";
	}
	
	public String getuicount(String elementmethod,String locator) 
	{
		ElementMethod em=new ElementMethod();
		///Setup.driver.wait();
		
		
		try
		{  
			String count = em.gettext(elementmethod, locator);
			///String count = em.getAngularControlText(elementmethod, locator);
			
			
			
		return count ;
		}
		catch(NoSuchElementException e)
		{
			Setup.log.error(e);
			Setup.log.error("Element not found on the UI. Please check locator of the object passed. ");
		}
		
		catch(Exception e)
		{
			Setup.log.error(e);
			Setup.log.error("Exception faced while fetching data from UI. ");
		}
		Setup.testcase.fail();
		return "0";
	}
	

	public String getuicountWithTrim(String elementmethod,String locator)
	{
		
		
		ElementMethod em=new ElementMethod();
		try
		{
		return trimuicount(em.gettext(elementmethod, locator));
		}
		catch(NoSuchElementException e)
		{
			Setup.log.error(e);
			Setup.log.error("Element not found on the UI. Please check locator of the object passed. ");
		}
		
		catch(Exception e)
		{
			Setup.log.error(e);
			Setup.log.error("Exception faced while fetching data from UI. ");
		}
		Setup.testcase.fail();
		return "0";
	}
	
	
	public String getuicountAngular(String elementmethod,String locator)
	{

		ElementMethod em=new ElementMethod();
		
		try{
		String count =em.getAngularControlText(elementmethod, locator);
		
		
		return count ;
		}
		catch(NoSuchElementException e)
		{
			Setup.log.error(e);
			Setup.log.error("Element not found on the UI. Please check locator of the object passed. ");
		}
		
		catch(Exception e)
		{
			Setup.log.error(e);
			Setup.log.error("Exception faced while fetching data from UI. ");
		}
		Setup.testcase.fail();
		return "0";
	}
	
		
		//String value1 =Setup.driver.findElement(By.cssSelector(#)
	
      
  
      
    
    		   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/** Trims unnecessary data for the captured data from the UI
	 * @param rawcount:  Untrimmed total record from the UI
	 * Returns actual count as String
	 */
	public String  trimuicount(String rawcount)
	{
		int index=0;
		char character = ' ';
		for(int i = 0; i < rawcount.length(); i++){
		    if(rawcount.charAt(i) == character){
		    	index=i;
		    }
		}
		return rawcount.substring(index+1,rawcount.length());
		
	}
	
}

	
		
		
		


