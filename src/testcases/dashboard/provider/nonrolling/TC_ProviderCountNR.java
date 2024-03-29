package testcases.dashboard.provider.nonrolling;


import java.io.IOException;
import java.util.Hashtable;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
/**
 *  Verifies Dashboard>>Location or Dashboard>>Provider count as it compares the grid from UI and Database <p>
 * 
 * @author awadhesh sengar
 * Created Date: 1 nov 2017
 */
public class TC_ProviderCountNR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	
	    @Test(dataProvider="TC_ProviderCountNR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokeProvider");

	    	Setup.log.info("TC_ProviderCountNR test case starts");
	    	exe.testexecute(Filelocation,"TC_ProviderCountNR",data);
	    	Setup.log.info("TC_ProviderCountNR test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_ProviderCountNR")

	    public Object[][] getDataForDashboardProviderCount() throws IOException, InvalidFormatException
		{
	        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokeProvider");
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderCountNR_Data");
	        return object;    
	    }
}
