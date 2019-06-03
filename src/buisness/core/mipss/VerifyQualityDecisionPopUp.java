package buisness.core.mipss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import configuration.Setup;

public class VerifyQualityDecisionPopUp {
	
	String se;
	int i;
	String IA = "(IA)";
	String ACI = "(ACI)";
	String Both = "(IA/ACI)";
	

	public boolean verify(String elementmethod,String locator)
	{
      se=Setup.driver.findElement(By.xpath(locator)).getText();
      String[] Object = se.split(" ");
      int Size=Object.length;
      
      System.out.println("the size of the Split is "+Size);
      
      for(i=0;i<=Size;i++)
      {
       if(i>=0)
       {
    	  if(Object[i].equalsIgnoreCase((IA)))
       {
    	   System.out.println("ia is found");
    	   
    	   Setup.driver.findElement(By.xpath("//div//div//div[3]/button[@class='btn btn-sm btn-mips-Cancel']")).click();
    	   return true;
       }
        else if (Object[i].equalsIgnoreCase((ACI)))
          {
        	   System.out.println("ACI is found"); 
        	   Setup.driver.findElement(By.xpath("//div//div//div[3]/button[@class='btn btn-sm btn-mips-Cancel']")).click();
        	  return true;
          }  
          else if (Object[i].equalsIgnoreCase(Both))
            	   
           {
        	  System.out.println("both are  found"); 
        	  Setup.driver.findElement(By.xpath("//div//div//div[3]/button[@class='btn btn-sm btn-mips-Cancel']")).click();
          return true;
       }
    	
       
      }
       else
       {
    	   Setup.driver.findElement(By.xpath("//div//div//div[3]/button[@class='btn btn-sm btn-success']")).click(); 
    	   return true;
    	   
    	   }
     
          
          
          
          
       }
	return false;
      
	
		
      
		
		
	}
	
	
	
	
	
	

}
