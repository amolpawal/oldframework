package testcases.dashboard.practice.nonRolling;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

/**@Author Awadhesh Sengar
	 * 12/15/2017
	 * Testcase to verify if Practice Performance patient drill down count is displayed correctly..
	 **/


public class TC_PracticePerformanceTrendPatientDrillDownCountNR extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();	
    String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokePractice");
	@Test(dataProvider="PracticePerformancrTrendPatientDrillDownCountNR")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
				
		log.info("\nTC To validate count of Patient Drill Down present on Performance Trend > present on Dashboard > practice for nonRolling");
		exe.testexecute(Filelocation,"TC_PPTPatientDDCountNR",data);
		log.info("\nTC To validate count of Patient Drill Down present on Performance Trend > present on Dashboard > practice for nonRolling Ends");
		Setup.testcase.assertAll();
	}
	@DataProvider(name="PracticePerformancrTrendPatientDrillDownCountNR")
    public Object[][] getDataForPracticePerformancrTrendPatientDrillDownCountNR() throws IOException, InvalidFormatException
	{
        Object[][] object=ex.getDataingrid(Filelocation,"TC_PPTPatientDDCountNR_Data");
		Setup.log.info("\n For TC To validate count of Patient Drill Down present on Performance Trend > present on Dashboard > practice for nonRolling, DataFile is used from "+Filelocation);
        return object;    
    } 
}
