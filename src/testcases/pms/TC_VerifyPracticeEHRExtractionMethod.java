package testcases.pms;

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
 * This test case to check practice EHR extraction method
 *  Data is provided through data sheet from excel
 * @author awadhesh sengar
 * Date 12-1-2018
 */
public class TC_VerifyPracticeEHRExtractionMethod extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="VerifyPracticeEHRExtractionMethod")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");		
		log.info("\n test case to check IT contact email  in PMS");
		exe.testexecute(Filelocation,"TC_VPExtractionMethod",data);
		log.info("\n TC to Verify Practice Extraction method in technical details ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="VerifyPracticeEHRExtractionMethod")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VPExtractionMethod_data");
		Setup.log.info("\n TC to Verify Practice Extraction method technical details in PMS ends  "+Filelocation);
        return object;    
    } 

}
