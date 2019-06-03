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
 * This test case to check pm/rcm push file type
 *  Data is provided through data sheet from excel
 * @author awadhesh sengar
 * Date 12-1-2018
 */
public class TC_VerifyPMrcmPushFileType extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="VerifyPMrcmPushFileType")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");		
		log.info("\n test case Verify PM/rcm push file type  in technical details PMS");
		exe.testexecute(Filelocation,"TC_VPMrcmPushFileType",data);
		log.info("\nTC to validate practice ehr push method  ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="VerifyPMrcmPushFileType")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VPMrcmPushFileType_data");
		Setup.log.info("\n test case Verify PM/rcm push file type  in technical details PMS ends  "+Filelocation);
        return object;    
    } 

}
