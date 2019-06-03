package testcases.pms.custominformation;

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
 * This test case to check practice custom information ACO
 *  Data is provided through data sheet from excel
 * @author awadhesh sengar
 * Date 8-2-2018
 */
public class TC_VerifyAco extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="VerifyAco")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");		
		log.info("\n test case to check ACO in CustomInformation ");
		exe.testexecute(Filelocation,"TC_VerifyAco",data);
		log.info("\nTC to validate ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="VerifyAco")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyAco_data");
		Setup.log.info("\n test case to check ACO in CustomInformation  "+Filelocation);
        return object;    
    } 

}
