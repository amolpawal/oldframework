package buisness.core.administration.pms.agreement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import buisness.core.DashboardUI;
import buisness.managers.DatabaseManger;
import buisness.util.datastructures.pms.FourVariablesCompare;
import configuration.Setup;

abstract public class PracticeAgreementGrid extends DashboardUI
{
	public FourVariablesCompare getWebGrid (String elementmethod,String locator)
	{
		System.out.printf("the captured x path is ",locator);
		Setup.log.trace(locator);
		if(locator!=null)
		{
			FourVariablesCompare FourVariablesCompare = new FourVariablesCompare();
			try{
				List<WebElement> rows = getWebElements(elementmethod, locator);
				for(WebElement table : rows)
				{
					String Var1=table.findElement(By.xpath("./td[1]")).getText();
					Setup.log.info(Var1);
					
					String Var2=table.findElement(By.xpath("./td[2]")).getText();
					Setup.log.info(Var2);
					
					String Var3=table.findElement(By.xpath("./td[3]")).getText();
					Setup.log.info(Var3);
					
					String Var4=table.findElement(By.xpath("./td[4]")).getText();
					Setup.log.info(Var4);
					
					FourVariablesCompare.add(Var1, Var2, Var3, Var4);
					
					
				}
				
			}
				catch(Exception e)
				{
					Setup.log.error(e);
					Setup.log.error("Please check xpath in ObjectRepositary.Properties file ");
				}
				System.err.println("count from UI");
				return FourVariablesCompare;
			}
	
	else
	{
		Setup.log.error("The Xpath of WebGrid is incorrect on missing please check the Submision.xlsx");
		return null;
	}
	}

	
		
		public FourVariablesCompare  getDatabaseGrid(String query)
		{
			DatabaseManger.SQLserverConnection();
			ResultSet resultSet = DatabaseManger.exeQuery(query);
			FourVariablesCompare FourVariablesCompare= new FourVariablesCompare();
			Setup.log.trace(query);
			if(resultSet != null)
			{
				try {
					while(resultSet.next())
					{
						String Var1=resultSet.getString("Var1");
						Setup.log.info(Var1);
						
						String Var2=resultSet.getString("Var2");
					    Setup.log.info(Var2);
						
						String Var3=resultSet.getString("Var3");
						Setup.log.info(Var3);
						
						String Var4=resultSet.getString("Var4");
						Setup.log.info(Var4);
					
					
					FourVariablesCompare.add(Var1, Var2, Var3, Var4);
					
			}
				
				}
			
		
				catch(SQLException ex)
			{
				Setup.log.error("Please check query in 'Queries.properties.");
				Setup.testcase.fail();
			}
			catch(Exception excp)
			{
				Setup.log.error("query in 'Queries.properties is correct.");
				Setup.testcase.fail();
			}
			return FourVariablesCompare;
		}

		else
		{
			Setup.log.error("Nothing to return hence return the NULL");
			return null;
		}
	}
}
