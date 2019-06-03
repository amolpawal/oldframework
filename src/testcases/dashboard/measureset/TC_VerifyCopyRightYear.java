package testcases.dashboard.measureset;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buisness.frameworkengine.ExcelReader;
import buisness.frameworkengine.TestExecutor;
import buisness.managers.ConfigurationManager;
import configuration.Setup;
/**@Author Awadhesh Sengar
 * 12/15/2017
 * Testcase to verify if location count displayed in Dahboard side bar matches with the database count.
 **/

public class TC_VerifyCopyRightYear   extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="VerifyCopyRightYear")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokeCommon");		
		log.info("\n test case to check Copyright year in dashboard");
		exe.testexecute(Filelocation,"TC_VerifyCopyrightyear",data);
		log.info("\n test case to check Copyright year in dashboard ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="VerifyCopyRightYear")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("SmokeCommon");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyCopyrightyear_data");
		Setup.log.info("\n  test case to check Copyright year in dashboard ends  "+Filelocation);
        return object;    
    } 

}
