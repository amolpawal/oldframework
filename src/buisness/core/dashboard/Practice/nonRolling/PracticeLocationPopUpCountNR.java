package buisness.core.dashboard.Practice.nonRolling;

import buisness.core.dashboard.provider.ProviderLocationCount;
import buisness.managers.ConfigurationManager;
import configuration.Setup;

/**
 * Verifies Location popup present on Dashboard > Practice >> Select Measure on
 * Location Tab For NOnRolling
 * <p>
 * Extends ProviderLocationCount
 * <p>
 * This class Query Keyword to Extended PracticeFavoritesMeasureCountNR class
 * Returns boolean true if grid from UI and Database match
 * <p>
 * Returns boolean false if grid from UI and Database do not match
 * <p>
 * Return data validate count.
 * 
 * @author Rakesh.Kulkani
 *         <p>
 *         Created Date: 21/03/2016
 * 
 */
public class PracticeLocationPopUpCountNR extends ProviderLocationCount {

	/** Compares Location popup present on Dashboard > Practice >> Select Measure on Location Tab for from UI and Database
	 * Passes locator : To Find the element
	 * This method verify Count
	 * Method to compare object of DatabaseGrid and WebGrid. It check value present on UI with Database
	 * @param locator : To Find the element Name of locator in object repository<p>
	 * @param elementmethod : To Find the element by the type of Element Example xpath, id,
	 * @Param data : quarter or month
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verifyPracticeLocationPopUpCountNR(String elementmethod,String locator,String data, String data1)  
	{
		String databaseCount;
		String webCount;
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("PracticeLocationPopUpCountNR");
		query=query.replace( "@quartermonth",data);
		query=query.replace( "@loginuser",getLoggedInUser());
		query=query.replace( "@measureID",newwayMeasureUid());
		
		if(isQuarter(data))
		{
			query=query.replace( "@flag",data1);
		}
		else
		{
			query=query.replace( "@flag",data1);
		}

		databaseCount=getdatabasecount(query);
		
	/*	if(verify_element(elementmethod, locator).equals("Pass"))
		{
				String newlocator=locator+"/div";
				if(verify_element(elementmethod, newlocator).equals("Fail"))
				{
				locator=locator+"/b";
				System.out.println(locator);
				webCount=getuicount(elementmethod,locator);
				}
			 else
			 {
				System.out.println(newlocator);
				webCount=getuicount(elementmethod,newlocator);
			 }
		}else
			  {
			    System.out.println("No records found");
			    Setup.log.error("\nNo records found");
			  }*/
		
		webCount=getuicountWithTrim(elementmethod,locator);
		
		Setup.log.info("Ui_Count"+webCount);
		Setup.log.info("Db_Count"+databaseCount);
		
		
		if(webCount.equals(databaseCount))
		{
			Setup.log.error("\nCount from Database and UI getting matched");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else
		{
			Setup.log.error("\nCount from Database and UI is not getting matched");
			Setup.testcase.fail();
			return false;
		}
		
	}

}
