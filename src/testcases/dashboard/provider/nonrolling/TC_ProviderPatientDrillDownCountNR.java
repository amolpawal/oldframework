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
 *  Verifies Count for Patient Drill Down in Dashboard>>Provider grid from UI and Database <p>
 * @author Awadhesh Sengar
 * Created Date: 1 NOV 2017
 */
public class TC_ProviderPatientDrillDownCountNR extends Setup  {

		ConfigurationManager rd=new ConfigurationManager();
		TestExecutor exe=new TestExecutor();
	    ExcelReader ex= new ExcelReader();
	    String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokeProvider");
	    
	    @Test(dataProvider="TC_ProviderPatientDrillDownCountNR")

		public void startTestCase(Hashtable <String,String> data) throws IOException, InvalidFormatException
		{

	    	Setup.log.info("TC_ProviderPatientDrillDownCountNR test case starts");
	    	exe.testexecute(Filelocation,"TC_ProviderPatientDDCountNR",data);
	    	Setup.log.info("TC_ProviderPatientDrillDownCountNR test case ends");
	    	Setup.testcase.assertAll();
		}

		@DataProvider(name="TC_ProviderPatientDrillDownCountNR")

	    public Object[][] getDataForProviderPatientDrillDownCount() throws IOException, InvalidFormatException
		{
	        Object[][] object=ex.getDataingrid(Filelocation,"TC_ProviderPatientDDCountNRData");
	        return object;    
	    }
}

