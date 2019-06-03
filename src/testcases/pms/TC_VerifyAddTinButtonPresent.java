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
 * This test case to check add tin button is present.
 *  Data is provided through data sheet from excel
 * @author awadhesh sengar
 * Date 12-1-2018
 */
public class TC_VerifyAddTinButtonPresent extends Setup{
	
	ConfigurationManager rd=new ConfigurationManager();
	TestExecutor exe = new TestExecutor();
    ExcelReader ex = new ExcelReader();
    
    
	@Test(dataProvider="VerifyAddTinButton")
	public void TC_AllMeasures(Hashtable <String,String> data) throws IOException, InvalidFormatException
	{
	
		String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");		
		log.info("\n test case to check  PracticeCity  in PMS");
		exe.testexecute(Filelocation,"TC_VTinButton",data);
		log.info("\n TC to validate add contact  button is avaiable in PMS ");
		Setup.testcase.assertAll();
	  

	}

	@DataProvider(name="VerifyAddTinButton")
    public Object[][] getDataFromDataprovider12() throws IOException, InvalidFormatException
	{
        String Filelocation=System.getProperty("user.dir")+rd.read_Configfile("PMS");
        Object[][] object=ex.getDataingrid(Filelocation,"TC_VTinButton_data");
		Setup.log.info("\n TC to validate add contact  button is avaiable in PMS ends  "+Filelocation);
        return object;    
    } 

}
