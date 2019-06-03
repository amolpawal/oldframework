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
 * This test case to check practice custom information Mips Component
 *  Data is provided through data sheet from excel
 * @author awadhesh sengar
 * Date 8-2-2018
 */
public class TC_VerifyMipsComponent extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="VerifyMipsComponent")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");		
		log.info("\n test case to check verify mips component in PMS  custom field ");
		exe.testexecute(Filelocation,"TC_VerifyMipsComponent",data);
		log.info("\nTC to validate ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="VerifyMipsComponent")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VerifyMipsComponent_data");
		Setup.log.info("\n test case to check verify mips component in PMS  custom field  ends  "+Filelocation);
        return object;    
    } 

}
