package buisness.core.dashboard.Practice.measureset;

import buisness.core.dashboard.Practice.PracticeLocationPopUp;
import buisness.core.dashboard.provider.ProviderLocationCount;
import buisness.managers.ConfigurationManager;
import buisness.util.datastructures.dashboard.practice.PracticeLocationPopUpGrid;
import configuration.Setup;

public class DescriptionToolTip extends MasterLogicUIdb {

	/** 
	 * 
	 * 
	 * @param locator : To Find the element Name of locator in object repository<p>
	 * @param elementmethod : To Find the element by the type of Element Example xpath, id,
	 * @Param data : quarter or month
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locator,String data)  
	{
		String databaseCount;
		String webCount;
		ConfigurationManager config=new ConfigurationManager();
		String query = config.getQuery("MeasureDescription");
	 
		query=query.replace( "@PQRSNationalProgramQualityMeasureUid",getTooltipMeasure(data));
		
		

		databaseCount=getdatabasecount(query);
		webCount=getUIvalue(elementmethod,locator,data);
		
		
		Setup.log.info("Ui_Count"+webCount);
		Setup.log.info("Db_Count"+databaseCount);
		
		
		if(webCount.equals(databaseCount))
		{
			Setup.log.trace("Count from Database and UI getting matched");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else
		{
			Setup.log.trace("Count from Database and UI is not getting matched");
			Setup.testcase.fail();
			return false;
		}
		
	}
		
}
