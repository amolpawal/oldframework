package buisness.core.Submission.pqrsSubmission.submission2015.milestoneTwo;
import buisness.core.Submission.ReportingMeasuresView;
import buisness.util.datastructures.Submission.gprosubmission.milestonetwo.ReportingMeasureGrid;
import configuration.Setup; 

/**
 * This class used to get PQRS Submission >> Submission 2015 >> Manage Provider Profile Milestone 
 *     >>PQRS Reporting Option tab
 * Get data from Database and UI and return a object with Grid value<p>
 * This class extends PqrsAdvancedStatus<p>
 * This class get data of  Pqrs Reporting Option IMR View
 * This class also contain getWebGrid() method to get Web Grid 
 * This class also contain getDatabaseGrid() method to get Web Grid 
 * This class returns result where the test case is Pass or Fail
 * @author rakesh.kulkarni
 * Date : 15/02/2016
 */
public class PqrsReportingOptionIMRView extends ReportingMeasuresView	 {
	/**	
	 * Method to compare object of PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone >>Select Provider tab
	 *  . It check value present on UI with Database 
	 * @param locater
	 * @return result of Test case "Pass" or "Fail"
	 */
	public boolean verify(String elementmethod,String locater)
	{

		
		ReportingMeasureGrid  dbGrid =getDatabaseGrid("PqrsReportingOptionIMRView");
		ReportingMeasureGrid uiGrid =getWebGrid(elementmethod,locater);
		if(uiGrid.compareTo(dbGrid) == 0) 
		{
			Setup.log.trace("Data present on practice Grid on UI match with Dtabase");
			Setup.testcase.assertTrue(true);
			return true;
		}
		else 
			Setup.log.trace("Data present on practice Grid on UI not match with Dtabase");
		Setup.testcase.fail();
		return false;
	}	
}

